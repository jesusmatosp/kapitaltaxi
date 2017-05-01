package com.kapital.sitramas.seguridad.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.kapital.sitramas.be.Persona;
import com.kapital.sitramas.be.Rol;
import com.kapital.sitramas.be.TipoUsuario;
import com.kapital.sitramas.be.Usuario;
import com.kapital.sitramas.be.UsuarioPK;
import com.kapital.sitramas.be.UsuarioRol;
import com.kapital.sitramas.be.UsuarioRolPK;
import com.kapital.sitramas.common.EmailUtil;
import com.kapital.sitramas.common.enums.EstadoEnum;
import com.kapital.sitramas.configuracion.dao.ClienteDAO;
import com.kapital.sitramas.seguridad.dao.RolDAO;
import com.kapital.sitramas.seguridad.dto.PersonaDTO;
import com.kapital.sitramas.seguridad.dto.RolDTO;
import com.kapital.sitramas.seguridad.dto.UsuarioDTO;
import com.kapital.sitramas.seguridad.service.UsuarioService;
import com.kapital.sitramas.usuario.dao.UsuarioDAO;
import com.kapital.sitramas.usuario.dao.UsuarioRolDAO;
import com.kapital.sitramas.utils.ConstantesUtils;

@Service
@Transactional(readOnly = true)
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Autowired
	private ClienteDAO clienteDao;
	
	@Autowired
	private UsuarioRolDAO usuarioRolDao;
	
	@Autowired
	private RolDAO rolDao;
	
	@Autowired
	private AsynchMessReceiver messageReceiver;
	
	@Transactional
	public Usuario findUsuarioByUsername(String username) {
		// TODO Auto-generated method stub
		return usuarioDao.findUsuarioByUsername(username);
	}

	@Transactional
	public String findPasswordByUsername(String username) {
		// TODO Auto-generated method stub
		return usuarioDao.findPasswordByUsername(username);
	}

	@Override
	@Async
	public void updatePasswordByUsername(String username, String password) {
		// TODO Auto-generated method stub
		try{
			usuarioDao.updatePasswordByUsername(username, password);
			//messageReceiver.getMessages();
			/*String bodyMessage = "Su contraseña Se actualizó satisfactoriamente <strong>Usuario: </strong>"+username+
					"<strong>Contrasenia:</strong>"+password;
			EmailUtil.prepareEmail(username, ConstantesUtils.SUBJECT_CREDENCIALES_UPDATE , 
				bodyMessage	);*/
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void saveUsuario(UsuarioDTO usuario) throws SQLException, Exception {
		// TODO Auto-generated method stub
		try{
			// Guardar Datos Usuario
			Usuario oUsuario = new Usuario();
			BeanUtils.copyProperties(oUsuario, usuario);
			UsuarioPK idUsuario = new UsuarioPK();
			idUsuario.setIdPersona(usuario.getIdPersona());
			TipoUsuario tipoUsuario = new TipoUsuario();
			tipoUsuario.setId(usuario.getIdTipoUsuario());
			oUsuario.setTblTipoUsuario(tipoUsuario);
			//usuarioDao.save(oUsuario);
			Persona persona = new Persona();
			persona.setId(usuario.getIdPersona());
			oUsuario.setPersona(persona);
			Long idUsuarioL = null; 
			if(usuario.getIdUsuario() != null){ //Modificacion
				idUsuarioL = usuario.getIdUsuario();
				oUsuario.setId(usuario.getIdUsuario());
				oUsuario.setUsuariosModificacion(oUsuario.getUsuarioCreacion());
				usuarioDao.updateUsuario(oUsuario);
			}else{
				usuarioDao.saveUsuario(oUsuario);
				idUsuarioL = usuarioDao.mysqlInsertId();
			}
			// Guardar Roles
			usuarioRolDao.deleteUsuarioRolByUsuarioId(idUsuarioL);
			List<RolDTO> rolesDto = usuario.getRoles();
			if(rolesDto != null){
				for(RolDTO roldto : rolesDto){
					UsuarioRolPK idUsuarioRol = new UsuarioRolPK();
					idUsuarioRol.setIdUsuario(idUsuarioL);
					idUsuarioRol.setIdRol(roldto.getId());
					// Save Roles
					UsuarioRol usuarioRol = new UsuarioRol();
					usuarioRol.setId(idUsuarioRol);
					usuarioRolDao.save(usuarioRol);
				}
			}
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public UsuarioDTO findUserByUsername(String username) throws SQLException, Exception{
		// TODO Auto-generated method stub
		UsuarioDTO usuarioDTO = null;
		try{
			Usuario usuario = findUsuarioByUsername(username);
			if(usuario != null){
				usuarioDTO = new UsuarioDTO();
				BeanUtils.copyProperties(usuarioDTO, usuario);
			}
		}catch(Exception e){
			throw e;
		}
		return usuarioDTO;
	}

	@Override
	public List<UsuarioDTO> allUsuarios() throws SQLException, Exception {
		// TODO Auto-generated method stub
		List<UsuarioDTO> usuarios = null;
		try{
			//List<Usuario> oUsuarios = usuarioDao.all();
			List<Usuario> oUsuarios = usuarioDao.allUsuarios();
			if(oUsuarios != null){
				usuarios = new ArrayList<UsuarioDTO>();
				for(Usuario u:oUsuarios){
					UsuarioDTO usuario = new UsuarioDTO();
					BeanUtils.copyProperties(usuario, u);
					TipoUsuario tipoUsuario = u.getTblTipoUsuario();
					usuario.setIdTipoUsuario(tipoUsuario.getId());
					usuario.setStrtipoUsuario(tipoUsuario.getNombreTipoUsuario());
					usuario.setNombresPersona(u.getPersona().getNombres()+" "+u.getPersona().getApellidoPaterno()+" "+u.getPersona().getApellidoMaterno());
					usuario.setIdUsuario(u.getId());
					usuarios.add(usuario);
				}
			}
			
			
		}catch(Exception e){
			throw e;
		}
		return usuarios;
	}

	@Override
	public void inactivarUsuarios(List<UsuarioDTO> usuarios) throws SQLException, Exception {
		// TODO Auto-generated method stub
		for(UsuarioDTO user:usuarios){
			Usuario usuario = usuarioDao.find(user.getIdUsuario());
			usuario.setComentarios(user.getComentarios());
			usuario.setEstado(EstadoEnum.INACTIVO.getValue());
			usuarioDao.update(usuario);
		}
	}

	@Override
	public PersonaDTO findUserById(Long id) throws SQLException, Exception {
		// TODO Auto-generated method stub
		PersonaDTO personaDTO = null;
		try{
			Usuario usuario = usuarioDao.findUsuarioById(id);
			if(usuario != null){
				personaDTO = new PersonaDTO();
				Persona persona = usuario.getPersona();
				BeanUtils.copyProperties(personaDTO, persona);
				UsuarioDTO usuarioDTO = new UsuarioDTO();
				BeanUtils.copyProperties(usuarioDTO, usuario);
				TipoUsuario tipoUser = usuario.getTblTipoUsuario();
				usuarioDTO.setIdTipoUsuario(tipoUser.getId());
				usuarioDTO.setStrtipoUsuario(tipoUser.getNombreTipoUsuario());
				usuarioDTO.setStrpassword(usuarioDao.findPasswordByUsername(usuarioDTO.getUsuario()));
				usuarioDTO.setIdUsuario(usuario.getId());
				if(usuarioDTO.getIdCliente() != null)
					usuarioDTO.setStrNombreCliente(clienteDao.find(usuarioDTO.getIdCliente()).getNombreCliente());
				List<UsuarioRol> usuarioRolL = usuarioRolDao.findUsuarioRolByUsuario(usuarioDTO.getIdUsuario());
				List<RolDTO> roles = new ArrayList<RolDTO>();
				for(UsuarioRol ur : usuarioRolL){
					RolDTO rol = new RolDTO();
					Rol r = rolDao.find(ur.getId().getIdRol());
					BeanUtils.copyProperties(rol, r);
					//rol.setId(ur.getId().getIdRol());
					roles.add(rol);
				}
				usuarioDTO.setRoles(roles);
				personaDTO.setUsuario(usuarioDTO);
			}
		}catch(Exception e){
			throw e;
		}
		return personaDTO;
	}

}

