package com.kapital.sitramas.seguridad.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.kapital.sitramas.be.RolPrivilegio;
import com.kapital.sitramas.dao.AbstractDAO;
import com.kapital.sitramas.seguridad.dao.RolPrivilegioDAO;

@Repository
@SuppressWarnings("unchecked")
public class RolPrivilegioDAOImpl extends AbstractDAO<RolPrivilegio> implements RolPrivilegioDAO {

	public RolPrivilegioDAOImpl(){
		super();
		setClazz(RolPrivilegio.class);
	}
	
	@Override
	public List<RolPrivilegio> findPrivilegioByRol(Long IdRol) throws SQLException, Exception {
		List<RolPrivilegio> lrolpriv = new ArrayList<RolPrivilegio>();
		Transaction trans = getCurrentSession().beginTransaction();
		Query query = getCurrentSession().createQuery("FROM RolPrivilegio c WHERE c.id.idRol = :id");
		query.setLong("id", IdRol);
		lrolpriv = query.list(); 
		trans.commit();
		return lrolpriv;
	}

	@Override
	public void deleteRolByPrivilegioId(Long id) throws SQLException, Exception {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		StringBuilder sql = new StringBuilder();
		sql.append("delete from tbl_rol_privilegio where n_id_rol = :idrol ");
		Query query = getCurrentSession().createSQLQuery(sql.toString());
		query.setLong("idrol", id);
		query.executeUpdate();
		trans.commit();
	}
	
}
