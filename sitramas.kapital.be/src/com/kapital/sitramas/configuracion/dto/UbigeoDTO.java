package com.kapital.sitramas.configuracion.dto;

import java.io.Serializable;

public class UbigeoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String departamento;
	private String provincia;
	private String distrito;
	private String codUbigeo;
	private Integer estado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getCodUbigeo() {
		return codUbigeo;
	}
	public void setCodUbigeo(String codUbigeo) {
		this.codUbigeo = codUbigeo;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
}
