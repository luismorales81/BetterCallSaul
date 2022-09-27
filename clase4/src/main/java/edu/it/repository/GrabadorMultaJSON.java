package edu.it.repository;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import edu.it.dtos.Ticket;

@Repository
public class GrabadorMultaJSON implements GrabadorMulta {
	public void grabar(Ticket tkt) {
		/*
		 * Generar un archivo por ticket, donde el archivo se llame
		 * /var/tickets/betterCallSaul/{id}.json
		 * var strTkt = new Gson().toJson(tkt);
		 */
		var strTkt = new Gson().toJson(tkt);
		System.out.println(strTkt);
		
		try {
			FileUtils.writeStringToFile(new File(""), strTkt, "utf-8");
		}
		catch (Exception ex) {
			
		}
	}
}
