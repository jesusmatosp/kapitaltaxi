package com.kapital.sitramas.seguridad.service;

import java.sql.SQLException;
import java.util.List;

import com.kapital.sitramas.be.Persona;
import com.kapital.sitramas.seguridad.dto.PersonaDTO;

public interface PersonaService {

	public List<Persona> allListPersonas() throws Exception;
	public PersonaDTO findPersonaByDNI(String dni) throws SQLException, Exception;
	public List<PersonaDTO> allListPersonasDTO() throws SQLException, Exception;
	public void save(PersonaDTO persona) throws SQLException, Exception;
	public PersonaDTO findPersonaById(Long id) throws SQLException, Exception;
	public void inactivarPersonas(List<PersonaDTO> usuarios) throws SQLException, Exception;
}
