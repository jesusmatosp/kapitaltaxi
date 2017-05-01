package com.kapital.sitramas.common;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface Crud <T extends Serializable>{
	
	List<T> all() throws Exception;
	List<T> all(List<Long> ids);
	T find(final long id)throws SQLException, Exception;
	void save(final T entity);
	void update(final T entity);
	void delete(final T entity);
	void delete(final long id) throws SQLException, Exception;
	void saveEntity(final T entity);
	Long mysqlInsertId()throws SQLException, Exception;
	List<T> allActives() throws Exception;

}
