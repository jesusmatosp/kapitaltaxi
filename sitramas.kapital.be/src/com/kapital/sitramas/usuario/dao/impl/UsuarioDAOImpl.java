package com.kapital.sitramas.usuario.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kapital.sitramas.be.Usuario;
import com.kapital.sitramas.be.UsuarioRol;
import com.kapital.sitramas.common.enums.EstadoEnum;
import com.kapital.sitramas.common.enums.TipoUsuarioEnum;
import com.kapital.sitramas.dao.AbstractDAO;
import com.kapital.sitramas.usuario.dao.UsuarioDAO;

@Repository
public class UsuarioDAOImpl extends AbstractDAO<Usuario> implements UsuarioDAO{

	public UsuarioDAOImpl(){
		super();
		setClazz(Usuario.class);
	} 
	
	@Override
	public Usuario findUsuarioByUsername(String username) {
		// TODO Auto-generated method stub
		Usuario usuario = null;
		Transaction trans = getCurrentSession().beginTransaction();
		try{
			Criteria criteria = getCurrentSession().createCriteria(Usuario.class);
			criteria.add(Restrictions.eq("usuario", username ));
			criteria.add(Restrictions.eq("estado", 1));
			usuario = (Usuario) criteria.uniqueResult();
			if(usuario != null){
				Hibernate.initialize(usuario.getPersona());
				Hibernate.initialize(usuario.getTblTipoUsuario());
			}
			trans.commit();
		}catch(Exception e){
			trans.rollback();
			throw e;
		}
		return usuario;
	}

	@Transactional
	public String findPasswordByUsername(String username) {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		String password = null;
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT CAST(AES_DECRYPT(c_password, 'llave') AS CHAR(50)) as password ");
			sql.append("FROM TBL_USUARIO WHERE c_usuario = :username ");
			Query query = getCurrentSession().createSQLQuery(sql.toString());
			query.setString("username", username);
			password = (String) query.uniqueResult();
			trans.commit();
		}catch(Exception e){
			trans.rollback();
			throw e;
		}
		return password;
	}

	@Transactional
	public void updatePasswordByUsername(String username, String password) {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE KAPITADB.TBL_USUARIO SET c_password = AES_ENCRYPT(:password,'llave') WHERE c_usuario = :username");
			Query query = getCurrentSession().createSQLQuery(sql.toString());
			query.setString("username", username);
			query.setString("password", password);
			query.executeUpdate();
			trans.commit();
		}catch(Exception e){
			trans.rollback();
			throw e;
		}
	}

	@Override
	public void saveUsuario(Usuario usuario) throws SQLException, Exception {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("insert into tbl_usuario (c_usuario, c_password, c_estado, d_feccrea, c_usucrea, n_id_tipo_usuario, n_id_persona ");
			if(usuario.getTblTipoUsuario().getId() == TipoUsuarioEnum.CLIENTE.getValue()){
				sql.append(" , n_id_cliente ");
			}
			sql.append(") values (:cUsuario,aes_encrypt(:cPassword,'llave'), :cEstado, curdate(), :usuarioCrea, :idTipoUsuario, :idPersona ");
			if(usuario.getTblTipoUsuario().getId() == TipoUsuarioEnum.CLIENTE.getValue()){
				sql.append(" , :idCliente ");
			}
			sql.append(" )");
			Query query = getCurrentSession().createSQLQuery(sql.toString());
			query.setString("cUsuario", usuario.getUsuario());
			query.setString("cPassword", usuario.getStrpassword());
			query.setInteger("cEstado", usuario.getEstado());
			query.setString("usuarioCrea", usuario.getUsuarioCreacion());
			query.setLong("idTipoUsuario", usuario.getTblTipoUsuario().getId());
			query.setLong("idPersona", usuario.getPersona().getId());
			if(usuario.getTblTipoUsuario().getId() == TipoUsuarioEnum.CLIENTE.getValue()){
				query.setLong("idCliente", usuario.getIdCliente());
			}
			query.executeUpdate();
			trans.commit();
		}catch(Exception e){
			trans.rollback();
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> allUsuarios() throws SQLException, Exception {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		List<Usuario> list = null;
		try{
			Criteria criteria = getCurrentSession().createCriteria(Usuario.class);
			criteria.createAlias("tblTipoUsuario", "tu", JoinType.INNER_JOIN);
			criteria.createAlias("persona", "per", JoinType.INNER_JOIN);
			list = new ArrayList<Usuario>();
			list = criteria.list();
			trans.commit();
		}catch(Exception e){
			trans.rollback();
			throw e;
		}
		return list;
	}

	@Override
	public Usuario findUsuarioById(Long id) throws SQLException, Exception {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		Usuario user = null;
		try{
			Criteria criteria = getCurrentSession().createCriteria(Usuario.class);
			criteria.createAlias("tblTipoUsuario", "tu", JoinType.INNER_JOIN);
			criteria.createAlias("persona", "per", JoinType.INNER_JOIN);
			criteria.add(Restrictions.eq("id",id));
			user = new Usuario();
			user = (Usuario) criteria.uniqueResult();
			trans.commit();
		}catch(Exception e){
			trans.rollback();
			throw e;
		}
		return user;
	}

	@Override
	public void updateUsuario(Usuario usuario) throws SQLException, Exception {
		// TODO Auto-generated method stub
		Transaction trans = getCurrentSession().beginTransaction();
		try{
			StringBuilder sql = new StringBuilder();
			sql.append(" update tbl_usuario set c_usuario=:usuario, c_password=aes_encrypt(:password,'llave'), c_estado=:estado,"
					+ " d_fecmod=:fecMod, c_usumod =:usuMod, n_id_tipo_usuario=:idTipoUsuario ");
			if(usuario.getTblTipoUsuario().getId() == TipoUsuarioEnum.CLIENTE.getValue()){
				sql.append(" , n_id_cliente=:idCliente ");
			}
			sql.append(" where n_id_usuario= :idUsuario ");
			Query query = getCurrentSession().createSQLQuery(sql.toString());
			query.setString("usuario", usuario.getUsuario());
			query.setString("password", usuario.getStrpassword());
			query.setInteger("estado", usuario.getEstado());
			query.setDate("fecMod", new Date());
			query.setString("usuMod", usuario.getUsuariosModificacion());
			query.setLong("idTipoUsuario", usuario.getTblTipoUsuario().getId());
			if(usuario.getTblTipoUsuario().getId() == TipoUsuarioEnum.CLIENTE.getValue()){
				query.setLong("idCliente", usuario.getIdCliente());
			}
			query.setLong("idUsuario", usuario.getId());
			query.executeUpdate();
			trans.commit();
		}catch(Exception e){
			trans.rollback();
			throw e;
		}
	}

}
