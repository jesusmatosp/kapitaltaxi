package com.kapital.sitramas.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.kapital.sitramas.be.Usuario;
import com.kapital.sitramas.common.enums.EstadoCargaEnum;
import com.kapital.sitramas.common.enums.EstadoProgramacionEnum;
import com.kapital.sitramas.common.enums.TipoUsuarioEnum;
import com.kapital.sitramas.configuracion.dto.ClienteDTO;
import com.kapital.sitramas.configuracion.service.ClienteService;
import com.kapital.sitramas.seguridad.service.UsuarioService;
import com.kapital.sitramas.servicios.dto.CargaMasivaDTO;
import com.kapital.sitramas.servicios.dto.ProgramacionDTO;
import com.kapital.sitramas.servicios.dto.ProgramacionPasajeroDTO;
import com.kapital.sitramas.servicios.dto.SedeDTO;
import com.kapital.sitramas.servicios.service.CargaMasivaService;
import com.kapital.sitramas.servicios.service.ProgramacionMessageSender;
import com.kapital.sitramas.servicios.service.ProgramacionService;
import com.kapital.sitramas.servicios.service.SedeService;
import com.kapital.sitramas.utils.ConstantesUtils;
import com.kapital.sitramas.utils.KapitalUtils;


@Controller
@RequestMapping("/servicios")
public class ProgramacionController {

	@Autowired
	private ProgramacionService programacionService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private SedeService sedeService;
	
	@Autowired
	private ProgramacionMessageSender programacionSender;
	
	@Autowired
	private CargaMasivaService cargaMasivaService;
	
	private static String UPLOADED_FOLDER = "D://temp//";
	
	
	
	@RequestMapping(value="/programacion", method=RequestMethod.GET)
	public ModelAndView programacion(Model model, HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		try{
			//List<ProgramacionDTO> programaciones = programacionService.findAllProgramacion();
			List<ProgramacionDTO> programaciones = programacionService.findAllProgramacionBorrador();
			model.addAttribute("programaciones", programaciones);
			String username = request.getUserPrincipal().getName();
			Usuario user = usuarioService.findUsuarioByUsername(username);
			boolean flagCliente = false; 
			ClienteDTO cliente = null;
			if(user.getTblTipoUsuario().getId().equals(TipoUsuarioEnum.CLIENTE.getValue())){ // Tipo de usuario es cliente
				cliente = clienteService.findClienteById(user.getIdCliente());
				flagCliente = true;
			}
			// Clientes....
			List<ClienteDTO> clientes = clienteService.allClienteActives();
			model.addAttribute("clientes", clientes);
			
			model.addAttribute("cliente", cliente);
			model.addAttribute("flagCliente", flagCliente);
			
		}catch(Exception e){
			mv.addObject("error", "Ocurrió un Error en la Aplicación");
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
		}
		mv.setViewName("programacion");
		return mv;
	}
	
