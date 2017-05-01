package com.kapital.sitramas.seguridad.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.kapital.sitramas.be.Privilegio;
import com.kapital.sitramas.be.Rol;
import com.kapital.sitramas.dao.AbstractDAO;
import com.kapital.sitramas.seguridad.dao.RolDAO;

@Repository
public class RolDAOImpl extends AbstractDAO<Rol> implements RolDAO {

	public RolDAOImpl(){
		super();
		setClazz(Rol.class);
	}

	@Override
	public void deleteListRol(String[] ids) {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("delete from tbl_rol where n_id_rol in (:idRol) ");
			Query query = getCurrentSession().createSQLQuery(sql.toString());
			query.setParameterList("idRol", ids);
			query.executeUpdate();
			trans.commit();
		}catch(Exception e){
			trans.rollback();
			throw e;
		}
	}

	@Override
	public List<Rol> listRolActive() throws SQLException, Exception {
		// TODO Auto-generated method stub
		getCurrentSession().getTransaction().begin();
		List<Rol> lista = new ArrayList<Rol>();
		Query query = getCurrentSession().createQuery("from "+Rol.class.getName()+" c WHERE c.estado = 1 "); 
		if(query != null){
			lista = query.list();
		}
		getCurrentSession().getTransaction().commit();
		return lista;
	}
	
	
}
