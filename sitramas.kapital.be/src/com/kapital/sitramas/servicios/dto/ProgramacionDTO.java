package com.kapital.sitramas.servicios.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.kapital.sitramas.common.enums.EstadoProgramacionEnum;

public class ProgramacionDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long idProgramacion;
	private Long idCliente;
	private int estado;
	private String usuarioCreacion;
	private String usuarioModificacion;
	private Date fechaCreacion;
	private Date fechaProgramacion;
	private Date fechaModificacion;
	private Integer version;
	private String rutaArchivo;
	// Utils
	private String strCliente;
	private String strFechaProgramacion;
	private String strEstadoProgramacion;
	private boolean flgBorrador;
	
	public String getStrCliente() {
		return strCliente;
	}

	public void setStrCliente(String strCliente) {
		this.strCliente = strCliente;
	}

	public String getStrFechaProgramacion() {
		if(fechaProgramacion != null){
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			strFechaProgramacion = sdf.format(fechaProgramacion);
		}
		return strFechaProgramacion;
	}

	public void setStrFechaProgramacion(String strFechaProgramacion) {
		this.strFechaProgramacion = strFechaProgramacion;
	}

	public String getStrEstadoProgramacion() {
		strEstadoProgramacion = EstadoProgramacionEnum.get(estado).name();
		return strEstadoProgramacion;
	}

	public void setStrEstadoProgramacion(String strEstadoProgramacion) {
		this.strEstadoProgramacion = strEstadoProgramacion;
	}

	public ProgramacionDTO(){
		
	}

	public Long getIdProgramacion() {
		return idProgramacion;
	}

	public void setIdProgramacion(Long idProgramacion) {
		this.idProgramacion = idProgramacion;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaProgramacion() {
		return fechaProgramacion;
	}

	public void setFechaProgramacion(Date fechaProgramacion) {
		this.fechaProgramacion = fechaProgramacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	public boolean isFlgBorrador() {
		return flgBorrador;
	}

	public void setFlgBorrador(boolean flgBorrador) {
		this.flgBorrador = flgBorrador;
	}
	
	
	
}
