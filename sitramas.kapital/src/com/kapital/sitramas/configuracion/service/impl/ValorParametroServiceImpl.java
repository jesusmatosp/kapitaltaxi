package com.kapital.sitramas.configuracion.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kapital.sitramas.be.ValorParametro;
import com.kapital.sitramas.configuracion.dao.ValorParametroDAO;
import com.kapital.sitramas.configuracion.dto.ValorParametroDTO;
import com.kapital.sitramas.configuracion.service.ValorParametroService;

@Service
@Transactional( readOnly = true )
public class ValorParametroServiceImpl implements ValorParametroService {

	@Autowired
	private ValorParametroDAO valorParamDAO;
	
	@Override
	public List<ValorParametroDTO> listValorParametro(Long idParametro) throws Exception {
		// TODO Auto-generated method stub
		List<ValorParametro> valorParametros = new ArrayList<ValorParametro>();
		List<ValorParametroDTO> valorParametrosDTO = new ArrayList<ValorParametroDTO>();
		valorParametros = valorParamDAO.listValorParametro(idParametro);
		for(ValorParametro p:valorParametros){
			ValorParametroDTO valorParamDTO = new ValorParametroDTO();
			BeanUtils.copyProperties(valorParamDTO, p);
			valorParametrosDTO.add(valorParamDTO);
		}
		return valorParametrosDTO;
	}

}
