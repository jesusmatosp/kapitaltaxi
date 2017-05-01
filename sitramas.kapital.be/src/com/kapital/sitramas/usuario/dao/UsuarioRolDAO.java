package com.kapital.sitramas.usuario.dao;

import java.sql.SQLException;
import java.util.List;

import com.kapital.sitramas.be.UsuarioRol;
import com.kapital.sitramas.common.Crud;

public interface UsuarioRolDAO extends Crud<UsuarioRol> {

	public List<UsuarioRol> findUsuarioRolByUsuario(Long idUsuario) throws SQLException, Exception;
	public void deleteUsuarioRolByUsuarioId(Long idUsuario) throws SQLException, Exception;
}
