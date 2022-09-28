package edu.it.repository;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import edu.it.dtos.Ticket;

@Repository
public class GrabadorMultaJSON implements GrabadorMulta {
	
	@Autowired
	private Gson gson;
	
	public void grabar(Ticket tkt) {
		try {
			var strTkt = gson.toJson(tkt);
			var nuestroPath = String.join("", "/var/tickets/betterCallSaul/", tkt.IDTicket, ".json");
			FileUtils.writeStringToFile(new File(nuestroPath), strTkt, "utf-8");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
