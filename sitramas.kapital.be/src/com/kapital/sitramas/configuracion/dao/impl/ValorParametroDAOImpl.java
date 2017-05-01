package com.kapital.sitramas.configuracion.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.kapital.sitramas.be.ValorParametro;
import com.kapital.sitramas.configuracion.dao.ValorParametroDAO;
import com.kapital.sitramas.dao.AbstractDAO;

@Repository
public class ValorParametroDAOImpl extends AbstractDAO<ValorParametro> implements ValorParametroDAO {

	@Override
	public List<ValorParametro> listValorParametro(Long parametro) throws SQLException, Exception {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		List<ValorParametro> list = new ArrayList<ValorParametro>();
		try{
			Query query = getCurrentSession().createQuery("from "+ValorParametro.class.getName()+" v where  v.parametro.id = :idParametro");
			query.setParameter("idParametro", parametro);
			if(query != null){
				list = query.list();
			}
			trans.commit();
		}catch(Exception e){
			trans.rollback();
			throw e;
		}
		return list;
	}

	
}
