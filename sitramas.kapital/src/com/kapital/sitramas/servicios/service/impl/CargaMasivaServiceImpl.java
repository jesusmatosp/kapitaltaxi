package com.kapital.sitramas.servicios.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kapital.sitramas.be.CargaMasiva;
import com.kapital.sitramas.servicios.dao.CargaMasivaDAO;
import com.kapital.sitramas.servicios.dto.CargaMasivaDTO;
import com.kapital.sitramas.servicios.service.CargaMasivaService;

@Service
public class CargaMasivaServiceImpl implements CargaMasivaService {

	@Autowired
	private CargaMasivaDAO cargaMasivaDao;
	
	@Override
	public CargaMasivaDTO guardarCargaMasiva(CargaMasivaDTO cargaMasivaDTO) throws SQLException, Exception {
		// TODO Auto-generated method stub
		try{
			CargaMasiva cargaMasiva = new CargaMasiva();
			BeanUtils.copyProperties(cargaMasiva, cargaMasivaDTO);
			cargaMasivaDao.save(cargaMasiva);
			cargaMasivaDTO.setId(cargaMasiva.getId());
		}catch(Exception e){
			throw e;
		}
		return cargaMasivaDTO;
	}

	@Override
	public List<CargaMasivaDTO> obtenerListaCargaMasiva() throws SQLException, Exception {
		// TODO Auto-generated method stub
		List<CargaMasivaDTO> list = null;
		try{
			List<CargaMasiva> cargas = cargaMasivaDao.all();
			if(cargas != null){
				list = new ArrayList<>();
				for(CargaMasiva carga:cargas){
					CargaMasivaDTO cargaMasivaDTO = new CargaMasivaDTO();
					BeanUtils.copyProperties(cargaMasivaDTO, carga);
					list.add(cargaMasivaDTO);
				}
			}
		}catch(Exception e){
			throw e;
		}
		return list;
	}

	@Override
	public List<CargaMasivaDTO> obtenerListaCargaMasivaIdProgramacion(Long idProgramacion)
			throws SQLException, Exception {
		// TODO Auto-generated method stub
		List<CargaMasivaDTO> list = null;
		try{
			List<CargaMasiva> listcargas = cargaMasivaDao.findCargasMasivasByIdProgramacion(idProgramacion);
			if(listcargas != null){
				list = new ArrayList<>();
				for(CargaMasiva carga:listcargas){
					CargaMasivaDTO cargaMasivaDTO = new CargaMasivaDTO();
					BeanUtils.copyProperties(cargaMasivaDTO, carga);
					list.add(cargaMasivaDTO);
				}
			}
		}catch(Exception e){
			throw e;
		}
		return list;
	}

	
	
}
