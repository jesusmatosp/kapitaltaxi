package com.kapital.sitramas.servicios.dao;

import java.sql.SQLException;
import java.util.List;

import com.kapital.sitramas.be.ProgramacionPasajero;
import com.kapital.sitramas.common.Crud;

public interface ProgramacionPasajeroDAO extends Crud<ProgramacionPasajero>{

	public List<ProgramacionPasajero> listProgramacionPasajeroActive(Long idProgramacion, Integer version) throws SQLException, Exception;
}
