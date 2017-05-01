package com.kapital.sitramas.configuracion.dao.impl;

import org.springframework.stereotype.Repository;

import com.kapital.sitramas.be.Parametro;
import com.kapital.sitramas.configuracion.dao.ParametroDAO;
import com.kapital.sitramas.dao.AbstractDAO;

@Repository
public class ParametroDAOImpl extends AbstractDAO<Parametro> implements ParametroDAO {

	public ParametroDAOImpl(){
		super();
		setClazz(Parametro.class);
	}
	
}
