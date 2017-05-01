package com.kapital.sitramas.be;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tbl_carga_masiva database table.
 * 
 */
@Embeddable
public class CargaMasivaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="n_id_carga_masiva")
	private Long idCargaMasiva;

	@Column(name="n_id_programacion", insertable=false, updatable=false)
	private Long idProgramacion;

	@Column(name="n_id_cliente", insertable=false, updatable=false)
	private Long idCliente;

	public CargaMasivaPK() {
	}
	
	public Long getIdCargaMasiva() {
		return idCargaMasiva;
	}
	
	public void setIdCargaMasiva(Long idCargaMasiva) {
		this.idCargaMasiva = idCargaMasiva;
	}

	public Long getIdProgramacion() {
		return idProgramacion;
	}

	public void setIdProgramacion(Long idProgramacion) {
		this.idProgramacion = idProgramacion;
	}
	
	public Long getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CargaMasivaPK)) {
			return false;
		}
		CargaMasivaPK castOther = (CargaMasivaPK)other;
		return 
			(this.idCargaMasiva == castOther.idCargaMasiva)
			&& (this.idProgramacion == castOther.idProgramacion)
			&& (this.idCliente == castOther.idCliente);
	}

	public int hashCode() {
		final Long prime = 31L;
		Long hash = 17L;
		hash = hash * prime + this.idCargaMasiva;
		hash = hash * prime + this.idProgramacion;
		hash = hash * prime + this.idCliente;
		
		return hash.intValue();
	}
}