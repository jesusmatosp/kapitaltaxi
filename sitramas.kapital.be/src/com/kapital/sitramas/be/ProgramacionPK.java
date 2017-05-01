package com.kapital.sitramas.be;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tbl_programacion database table.
 * 
 */
@Embeddable
public class ProgramacionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="n_id_programacion")
	private Long idProgramacion;

	@Column(name="n_id_cliente", insertable=false, updatable=false)
	private Long idCliente;

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

	public ProgramacionPK() {
	}
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProgramacionPK)) {
			return false;
		}
		ProgramacionPK castOther = (ProgramacionPK)other;
		return 
			(this.idProgramacion == castOther.idProgramacion)
			&& (this.idCliente == castOther.idCliente);
	}

	public int hashCode() {
		final Long prime = 31L;
		Long hash = 17L;
		hash = hash * prime + this.idProgramacion;
		hash = hash * prime + this.idCliente;
		
		return hash.intValue();
	}
}