package com.kapital.sitramas.seguridad.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kapital.sitramas.be.Persona;
import com.kapital.sitramas.be.Usuario;
import com.kapital.sitramas.common.enums.EstadoEnum;
import com.kapital.sitramas.seguridad.dto.PersonaDTO;
import com.kapital.sitramas.seguridad.dto.UsuarioDTO;
import com.kapital.sitramas.seguridad.service.PersonaService;
import com.kapital.sitramas.usuario.dao.PersonaDAO;
import com.kapital.sitramas.utils.KapitalUtils;

@Service
@Transactional(readOnly = true)
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaDAO personaDao;

	
	@Transactional
	public List<Persona> allListPersonas() throws Exception{
		// TODO Auto-generated method stub
		return personaDao.all();
	}


	@Override
	public PersonaDTO findPersonaByDNI(String dni) throws SQLException, Exception {
		// TODO Auto-generated method stub
		Persona oPersona = personaDao.findPersonaByDNI(dni);
		PersonaDTO personaDTO = null;
		if(oPersona != null){
			personaDTO = new PersonaDTO();
			BeanUtils.copyProperties(personaDTO, oPersona);
			List<Usuario> usuarios = oPersona.getUsuarios();
			if(!usuarios.isEmpty()){
				for(Usuario u:usuarios){
					UsuarioDTO usuarioDTO = new UsuarioDTO();
					BeanUtils.copyProperties(usuarioDTO, u);
					personaDTO.setUsuario(usuarioDTO);
				}
			}
		}
		return personaDTO;
	}


	@Override
	public List<PersonaDTO> allListPersonasDTO() throws SQLException, Exception {
		// TODO Auto-generated method stub
		List<PersonaDTO> listPersonasDTO = null;
		List<Persona> personas = personaDao.all();
		if(personas != null){
			listPersonasDTO = new ArrayList<PersonaDTO>();
			for(Persona p:personas){
				PersonaDTO personaDTO = new PersonaDTO();
				BeanUtils.copyProperties(personaDTO, p);
				listPersonasDTO.add(personaDTO);
			}
		}
		return listPersonasDTO;
	}


	@Override
	public void save(PersonaDTO persona) throws SQLException, Exception {
		// TODO Auto-generated method stub
		// Guardar Datos Persona
		Persona oPersona = new Persona();
		BeanUtils.copyProperties(oPersona, persona);
		//oPersona.setEstado(String.valueOf(EstadoEnum.ACTIVO.getValue()));
		String fechaNacimiento = persona.getStrfechaNacimiento();
		oPersona.setFechaNacimiento(KapitalUtils.convertStringToDate(fechaNacimiento));
		
		personaDao.save(oPersona);
		// Guardar Datos Usuario
	}


	@Override
	public PersonaDTO findPersonaById(Long id) throws SQLException, Exception {
		// TODO Auto-generated method stub
		PersonaDTO personaDTO = new PersonaDTO();
		try{
			Persona persona = personaDao.find(id);
			BeanUtils.copyProperties(personaDTO, persona);
		}catch(Exception e)
		{
			throw e;
		}
		return personaDTO;
	}


	@Override
	public void inactivarPersonas(List<PersonaDTO> personas) throws SQLException, Exception {
		// TODO Auto-generated method stub
		for(PersonaDTO p:personas){
			Persona persona = personaDao.find(Long.valueOf(p.getId()));
			persona.setComentarios(p.getComentarios());
			persona.setEstado(String.valueOf(EstadoEnum.INACTIVO.getValue()));
			personaDao.update(persona);
		}
	}
}
