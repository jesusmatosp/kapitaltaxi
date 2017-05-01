package com.kapital.sitramas.usuario.dao;

import java.sql.SQLException;

import com.kapital.sitramas.be.Persona;
import com.kapital.sitramas.common.Crud;

public interface PersonaDAO extends Crud<Persona> {
	
	public Persona findPersonaByDNI(String dni) throws SQLException, Exception;
	
}
