package com.kapital.sitramas.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.kapital.sitramas.model.ServicioModel;

public class ProgramacionFieldSetMapper implements FieldSetMapper<ServicioModel> {

	
	public ServicioModel mapFieldSet(FieldSet fieldSet) throws BindException {
		// TODO Auto-generated method stub
		/**
		 * 
		 * 0-fecha, 1-proveedor, 2-sede, 3-entradaSalida, 4-tipo, 5-campania, 6-departamento, 7-responsable, 8-dni, 9-nombres,
		  10-direccion, 11-referencia, 12-distrito, 13-cobertura, 14-telefono1, 15-telefono2, 16-celular, 
		  17-observaciones, 18-horaIngreso, 19-direcciondup, 20-coordenadas
		 * 
		 * **/
		ServicioModel servicio = new ServicioModel();
		servicio.setFecha(fieldSet.readString(0));
		servicio.setSede(fieldSet.readString(2));
		servicio.setEntradaSalida(fieldSet.readString(3));
		servicio.setTipo(fieldSet.readString(4));
		servicio.setCampania(fieldSet.readString(5));
		servicio.setDepartamento(fieldSet.readString(6));
		servicio.setResponsable(fieldSet.readString(7));
		servicio.setDni(fieldSet.readString(8));
		servicio.setNombres(fieldSet.readString(9));
		servicio.setDireccion(fieldSet.readString(10));
		if(fieldSet.readString(11).isEmpty()){
			servicio.setReferencia("-");
		}else{
			servicio.setReferencia(fieldSet.readString(11));
		}
		servicio.setDistrito(fieldSet.readString(12));
		servicio.setCobertura(fieldSet.readString(13));
		servicio.setTelefono1(fieldSet.readString(14).isEmpty() ? "-" : fieldSet.readString(14));
		servicio.setTelefono2(fieldSet.readString(15).isEmpty() ? "-" : fieldSet.readString(15));
		servicio.setObservaciones(fieldSet.readString(16).isEmpty() ? "-" : fieldSet.readString(16));
		servicio.setCelular(fieldSet.readString(17).isEmpty() ? "-" : fieldSet.readString(17));
		servicio.setHoraIngreso(fieldSet.readString(18));
		servicio.setDireccionDuplicada(fieldSet.readString(19).isEmpty() ? "-" : fieldSet.readString(19));
		servicio.setCoordenadas(fieldSet.readString(20).isEmpty() ? "-" : fieldSet.readString(20));
		
		return servicio;
	}

	
}
