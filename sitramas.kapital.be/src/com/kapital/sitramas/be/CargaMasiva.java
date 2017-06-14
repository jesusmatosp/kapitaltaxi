package com.kapital.sitramas.be;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_carga_masiva database table.
 */
@Entity
@Table(name="tbl_carga_masiva")
@NamedQuery(name="CargaMasiva.findAll", query="SELECT c FROM CargaMasiva c")
public class CargaMasiva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="n_id_carga_masiva")
	private Long id;

	@Column(name="n_id_programacion")
	private Long idProgramacion;
	
	@Column(name="c_estado_carga")
	private String estadoCarga;

	@Column(name="c_nombre_archivo")
	private String nombreArchivo;

	@Column(name="c_ruta_archivo")
	private String rutaArchivo;

	@Column(name="c_usuario_carga")
	private String usuarioCarga;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_fecha_carga")
	private Date fechaCarga;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_fecha_proceso")
	private Date fechaProceso;

	@Column(name="n_version")
	private int version;
	
	//bi-directional many-to-one association to Programacion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="n_id_programacion", referencedColumnName="n_id_programacion", insertable=false, updatable=false)
	private Programacion programacion;

	public CargaMasiva() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdProgramacion() {
		return idProgramacion;
	}

	public void setIdProgramacion(Long idProgramacion) {
		this.idProgramacion = idProgramacion;
	}

	public String getEstadoCarga() {
		return estadoCarga;
	}

	public void setEstadoCarga(String estadoCarga) {
		this.estadoCarga = estadoCarga;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	public String getUsuarioCarga() {
		return usuarioCarga;
	}

	public void setUsuarioCarga(String usuarioCarga) {
		this.usuarioCarga = usuarioCarga;
	}

	public Date getFechaCarga() {
		return fechaCarga;
	}

	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	public Date getFechaProceso() {
		return fechaProceso;
	}

	public void setFechaProceso(Date fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Programacion getProgramacion() {
		return programacion;
	}

	public void setProgramacion(Programacion programacion) {
		this.programacion = programacion;
	}

}