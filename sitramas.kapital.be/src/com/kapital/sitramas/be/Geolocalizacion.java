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
@Table(name="tbl_geolocalizacion")
@NamedQuery(name="Geolocalizacion.findAll", query="SELECT g FROM Geolocalizacion g")
public class Geolocalizacion implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GeolocalizacionPK id;
	
	@Column(name="c_latitud")
	private String latitud;
	
	@Column(name="c_longitud")
	private String longitud;
	
	@Column(name="c_estado")
	private String estado;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="n_id_servicio", insertable=false, updatable=false)
	private Servicio servicio;
	
	private Geolocalizacion(){
		
	}

	public GeolocalizacionPK getId() {
		return id;
	}

	public void setId(GeolocalizacionPK id) {
		this.id = id;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
}
