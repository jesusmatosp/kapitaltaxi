package com.kapital.sitramas.seguridad.service;

import java.sql.SQLException;
import java.util.List;

import com.kapital.sitramas.be.Privilegio;
import com.kapital.sitramas.seguridad.dto.PrivilegioDTO;

public interface PrivilegioService {

	public List<Privilegio> allListPrivilegios() throws Exception;
	public void save(PrivilegioDTO privilegio) throws SQLException, Exception;
	public PrivilegioDTO findById(Long id) throws SQLException, Exception;
	public void deletePrivilegio(Long id) throws SQLException, Exception;
	public void deletePrivilegioByIds(String []ids) throws SQLException, Exception;
	public List<PrivilegioDTO> allListPrivilegiosActivos() throws SQLException, Exception;
}
