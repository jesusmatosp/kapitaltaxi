package com.kapital.sitramas.configuracion.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kapital.sitramas.be.Ubigeo;
import com.kapital.sitramas.configuracion.dao.UbigeoDAO;
import com.kapital.sitramas.configuracion.dto.UbigeoDTO;
import com.kapital.sitramas.configuracion.service.UbigeoService;

@Service
@Transactional( readOnly = true )
public class UbigeoServiceImpl implements UbigeoService{

	@Autowired
	private UbigeoDAO ubigeodao;
	
	@Override
	public List<UbigeoDTO> findAllDepartamentosActive() throws SQLException, Exception{
		// TODO Auto-generated method stub
		List<UbigeoDTO> departamentosDTO = new ArrayList<UbigeoDTO>();
		try{
			List<Ubigeo> departamentos = ubigeodao.allDepartamentosActive();
			for(Ubigeo u:departamentos){
				UbigeoDTO ubigeoDTO = new UbigeoDTO();
				BeanUtils.copyProperties(ubigeoDTO, u);
				departamentosDTO.add(ubigeoDTO);
			}
		}catch (Exception e) {
			throw e;
		}
		return departamentosDTO;
	}

	@Override
	public List<UbigeoDTO> findAllProvinciasActive(String codDep) throws SQLException, Exception {
		// TODO Auto-generated method stub
		List<UbigeoDTO> provinciasDTO = new ArrayList<UbigeoDTO>();
		try{
			List<Ubigeo> provincias = ubigeodao.allProvinciasActive(codDep);
			for(Ubigeo u:provincias){
				UbigeoDTO ubigeoDTO = new UbigeoDTO();
				BeanUtils.copyProperties(ubigeoDTO, u);
				provinciasDTO.add(ubigeoDTO);
			}
		}catch(Exception e){
			throw e;
		}
		return provinciasDTO;
	}

	@Override
	public List<UbigeoDTO> findAllDistritosActive(String codDepProv) throws SQLException, Exception {
		// TODO Auto-generated method stub
		List<UbigeoDTO> distritosDTO = new ArrayList<UbigeoDTO>();
		try{
			List<Ubigeo> distritos = ubigeodao.allDistritosActive(codDepProv);
			for(Ubigeo u:distritos){
				UbigeoDTO ubigeoDTO = new UbigeoDTO();
				BeanUtils.copyProperties(ubigeoDTO, u);
				distritosDTO.add(ubigeoDTO);
			}
		}catch(Exception e){
			throw e;
		}
		return distritosDTO;
	}

	@Override
	public UbigeoDTO findUbigeoByCodUbigeo(String codUbigeo) throws SQLException, Exception {
		// TODO Auto-generated method stub
		UbigeoDTO ubigeoDTO = new UbigeoDTO();
		try{
			Ubigeo ubigeo = ubigeodao.findByCodUbigeo(codUbigeo);
			if(ubigeo != null){
				BeanUtils.copyProperties(ubigeoDTO, ubigeo);
			}
		}catch(Exception e){
			throw e;
		}
		return ubigeoDTO;
	}

	@Override
	public UbigeoDTO findUbigeoById(Long id) throws SQLException, Exception {
		// TODO Auto-generated method stub
		Ubigeo ubigeo = ubigeodao.find(id);
		UbigeoDTO ubigeoDTO = new UbigeoDTO();
		BeanUtils.copyProperties(ubigeoDTO, ubigeo);
		return ubigeoDTO;
	}
}
