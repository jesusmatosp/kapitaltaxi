package com.kapital.sitramas.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.google.common.base.Preconditions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.kapital.sitramas.common.Crud;

@SuppressWarnings("unchecked")
public class AbstractDAO <T extends Serializable> implements Crud<T> {
	
	private Class<T> clazz;
	
	@Autowired
	private SessionFactory sessionFactory;

	protected final void setClazz(final Class<T> clazzToSet) {
		clazz = Preconditions.checkNotNull(clazzToSet);
	}
	 

	@Override
	public Long mysqlInsertId() throws SQLException, Exception{
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT LAST_INSERT_ID()");
		Query query = getCurrentSession().createSQLQuery(sql.toString());
		Long lastId =  Long.valueOf(query.uniqueResult().toString());
		trans.commit();
		return lastId;
	}	
	
	@Override
	@Transactional
	public List<T> all() throws Exception{
		// TODO Auto-generated method stub
		getCurrentSession().getTransaction().begin();
		List<T> lista = new ArrayList<T>();
		Query query = getCurrentSession().createQuery("from "+clazz.getName()); 
		if(query != null){
			lista = query.list();
		}
		getCurrentSession().getTransaction().commit();
		return lista;
	}
	
	@Override
	@Transactional
	public List<T> allActives() throws Exception{
		// TODO Auto-generated method stub
		List<T> lista = null;
		try{
			getCurrentSession().getTransaction().begin();
			lista = new ArrayList<T>();
			Query query = getCurrentSession().createQuery("from "+clazz.getName()+" o where o.estado = 1"); 
			if(query != null){
				lista = query.list();
			}
			getCurrentSession().getTransaction().commit();
		}catch(Exception e){
			getCurrentSession().getTransaction().rollback();
			throw e;
		}
		
		return lista;
	}

	@Override
	public List<T> all(List<Long> ids) {
		Query query = getCurrentSession().createQuery("FROM " + clazz.getName() + " c WHERE c.id IN :ids");
		query.setParameterList("ids", ids);
		return query.list();
	}

	@Override
	public T find(final long id) throws SQLException, Exception {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		T t = null;
		try{
			t = (T) getCurrentSession().get(clazz, id);
			trans.commit();
		}catch(Exception e){
			trans.rollback();
			throw e;
		}
		return t;
	}

	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		try{
			Preconditions.checkNotNull(entity);
	        getCurrentSession().saveOrUpdate(entity);
	        trans.commit();
		}catch(Exception e){
			trans.rollback();
			throw e;
		}
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		try{
			Preconditions.checkNotNull(entity);
	        getCurrentSession().merge(entity);
	        trans.commit();
		}catch(Exception e){
			trans.rollback();
			throw e;
		}
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		Preconditions.checkNotNull(entity);
        getCurrentSession().delete(entity);
        trans.commit();
	}
	
	@Override
	public void delete(final long entityId) throws SQLException, Exception{
		// TODO Auto-generated method stub
		final T entity = find(entityId);
        Preconditions.checkState(entity != null);
        delete(entity);
	}

	@Override
	public void saveEntity(T entity) {
		// TODO Auto-generated method stub
		Preconditions.checkNotNull(entity);
        getCurrentSession().save(entity);
	}
	
	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
