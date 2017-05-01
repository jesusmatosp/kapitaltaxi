package com.kapital.sitramas.be;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tbl_detalle_servicio")
@NamedQuery(name="DetalleServicio.findAll", query="SELECT o from DetalleServicio o")
public class DetalleServicio implements Serializable{

	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private DetalleServicioPK id;

	@Column(name="n_id_incidencia")
	private Long idIncidencia;
	
	@Column(name="c_estado_servicio")
	private String estadoServicio;
	
	@Column(name="c_estado")
	private String estado;
	
	@Column(name="c_adicional")
	private String adicional;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="n_id_servicio", insertable=false, updatable=false)
	private Servicio servicio;
	
	
	
	public DetalleServicio(){
		
	}

	public DetalleServicioPK getId() {
		return id;
	}

	public void setId(DetalleServicioPK id) {
		this.id = id;
	}

	public Long getIdIncidencia() {
		return idIncidencia;
	}

	public void setIdIncidencia(Long idIncidencia) {
		this.idIncidencia = idIncidencia;
	}

	public String getEstadoServicio() {
		return estadoServicio;
	}

	public void setEstadoServicio(String estadoServicio) {
		this.estadoServicio = estadoServicio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAdicional() {
		return adicional;
	}

	public void setAdicional(String adicional) {
		this.adicional = adicional;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	
}