	@RequestMapping(value="/addprogramacion/{idProgramacion}", method=RequestMethod.GET)
	public ModelAndView cargarProgramacion(@PathVariable Long idProgramacion,
			Model model, HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		try{
			ProgramacionDTO programacionDTO = programacionService.findById(idProgramacion);
			model.addAttribute("programacion", programacionDTO);
			List<ProgramacionPasajeroDTO> pasajeros = programacionService.findAllProgramacionCliente(idProgramacion, programacionDTO.getVersion());
			model.addAttribute("pasajeros", pasajeros);
		}catch(Exception e){
			mv.addObject("error", "Ocurrió un Error en la Aplicación");
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
		}
		mv.setViewName("addprogramacion");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("deletedetalleprogramacion")
	public JsonResponse eliminarDetalleProgramacion(Long id){
		JsonResponse response = new JsonResponse();
		try{
			programacionService.deleteDetalleProgramacion(id);
			response.setMessage(ConstantesUtils.DELETE_RECORD);
			response.setSuccess(true);
		}catch(Exception e){
			response.setMessage(ConstantesUtils.ERROR_DELETE);
			response.setSuccess(false);
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
		}
		return response;
	}
	
	@ResponseBody
	@RequestMapping("enviarProgramacion")
	public JsonResponse enviarProgramacion(Long id){
		JsonResponse response = new JsonResponse();
		try{			
			Integer result = programacionService.enviarProgramacion(id);
			if(result == 1){
				response.setMessage(ConstantesUtils.UPDATE_RECORD);
				response.setSuccess(true);
			}else if(result == 0){
				response.setMessage(ConstantesUtils.DUPLICATE_SEND);
				response.setSuccess(false);
			}
		}catch(Exception e){
			response.setSuccess(false);
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
		}
		return response;
	}
	
	@RequestMapping(value="/detalleProgramacion/{idProgramacion}",
					method = RequestMethod.GET)
	public ModelAndView detalleProgramacion(HttpServletRequest request, 
					@PathVariable("idProgramacion") Long idProgramacion,
					Model model){
		ModelAndView mv = new ModelAndView();
		try{
			ProgramacionPasajeroDTO pasajeroDTO = programacionService.findProgramacionClienteById(idProgramacion);
			SedeDTO sedeDTO = sedeService.obtenerSedeById(pasajeroDTO.getIdSede());
			pasajeroDTO.setSede(sedeDTO.getNombreSede());
			model.addAttribute("pasajero", pasajeroDTO);
			
		}catch(Exception e){
			mv.addObject("error", "Ocurrió un Error en la Aplicación");
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
		}
		mv.setViewName("viewprogramacion");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="saveProgramacion", method=RequestMethod.POST)
	public JsonResponse saveProgramacion(ProgramacionDTO programacion, HttpServletRequest request, 
			@RequestParam Long idCliente){
		JsonResponse response = new JsonResponse();
		try{
			String userCreacion = "" +request.getSession().getAttribute("userDNI");
			programacion.setUsuarioCreacion(userCreacion);
			programacion.setFechaCreacion(new Date());
			programacion.setIdCliente(idCliente);
			programacion.setEstado(EstadoProgramacionEnum.BORRADOR.getValue());
			programacion.setFechaProgramacion(KapitalUtils.convertStringToDate(programacion.getStrFechaProgramacion()));
			programacionService.saveProgramacion(programacion);
			response.setMessage(ConstantesUtils.CREATE_RECORD);
			response.setSuccess(true);
		}catch(Exception e){
			response.setSuccess(false);
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
		}
		return response;
	}
	
	@RequestMapping("/jobLauncher")
	public void handle() throws Exception{
		
	}
	
	@PostMapping("/upload")
	public String singleFileUpload(@RequestParam("file") 
			MultipartFile file, RedirectAttributes redirectAttributes, 
			@RequestParam("idProgramacion") Long idProgramacion,
			@RequestParam("strFechaProgramacion") String strFechaProgramacion,
			HttpServletRequest request){
		JsonResponse response = new JsonResponse();
		if(file.isEmpty()){
			redirectAttributes.addFlashAttribute("message",
					"Please select a file to upload");
			response.setSuccess(false);
		}
		try{
			byte[] bytes = file.getBytes();
			//Path path = Paths.get(UPLOADED_FOLDER+file.getOriginalFilename());
			String fileName = KapitalUtils.getCurrentDateYYYYMMDD(KapitalUtils.convertStringToDate(strFechaProgramacion))+".csv";
			Path path = Paths.get(UPLOADED_FOLDER+fileName);
			Files.write(path, bytes);
			response.setMessage("Creado");
			response.setSuccess(true);
			// Actualiza tabla
			String userCreacion = "" +request.getSession().getAttribute("userDNI");
			ProgramacionDTO programacionDTO = programacionService.findById(idProgramacion);
			programacionDTO.setRutaArchivo(fileName);
			programacionDTO.setUsuarioModificacion(userCreacion);
			programacionService.actualizarProgramacion(programacionDTO);
			// Registra Carga Masiva
			CargaMasivaDTO cargaMasivaDTO = new CargaMasivaDTO();
			cargaMasivaDTO.setEstadoCarga(EstadoCargaEnum.INICIADO.getValue());
			cargaMasivaDTO.setFechaCarga(KapitalUtils.getCurrentDate());
			cargaMasivaDTO.setFechaProceso(KapitalUtils.getCurrentDate());
			cargaMasivaDTO.setNombreArchivo(fileName);
			cargaMasivaDTO.setRutaArchivo(UPLOADED_FOLDER+fileName);
			cargaMasivaDTO.setUsuarioCarga(userCreacion);
			cargaMasivaDTO.setVersion(programacionDTO.getVersion());
			cargaMasivaDTO.setIdProgramacion(idProgramacion);
			cargaMasivaService.guardarCargaMasiva(cargaMasivaDTO);
			//Activa Proceso:.....
			//procesarCargaProgramacion(UPLOADED_FOLDER+fileName, idProgramacion);
			if(cargaMasivaDTO.getId() != null){
				// Enviar Carga de Proceso a la cola de mensajes
				programacionSender.sendProgramacionMessage(UPLOADED_FOLDER+fileName, idProgramacion, cargaMasivaDTO.getId());				
			}
		}catch(IOException e){
			response.setSuccess(false);
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
		}catch (Exception e) {
			// TODO: handle exception
			response.setSuccess(false);
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
		}
		return "redirect:/servicios/programacion.do";
	}
	
	@ResponseBody
	@RequestMapping(value="/monitorCarga", method=RequestMethod.POST)
	public JsonResponse allCargas(@RequestParam("idProgramacion") Long idProgramacion){
		JsonNodeFactory jsonFactory = JsonNodeFactory.instance;
        JsonResponse response = new JsonResponse();
        try{
        	List<CargaMasivaDTO> cargas = cargaMasivaService.obtenerListaCargaMasivaIdProgramacion(idProgramacion);
        	ArrayNode jsonList = new ArrayNode(jsonFactory);
        	
        	for(CargaMasivaDTO cargaDTO : cargas){
        		ObjectNode json = new ObjectNode(jsonFactory);
        		json.put("fechaCarga", KapitalUtils.convertDateToString(cargaDTO.getFechaCarga()));
        		json.put("fechaProceso", KapitalUtils.convertDateToString(cargaDTO.getFechaProceso()));
        		json.put("estadoCarga", cargaDTO.getEstadoCarga());
        		json.put("nombreArchivo", cargaDTO.getNombreArchivo());
        		json.put("usuarioCarga", cargaDTO.getUsuarioCarga());
        		jsonList.add(json);
        	}
        	response.setData(jsonList);
        	response.setTotal(jsonList.size());
        	response.setSuccess(true);
        }catch(Exception e){
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "[SITRAMAS ERROR] " + e);
        }
        return response;
	}
	
