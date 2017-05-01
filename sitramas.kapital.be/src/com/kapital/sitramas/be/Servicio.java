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
@Table(name="tbl_servicio")
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="n_id_servicio")
	private Long id;
	
	@Column(name="n_id_unidad_conductor")
	private Long idUnidadConductor;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_fecha_programacion")
	private Date fechaProgramacion;
	
	@Column(name="c_cod_servicio")
	private String codServicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="c_hora_llegada")
	private Date horaLlegada;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="c_hora_programada")
	private Date horaProgramada;
	
	@Column(name="c_tipo_entrsal")
	private String entradaSalida;
	
	@Column(name="n_tipo_servicio")
	private Integer tipoServicio;
	
	@Column(name="c_est_serv")
	private String estadoServicio;
	
	@Column(name="c_motivo")
	private String motivo;
	
	@Column(name="c_desc_motivo")
	private String descrMotivo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_feccrea")
	private Date fechaCreacion;
	
	@Column(name="c_usucrea")
	private String usuarioCreacion;
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date fechaModificacion;
	
	@Column(name="c_usumod")
	private String usuarioModificacion;
	
	@Column(name="n_id_sede")
	private Long idSede;
	
	@OneToMany(mappedBy="servicio")
	private List<Programacion> programaciones; 
	
	@OneToMany(mappedBy="servicio")
	private List<DetalleServicio> detalleServicio;
	
	/*@OneToMany(mappedBy="servicio")
	private List<Sede> sedes;*/
	
	@OneToMany(mappedBy="servicio")
	private List<Geolocalizacion> geolocalizaciones;
	
	public Servicio(){
		
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

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
}
