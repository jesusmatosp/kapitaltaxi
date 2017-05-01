package com.kapital.sitramas.be;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tbl_rol_privilegio")
@NamedQuery(name="RolPrivilegio.findAll", query="SELECT rp FROM RolPrivilegio rp ")
public class RolPrivilegio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private RolPrivilegioPK id;

	public RolPrivilegio(){
		
	}
	
	public RolPrivilegioPK getId() {
		return id;
	}

	public void setId(RolPrivilegioPK id) {
		this.id = id;
	}
}
