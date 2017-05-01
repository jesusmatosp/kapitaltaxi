package com.kapital.sitramas.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.kapital.sitramas.be.Privilegio;
import com.kapital.sitramas.common.enums.EstadoCivilEnum;
import com.kapital.sitramas.common.enums.EstadoEnum;
import com.kapital.sitramas.common.enums.ParametroEnum;
import com.kapital.sitramas.common.enums.SexoEnum;
import com.kapital.sitramas.configuracion.dto.ClienteDTO;
import com.kapital.sitramas.configuracion.dto.UbigeoDTO;
import com.kapital.sitramas.configuracion.dto.ValorParametroDTO;
import com.kapital.sitramas.configuracion.service.ClienteService;
import com.kapital.sitramas.configuracion.service.UbigeoService;
import com.kapital.sitramas.configuracion.service.ValorParametroService;
import com.kapital.sitramas.seguridad.dto.PersonaDTO;
import com.kapital.sitramas.seguridad.dto.PrivilegioDTO;
import com.kapital.sitramas.seguridad.dto.RolDTO;
import com.kapital.sitramas.seguridad.dto.UsuarioDTO;
import com.kapital.sitramas.seguridad.service.MessageSender;
import com.kapital.sitramas.seguridad.service.PrivilegioService;
import com.kapital.sitramas.seguridad.service.RolService;
import com.kapital.sitramas.seguridad.service.UsuarioService;
import com.kapital.sitramas.seguridad.service.impl.AsynchMessReceiver;

@Controller
@RequestMapping("/seguridad")
public class AdministrarCuentaController {

	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PrivilegioService privilegioService;
	
	@Autowired
	private RolService roleService;
	
	@Autowired
	private UbigeoService ubigeoService;
	
	@Autowired
	private ValorParametroService valorparamService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private MessageSender messageSender;
	
	@Autowired
	private AsynchMessReceiver messageReceiver;
	
	@RequestMapping(value="/cuenta", method=RequestMethod.GET)
	public String updateContrasenia(){
		return "cuenta";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ModelAndView updatePassword(@RequestParam("password_old") String passwordOld,
									   @RequestParam("password_new") String passwordNew,
									   @RequestParam("password_confirm") String passwordConfirm,
									   HttpServletRequest request){
		ModelAndView model = new ModelAndView();
		String username = request.getUserPrincipal().getName();
		String password = usuarioService.findPasswordByUsername(username);
		if(password.equals(passwordOld)){
			usuarioService.updatePasswordByUsername(username, passwordNew);
			UsuarioDTO user = new UsuarioDTO();
			user.setUsuario(username);
			user.setStrpassword(passwordNew);
			messageSender.sendMessageUsuario(user);
			model.addObject("msg", "La contraseña se modificó satisfactoriamente");
		}else{
			model.addObject("error", "El password es Incorrecto");
		}	
		model.setViewName("cuenta");
		return model;
	}
	
	@RequestMapping(value="/privilegios", method=RequestMethod.GET)
	public ModelAndView privilegios(Model model) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<Privilegio> privilegios = privilegioService.allListPrivilegios();
		model.addAttribute("lPrivilegios", privilegios);
		mv.setViewName("privilegios");
		return mv;
	}
	
	@RequestMapping(value="/addprivilegio" , method=RequestMethod.GET)
	public String addPrivilegio(Model model) throws Exception {
		List<EstadoEnum> stateList = new ArrayList<EstadoEnum>( Arrays.asList(EstadoEnum.values() ));
		model.addAttribute("stateList", stateList);
		model.addAttribute("title", "Nuevo");
		return "addprivilegio";
	}
	
	@ResponseBody
	@RequestMapping( value = "/privilegios/save", method=RequestMethod.POST)
	public JsonResponse savePrivilegio(PrivilegioDTO privilegio, HttpServletRequest request) throws Exception {
		JsonResponse response = new JsonResponse();
		try{
			String userCreacion = "" +request.getSession().getAttribute("userDNI");
			if(privilegio.getId() != null){
				PrivilegioDTO privilegioDTO = privilegioService.findById(privilegio.getId());
				privilegio.setUsuarioModifica(userCreacion);
				privilegio.setFechaModificacion(new Date());
				privilegio.setFechaCreacion(privilegioDTO.getFechaCreacion());
				privilegio.setUsuarioCreacion(privilegioDTO.getUsuarioCreacion());
			}else{
				privilegio.setFechaCreacion(new Date());
				privilegio.setUsuarioCreacion(userCreacion);
			}
			privilegioService.save(privilegio); // Guardar
			response.setMessage("Creado");
			response.setSuccess(true);
		}catch(Exception e){
			response.setSuccess(false);
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
		}
		return response;
	}
	
