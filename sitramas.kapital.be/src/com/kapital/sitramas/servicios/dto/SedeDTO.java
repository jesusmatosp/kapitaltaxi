package com.kapital.sitramas.servicios.dto;

import java.io.Serializable;
import java.util.Date;


public class SedeDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String codSede;
	private String nombreSede;
	private String usuarioCreacion;
	private String usuarioModifica;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idCliente;
	private Long idUbigeo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodSede() {
		return codSede;
	}
	public void setCodSede(String codSede) {
		this.codSede = codSede;
	}
	public String getNombreSede() {
		return nombreSede;
	}
	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	public String getUsuarioModifica() {
		return usuarioModifica;
	}
	public void setUsuarioModifica(String usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public Long getIdUbigeo() {
		return idUbigeo;
	}
	public void setIdUbigeo(Long idUbigeo) {
		this.idUbigeo = idUbigeo;
	}
	
	
}
