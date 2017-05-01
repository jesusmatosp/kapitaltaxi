package com.kapital.sitramas.configuracion.dao;

import java.sql.SQLException;
import java.util.List;

import com.kapital.sitramas.be.Ubigeo;
import com.kapital.sitramas.common.Crud;

public interface UbigeoDAO extends Crud<Ubigeo>{

	public List<Ubigeo> allDepartamentosActive();
	public List<Ubigeo> allProvinciasActive(String codDepartamento);
	public List<Ubigeo> allDistritosActive(String  codProvincia);
	public Ubigeo findByCodUbigeo(String codUbigeo) throws SQLException, Exception;
	
}
