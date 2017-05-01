package com.kapital.sitramas.be;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_incidencia database table.
 * 
 */
@Entity
@Table(name="tbl_incidencia")
@NamedQuery(name="Incidencia.findAll", query="SELECT i FROM Incidencia i")
public class Incidencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="n_id_incidencia")
	private int nIdIncidencia;

	@Column(name="c_desc_incidencia")
	private String cDescIncidencia;

	@Column(name="c_latitud")
	private String cLatitud;

	@Column(name="c_longitud")
	private String cLongitud;

	@Column(name="c_observaciones")
	private String cObservaciones;

	@Column(name="c_ruta_fotografia")
	private String cRutaFotografia;

	@Column(name="c_usucrea")
	private String cUsucrea;

	@Column(name="c_usumod")
	private String cUsumod;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_fec_incidencia")
	private Date dFecIncidencia;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_feccrea")
	private Date dFeccrea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Column(name="n_tipo_incidencia")
	private int nTipoIncidencia;

	public Incidencia() {
	}

	public int getNIdIncidencia() {
		return this.nIdIncidencia;
	}

	public void setNIdIncidencia(int nIdIncidencia) {
		this.nIdIncidencia = nIdIncidencia;
	}

	public String getCDescIncidencia() {
		return this.cDescIncidencia;
	}

	public void setCDescIncidencia(String cDescIncidencia) {
		this.cDescIncidencia = cDescIncidencia;
	}

	public String getCLatitud() {
		return this.cLatitud;
	}

	public void setCLatitud(String cLatitud) {
		this.cLatitud = cLatitud;
	}

	public String getCLongitud() {
		return this.cLongitud;
	}

	public void setCLongitud(String cLongitud) {
		this.cLongitud = cLongitud;
	}

	public String getCObservaciones() {
		return this.cObservaciones;
	}

	public void setCObservaciones(String cObservaciones) {
		this.cObservaciones = cObservaciones;
	}

	public String getCRutaFotografia() {
		return this.cRutaFotografia;
	}

	public void setCRutaFotografia(String cRutaFotografia) {
		this.cRutaFotografia = cRutaFotografia;
	}

	public String getCUsucrea() {
		return this.cUsucrea;
	}

	public void setCUsucrea(String cUsucrea) {
		this.cUsucrea = cUsucrea;
	}

	public String getCUsumod() {
		return this.cUsumod;
	}

	public void setCUsumod(String cUsumod) {
		this.cUsumod = cUsumod;
	}

	public Date getDFecIncidencia() {
		return this.dFecIncidencia;
	}

	public void setDFecIncidencia(Date dFecIncidencia) {
		this.dFecIncidencia = dFecIncidencia;
	}

	public Date getDFeccrea() {
		return this.dFeccrea;
	}

	public void setDFeccrea(Date dFeccrea) {
		this.dFeccrea = dFeccrea;
	}

	public Date getDFecmod() {
		return this.dFecmod;
	}

	public void setDFecmod(Date dFecmod) {
		this.dFecmod = dFecmod;
	}

	public int getNTipoIncidencia() {
		return this.nTipoIncidencia;
	}

	public void setNTipoIncidencia(int nTipoIncidencia) {
		this.nTipoIncidencia = nTipoIncidencia;
	}

}