package com.kapital.sitramas.be;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetalleServicioPK implements Serializable{

	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	
	@Column(name="n_id_detalle_servicio")
	private Long idDetalleServicio;
	
	@Column(name="n_id_servicio", insertable=false, updatable=false)
	private Long idServicio;
	
	@Column(name="n_id_pasajero", insertable=false, updatable=false)
	private Long idPasajero;
	
	@Column(name="n_id_cobertura", insertable=false, updatable=false)
	private Long idCobertura;
	
	public DetalleServicioPK(){
		
	}
	
	public Long getIdDetalleServicio() {
		return idDetalleServicio;
	}
	public void setIdDetalleServicio(Long idDetalleServicio) {
		this.idDetalleServicio = idDetalleServicio;
	}
	public Long getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}
	public Long getIdPasajero() {
		return idPasajero;
	}
	public void setIdPasajero(Long idPasajero) {
		this.idPasajero = idPasajero;
	}
	public Long getIdCobertura() {
		return idCobertura;
	}
	public void setIdCobertura(Long idCobertura) {
		this.idCobertura = idCobertura;
	}
	
	
}
