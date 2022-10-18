package edu.it.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import edu.it.dtos.Ticket;

@Repository
public class GrabadorMultaSQL implements GrabadorMulta {
	@Autowired
	private GrabadorMultaRepository grabadorMultaRepository;
	
	public void grabar(Ticket tkt) {
		try {
			grabadorMultaRepository.save(tkt);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
