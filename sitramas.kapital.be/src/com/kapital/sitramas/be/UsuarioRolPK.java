package com.kapital.sitramas.be;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioRolPK implements Serializable{

	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	
	@Column(name="n_id_usuario")
	private Long idUsuario;
	
	@Column(name="n_id_rol")
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
