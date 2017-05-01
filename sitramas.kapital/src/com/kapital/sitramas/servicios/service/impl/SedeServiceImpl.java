package com.kapital.sitramas.servicios.service.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kapital.sitramas.be.Sede;
import com.kapital.sitramas.servicios.dao.SedeDAO;
import com.kapital.sitramas.servicios.dto.SedeDTO;
import com.kapital.sitramas.servicios.service.SedeService;

@Service
public class SedeServiceImpl implements SedeService{

	@Autowired
	private SedeDAO sededao;
	
	@Override
	public SedeDTO obtenerSedeById(Long id) throws Exception {
		// TODO Auto-generated method stub
		SedeDTO sedeDTO = null;
		Sede sede = sededao.find(id);
		if(sede != null){
			sedeDTO = new SedeDTO();
			BeanUtils.copyProperties(sedeDTO, sede);
		}
		return sedeDTO;
	}

	
}
