package com.kapital.sitramas.dao;

import java.util.List;

import com.kapital.sitramas.be.Usuario;

public interface UsuarioDAO {

	public void save(Usuario usuario);
	public List<Usuario> list();
	
}
