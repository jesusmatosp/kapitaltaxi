package com.kapital.sitramas.seguridad.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kapital.sitramas.be.Privilegio;
import com.kapital.sitramas.seguridad.dao.PrivilegioDAO;
import com.kapital.sitramas.seguridad.dto.PrivilegioDTO;
import com.kapital.sitramas.seguridad.service.PrivilegioService;

@Service
@Transactional(readOnly=true)
public class PrivilegioServiceImpl implements PrivilegioService {

	@Autowired
	private PrivilegioDAO privilegioDao;
	
	@Override
	public List<Privilegio> allListPrivilegios()throws Exception {
		// TODO Auto-generated method stub
		List<Privilegio> privilegios = new ArrayList<Privilegio>();
		privilegios = privilegioDao.all() ;
		return privilegios;
	}

	@Override
	public void save(PrivilegioDTO privilegioDTO) throws SQLException, Exception{
		// TODO Auto-generated method stub
		Privilegio privilegio = new Privilegio();
		BeanUtils.copyProperties(privilegio, privilegioDTO);
		if(privilegioDTO.getId() !=null)
			privilegioDao.update(privilegio);
		else
			privilegioDao.save(privilegio);
	}

	@Override
	public PrivilegioDTO findById(Long id) throws SQLException, Exception {
		// TODO Auto-generated method stub
		Privilegio privilegio = privilegioDao.find(id);
		PrivilegioDTO privilegioDto = new PrivilegioDTO();
		BeanUtils.copyProperties(privilegioDto, privilegio);
		return privilegioDto;
	}

	@Override
	public void deletePrivilegio(Long id) throws SQLException, Exception {
		// TODO Auto-generated method stub
		try{
			privilegioDao.deletePrivilegio(id);
		}catch(SQLException ex){
			throw new SQLException();
		}catch (Exception e) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
			e.printStackTrace();
		}
	}

	@Override
	public void deletePrivilegioByIds(String[] ids) throws SQLException, Exception {
		// TODO Auto-generated method stub
		try{
			privilegioDao.deletePrivilegioByIds(ids);
		}catch (Exception e) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
			throw e;
		}
	}

	@Override
	public List<PrivilegioDTO> allListPrivilegiosActivos() throws SQLException, Exception {
		// TODO Auto-generated method stub
		List<PrivilegioDTO> privilegiosDto = new ArrayList<PrivilegioDTO>();
		try{
			List<Privilegio> lista = privilegioDao.findAllPrivilegioActive();
			for(Privilegio privilegio:lista){
				PrivilegioDTO privilegioDto = new PrivilegioDTO();
				BeanUtils.copyProperties(privilegioDto, privilegio);
				privilegiosDto.add(privilegioDto);
			}
		}catch(Exception e){
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
			throw e;
		}
		return privilegiosDto;
	}

}
