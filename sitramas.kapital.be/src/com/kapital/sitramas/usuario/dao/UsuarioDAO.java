package com.kapital.sitramas.usuario.dao;

import java.sql.SQLException;
import java.util.List;

import com.kapital.sitramas.be.Usuario;
import com.kapital.sitramas.common.Crud;
import com.kapital.sitramas.seguridad.dto.UsuarioDTO;

public interface UsuarioDAO extends Crud<Usuario> {

	public Usuario findUsuarioByUsername(String username);
	public String findPasswordByUsername(String username);
	public void updatePasswordByUsername(String username, String password);
	public void saveUsuario(Usuario usuario) throws SQLException, Exception;
	public List<Usuario> allUsuarios() throws SQLException, Exception;
	public Usuario findUsuarioById(Long id) throws SQLException, Exception;
	public void updateUsuario(Usuario usuario) throws SQLException, Exception;
	
}
