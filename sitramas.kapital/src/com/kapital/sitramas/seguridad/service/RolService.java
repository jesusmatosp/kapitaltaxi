package com.kapital.sitramas.seguridad.service;

import java.sql.SQLException;
import java.util.List;

import com.kapital.sitramas.seguridad.dto.RolDTO;
import com.kapital.sitramas.seguridad.dto.RolPrivilegioDTO;

public interface RolService {

	public void saveRol(RolDTO rol) throws SQLException, Exception;
	public List<RolDTO> allRoles() throws SQLException, Exception;
	public List<RolDTO> listRolesActives() throws SQLException, Exception;
	public RolDTO findRolById(Long Id) throws SQLException, Exception;
	public void deleteRolById(Long id) throws SQLException, Exception; 
	public void deleteListRolById(String [] ids) throws SQLException, Exception;
	
}
