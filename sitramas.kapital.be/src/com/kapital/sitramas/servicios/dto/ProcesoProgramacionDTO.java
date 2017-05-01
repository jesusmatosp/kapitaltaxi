package com.kapital.sitramas.servicios.dto;

import java.io.Serializable;

public class ProcesoProgramacionDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String file;
	private Long idProgramacion;
	private Long idCargaMasiva;
	
	

	public ProcesoProgramacionDTO() { } 
	
	public ProcesoProgramacionDTO(String file, Long idProgramacion, Long idCargaMasiva) {
		this.file = file;
		this.idProgramacion = idProgramacion;
		this.idCargaMasiva = idCargaMasiva;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public Long getIdProgramacion() {
		return idProgramacion;
	}
	public void setIdProgramacion(Long idProgramacion) {
		this.idProgramacion = idProgramacion;
	}
	public Long getIdCargaMasiva() {
		return idCargaMasiva;
	}
	public void setIdCargaMasiva(Long idCargaMasiva) {
		this.idCargaMasiva = idCargaMasiva;
	}
	
	
}
