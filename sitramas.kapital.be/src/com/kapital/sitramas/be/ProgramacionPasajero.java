package com.kapital.sitramas.be;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_pasajero database table.
 * 
 */
@Entity
@Table(name="tbl_programa_pasajero")
@NamedQuery(name="Pasajero.findAll", query="SELECT p FROM ProgramacionPasajero p")
public class ProgramacionPasajero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="n_id_pasajero")
	private Long id;

	@Column(name="c_dni")
	private String dni;
	
	@Column(name="c_estado")
	private String estado;

	@Column(name="c_nombres")
	private String nombres;

	@Column(name="c_campania")
	private String campania;

	@Column(name="c_departamento")
	private String departamento;

	@Column(name="c_direccion")
	private String direccion;

	@Column(name="c_referencia")
	private String referencia;
	
	@Column(name="c_longitud")
	private String longitud;
	
	@Column(name="c_latitud")
	private String latitud;

	@Column(name="c_usucrea")
	private String usuarioCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_feccrea")
	private Date fechaCreacion;
	
	@Column(name="c_usumod")
	private String usuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_fecmod")
	private Date fechaModificacion;
	
	@Column(name="n_id_sede")
	private Long idSede;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_fecha_programacion")
	private Date fechaProgramacion;
	
	@Column(name="c_hora_llegada")
	private String horaLlegada;
	
	@Column(name="c_hora_programada")
	private String horaProgramada;
	
	@Column(name="c_tipo_entrsal")
	private String codEntradaSalida;
	
	@Column(name="c_distrito")
	private String distrito;
	
	@Column(name="c_responsable")
	private String responsable;
	
	@Column(name="c_cod_cobertura")
	private String cobertura;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="n_id_programacion", insertable=false, updatable=false)
	private Programacion programacion;
	
	/*@Column(name="n_id_programacion")
	private Long idProgramacion;*/

	public ProgramacionPasajero() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getCampania() {
		return campania;
	}

	public void setCampania(String campania) {
		this.campania = campania;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
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

	public Long getIdSede() {
		return idSede;
	}

	public void setIdSede(Long idSede) {
		this.idSede = idSede;
	}

	public Date getFechaProgramacion() {
		return fechaProgramacion;
	}

	public void setFechaProgramacion(Date fechaProgramacion) {
		this.fechaProgramacion = fechaProgramacion;
	}

	public String getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public String getHoraProgramada() {
		return horaProgramada;
	}

	public void setHoraProgramada(String horaProgramada) {
		this.horaProgramada = horaProgramada;
	}

	public String getCodEntradaSalida() {
		return codEntradaSalida;
	}

	public void setCodEntradaSalida(String codEntradaSalida) {
		this.codEntradaSalida = codEntradaSalida;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getCobertura() {
		return cobertura;
	}

	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}

	public Programacion getProgramacion() {
		return programacion;
	}

	public void setProgramacion(Programacion programacion) {
		this.programacion = programacion;
	}

	

}