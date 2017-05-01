package com.kapital.sitramas.configuracion.service;

import java.sql.SQLException;
import java.util.List;

import com.kapital.sitramas.be.Ubigeo;
import com.kapital.sitramas.configuracion.dto.UbigeoDTO;

public interface UbigeoService {

	public List<UbigeoDTO> findAllDepartamentosActive() throws SQLException, Exception;
	public List<UbigeoDTO> findAllProvinciasActive(String codDep) throws SQLException, Exception;
	public List<UbigeoDTO> findAllDistritosActive(String codDepProv) throws SQLException, Exception;
	public UbigeoDTO findUbigeoByCodUbigeo(String codUbigeo) throws SQLException, Exception;
	public UbigeoDTO findUbigeoById(Long id) throws SQLException, Exception;
}
