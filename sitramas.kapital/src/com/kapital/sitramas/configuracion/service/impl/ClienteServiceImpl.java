package com.kapital.sitramas.configuracion.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kapital.sitramas.be.Cliente;
import com.kapital.sitramas.configuracion.dao.ClienteDAO;
import com.kapital.sitramas.configuracion.dto.ClienteDTO;
import com.kapital.sitramas.configuracion.service.ClienteService;

@Service
@Transactional( readOnly = true )
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDAO clientedao;
	
	@Override
	public List<ClienteDTO> allClienteActives() throws SQLException, Exception {
		// TODO Auto-generated method stub
		List<ClienteDTO> clientesDTO = null;
		try{
			List<Cliente> clientes = clientedao.allActives();
			clientesDTO = new ArrayList<ClienteDTO>();
			
			for(Cliente cliente:clientes){
				ClienteDTO clienteDTO = new ClienteDTO();
				BeanUtils.copyProperties(clienteDTO, cliente);
				clientesDTO.add(clienteDTO);
			}
			
		}catch(Exception e){
			throw e;
		}
		return clientesDTO;
	}

	@Override
	public ClienteDTO findClienteById(Long id) throws SQLException, Exception {
		// TODO Auto-generated method stub
		ClienteDTO clientedto = null;
		try{
			Cliente cliente = clientedao.find(id);
			if(cliente != null){
				clientedto = new ClienteDTO();
				BeanUtils.copyProperties(clientedto, cliente);
			}
		}catch(Exception e){
			throw e;
		}
		return clientedto;
	}

}
