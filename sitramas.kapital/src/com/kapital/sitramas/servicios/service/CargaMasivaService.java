package com.kapital.sitramas.servicios.service;

import java.sql.SQLException;
import java.util.List;

import com.kapital.sitramas.servicios.dto.CargaMasivaDTO;

public interface CargaMasivaService {

	public CargaMasivaDTO guardarCargaMasiva(CargaMasivaDTO cargaMasivaDTO) throws SQLException, Exception;
	public List<CargaMasivaDTO> obtenerListaCargaMasiva() throws SQLException, Exception;
	public List<CargaMasivaDTO> obtenerListaCargaMasivaIdProgramacion(Long idProgramacion) throws SQLException, Exception;
}
