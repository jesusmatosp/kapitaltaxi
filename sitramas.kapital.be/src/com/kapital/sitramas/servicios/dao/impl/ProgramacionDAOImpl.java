package com.kapital.sitramas.servicios.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kapital.sitramas.be.Programacion;
import com.kapital.sitramas.be.ProgramacionPasajero;
import com.kapital.sitramas.common.enums.EstadoProgramacionEnum;
import com.kapital.sitramas.dao.AbstractDAO;
import com.kapital.sitramas.servicios.dao.ProgramacionDAO;

@Repository
public class ProgramacionDAOImpl extends AbstractDAO<Programacion> implements ProgramacionDAO {

	public ProgramacionDAOImpl(){
		super();
		setClazz(Programacion.class);
	}

	@Override
	public Integer findByDate(Date fechaProgramacion) throws SQLException, Exception {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		Integer lastVersion = null;
		try{
			Criteria criteria = getCurrentSession().createCriteria(Programacion.class);
			criteria.add(Restrictions.eq("fechaProgramacion", fechaProgramacion));
			criteria.setProjection(Projections.max("version"));
			lastVersion = (Integer) criteria.uniqueResult();
			trans.commit();
		}catch(Exception e){
			trans.rollback();
			throw e;
		}
		return lastVersion;
	}

	@Override
	public List<Programacion> allProgramacionBorrador() throws SQLException, Exception {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		List<Programacion> programacion = null;
		try{
			Criteria criteria = getCurrentSession().createCriteria(Programacion.class);
			criteria.addOrder(Order.desc("fechaProgramacion"));
			criteria.addOrder(Order.desc("version"));
			programacion = criteria.list();
			trans.commit();
		}catch(Exception e){
			trans.rollback();
			throw e;
		}
		return programacion;
	}

	@Override
	public List<Programacion> findProgramacionByDate(Date fechaInicio, Date fechaFin) throws SQLException {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		List<Programacion> programacion = null;
		try{
			Criteria criteria = getCurrentSession().createCriteria(Programacion.class);
			criteria.add(Restrictions.between("fechaProgramacion", fechaInicio, fechaFin));
			criteria.add(Restrictions.eq("estado", EstadoProgramacionEnum.ENVIADO.getValue()));
			//criteria.add(Restrictions.or(Restrictions.eq("estado", EstadoProgramacionEnum.PROGRAMADO.getValue())));
			criteria.addOrder(Order.desc("fechaProgramacion"));
			criteria.addOrder(Order.desc("version"));
			programacion = criteria.list();
			trans.commit();
		}catch(Exception e){
			trans.rollback();
			throw e;
		}
		return programacion;
	}

	
	
}
