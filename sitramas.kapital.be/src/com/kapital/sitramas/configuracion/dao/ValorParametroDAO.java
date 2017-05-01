package com.kapital.sitramas.configuracion.dao;

import java.sql.SQLException;
import java.util.List;

import com.kapital.sitramas.be.ValorParametro;
import com.kapital.sitramas.common.Crud;

public interface ValorParametroDAO extends Crud<ValorParametro> {

	public List<ValorParametro> listValorParametro(Long parametro) throws SQLException, Exception;
	
	
}
