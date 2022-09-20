package edu.it.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivarsoft.sensorclima.SensorClima;
import com.bolivarsoft.sensorvelocidad.SensorVelocidad;
import com.google.gson.Gson;

@Service
public class SensorPermanente {
	@Autowired
	private SensorVelocidad sensorVelocidad;
	
	@Autowired
	private SensorClima sensorClima;
	
	@Autowired
	private Gson gson;
	
	public void run() {
		for (;;) {
			var datosVehiculo = sensorVelocidad.sensarVehiculo();
			var clima = sensorClima.sensar();
			
			System.out.println(gson.toJson(datosVehiculo));
			System.out.println(gson.toJson(clima));
		}
	}
}
