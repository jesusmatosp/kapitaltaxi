package com.kapital.sitramas.configuracion.dao.impl;

import org.springframework.stereotype.Repository;

import com.kapital.sitramas.configuracion.dao.ClienteDAO;
import com.kapital.sitramas.be.Cliente;
import com.kapital.sitramas.be.Privilegio;
import com.kapital.sitramas.dao.AbstractDAO;

@Repository
public class ClienteDAOImpl extends AbstractDAO<Cliente> implements ClienteDAO {
	
	public ClienteDAOImpl(){
		super();
		setClazz(Cliente.class);
	}
	
}
