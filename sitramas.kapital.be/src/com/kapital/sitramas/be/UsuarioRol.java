package com.kapital.sitramas.be;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_usuario_rol database table.
 * 
 */
@Entity
@Table(name="tbl_usuario_rol")
@NamedQuery(name="UsuarioRol.findAll", query="SELECT u FROM UsuarioRol u")
public class UsuarioRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuarioRolPK id;

	public UsuarioRol() {
	}

	public UsuarioRolPK getId() {
		return this.id;
	}

	public void setId(UsuarioRolPK id) {
		this.id = id;
	}

}