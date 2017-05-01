package com.kapital.sitramas.be;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RolPrivilegioPK implements Serializable {

	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	@Column(name="n_id_rol")
	private Long idRol;
	
	@Column(name="n_id_privilegio")
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
