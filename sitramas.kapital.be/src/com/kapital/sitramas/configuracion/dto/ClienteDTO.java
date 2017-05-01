package com.kapital.sitramas.configuracion.dto;

import java.io.Serializable;
import java.util.Date;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String correoRepresentante;
	private String direccion;
	private String estado;
	private String nombreRepresentante;
	private String nombreCliente;
	private String numRuc;
	private String numeroCelular1;
	private String numeroCelular2;
	private String paginaWeb;
	private String usuarioCreacion;
	private String usuarioModificacion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idUbigeo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCorreoRepresentante() {
		return correoRepresentante;
	}
	public void setCorreoRepresentante(String correoRepresentante) {
		this.correoRepresentante = correoRepresentante;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNombreRepresentante() {
		return nombreRepresentante;
	}
	public void setNombreRepresentante(String nombreRepresentante) {
		this.nombreRepresentante = nombreRepresentante;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getNumRuc() {
		return numRuc;
	}
	public void setNumRuc(String numRuc) {
		this.numRuc = numRuc;
	}
	public String getNumeroCelular1() {
		return numeroCelular1;
	}
	public void setNumeroCelular1(String numeroCelular1) {
		this.numeroCelular1 = numeroCelular1;
	}
	public String getNumeroCelular2() {
		return numeroCelular2;
	}
	public void setNumeroCelular2(String numeroCelular2) {
		this.numeroCelular2 = numeroCelular2;
	}
	public String getPaginaWeb() {
		return paginaWeb;
	}
	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public Long getIdUbigeo() {
		return idUbigeo;
	}
	public void setIdUbigeo(Long idUbigeo) {
		this.idUbigeo = idUbigeo;
	}
	
}
