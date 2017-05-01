package com.kapital.sitramas.task.scheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kapital.sitramas.seguridad.service.impl.AsynchMessReceiver;
import com.kapital.sitramas.servicios.service.impl.ProgramacionMessageReceiver;

@Component("sitramasQueueTask")
public class SitramasQueueTask {

	@Autowired
	private AsynchMessReceiver messageReceiver;
	
	@Autowired
	private ProgramacionMessageReceiver programacionReceiver;
	
	public void run(){
		messageReceiver.getMessages();
	}

	public void printMessage(){
		System.out.println("I am called by Spring scheduler");
		messageReceiver.getMessages();
		System.out.println("Post Receiver");
	}
	
	public void procesarCargaMasiva(){
		Logger.getLogger(getClass().getName()).log(Level.INFO, "[SITRAMAS]", "Inicio Proceso de Carga Masiva");
		programacionReceiver.procesarCargaMasiva();
		Logger.getLogger(getClass().getName()).log(Level.INFO, "[SITRAMAS]", "Fin de Proceso de Carga Masiva");
	}
	
}
