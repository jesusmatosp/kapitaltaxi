package com.kapital.sitramas.servicios.dto;

import java.io.Serializable;

import com.kapital.sitramas.be.Servicio;

public class DetalleServicioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idDetalleServicio;
	private Long idServicio;
	private Long idPasajero;
	private Long idCobertura;
	private Long idIncidencia;
	private String estadoServicio;
	private String estado;
	private String adicional;
	private Servicio servicio;
	
	public DetalleServicioDTO(){
		
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
