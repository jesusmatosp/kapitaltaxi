package com.kapital.sitramas.seguridad.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.kapital.sitramas.be.Privilegio;
import com.kapital.sitramas.dao.AbstractDAO;
import com.kapital.sitramas.seguridad.dao.PrivilegioDAO;

@Repository
public class PrivilegioDAOImpl extends AbstractDAO<Privilegio> implements PrivilegioDAO  {

	public PrivilegioDAOImpl(){
		super();
		setClazz(Privilegio.class);
	}

	@Override
	public void deletePrivilegio(Long id) throws SQLException, Exception {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		StringBuilder sql = new StringBuilder();
		sql.append("delete from tbl_privilegio where n_id_privilegio= :idPrivilegio ");
		Query query = getCurrentSession().createSQLQuery(sql.toString());
		query.setLong("idPrivilegio", id);
		query.executeUpdate();
		trans.commit();
		
	}

	@Override
	public void deletePrivilegioByIds(String[] ids) {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		StringBuilder sql = new StringBuilder();
		sql.append("delete from tbl_privilegio where n_id_privilegio in (:idPrivilegio) ");
		Query query = getCurrentSession().createSQLQuery(sql.toString());
		query.setParameterList("idPrivilegio", ids);
		query.executeUpdate();
		trans.commit();
	}

	@Override
	public List<Privilegio> findAllPrivilegioActive() throws SQLException, Exception {
		// TODO Auto-generated method stub
		getCurrentSession().getTransaction().begin();
		List<Privilegio> lista = new ArrayList<Privilegio>();
		Query query = getCurrentSession().createQuery("from "+Privilegio.class.getName()+" c WHERE c.estado = 1 "); 
		if(query != null){
			lista = query.list();
		}
		getCurrentSession().getTransaction().commit();
		return lista;
	}
}
