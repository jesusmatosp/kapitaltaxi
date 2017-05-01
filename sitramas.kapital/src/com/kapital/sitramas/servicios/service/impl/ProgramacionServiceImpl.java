package com.kapital.sitramas.servicios.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kapital.sitramas.be.Cliente;
import com.kapital.sitramas.be.Programacion;
import com.kapital.sitramas.be.ProgramacionPasajero;
import com.kapital.sitramas.configuracion.dao.ClienteDAO;
import com.kapital.sitramas.servicios.dao.ProgramacionDAO;
import com.kapital.sitramas.servicios.dao.ProgramacionPasajeroDAO;
import com.kapital.sitramas.servicios.dto.ProgramacionDTO;
import com.kapital.sitramas.servicios.dto.ProgramacionPasajeroDTO;
import com.kapital.sitramas.servicios.service.ProgramacionService;
import com.kapital.sitramas.utils.KapitalUtils;

@Service
public class ProgramacionServiceImpl implements ProgramacionService {

	@Autowired
	private ProgramacionDAO programacionDAO;
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private ProgramacionPasajeroDAO programacionPasajeroDAO;
	
	@Override
	public List<ProgramacionDTO> findAllProgramacion() throws SQLException, Exception {
		// TODO Auto-generated method stub
		List<ProgramacionDTO> lstprogramcionDTO = null;
		try{
			List<Programacion> programacion = programacionDAO.all();
			lstprogramcionDTO = new ArrayList<ProgramacionDTO>();
			for(Programacion p:programacion){
				ProgramacionDTO programacionDTO = new ProgramacionDTO();
				BeanUtils.copyProperties(programacionDTO, p);
				programacionDTO.setIdProgramacion(p.getId());
				programacionDTO.setIdCliente(p.getIdCliente());
				Cliente cliente = clienteDAO.find(p.getIdCliente());
				if(cliente!=null)
					programacionDTO.setStrCliente(cliente.getNombreCliente());
				lstprogramcionDTO.add(programacionDTO);
			}
		}catch(Exception e){
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
			throw e;
		}
		return lstprogramcionDTO;
	}

	@Override
	public void saveProgramacion(ProgramacionDTO programacionDTO) throws SQLException, Exception {
		// TODO Auto-generated method stub
		Programacion programacion = new Programacion();
		BeanUtils.copyProperties(programacion, programacionDTO);
		Integer lastVersion = programacionDAO.findByDate(programacionDTO.getFechaProgramacion());
		if(lastVersion != null){
			programacion.setVersion(lastVersion+1);
		}else{
			programacion.setVersion(1);
		}
		programacionDAO.save(programacion);
	}

	@Override
	public ProgramacionDTO findById(Long id) throws SQLException, Exception {
		// TODO Auto-generated method stub
		ProgramacionDTO programacionDTO = null;
		try{
		  Programacion programacion = programacionDAO.find(id);
		  if(programacion != null){
			  programacionDTO = new ProgramacionDTO();
			  BeanUtils.copyProperties(programacionDTO, programacion);
			  programacionDTO.setIdProgramacion(id);
			  Cliente cliente = clienteDAO.find(programacionDTO.getIdCliente());
			  programacionDTO.setStrCliente(cliente.getNombreCliente());
		  }
		}catch(Exception e){
			throw e;
		}
		return programacionDTO;
	}

	@Override
	public void actualizarProgramacion(ProgramacionDTO programacionDTO) throws SQLException, Exception {
		// TODO Auto-generated method stub
		Programacion programacion = new Programacion();
		BeanUtils.copyProperties(programacion, programacionDTO);
		programacion.setId(programacionDTO.getIdProgramacion());
		programacion.setFechaModificacion(KapitalUtils.getCurrentDate());
		programacion.setUsuarioModificacion(programacionDTO.getUsuarioModificacion());
		programacionDAO.save(programacion);
	}

	@Override
	public List<ProgramacionPasajeroDTO> findAllProgramacionCliente(Long idProgramacion, Integer version) throws SQLException, Exception {
		// TODO Auto-generated method stub
		List<ProgramacionPasajeroDTO> pasajeros = null;
		try{
			List<ProgramacionPasajero> oPasajeros = programacionPasajeroDAO.listProgramacionPasajeroActive(idProgramacion, version);
			pasajeros = new ArrayList<ProgramacionPasajeroDTO>();
			for(ProgramacionPasajero pp:oPasajeros){
				ProgramacionPasajeroDTO programacionPasajeroDTO = new ProgramacionPasajeroDTO();
				BeanUtils.copyProperties(programacionPasajeroDTO, pp);
				pasajeros.add(programacionPasajeroDTO);
			}
		}catch(Exception e){
			throw e;
		}
		return pasajeros;
	}

	@Override
	public ProgramacionPasajeroDTO findProgramacionClienteById(Long idProgramacionPasajero)
			throws SQLException, Exception {
		// TODO Auto-generated method stub
		ProgramacionPasajeroDTO programacionDTO = null;
		ProgramacionPasajero programacionPasajero = programacionPasajeroDAO.find(idProgramacionPasajero);
		if(programacionPasajero != null){
			programacionDTO = new ProgramacionPasajeroDTO();
			BeanUtils.copyProperties(programacionDTO, programacionPasajero);
		}
		return programacionDTO;
	}
	
	
}
