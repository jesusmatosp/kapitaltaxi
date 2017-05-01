package com.kapital.sitramas.servicios.service;

import java.sql.SQLException;
import java.util.List;
import com.kapital.sitramas.servicios.dto.ProgramacionDTO;
import com.kapital.sitramas.servicios.dto.ProgramacionPasajeroDTO;

public interface ProgramacionService {

	public List<ProgramacionDTO> findAllProgramacion() throws SQLException, Exception;
	public void saveProgramacion(ProgramacionDTO programacionDTO) throws SQLException, Exception;
	public ProgramacionDTO findById(Long id)throws SQLException, Exception;
	public void actualizarProgramacion(ProgramacionDTO programacionDTO) throws SQLException, Exception;
	
	public List<ProgramacionPasajeroDTO> findAllProgramacionCliente(Long idProgramacion, Integer version) throws SQLException, Exception;
	public ProgramacionPasajeroDTO findProgramacionClienteById(Long idProgramacionPasajero) throws SQLException, Exception;
}
