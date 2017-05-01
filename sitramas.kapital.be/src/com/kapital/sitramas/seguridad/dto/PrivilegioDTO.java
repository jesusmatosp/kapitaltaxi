package com.kapital.sitramas.seguridad.dto;

import java.io.Serializable;
import java.util.Date;

public class PrivilegioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombrePrivilegio;
	private String descripcionPrivilegio;
	private String estado;
	private String usuarioCreacion;
	private String usuarioModifica;
	private Date fechaCreacion;
	private Date fechaModificacion;
	
	private boolean activa;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
	public boolean isActiva() {
		return activa;
	}
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	public String getNombrePrivilegio() {
		return nombrePrivilegio;
	}
	public void setNombrePrivilegio(String nombrePrivilegio) {
		this.nombrePrivilegio = nombrePrivilegio;
	}
	public String getDescripcionPrivilegio() {
		return descripcionPrivilegio;
	}
	public void setDescripcionPrivilegio(String descripcionPrivilegio) {
		this.descripcionPrivilegio = descripcionPrivilegio;
	}

}
