package com.kapital.sitramas.seguridad.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.kapital.sitramas.be.Privilegio;

public class RolDTO implements Serializable {

	private Long id;
	private String descripcionRol;
	private String estado;
	private String nombreRol;
	private String usuarioCreacion;
	private String usuarioModificacion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estadoDescr;
	private String strFechaCreacion;
	private String strFechaModificacion;
	private List<PrivilegioDTO> tblPrivilegios;
	
	private boolean activa;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcionRol() {
		return descripcionRol;
	}
	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
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
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public String getEstadoDescr() {
		return estadoDescr;
	}
	public void setEstadoDescr(String estadoDescr) {
		this.estadoDescr = estadoDescr;
	}
	public String getStrFechaCreacion() {
		return strFechaCreacion;
	}
	public void setStrFechaCreacion(String strFechaCreacion) {
		this.strFechaCreacion = strFechaCreacion;
	}
	public String getStrFechaModificacion() {
		return strFechaModificacion;
	}
	public void setStrFechaModificacion(String strFechaModificacion) {
		this.strFechaModificacion = strFechaModificacion;
	}
	public List<PrivilegioDTO> getTblPrivilegios() {
		return tblPrivilegios;
	}
	public void setTblPrivilegios(List<PrivilegioDTO> tblPrivilegios) {
		this.tblPrivilegios = tblPrivilegios;
	}
	public boolean isActiva() {
		return activa;
	}
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	
	
}
