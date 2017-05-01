package com.kapital.sitramas.servicios.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import com.kapital.sitramas.be.DetalleServicio;
import com.kapital.sitramas.be.Geolocalizacion;
import com.kapital.sitramas.be.Programacion;
import com.kapital.sitramas.be.Sede;

public class ServicioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long idUnidadConductor;
	private Date fechaProgramacion;
	private String codServicio;
	private Date horaLlegada;
	private Date horaProgramada;
	private String entradaSalida;
	private Integer tipoServicio;
	private String estadoServicio;
	private String motivo;
	private String descrMotivo;
	private Date fechaCreacion;
	private String usuarioCreacion;
	private Date fechaModificacion;
	private String usuarioModificacion;	
	private Long idSede;
	private List<Programacion> programaciones; 
	private List<DetalleServicio> detalleServicio;
	private List<Sede> sedes;
	private List<Geolocalizacion> geolocalizaciones;
	
	public ServicioDTO(){
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdUnidadConductor() {
		return idUnidadConductor;
	}
	public void setIdUnidadConductor(Long idUnidadConductor) {
		this.idUnidadConductor = idUnidadConductor;
	}
	public Date getFechaProgramacion() {
		return fechaProgramacion;
	}
	public void setFechaProgramacion(Date fechaProgramacion) {
		this.fechaProgramacion = fechaProgramacion;
	}
	public String getCodServicio() {
		return codServicio;
	}
	public void setCodServicio(String codServicio) {
		this.codServicio = codServicio;
	}
	public Date getHoraLlegada() {
		return horaLlegada;
	}
	public void setHoraLlegada(Date horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	public Date getHoraProgramada() {
		return horaProgramada;
	}
	public void setHoraProgramada(Date horaProgramada) {
		this.horaProgramada = horaProgramada;
	}
	public String getEntradaSalida() {
		return entradaSalida;
	}
	public void setEntradaSalida(String entradaSalida) {
		this.entradaSalida = entradaSalida;
	}
	public Integer getTipoServicio() {
		return tipoServicio;
	}
	public void setTipoServicio(Integer tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	public String getEstadoServicio() {
		return estadoServicio;
	}
	public void setEstadoServicio(String estadoServicio) {
		this.estadoServicio = estadoServicio;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getDescrMotivo() {
		return descrMotivo;
	}
	public void setDescrMotivo(String descrMotivo) {
		this.descrMotivo = descrMotivo;
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
	public Long getIdSede() {
		return idSede;
	}
	public void setIdSede(Long idSede) {
		this.idSede = idSede;
	}
	public List<Programacion> getProgramaciones() {
		return programaciones;
	}
	public void setProgramaciones(List<Programacion> programaciones) {
		this.programaciones = programaciones;
	}
	public List<DetalleServicio> getDetalleServicio() {
		return detalleServicio;
	}
	public void setDetalleServicio(List<DetalleServicio> detalleServicio) {
		this.detalleServicio = detalleServicio;
	}
	public List<Sede> getSedes() {
		return sedes;
	}
	public void setSedes(List<Sede> sedes) {
		this.sedes = sedes;
	}
	public List<Geolocalizacion> getGeolocalizaciones() {
		return geolocalizaciones;
	}
	public void setGeolocalizaciones(List<Geolocalizacion> geolocalizaciones) {
		this.geolocalizaciones = geolocalizaciones;
	}
	
	
	
}
