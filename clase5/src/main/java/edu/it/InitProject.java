package edu.it;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import edu.it.service.SensorPermanente;
import edu.it.util.Utiles;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InitProject implements CommandLineRunner {
	private SensorPermanente sensorPermanente;
	
	public InitProject(SensorPermanente sensorPermanente) {
		this.sensorPermanente = sensorPermanente;
	}
	
	public void run(String... args) throws Exception {
		// sensorPermanente.run();
		var alumno = Utiles.crearAlumnoRandom();
		log.info(alumno.toString());
	}
}
