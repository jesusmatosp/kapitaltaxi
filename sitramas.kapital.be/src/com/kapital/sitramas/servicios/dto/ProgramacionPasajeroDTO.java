package com.kapital.sitramas.servicios.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.kapital.sitramas.be.Programacion;

public class ProgramacionPasajeroDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String campania;
	private String departamento;
	private String direccion;
	private String dni;
	private String estado;
	private String latitud;
	private String longitud;
	private String motivoBaja;
	private String nombres;
	private String referencia;
	private String usuarioCreacion;
	private String usuarioModificacion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Integer tipoDocumento;
	
	private Long idSede;
	private Date fechaProgramacion;
	private String horaLlegada;
	private String horaProgramada;
	private String codEntradaSalida;
	private String distrito;
	private String responsable;
	private String cobertura;
	//private ProgramacionDTO programacion;
	private String sede;
	
	public ProgramacionPasajeroDTO() {}
	
	public ProgramacionPasajeroDTO(Long id, String apellidoPaterno, String apellidoMaterno, String campania, String departamento, String direccion,
					String dni, String estado, String latitud, String longitud, String motivoBaja, String nombres, String referencia,
					String usuarioCreacion, String usuarioModificacion, Date fechaCreacion, Date fechaModificacion, Integer tipoDocumento,
					Long idSede, Date fechaProgramacion, String horaLlegada, String horaProgramada, String codEntradaSalida, String distrito,
					String responsable, String cobertura){
		this.id = id;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.campania = campania;
		this.departamento = departamento;
		this.direccion = direccion;
		this.dni = dni;
		this.estado = estado;
		this.latitud = latitud;
		this.longitud = longitud;
		this.motivoBaja = motivoBaja;
		this.nombres = nombres;
		this.referencia = referencia;
		this.usuarioCreacion = usuarioCreacion;
		this.usuarioModificacion = usuarioCreacion;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaCreacion;
		this.tipoDocumento = tipoDocumento;
		this.idSede = idSede;
		this.fechaProgramacion = fechaProgramacion;
		this.horaLlegada = horaLlegada;
		this.horaProgramada = horaProgramada;
		this.codEntradaSalida = codEntradaSalida;
		this.distrito = distrito;
		this.responsable = responsable;
		this.cobertura = cobertura;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
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
	public String getMotivoBaja() {
		return motivoBaja;
	}
	public void setMotivoBaja(String motivoBaja) {
		this.motivoBaja = motivoBaja;
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
	public Integer getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(Integer tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
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

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	
	
	
	
}
