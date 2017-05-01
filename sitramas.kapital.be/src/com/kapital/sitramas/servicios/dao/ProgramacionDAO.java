package com.kapital.sitramas.servicios.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.kapital.sitramas.be.Programacion;
import com.kapital.sitramas.common.Crud;

public interface ProgramacionDAO extends Crud<Programacion> {

	public Integer findByDate(Date fechaProgramacion) throws SQLException, Exception;
	public List<Programacion> allProgramacionBorrador() throws SQLException, Exception;
	public List<Programacion> findProgramacionByDate(Date fechaInicio, Date fechaFin) throws SQLException;
	
}
