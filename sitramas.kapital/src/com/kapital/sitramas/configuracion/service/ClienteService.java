package com.kapital.sitramas.configuracion.service;

import java.sql.SQLException;
import java.util.List;

import com.kapital.sitramas.configuracion.dto.ClienteDTO;

public interface ClienteService {

	public List<ClienteDTO> allClienteActives() throws SQLException, Exception;
	public ClienteDTO findClienteById(Long id) throws SQLException, Exception;
}
