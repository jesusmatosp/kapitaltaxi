package com.kapital.sitramas.seguridad.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kapital.sitramas.be.Rol;
import com.kapital.sitramas.be.RolPrivilegio;
import com.kapital.sitramas.be.RolPrivilegioPK;
import com.kapital.sitramas.seguridad.dao.RolDAO;
import com.kapital.sitramas.seguridad.dao.RolPrivilegioDAO;
import com.kapital.sitramas.seguridad.dto.PrivilegioDTO;
import com.kapital.sitramas.seguridad.dto.RolDTO;
import com.kapital.sitramas.seguridad.dto.RolPrivilegioDTO;
import com.kapital.sitramas.seguridad.service.RolService;

@Service
@Transactional(readOnly=true)
public class RolServiceImpl implements RolService{

	@Autowired
	private RolDAO roledao;
	
	@Autowired
	private RolPrivilegioDAO rolePrivilegioDao;
	
	@Override
	public void saveRol(RolDTO rol) throws SQLException, Exception {
		// TODO Auto-generated method stub
		try{
			Rol oRol =  new Rol();
			BeanUtils.copyProperties(oRol, rol);
			oRol.setTblPrivilegios(null);
			roledao.save(oRol);
			if(rol.getTblPrivilegios() != null && rol.getTblPrivilegios().size() > 0 ){
				List<PrivilegioDTO> lprivdto =  rol.getTblPrivilegios();
				for(PrivilegioDTO privdto:lprivdto){
					RolPrivilegio rolePrivilegio = new RolPrivilegio();
					RolPrivilegioPK id = new RolPrivilegioPK();
					id.setIdRol(oRol.getId());
					id.setIdPrivilegio(privdto.getId());
					rolePrivilegio.setId(id);
					rolePrivilegioDao.save(rolePrivilegio);
				}
			}
		}catch(Exception e){
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
			throw e;
		}
	}

	@Override
	public List<RolDTO> allRoles() throws SQLException, Exception {
		// TODO Auto-generated method stub
		List<RolDTO> rolesDto = new ArrayList<RolDTO>();
		try{
			List<Rol> roles = roledao.all();
			
			for(Rol rol:roles){
				RolDTO rolDTO = new RolDTO();
				BeanUtils.copyProperties(rolDTO, rol);
				rolesDto.add(rolDTO);
			}
		}catch(Exception e){
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
			throw e;
		}
		return rolesDto;
	}

	@Override
	public RolDTO findRolById(Long Id) throws SQLException, Exception {
		// TODO Auto-generated method stub
		RolDTO roldto = new RolDTO();
		try{
			Rol rol = roledao.find(Id);
			BeanUtils.copyProperties(roldto, rol);
			List<RolPrivilegio> rolPrivilegios = rolePrivilegioDao.findPrivilegioByRol(Id);
			List<PrivilegioDTO> privilegios = new ArrayList<PrivilegioDTO>();
			for(RolPrivilegio rp:rolPrivilegios){
				PrivilegioDTO pdto = new PrivilegioDTO();
				pdto.setId(rp.getId().getIdPrivilegio());
				privilegios.add(pdto);
			}
			roldto.setTblPrivilegios(privilegios);
		}catch(Exception e){
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
			throw e;
		}
		return roldto;
	}

	@Override
	public void deleteRolById(Long id) throws SQLException, Exception {
		// TODO Auto-generated method stub
		try{
			Rol rol = new Rol();
			rol.setId(id);
			roledao.delete(rol);
		}catch(Exception e){
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
			throw e;
		}
	}

	@Override
	public void deleteListRolById(String[] ids) throws SQLException, Exception {
		// TODO Auto-generated method stub
		try{
			roledao.deleteListRol(ids);
		}catch(Exception e){
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
			throw e;
		}
	}

	@Override
	public List<RolDTO> listRolesActives() throws SQLException, Exception {
		// TODO Auto-generated method stub
		List<RolDTO> rolesDto = new ArrayList<RolDTO>();
		try{
			List<Rol> roles = roledao.listRolActive();
			
			for(Rol rol:roles){
				RolDTO rolDTO = new RolDTO();
				BeanUtils.copyProperties(rolDTO, rol);
				rolesDto.add(rolDTO);
			}
		}catch(Exception e){
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
			throw e;
		}
		return rolesDto;
	}


}
