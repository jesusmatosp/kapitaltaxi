package com.kapital.sitramas.seguridad.dto;

import java.io.Serializable;

public class UsuarioRolDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idUsuario;
	private Long idRol;
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Long getIdRol() {
		return idRol;
	}
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}
	
	
}
