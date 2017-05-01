package com.kapital.sitramas.servicios.dto;

import java.io.Serializable;
import java.util.Date;

public class CargaMasivaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long idProgramacion;
	private String estadoCarga;
	private String nombreArchivo;
	private String rutaArchivo;
	private String usuarioCarga;
	private Date fechaCarga;
	private Date fechaProceso;
	private int version;
	
	public CargaMasivaDTO(){ }
	
	public CargaMasivaDTO(Long id, Long idProgramacion, String estadoCarga,
			String nombreArchivo, String rutaArchivo, String usuarioCarga, Date fechaCarga, Date fechaProceso,
			int version) {
		this.id = id;
		this.idProgramacion = idProgramacion;
		this.estadoCarga = estadoCarga;
		this.nombreArchivo = nombreArchivo;
		this.rutaArchivo = rutaArchivo;
		this.usuarioCarga = usuarioCarga;
		this.fechaCarga = fechaCarga;
		this.fechaProceso = fechaProceso;
		this.version = version;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdProgramacion() {
		return idProgramacion;
	}
	public void setIdProgramacion(Long idProgramacion) {
		this.idProgramacion = idProgramacion;
	}
	public String getEstadoCarga() {
		return estadoCarga;
	}
	public void setEstadoCarga(String estadoCarga) {
		this.estadoCarga = estadoCarga;
	}
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	public String getRutaArchivo() {
		return rutaArchivo;
	}
	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}
	public String getUsuarioCarga() {
		return usuarioCarga;
	}
	public void setUsuarioCarga(String usuarioCarga) {
		this.usuarioCarga = usuarioCarga;
	}
	public Date getFechaCarga() {
		return fechaCarga;
	}
	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}
	public Date getFechaProceso() {
		return fechaProceso;
	}
	public void setFechaProceso(Date fechaProceso) {
		this.fechaProceso = fechaProceso;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	
}
