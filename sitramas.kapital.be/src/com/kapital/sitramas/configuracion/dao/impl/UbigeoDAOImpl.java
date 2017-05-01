package com.kapital.sitramas.configuracion.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.kapital.sitramas.be.Ubigeo;
import com.kapital.sitramas.configuracion.dao.UbigeoDAO;
import com.kapital.sitramas.dao.AbstractDAO;

@Repository
public class UbigeoDAOImpl extends AbstractDAO<Ubigeo> implements UbigeoDAO {

	public UbigeoDAOImpl(){
		super();
		setClazz(Ubigeo.class);
	}
	
	@Override
	public List<Ubigeo> allDepartamentosActive() {
		// TODO Auto-generated method stub
		getCurrentSession().getTransaction().begin();
		List<Ubigeo> lista = new ArrayList<Ubigeo>();
		Query query = getCurrentSession().createQuery("from "+Ubigeo.class.getName()+" u where u.provincia is null and u.distrito is null and u.estado = 1 "); 
		if(query != null){
			lista = query.list();
		}
		getCurrentSession().getTransaction().commit();
		return lista;
	}

	@Override
	public List<Ubigeo> allProvinciasActive(String codDepartamento) {
		// TODO Auto-generated method stub
		getCurrentSession().getTransaction().begin();
		List<Ubigeo> lista = new ArrayList<Ubigeo>();
		Query query = getCurrentSession().createQuery("from "+Ubigeo.class.getName()+" u where u.codUbigeo like :codUbigeo and u.provincia is not null and u.distrito is null and u.estado = 1 ");
		query.setParameter("codUbigeo", codDepartamento+"%");
		if(query != null){
			lista = query.list();
		}
		getCurrentSession().getTransaction().commit();
		return lista;
	}

	@Override
	public List<Ubigeo> allDistritosActive(String codProvincia) {
		// TODO Auto-generated method stub
		getCurrentSession().getTransaction().begin();
		List<Ubigeo> lista = new ArrayList<Ubigeo>();
		Query query = getCurrentSession().createQuery("from "+Ubigeo.class.getName()+" u where u.codUbigeo like :codUbigeo and u.distrito is not null and u.estado = 1 ");
		query.setParameter("codUbigeo", codProvincia+"%");
		if(query != null){
			lista = query.list();
		}
		getCurrentSession().getTransaction().commit();
		return lista;
	}

	@Override
	public Ubigeo findByCodUbigeo(String codUbigeo) throws SQLException, Exception {
		// TODO Auto-generated method stub
		getCurrentSession().getTransaction().begin();
		Ubigeo ubigeo = null;
		Query query = getCurrentSession().createQuery("from "+Ubigeo.class.getName()+" u where u.codUbigeo = :codUbigeo and u.estado = 1 ");
		query.setParameter("codUbigeo", codUbigeo);
		if(query != null){
			ubigeo = new Ubigeo();
			ubigeo = (Ubigeo) query.uniqueResult();
		}
		getCurrentSession().getTransaction().commit();
		return ubigeo;
	}

}
