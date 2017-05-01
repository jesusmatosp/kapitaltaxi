package com.kapital.sitramas.servicios.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.kapital.sitramas.be.ProgramacionPasajero;
import com.kapital.sitramas.dao.AbstractDAO;
import com.kapital.sitramas.servicios.dao.ProgramacionPasajeroDAO;

@Repository
public class ProgramacionPasajeroDAOImpl extends AbstractDAO<ProgramacionPasajero> implements ProgramacionPasajeroDAO{

	public ProgramacionPasajeroDAOImpl() {
		// TODO Auto-generated constructor stub
		super();
		setClazz(ProgramacionPasajero.class);
	}
	
	@Override
	public List<ProgramacionPasajero> listProgramacionPasajeroActive(Long idProgramacion, Integer version) throws SQLException, Exception {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		List<ProgramacionPasajero> lista = new ArrayList<ProgramacionPasajero>();
		Query query = getCurrentSession().createQuery("from ProgramacionPasajero pp where pp.estado = 1 and pp.programacion.id = :idProgramacion "
				+ "and pp.programacion.version = :version" );
		query.setLong("idProgramacion", idProgramacion);
		query.setInteger("version", version);
		
		if(query != null){
			lista = query.list();
		}
		trans.commit();
		return lista;
	}
	
}
