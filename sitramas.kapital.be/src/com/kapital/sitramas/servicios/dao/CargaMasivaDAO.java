package com.kapital.sitramas.servicios.dao;

import java.sql.SQLException;
import java.util.List;

import com.kapital.sitramas.be.CargaMasiva;
import com.kapital.sitramas.common.Crud;

public interface CargaMasivaDAO extends Crud<CargaMasiva> {

	public List<CargaMasiva> findCargasMasivasByIdProgramacion(Long idProgramacion) throws SQLException, Exception;
	
}
