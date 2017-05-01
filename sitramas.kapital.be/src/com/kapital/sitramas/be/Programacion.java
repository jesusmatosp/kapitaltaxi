package com.kapital.sitramas.be;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_programacion database table.
 * 
 */
@Entity
@Table(name="tbl_programacion")
@NamedQuery(name="Programacion.findAll", query="SELECT p FROM Programacion p")
public class Programacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="n_id_programacion")
	private Long id;

	@Column(name="n_id_cliente")
	private Long idCliente;
	
	@Column(name="c_estado")
	private int estado;

	@Column(name="c_usucrea")
	private String usuarioCreacion;

	@Column(name="c_usumod")
	private String usuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_feccrea")
	private Date fechaCreacion;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecha_programacion")
	private Date fechaProgramacion;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date fechaModificacion;

	@Column(name="n_version")
	private Integer version;
	
	@Column(name="c_ruta_archivo")
	private String rutaArchivo;
	
	//bi-directional many-to-one association to CargaMasiva
	@OneToMany(mappedBy="programacion")
	private List<CargaMasiva> lstCargaMasiva;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="n_id_programacion", insertable=false, updatable=false)
	private Servicio servicio;
	
	@OneToMany(mappedBy="programacion")
	private List<ProgramacionPasajero> lstPasajeros;
	
	public Programacion() {
	}

	

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
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

	public Date getFechaProgramacion() {
		return fechaProgramacion;
	}

	public void setFechaProgramacion(Date fechaProgramacion) {
		this.fechaProgramacion = fechaProgramacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public List<CargaMasiva> getLstCargaMasiva() {
		return lstCargaMasiva;
	}

	public void setLstCargaMasiva(List<CargaMasiva> lstCargaMasiva) {
		this.lstCargaMasiva = lstCargaMasiva;
	}

	public CargaMasiva addTblCargaMasiva(CargaMasiva lstCargaMasiva) {
		getLstCargaMasiva().add(lstCargaMasiva);
		lstCargaMasiva.setProgramacion(this);
		return lstCargaMasiva;
	}

	public CargaMasiva removeTblCargaMasiva(CargaMasiva lstCargaMasiva) {
		getLstCargaMasiva().remove(lstCargaMasiva);
		lstCargaMasiva.setProgramacion(null);
		return lstCargaMasiva;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}



	public String getRutaArchivo() {
		return rutaArchivo;
	}



	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}



	public List<ProgramacionPasajero> getLstPasajeros() {
		return lstPasajeros;
	}



	public void setLstPasajeros(List<ProgramacionPasajero> lstPasajeros) {
		this.lstPasajeros = lstPasajeros;
	}

}