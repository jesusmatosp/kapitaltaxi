package com.kapital.sitramas.procesos;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.kapital.sitramas.servicios.dto.ProgramacionProcessDTO;

public class ProgramacionItemWriter implements ItemWriter<ProgramacionProcessDTO>{

	
	@Override
	public void write(List<? extends ProgramacionProcessDTO> arg0) throws Exception {
		// TODO Auto-generated method stub
		for(ProgramacionProcessDTO programacion:arg0){
			System.out.println("Personas: ["+programacion.getNumero()+", "+programacion.getSede()+", "+
					programacion.getTipo()+", "+programacion.getEntradaSalida()+", "+programacion.getNombres()+", "+programacion.getDni()+
					","+programacion.getCampania()+","+programacion.getDepartamento()+","+programacion.getResponsable()+"]");
		}
	}

}
