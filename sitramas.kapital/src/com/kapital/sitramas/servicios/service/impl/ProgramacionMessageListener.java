package com.kapital.sitramas.servicios.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kapital.sitramas.be.CargaMasiva;
import com.kapital.sitramas.servicios.dao.CargaMasivaDAO;
import com.kapital.sitramas.servicios.dao.impl.CargaMasivaDAOImpl;
import com.kapital.sitramas.servicios.dto.ProcesoProgramacionDTO;
import com.kapital.sitramas.utils.KapitalUtils;

@Component
public class ProgramacionMessageListener implements MessageListener{

	//private JobLauncher JobLauncher;
	//private Job programacionJob; 
	
	@Autowired
	private JobLauncher JobLauncher;
	@Autowired
	private Job programacionJob; 
	@Autowired
	private CargaMasivaDAO cargaMasivaDao;
	/*public ProgramacionMessageListener(JobLauncher jobLauncher,
			Job programacionJob) {
		JobLauncher = jobLauncher;
		this.programacionJob = programacionJob;
	}*/

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		try{
			Logger.getLogger(getClass().getName()).log(Level.INFO, "[CARGA DE PROCESOS]", "Recuperando Información de la cola de Mensajes");
			ObjectMessage proceso = (ObjectMessage) message;
			ProcesoProgramacionDTO process = (ProcesoProgramacionDTO) proceso.getObject(); 
			System.out.println("[Archivo= "+((ProcesoProgramacionDTO) proceso.getObject()).getFile()+", IdProceso= "+
									((ProcesoProgramacionDTO) proceso.getObject()).getIdProgramacion()+"]");
			System.out.println("[Archivo= "+process.getFile()+", IdProceso= "+process.getIdProgramacion()+"]");
			Logger.getLogger(getClass().getName()).log(Level.INFO, "[CARGA DE PROCESOS]", "Iniciando Carga Masiva");
			JobExecution jobExecution = JobLauncher.run(programacionJob, new JobParametersBuilder()
					.addString("carga", process.getFile())
					.addLong("idProgramacion", process.getIdProgramacion())
					.toJobParameters());
			System.out.println(jobExecution.getStatus());
			List<Throwable> errores = jobExecution.getFailureExceptions();
			for(Throwable t:errores){
				System.err.println("Error: "+t.getMessage());
			}
			
			//CargaMasivaDAO cargaMasivaDao = new CargaMasivaDAOImpl();
			CargaMasiva cargaMasiva = cargaMasivaDao.find(process.getIdCargaMasiva());
			cargaMasiva.setFechaProceso(KapitalUtils.getCurrentDate());
			cargaMasiva.setEstadoCarga(jobExecution.getStatus().toString());
			cargaMasivaDao.save(cargaMasiva);
			
			Logger.getLogger(getClass().getName()).log(Level.INFO, "[CARGA DE PROCESOS]", "Finalizando Carga");
		}catch(JMSException e){
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "[SITRAMAS - ERROR]", "Error en la Cola de Mensaje "+ e);
			e.printStackTrace();
		}catch(Exception e){
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "[SITRAMAS - ERROR]", "Ocurrió un error en el Sistema "+ e);
			e.printStackTrace();
		}
	}

	/*public JobLauncher getJobLauncher() {
		return JobLauncher;
	}
	
	public void setJobLauncher(JobLauncher jobLauncher) {
		JobLauncher = jobLauncher;
	}
	
	public Job getProgramacionJob() {
		return programacionJob;
	}

	public void setProgramacionJob(Job programacionJob) {
		this.programacionJob = programacionJob;
	}*/

}
