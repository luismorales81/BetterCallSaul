package edu.it;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.it.service.SensorPermanente;

@Component
public class InitProject implements CommandLineRunner {
	private SensorPermanente sensorPermanente;
	
	public InitProject(SensorPermanente sensorPermanente) {
		this.sensorPermanente = sensorPermanente;
	}
	
	public void run(String... args) throws Exception {
		sensorPermanente.run();
	}
}
