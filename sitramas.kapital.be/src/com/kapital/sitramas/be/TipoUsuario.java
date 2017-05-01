package com.kapital.sitramas.be;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_tipo_usuario database table.
 * 
 */
@Entity
@Table(name="tbl_tipo_usuario")
@NamedQuery(name="TipoUsuario.findAll", query="SELECT t FROM TipoUsuario t")
public class TipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="n_id_tipo_usuario")
	private Long id;

	@Column(name="c_desc_tipo_usuario")
	private String descrTipoUsuario;

	@Column(name="c_estado")
	private Long estado;

	@Column(name="c_nom_tipo_usuario")
	private String nombreTipoUsuario;

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

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tblTipoUsuario")
	private List<Usuario> tblUsuarios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrTipoUsuario() {
		return descrTipoUsuario;
	}

	public void setDescrTipoUsuario(String descrTipoUsuario) {
		this.descrTipoUsuario = descrTipoUsuario;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public String getNombreTipoUsuario() {
		return nombreTipoUsuario;
	}

	public void setNombreTipoUsuario(String nombreTipoUsuario) {
		this.nombreTipoUsuario = nombreTipoUsuario;
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

	public List<Usuario> getTblUsuarios() {
		return tblUsuarios;
	}

	public void setTblUsuarios(List<Usuario> tblUsuarios) {
		this.tblUsuarios = tblUsuarios;
	}

	public TipoUsuario() {
	}

	

}