	@ResponseBody
	@RequestMapping(value="/enviarProgramacion/{idProgramacion}",
				method=RequestMethod.POST)
	public JsonResponse enviarProgramacion(HttpServletRequest request, 
			@PathVariable("idProgramacion") Long idProgramacion){
		JsonResponse response = new JsonResponse();
		try{
			String userCreacion = "" +request.getSession().getAttribute("userDNI");
			ProgramacionDTO programacionDTO = programacionService.findById(idProgramacion);
			programacionDTO.setEstado(EstadoProgramacionEnum.ENVIADO.getValue());
			programacionDTO.setUsuarioModificacion(userCreacion);
			programacionService.actualizarProgramacion(programacionDTO);
			response.setMessage("Enviado");
			response.setSuccess(true);
		}catch(Exception e){
			response.setSuccess(false);
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
		}
		return response;
	}
	
	@RequestMapping(value="/download/{idProgramacion}",
			method = RequestMethod.GET)
	public void doDownload(@PathVariable("idProgramacion") Long idProgramacion, 
			HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		try{
			ProgramacionDTO programacionDTO = 
					programacionService.findById(idProgramacion);
			// Get File
			File file = null;
			file = new File(UPLOADED_FOLDER+programacionDTO.getRutaArchivo());
			
			if(!file.exists()){
				String errorMessage = "Disculpe, El archivo que intenta descargar No existe";
				Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error de Descarga",
						errorMessage);
				OutputStream outputStream = response.getOutputStream();
				outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
				outputStream.close();
				return;
			}
			
			String mimeType = URLConnection.guessContentTypeFromName(file.getName());
			if(mimeType==null){
				mimeType = "application/octet-stream";
			}
			
			response.setContentType(mimeType);
			response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));
			
			response.setContentLength((int) file.length() );
			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
			FileCopyUtils.copy(inputStream, response.getOutputStream());
		}catch(Exception e){
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SITRAMAS ERROR:", e);
		}
	}

	
	@GetMapping("/uploadStatus")
	public String uploadStatus(){
		return "programacion";
	}
	
	@Autowired
	private JobLauncher JobLauncher;
	
	@Autowired 
	private Job programacionJob; 
	
	public void procesarCargaProgramacion(String file, Long idProgramacion){
		try{
			JobExecution jobExecution = JobLauncher.run(programacionJob, new JobParametersBuilder()
					.addString("carga", file)
					.addLong("idProgramacion", idProgramacion)
					.toJobParameters());
			System.out.println(jobExecution.getStatus());
			//System.err.println(jobExecution.get);
			List<Throwable> errores = jobExecution.getFailureExceptions();
			for(Throwable t:errores){
				System.err.println("Error: "+t.getMessage());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
