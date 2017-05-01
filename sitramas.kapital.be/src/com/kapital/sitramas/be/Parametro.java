package com.kapital.sitramas.be;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name="tbl_parametro" )
@NamedQuery(name="Parametro.findAll", query="SELECT p FROM Parametro p")
public class Parametro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="n_id_parametro")
	private Long id;

	@Column(name="c_nom_parametro")
	private String nombreParametro;
	
	@Column(name="c_estado")
	private Integer estado;
	
	@Column(name="c_descripcion")
	private String descrParametro;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_feccrea")
	private Date fechaCreacion;
	
	@Column(name="c_usucrea")
	private String usuarioCreacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_fecmod")
	private Date fechaModificacion;
	
	@Column(name="c_usumod")
	private String usuarioModificacion;

	@OneToMany( mappedBy="parametro" )
	private List<ValorParametro> valorParametros;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreParametro() {
		return nombreParametro;
	}

	public void setNombreParametro(String nombreParametro) {
		this.nombreParametro = nombreParametro;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getDescrParametro() {
		return descrParametro;
	}

	public void setDescrParametro(String descrParametro) {
		this.descrParametro = descrParametro;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<ValorParametro> getValorParametros() {
		return valorParametros;
	}

	public void setValorParametros(List<ValorParametro> valorParametros) {
		this.valorParametros = valorParametros;
	}
}
