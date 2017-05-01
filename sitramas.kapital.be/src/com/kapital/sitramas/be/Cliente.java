package com.kapital.sitramas.be;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_cliente database table.
 * 
 */
@Entity
@Table(name="tbl_cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="n_id_cliente")
	private Long id;

	@Column(name="c_correo_representante")
	private String correoRepresentante;

	@Column(name="c_direccion")
	private String direccion;

	@Column(name="c_estado")
	private String estado;

	@Column(name="c_nom_representante")
	private String nombreRepresentante;

	@Column(name="c_nombre_cliente")
	private String nombreCliente;

	@Column(name="c_num_ruc")
	private String numRuc;

	@Column(name="c_numero_celular")
	private String numeroCelular1;

	@Column(name="c_numero_telefono1")
	private String numeroCelular2;

	@Column(name="c_pagina_web")
	private String paginaWeb;

	@Column(name="c_usucrea")
	private String usuarioCreacion;

	@Column(name="c_usumod")
	private String usuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_feccrea")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_fecmod")
	private Date fechaModificacion;

	@Column(name="n_id_ubigeo")
	private Long idUbigeo;

	
	public Cliente() {
	}

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