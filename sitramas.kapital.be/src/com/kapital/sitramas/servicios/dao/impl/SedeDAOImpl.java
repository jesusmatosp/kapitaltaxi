package com.kapital.sitramas.servicios.dao.impl;

import org.springframework.stereotype.Repository;

import com.kapital.sitramas.be.Sede;
import com.kapital.sitramas.dao.AbstractDAO;
import com.kapital.sitramas.servicios.dao.SedeDAO;

@Repository
public class SedeDAOImpl extends AbstractDAO<Sede> implements SedeDAO {
	
	public SedeDAOImpl(){
		super();
		setClazz(Sede.class);
	}
	

}
