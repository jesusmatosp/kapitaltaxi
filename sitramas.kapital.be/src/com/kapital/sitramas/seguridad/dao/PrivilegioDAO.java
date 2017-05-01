package com.kapital.sitramas.seguridad.dao;

import java.sql.SQLException;
import java.util.List;

import com.kapital.sitramas.be.Privilegio;
import com.kapital.sitramas.common.Crud;
import com.kapital.sitramas.seguridad.dto.PrivilegioDTO;

public interface PrivilegioDAO extends Crud<Privilegio> {
	
	public void deletePrivilegio(Long id) throws SQLException, Exception;
	public void deletePrivilegioByIds(String[] ids);
	public List<Privilegio> findAllPrivilegioActive() throws SQLException, Exception;
}