	@RequestMapping( value ="/updateprivilegio/{privilegioId}", method = RequestMethod.GET )
	public String updateprivilegio(
			@PathVariable long privilegioId, Model model){
		try{
			PrivilegioDTO privilegioDto = privilegioService.findById(privilegioId);
			List<EstadoEnum> stateList = new ArrayList<EstadoEnum>( Arrays.asList(EstadoEnum.values() ));
			model.addAttribute("stateList", stateList);
			model.addAttribute("privilegio", privilegioDto);
			model.addAttribute("title", "Modificar");
		}catch(Exception e){
			e.printStackTrace();
		}
		return "addprivilegio";
	}
	
	@RequestMapping( value = "/privilegios/delete/{privilegioId}", method = RequestMethod.GET )
	public ModelAndView eliminarPrivilegio(
			@PathVariable long privilegioId, Model model){
		ModelAndView mw = new ModelAndView();
		try{
			privilegioService.deletePrivilegio(privilegioId);
			List<Privilegio> privilegios = privilegioService.allListPrivilegios();
			model.addAttribute("lPrivilegios", privilegios);
		}catch(Exception e){
			e.printStackTrace();
		}
		mw.setViewName("privilegios");
		return mw;
	}
	
	@RequestMapping(value="/privilegios/delete", method=RequestMethod.POST)
	public ModelAndView eliminarListaPrivilegios(HttpServletRequest request, Model model){
		ModelAndView mw = new ModelAndView();
		try{
			String [] lista = request.getParameterValues("selectedItems");
			for(String elemento:lista){
				System.out.println("Elemento a eliminar::: "+elemento);
			}
			privilegioService.deletePrivilegioByIds(lista);
			List<Privilegio> privilegios = privilegioService.allListPrivilegios();
			model.addAttribute("lPrivilegios", privilegios);
		}catch(Exception e){
			e.printStackTrace();
		}
		mw.setViewName("privilegios");
		return mw;
	}
	
