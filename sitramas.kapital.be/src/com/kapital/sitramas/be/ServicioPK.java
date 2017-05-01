package com.kapital.sitramas.be;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ServicioPK implements Serializable{

	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	
	@Column(name="n_id_servicio")
	private Long idServicio;
	
	@Column(name="n_id_sede", insertable=false, updatable=false)
	private Long idSede;
	
	public ServicioPK(){
		
	}
	
	public Long getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}
	public Long getIdSede() {
		return idSede;
	}
	public void setIdSede(Long idSede) {
		this.idSede = idSede;
	}
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ServicioPK)) {
			return false;
		}
		ServicioPK castOther = (ServicioPK)other;
		return 
			(this.idServicio == castOther.idServicio)
			&& (this.idSede == castOther.idSede);
	}

	public int hashCode() {
		final Long prime = 31L;
		Long hash = 17L;
		hash = hash * prime + this.idServicio;
		hash = hash * prime + this.idSede;
		
		return hash.intValue();
	}
	
}
