package com.kapital.sitramas.usuario.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kapital.sitramas.be.UsuarioRol;
import com.kapital.sitramas.dao.AbstractDAO;
import com.kapital.sitramas.usuario.dao.UsuarioRolDAO;

@Repository
public class UsuarioRolDAOImpl extends AbstractDAO<UsuarioRol> implements UsuarioRolDAO {

	public UsuarioRolDAOImpl(){
		super();
		setClazz(UsuarioRol.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioRol> findUsuarioRolByUsuario(Long idUsuario) throws SQLException, Exception {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		List<UsuarioRol> usuarioRolL = null;
		try{
			Criteria criteriaL = getCurrentSession().createCriteria(UsuarioRol.class);
			criteriaL.add(Restrictions.eq("id.idUsuario", idUsuario));
			usuarioRolL = criteriaL.list();
			trans.commit();
		}catch(Exception e){
			trans.rollback();
		}
		return usuarioRolL;
	}

	@Override
	public void deleteUsuarioRolByUsuarioId(Long idUsuario) throws SQLException, Exception {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("delete from tbl_usuario_rol where n_id_usuario= :idUsuario ");
			Query query = getCurrentSession().createSQLQuery(sql.toString());
			query.setLong("idUsuario", idUsuario);
			query.executeUpdate();
			trans.commit();	
		}catch(Exception e){
			trans.rollback();
			throw e;
		}
	} 
	
}
