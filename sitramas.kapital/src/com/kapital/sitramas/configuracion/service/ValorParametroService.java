package com.kapital.sitramas.configuracion.service;

import java.util.List;

import com.kapital.sitramas.configuracion.dto.ValorParametroDTO;

public interface ValorParametroService {
	public List<ValorParametroDTO> listValorParametro(Long idParametro) throws Exception;
}
