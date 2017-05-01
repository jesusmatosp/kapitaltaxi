package com.kapital.sitramas.be;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.persistence.*;

import com.kapital.sitramas.common.enums.EstadoEnum;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_rol database table.
 * 
 */
@Entity
@Table(name="tbl_rol")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="n_id_rol")
	private Long id;

	@Column(name="c_desc_rol")
	private String descripcionRol;

	@Column(name="c_estado")
	private String estado;

	@Column(name="c_nom_rol")
	private String nombreRol;

	@Column(name="c_usucrea")
	private String usuarioCreacion;

	@Column(name="c_usumod")
	private String usuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_feccrea")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_fecmod")
	private Date fechaModificacion;
	
	@Transient
	private String estadoDescr;
	@Transient
	private String strFechaCreacion;
	@Transient
	private String strFechaModificacion;

	//bi-directional many-to-many association to Privilegio
	@ManyToMany
	@JoinTable(
		name="tbl_rol_privilegio"
		, joinColumns={
			@JoinColumn(name="n_id_rol")
			}
		, inverseJoinColumns={
			@JoinColumn(name="n_id_privilegio")
			}
		)
	private List<Privilegio> tblPrivilegios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcionRol() {
		return descripcionRol;
	}

	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
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

	public String getEstadoDescr() {
		if(Integer.parseInt(estado) == EstadoEnum.ACTIVO.getValue()){
			estadoDescr = EstadoEnum.ACTIVO.name();
		}else{
			estadoDescr = EstadoEnum.INACTIVO.name();
		}
		return estadoDescr;
	}

	public void setEstadoDescr(String estadoDescr) {
		this.estadoDescr = estadoDescr;
	}

	public List<Privilegio> getTblPrivilegios() {
		return tblPrivilegios;
	}

	public void setTblPrivilegios(List<Privilegio> tblPrivilegios) {
		this.tblPrivilegios = tblPrivilegios;
	}

	public String getStrFechaCreacion() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		strFechaCreacion = sdf.format(fechaCreacion);
		return strFechaCreacion;
	}

	public void setStrFechaCreacion(String strFechaCreacion) {
		this.strFechaCreacion = strFechaCreacion;
	}

	public String getStrFechaModificacion() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		strFechaModificacion = sdf.format(fechaCreacion);
		return strFechaModificacion;
	}

	public void setStrFechaModificacion(String strFechaModificacion) {
		this.strFechaModificacion = strFechaModificacion;
	}

	

}