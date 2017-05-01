package com.kapital.sitramas.seguridad.dao;

import java.sql.SQLException;
import java.util.List;

import com.kapital.sitramas.be.RolPrivilegio;
import com.kapital.sitramas.common.Crud;

public interface RolPrivilegioDAO extends Crud<RolPrivilegio> {

	public List<RolPrivilegio> findPrivilegioByRol(Long IdRol) throws SQLException, Exception;
	public void deleteRolByPrivilegioId(Long id) throws SQLException, Exception;
}
