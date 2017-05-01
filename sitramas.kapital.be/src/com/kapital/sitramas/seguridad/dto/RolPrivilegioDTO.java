package com.kapital.sitramas.seguridad.dto;

import java.io.Serializable;

public class RolPrivilegioDTO implements Serializable {

	private Long idRol;
	private Long idPrivilegio;
	
	public Long getIdRol() {
		return idRol;
	}
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}
	public Long getIdPrivilegio() {
		return idPrivilegio;
	}
	public void setIdPrivilegio(Long idPrivilegio) {
		this.idPrivilegio = idPrivilegio;
	}
	
}
