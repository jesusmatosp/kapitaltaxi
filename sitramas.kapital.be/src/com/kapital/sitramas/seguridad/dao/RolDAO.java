package com.kapital.sitramas.seguridad.dao;

import java.sql.SQLException;
import java.util.List;

import com.kapital.sitramas.be.Rol;
import com.kapital.sitramas.common.Crud;

public interface RolDAO extends Crud<Rol> {

	public void deleteListRol(String [] ids);
	public List<Rol> listRolActive() throws SQLException, Exception;
	
}
