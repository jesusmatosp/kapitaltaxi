package com.kapital.sitramas.be;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tbl_usuario database table.
 * 
 */
@Embeddable
public class UsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="n_id_usuario")
	private Long idUsuario;

	@Column(name="n_id_persona", insertable=false, updatable=false)
	private Long idPersona;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public UsuarioPK() {
	}
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuarioPK)) {
			return false;
		}
		UsuarioPK castOther = (UsuarioPK)other;
		return 
			(this.idUsuario == castOther.idUsuario)
			&& (this.idPersona == castOther.idPersona);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + Integer.valueOf(this.idUsuario.toString());
		hash = hash * prime + Integer.valueOf(this.idPersona.toString());
		return hash;
	}
}