package com.kapital.sitramas.be;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.persistence.*;

import com.kapital.sitramas.common.enums.EstadoEnum;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_privilegio database table.
 * 
 */
@Entity
@Table(name="tbl_privilegio")
@NamedQuery(name="Privilegio.findAll", query="SELECT p FROM Privilegio p")
public class Privilegio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="n_id_privilegio")
	private Long id;

	@Column(name="c_desc_privilegio")
	private String descripcionPrivilegio;

	@Column(name="c_estado")
	private Integer estado;

	@Column(name="c_nom_privilegio")
	private String nombrePrivilegio;

	@Column(name="c_usucrea")
	private String usuarioCreacion;

	@Column(name="c_usumod")
	private String usuarioModifica;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_feccrea")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="d_fecmod")
	private Date fechaModificacion;

	@Transient
	private String estadoDescr;
	
	@Transient
	private String strfechaCreacion;
	
	//bi-directional many-to-many association to Rol
	@ManyToMany(mappedBy="tblPrivilegios")
	private List<Rol> tblRols;

	public Privilegio() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescripcionPrivilegio() {
		return descripcionPrivilegio;
	}

	public void setDescripcionPrivilegio(String descripcionPrivilegio) {
		this.descripcionPrivilegio = descripcionPrivilegio;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getNombrePrivilegio() {
		return nombrePrivilegio;
	}

	public void setNombrePrivilegio(String nombrePrivilegio) {
		this.nombrePrivilegio = nombrePrivilegio;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioModifica() {
		return usuarioModifica;
	}

	public void setUsuarioModifica(String usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
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

	public List<Rol> getTblRols() {
		return this.tblRols;
	}

	public void setTblRols(List<Rol> tblRols) {
		this.tblRols = tblRols;
	}

	public String getEstadoDescr() {
		if(estado.intValue() == EstadoEnum.ACTIVO.getValue()){
			estadoDescr = EstadoEnum.ACTIVO.name();
		}else{
			estadoDescr = EstadoEnum.INACTIVO.name();
		}
		return estadoDescr;
	}

	public void setEstadoDescr(String estadoDescr) {
		this.estadoDescr = estadoDescr;
	}

	public String getStrfechaCreacion() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		strfechaCreacion = sdf.format(fechaCreacion);
		return strfechaCreacion;
	}

	public void setStrfechaCreacion(String strfechaCreacion) {
		this.strfechaCreacion = strfechaCreacion;
	}

}