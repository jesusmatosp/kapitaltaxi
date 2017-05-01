package com.kapital.sitramas.seguridad.service;

import java.sql.SQLException;
import java.util.List;

import com.kapital.sitramas.be.Usuario;
import com.kapital.sitramas.seguridad.dto.PersonaDTO;
import com.kapital.sitramas.seguridad.dto.UsuarioDTO;

public interface UsuarioService {
	public Usuario findUsuarioByUsername(String username);
	public String findPasswordByUsername(String username);
	public void updatePasswordByUsername(String username, String password);
	public void saveUsuario(UsuarioDTO usuario) throws SQLException, Exception;
	public UsuarioDTO findUserByUsername(String username) throws SQLException, Exception;
	public List<UsuarioDTO> allUsuarios()throws SQLException, Exception;
	public void inactivarUsuarios(List<UsuarioDTO> usuarios) throws SQLException, Exception;
	public PersonaDTO findUserById(Long id) throws SQLException, Exception;
}
