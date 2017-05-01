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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.kapital.sitramas.common.enums.EstadoCivilEnum;
import com.kapital.sitramas.common.enums.EstadoEnum;
import com.kapital.sitramas.common.enums.ParametroEnum;
import com.kapital.sitramas.common.enums.SexoEnum;
import com.kapital.sitramas.configuracion.dto.UbigeoDTO;
import com.kapital.sitramas.configuracion.dto.ValorParametroDTO;
import com.kapital.sitramas.configuracion.service.UbigeoService;
import com.kapital.sitramas.configuracion.service.ValorParametroService;
import com.kapital.sitramas.seguridad.dto.PersonaDTO;
import com.kapital.sitramas.seguridad.dto.UsuarioDTO;
import com.kapital.sitramas.seguridad.service.PersonaService;

@Controller
@RequestMapping("/personal")
public class AdministrarPersonasController {

	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private UbigeoService ubigeoService;
	
	@Autowired
	private ValorParametroService valorparamService;
	
	@RequestMapping(value="/personas", method=RequestMethod.GET)
	public ModelAndView usuarios(Model model){
		ModelAndView mv = new ModelAndView();
		try{
			List<PersonaDTO> personas = personaService.allListPersonasDTO();	
			model.addAttribute("personas", personas);
		}catch(Exception e){
			mv.addObject("error", "Ocurrió un Error en la Aplicación");
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
		}
		mv.setViewName("personas");
		return mv;
	}
	
	@RequestMapping(value="/addpersona", method=RequestMethod.GET)
	public ModelAndView addPersona(Model model){
		ModelAndView mv = new ModelAndView();
		try{
			cargarDatos(model);
		}catch(Exception e){
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
			e.printStackTrace();
		}
		mv.setViewName("addpersona");
		return mv;
	}
	
