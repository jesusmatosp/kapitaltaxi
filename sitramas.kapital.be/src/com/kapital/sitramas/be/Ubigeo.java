package com.kapital.sitramas.be;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_ubigeo database table.
 * 
 */
@Entity
@Table(name="tbl_ubigeo")
@NamedQuery(name="Ubigeo.findAll", query="SELECT u FROM Ubigeo u")
public class Ubigeo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="n_id_ubigeo")
	private Long id;
	
	@Column(name="c_departamento")
	private String departamento;
	
	@Column(name="c_provincia")
	private String provincia;
	
	@Column(name="c_distrito")
	private String distrito;
	
	@Column(name="c_cod_ubigeo")
	private String codUbigeo;
	

	@Column(name="c_estado")
	private Integer estado;
	
	

	public Ubigeo() {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}