	@RequestMapping( value="/roles", method=RequestMethod.GET )
	public ModelAndView roles(Model model){
		ModelAndView mv = new ModelAndView();
		try {
			List<RolDTO> lRoles = roleService.allRoles();
			model.addAttribute("lroles", lRoles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("roles");
		return mv;
	}
	
	@RequestMapping(value="/addrol" , method=RequestMethod.GET)
	public String addRol(Model model) throws Exception {
		List<EstadoEnum> stateList = new ArrayList<EstadoEnum>( Arrays.asList(EstadoEnum.values() ));
		model.addAttribute("stateList", stateList);
		model.addAttribute("title", "Nuevo");
		List<PrivilegioDTO> privilegios = privilegioService.allListPrivilegiosActivos();
		model.addAttribute("lprivilegios", privilegios);
		return "addrol";
	}	
	
	@RequestMapping( value = "/role/update/{idRol}", method=RequestMethod.GET)
	public ModelAndView updateRol(@PathVariable Long idRol, Model model){
		ModelAndView mv = new ModelAndView();
		try{
			List<EstadoEnum> stateList = new ArrayList<EstadoEnum>( Arrays.asList(EstadoEnum.values() ));
			model.addAttribute("stateList", stateList);
			RolDTO roldto = new RolDTO();
			roldto = roleService.findRolById(idRol);
			List<PrivilegioDTO> privilegios = privilegioService.allListPrivilegiosActivos();
			List<PrivilegioDTO> privactivos = roldto.getTblPrivilegios();
			for(PrivilegioDTO p:privilegios){
				for(PrivilegioDTO pa:privactivos){
					if(p.getId().equals(pa.getId())){
						p.setActiva(true);
					}
				}
			}
			model.addAttribute("lprivilegios", privilegios);
			model.addAttribute("title", "Modificar");
			model.addAttribute("oRole", roldto);
		}catch(Exception e){
			mv.addObject("error", "Ocurrió un Error en la Aplicación");
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
			e.printStackTrace();
		}
		mv.setViewName("addrol");
		return mv;
	}
	
	@RequestMapping(value="/roles/delete", method=RequestMethod.POST)
	public ModelAndView deleteListRoles(Model model, HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		try{
			String [] lista = request.getParameterValues("selectedItems");
			for(String elemento:lista){
				System.out.println("Elemento a eliminar::: "+elemento);
			}
			roleService.deleteListRolById(lista);
			List<RolDTO> lRoles = roleService.allRoles();
			model.addAttribute("lroles", lRoles);
		}catch(Exception e){
			mv.addObject("error", "Ocurrió un Error en la Aplicación");
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
			e.printStackTrace();
			mv.setViewName("roles");
		}
		mv.setViewName("roles");
		return mv;
	}
	
	@RequestMapping( value = "/roles/delete/{idRol}", method=RequestMethod.GET )
	public ModelAndView deleteRole(@PathVariable long idRol, Model model){
		ModelAndView mv = new ModelAndView();
		try{
			roleService.deleteRolById(idRol);
			List<RolDTO> lRoles = roleService.allRoles();
			model.addAttribute("lroles", lRoles);
			mv.setViewName("roles");
		}catch(Exception e){
			mv.addObject("error", "Ocurrió un Error en la Aplicación");
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
			e.printStackTrace();
			mv.setViewName("roles");
		}
		return mv;
	}
	
	@RequestMapping( value = "/roles/save", method = RequestMethod.POST)
	public ModelAndView saveRol(@RequestParam("txtnamerol") String roleName,
								@RequestParam("txtdescrol") String roleDescr,
								@RequestParam("stateLst") String roleEstado,
								@RequestParam("hdRoleId") Long roleId,
								HttpServletRequest request, Model model) {
		ModelAndView mv = new ModelAndView();
		try{
			RolDTO rolDto = new RolDTO();
			rolDto.setId(roleId);
			rolDto.setNombreRol(roleName);
			rolDto.setDescripcionRol(roleDescr);
			rolDto.setEstado(roleEstado);
			rolDto.setFechaCreacion(new Date());
			rolDto.setUsuarioCreacion(request.getUserPrincipal().getName());
			/** Asocia privilegio a rol*/
			List<PrivilegioDTO> lprivdto = new ArrayList<PrivilegioDTO>();
			String [] lista = request.getParameterValues("selectedItems");
			for(String elemento:lista){
				PrivilegioDTO privdto = new PrivilegioDTO();
				privdto.setId(Long.valueOf(elemento));
				lprivdto.add(privdto);
			}
			rolDto.setTblPrivilegios(lprivdto);			
			roleService.saveRol(rolDto);
			List<PrivilegioDTO> privilegios = privilegioService.allListPrivilegiosActivos();
			model.addAttribute("lprivilegios", privilegios);
			mv.addObject("msg", "El Registró se Almacenó Correctamente");
			mv.setViewName("addrol");
		}catch(Exception e){
			mv.addObject("error", "Ocurrió un Error en la Aplicación");
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
			e.printStackTrace();
			mv.setViewName("addrol");
		}
		return mv;
	}
	
	@RequestMapping(value="/usuarios", method=RequestMethod.GET)
	public ModelAndView usuarios(Model model){
		ModelAndView mv = new ModelAndView();
		try{
			List<UsuarioDTO> usuarios = usuarioService.allUsuarios();
			model.addAttribute("usuarios", usuarios);
		}catch(Exception e){
			mv.addObject("error", "Ocurrió un Error en la Aplicación");
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
			e.printStackTrace();
		}
		mv.setViewName("usuarios");
		return mv;
	}
	
	@RequestMapping( value="/usuarios/updateusuario/{usuarioId}", method = RequestMethod.GET)
	public ModelAndView updateuser(@PathVariable long usuarioId, Model model){
		ModelAndView mv = new ModelAndView();
		try{
			
			PersonaDTO personaDTO = usuarioService.findUserById(usuarioId);
			model.addAttribute("persona", personaDTO);
			// Cargar Roles
			List<RolDTO> rolesDto = roleService.listRolesActives();
			List<RolDTO> userRol = personaDTO.getUsuario().getRoles();
			if(userRol != null){
				for(RolDTO r:rolesDto){
					for(RolDTO activo:userRol){
						if(r.getId().equals(activo.getId())){
							r.setActiva(true);
						}
					}
				}
			}
			// Tipo de Usuario
			List<ValorParametroDTO> valParams = valorparamService
					.listValorParametro(ParametroEnum.TIPO_USUARIO.getValue());
			model.addAttribute("tipoUsuario", valParams);
			model.addAttribute("roles", rolesDto);
			
			// Clientes....
			List<ClienteDTO> clientes = clienteService.allClienteActives();
			model.addAttribute("clientes", clientes);
			
			// Cargar Estados
			List<EstadoEnum> stateList = new ArrayList<EstadoEnum>(Arrays.asList(EstadoEnum.values()));
			model.addAttribute("stateList", stateList);
			
		}catch(Exception e){
			mv.addObject("error", "Ocurrió un Error en la Aplicación");
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
			e.printStackTrace();
		}
		mv.setViewName("addusuario");
		return mv;
	}
	
	@RequestMapping( value="/usuarios/usuario/{usuarioId}", method = RequestMethod.GET)
	public ModelAndView viewuser(@PathVariable Long usuarioId, Model model){
		ModelAndView mv = new ModelAndView();
		try{
			PersonaDTO personaDTO = usuarioService.findUserById(usuarioId);
			model.addAttribute("persona", personaDTO);
		}catch(Exception e){
			mv.addObject("error", "Ocurrió un Error en la Aplicación");
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
			e.printStackTrace();
		}
		mv.setViewName("usuario");
		return mv;
	}
	
	
	@RequestMapping( value="/usuarios/addusuario", method = RequestMethod.GET)
	public ModelAndView adduser(Model model){
		ModelAndView mv = new ModelAndView();
		try{
			// Cargar departamentos
			List<UbigeoDTO> departamentos = ubigeoService.findAllDepartamentosActive();
			model.addAttribute("departamentos", departamentos);
			// Cargar Estados
			List<EstadoEnum> stateList = new ArrayList<EstadoEnum>( Arrays.asList(EstadoEnum.values() ));
			model.addAttribute("stateList", stateList);
			
			// Sexo Persona
			List<SexoEnum> sexoList = new ArrayList<SexoEnum>( Arrays.asList(SexoEnum.values() ));
			model.addAttribute("sexoList", sexoList);
			
			// Estado Civil
			List<EstadoCivilEnum> estadoCivilList = new ArrayList<EstadoCivilEnum>( Arrays.asList(EstadoCivilEnum.values() ));
			model.addAttribute("estadoCivilList", estadoCivilList);
			
			// Cargar Roles
			List<RolDTO> rolesDto = roleService.listRolesActives();
			model.addAttribute("roles", rolesDto);
			
			// Tipo de Usuario
			List<ValorParametroDTO> valParams = valorparamService.listValorParametro(ParametroEnum.TIPO_USUARIO.getValue());
			model.addAttribute("tipoUsuario", valParams);
		
			// Clientes....
			
			List<ClienteDTO> clientes = clienteService.allClienteActives();
			model.addAttribute("clientes", clientes);
			
		}catch(Exception e){
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
			e.printStackTrace();
		}
		mv.setViewName("addusuario");
		return mv;
	}
	

	
	@ResponseBody
	@RequestMapping("findUsuario")
	public JsonResponse findUsuarioExiste(@RequestParam String usuario){
		JsonResponse response = new JsonResponse();
		JsonNodeFactory jsonFactory = JsonNodeFactory.instance;
		//ArrayNode jsonList = new ArrayNode(jsonFactory);
		ObjectNode json = new ObjectNode(jsonFactory);
		boolean existeUsuario = false;
		try{
			UsuarioDTO usuarioDTO = usuarioService.findUserByUsername(usuario);
			if(usuarioDTO != null){
				existeUsuario = true;
			}
			json.put("existeUser", existeUsuario);
			response.setData(json);
			response.setMessage("Success");
			response.setSuccess(true);
		}catch(Exception e){
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
			response.setMessage("Error Desconocido: por favor reporte el problema.");
            response.setSuccess(false);			
		}
		return response;
	}
	
	
	@ResponseBody
	@RequestMapping(value="saveUsuario", method=RequestMethod.POST )
	public JsonResponse saveUsuario(PersonaDTO persona, HttpServletRequest request){
		JsonResponse response = new JsonResponse();
		try{
			System.out.println("Datos Persona::: "+persona.getDni()+" "+persona.getNombres());
			String userCreacion = "" +request.getSession().getAttribute("userDNI");
			UsuarioDTO usuario = persona.getUsuario();
			usuario.setUsuarioCreacion(userCreacion);
			usuario.setFechaCreacion(new Date());
			usuario.setIdPersona(Long.valueOf(persona.getId()));
			// asignación de Roles:
			String [] lista = request.getParameterValues("selectedItems");
			List<RolDTO> roles = new ArrayList<RolDTO>();
			if(lista!=null){
				for(String id:lista){
					RolDTO rol = new RolDTO();
					rol.setId(Long.valueOf(id));
					roles.add(rol);
				}
				
			}
			usuario.setRoles(roles);
			/*if(persona.getId() != null){
				System.out.println("Tiene Id... Actualiza o Inserta");
			}*/
			usuarioService.saveUsuario(usuario);
			response.setMessage("Creado");
			response.setSuccess(true);
		}catch(Exception e){
			response.setSuccess(false);
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
		}
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="inactivarUsuarios", method=RequestMethod.POST)
	public JsonResponse inactivarUsuario(@RequestParam String comentarios, HttpServletRequest request){
		JsonResponse response = new JsonResponse();
		try{
			String [] lista = request.getParameterValues("selectedItems");
			List<UsuarioDTO> users = new ArrayList<UsuarioDTO>();
			for(String s:lista){
				System.out.println("Id. por inactivar: " + s);
				UsuarioDTO user = new UsuarioDTO();
				user.setComentarios(comentarios);
				user.setIdUsuario(Long.valueOf(s));
				users.add(user);
			}
			usuarioService.inactivarUsuarios(users);
			response.setMessage("Inactivo");
			response.setSuccess(true);
		}catch(Exception e){
			response.setSuccess(false);
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
		}
		return response;
	}
	
	
}
