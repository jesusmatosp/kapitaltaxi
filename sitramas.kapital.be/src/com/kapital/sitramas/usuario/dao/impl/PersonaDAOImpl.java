package com.kapital.sitramas.usuario.dao.impl;

import java.sql.SQLException;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.kapital.sitramas.be.Persona;
import com.kapital.sitramas.dao.AbstractDAO;
import com.kapital.sitramas.usuario.dao.PersonaDAO;

@Repository
public class PersonaDAOImpl extends AbstractDAO<Persona> implements PersonaDAO {

	public PersonaDAOImpl(){
		super();
		setClazz(Persona.class);
	}

	@Override
	public Persona findPersonaByDNI(String dni) throws SQLException, Exception {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		Persona persona = null;
		try{
		Criteria criteria = getCurrentSession().createCriteria(Persona.class);
		criteria.add(Restrictions.eq("dni", dni ));
		criteria.add(Restrictions.eq("estado", "1"));
		persona = (Persona) criteria.uniqueResult();
		if(persona!=null){
			Hibernate.initialize(persona.getUsuarios());
		}
		trans.commit();
		}catch(Exception e){
			trans.rollback();
			throw e;
		}
		return persona;
	}
}
