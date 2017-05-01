package com.kapital.sitramas.servicios.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.kapital.sitramas.be.CargaMasiva;
import com.kapital.sitramas.dao.AbstractDAO;
import com.kapital.sitramas.servicios.dao.CargaMasivaDAO;

@Repository
public class CargaMasivaDAOImpl extends AbstractDAO<CargaMasiva> implements CargaMasivaDAO{

	public CargaMasivaDAOImpl(){
		super();
		setClazz(CargaMasiva.class);
	}

	@Override
	public List<CargaMasiva> findCargasMasivasByIdProgramacion(Long idProgramacion) throws SQLException, Exception {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		List<CargaMasiva> list = null;
		Query query = getCurrentSession().createQuery("from CargaMasiva c where c.idProgramacion = :idProgramacion ");
		query.setLong("idProgramacion", idProgramacion);
		if(query != null){
			list = new ArrayList<>();
			list = query.list();
		}
		trans.commit();
		return list;
	}
}
