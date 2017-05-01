package com.kapital.sitramas.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kapital.sitramas.seguridad.service.UsuarioService;

@Controller
public class GenericController {

	private boolean menuHome;
	private boolean menuServicios;
	public boolean menuUnidades;
	public boolean menuConductores;
	public boolean menuZonificacion;
	public boolean menuSeguridad;
	public boolean menuSeguridadAdministrarCuenta;
	public boolean menuSeguridadAdministrarPrivilegios;
	public boolean menuSeguridadAdministrarRoles;
	public boolean menuSeguridadAdministrarUsuarios;
	public boolean menuConfiguracion;
	private HttpServletRequest request;
	
	public GenericController(){
		
	}
	
	public GenericController(HttpServletRequest request){
		this.request = request;
	}

	public boolean isMenuHome() {
		return menuHome;
	}

	public void setMenuHome(boolean menuHome) {
		this.menuHome = menuHome;
	}

	public boolean isMenuServicios() {
		return menuServicios;
	}

	public void setMenuServicios(boolean menuServicios) {
		this.menuServicios = menuServicios;
	}
	
	public boolean isMenuUnidades() {
		return menuUnidades;
	}

	public void setMenuUnidades(boolean menuUnidades) {
		this.menuUnidades = menuUnidades;
	}

	public boolean isMenuConductores() {
		return menuConductores;
	}

	public void setMenuConductores(boolean menuConductores) {
		this.menuConductores = menuConductores;
	}

	public boolean isMenuZonificacion() {
		return menuZonificacion;
	}

	public void setMenuZonificacion(boolean menuZonificacion) {
		this.menuZonificacion = menuZonificacion;
	}

	public boolean isMenuSeguridad() {
		return menuSeguridad;
	}

	public void setMenuSeguridad(boolean menuSeguridad) {
		this.menuSeguridad = menuSeguridad;
	}

	public boolean isMenuSeguridadAdministrarCuenta() {
		return menuSeguridadAdministrarCuenta;
	}

	public void setMenuSeguridadAdministrarCuenta(boolean menuSeguridadAdministrarCuenta) {
		this.menuSeguridadAdministrarCuenta = menuSeguridadAdministrarCuenta;
	}

	public boolean isMenuSeguridadAdministrarPrivilegios() {
		return menuSeguridadAdministrarPrivilegios;
	}

	public void setMenuSeguridadAdministrarPrivilegios(boolean menuSeguridadAdministrarPrivilegios) {
		this.menuSeguridadAdministrarPrivilegios = menuSeguridadAdministrarPrivilegios;
	}

	public boolean isMenuSeguridadAdministrarRoles() {
		return menuSeguridadAdministrarRoles;
	}

	public void setMenuSeguridadAdministrarRoles(boolean menuSeguridadAdministrarRoles) {
		this.menuSeguridadAdministrarRoles = menuSeguridadAdministrarRoles;
	}

	public boolean isMenuSeguridadAdministrarUsuarios() {
		return menuSeguridadAdministrarUsuarios;
	}

	public void setMenuSeguridadAdministrarUsuarios(boolean menuSeguridadAdministrarUsuarios) {
		this.menuSeguridadAdministrarUsuarios = menuSeguridadAdministrarUsuarios;
	}

	public boolean isMenuConfiguracion() {
		return menuConfiguracion;
	}

	public void setMenuConfiguracion(boolean menuConfiguracion) {
		this.menuConfiguracion = menuConfiguracion;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}
