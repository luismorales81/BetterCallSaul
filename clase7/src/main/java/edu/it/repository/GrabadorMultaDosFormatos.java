package edu.it.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import edu.it.dtos.Ticket;

@Repository
@Primary
public class GrabadorMultaDosFormatos implements GrabadorMulta {
	
	@Autowired
	private GrabadorMultaJSON grabadorMultaJSON;
	
	@Autowired
	private GrabadorMultaSQL grabadorMultaSQL;
	
	public void grabar(Ticket tkt) {
		try {
			grabadorMultaSQL.grabar(tkt);
		}
		catch (Exception ex) {
			
		}
		
		try {
			grabadorMultaJSON.grabar(tkt);
		}
		catch (Exception ex) {
			
		}
	}
}