	@RequestMapping(value="/updatepersona/{usuarioId}", method=RequestMethod.GET)
	public ModelAndView updatePersona(@PathVariable Long usuarioId, Model model){
		ModelAndView mv = new ModelAndView();
		try{
			PersonaDTO personaDTO = personaService.findPersonaById(usuarioId);
			UbigeoDTO ubigeo = ubigeoService.findUbigeoById(personaDTO.getIdUbigeo());
			personaDTO.setStrDepartamento(ubigeo.getCodUbigeo().substring(0,2)+"0000");
			personaDTO.setStrProvincia(ubigeo.getCodUbigeo().substring(0, 4)+"00");
			personaDTO.setStrDistrito(ubigeo.getCodUbigeo());
			model.addAttribute("persona", personaDTO);
			cargarDatos(model);
			List<UbigeoDTO> provincias = ubigeoService.findAllProvinciasActive(ubigeo.getCodUbigeo().substring(0,2));
			model.addAttribute("provincias", provincias);
			List<UbigeoDTO> distritos = ubigeoService.findAllDistritosActive(ubigeo.getCodUbigeo().substring(0,4));
			model.addAttribute("distritos", distritos);
		}catch(Exception e){
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
			e.printStackTrace();
		}
		mv.setViewName("addpersona");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("listProvincia")
	public JsonResponse listProvincia(@RequestParam String id){
		JsonResponse response = new JsonResponse();
		JsonNodeFactory jsonFactory = JsonNodeFactory.instance;
		ArrayNode jsonList = new ArrayNode(jsonFactory);
		try{
			
			String codDpto = id.substring(0,2);
			List<UbigeoDTO> pronvincias = ubigeoService.findAllProvinciasActive(codDpto);
			for(UbigeoDTO u:pronvincias){
				ObjectNode json = new ObjectNode(jsonFactory);
				json.put("id", u.getCodUbigeo());
				json.put("nombre", u.getProvincia());
				jsonList.add(json);
			}
			response.setData(jsonList);
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
	@RequestMapping("listDistrito")
	public JsonResponse listDistritos(@RequestParam String id){
		JsonResponse response = new JsonResponse();
		JsonNodeFactory jsonFactory = JsonNodeFactory.instance;
		ArrayNode jsonList = new ArrayNode(jsonFactory);
		try{
			String codDptoPrv = id.substring(0,4);
			List<UbigeoDTO> distritos = ubigeoService.findAllDistritosActive(codDptoPrv);
			for(UbigeoDTO u:distritos){
				ObjectNode json = new ObjectNode(jsonFactory);
				json.put("id", u.getCodUbigeo());
				json.put("nombre", u.getDistrito());
				jsonList.add(json);
			}
			response.setData(jsonList);
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
	@RequestMapping("findPersona")
	public JsonResponse findPersonaByDNI(@RequestParam String dni){
		JsonResponse response = new JsonResponse();
		JsonNodeFactory jsonFactory = JsonNodeFactory.instance;
		//ArrayNode jsonList = new ArrayNode(jsonFactory);
		ObjectNode json = new ObjectNode(jsonFactory);
		boolean existePersona = false;
		try{
			PersonaDTO personaDTO = personaService.findPersonaByDNI(dni);
			if(personaDTO != null){
				existePersona = true;
				json.put("nombres", personaDTO.getStrNombresCompletos());
				json.put("personaId", personaDTO.getId());
			}
			json.put("existe", existePersona);
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
	@RequestMapping(value="savePersona", method=RequestMethod.POST )
	public JsonResponse saveUsuario(PersonaDTO persona, HttpServletRequest request, 
			@RequestParam("codDepartamento") String codDepartamento,
			@RequestParam("codProvincia") String codProvincia,
			@RequestParam("codDistrito") String codDistrito){
		JsonResponse response = new JsonResponse();
		try{
			System.out.println("Datos Persona::: "+persona.getDni()+" "+persona.getNombres());
			String userCreacion = "" +request.getSession().getAttribute("userDNI");
			if(persona.getId() != null){
				PersonaDTO personaTmp = personaService.findPersonaById(Long.valueOf(persona.getId()));
				persona.setFechaCreacion(personaTmp.getFechaCreacion());//Fecha Actual
				persona.setUsuarioCreacion(personaTmp.getUsuarioCreacion()); // Usuario Creacion
			}else{
				persona.setFechaCreacion(new Date());
				persona.setUsuarioCreacion(userCreacion);
			}
			persona.setFechaModificacion(new Date());
			persona.setUsuarioModificacion(userCreacion);
			if(codDepartamento != null && codProvincia != null && codDistrito != null){
				UbigeoDTO ubigeoDTO = ubigeoService.findUbigeoByCodUbigeo(codDistrito);
				if(ubigeoDTO!=null){
					persona.setIdUbigeo(ubigeoDTO.getId());
				}
			}
			personaService.save(persona);
			response.setMessage("Creado");
			response.setSuccess(true);
		}catch(Exception e){
			response.setSuccess(false);
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
		}
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="inactivarPersonas", method=RequestMethod.POST)
	public JsonResponse inactivarPersonas(@RequestParam String comentarios, HttpServletRequest request){
		JsonResponse response = new JsonResponse();
		try{
			String [] lista = request.getParameterValues("selectedItems");
			List<PersonaDTO> personas = new ArrayList<PersonaDTO>();
			for(String s:lista){
				System.out.println("Id. por inactivar: " + s);
				PersonaDTO personaDTO = new PersonaDTO();
				personaDTO.setComentarios(comentarios);
				personaDTO.setId(Integer.valueOf(s));
				personas.add(personaDTO);
			}
			personaService.inactivarPersonas(personas);
			response.setMessage("Inactivo");
			response.setSuccess(true);
		}catch(Exception e){
			response.setSuccess(false);
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
		}
		return response;
	}
	
	@RequestMapping( value="/persona/{personaId}", method = RequestMethod.GET)
	public ModelAndView viewuser(@PathVariable Long personaId, Model model){
		ModelAndView mv = new ModelAndView();
		try{
			PersonaDTO personaDTO = personaService.findPersonaById(personaId);
			UbigeoDTO ubigeo = ubigeoService.findUbigeoById(personaDTO.getIdUbigeo());
			personaDTO.setStrDepartamento(ubigeo.getDepartamento());
			personaDTO.setStrProvincia(ubigeo.getProvincia());
			personaDTO.setStrDistrito(ubigeo.getDistrito());
			model.addAttribute("persona", personaDTO);
		}catch(Exception e){
			mv.addObject("error", "Ocurrió un Error en la Aplicación");
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
			e.printStackTrace();
		}
		mv.setViewName("persona");
		return mv;
	}
	
	public void cargarDatos(Model model) throws Exception{
		// Cargar departamentos
		List<UbigeoDTO> departamentos = ubigeoService.findAllDepartamentosActive();
		model.addAttribute("departamentos", departamentos);
		// Cargar Estados
		List<EstadoEnum> stateList = new ArrayList<EstadoEnum>(Arrays.asList(EstadoEnum.values()));
		model.addAttribute("stateList", stateList);

		// Sexo Persona
		List<SexoEnum> sexoList = new ArrayList<SexoEnum>(Arrays.asList(SexoEnum.values()));
		model.addAttribute("sexoList", sexoList);

		// Estado Civil
		List<EstadoCivilEnum> estadoCivilList = new ArrayList<EstadoCivilEnum>(Arrays.asList(EstadoCivilEnum.values()));
		model.addAttribute("estadoCivilList", estadoCivilList);

		// Tipo de Usuario
		List<ValorParametroDTO> valParams = valorparamService
				.listValorParametro(ParametroEnum.TIPO_DOCUMENTO.getValue());
		model.addAttribute("tipoDocumento", valParams);
	}
}
