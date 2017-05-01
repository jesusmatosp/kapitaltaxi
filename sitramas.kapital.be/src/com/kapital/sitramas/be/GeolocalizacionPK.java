package com.kapital.sitramas.be;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GeolocalizacionPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="n_id_geolocaliza")
	private Long idGeolocalizaion;
	
	@Column(name="n_id_servicio")
	private Long idServicio;
	
	public GeolocalizacionPK(){
		
	}

	public Long getIdGeolocalizaion() {
		return idGeolocalizaion;
	}

	public void setIdGeolocalizaion(Long idGeolocalizaion) {
		this.idGeolocalizaion = idGeolocalizaion;
	}

	public Long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}
	
	
}
