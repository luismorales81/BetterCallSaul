package edu.it.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivarsoft.sensorclima.TipoClima;
import com.bolivarsoft.sensorvelocidad.DatosVehiculo;
import com.bolivarsoft.sensorvelocidad.SensorVelocidad;
import com.google.gson.Gson;

import edu.it.proxy.SensorClimaProxy;

@Service
public class SensorPermanente {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SensorVelocidad sensorVelocidad;
	
	@Autowired
	private SensorClimaProxy sensorClimaProxy;
	
	@Autowired
	private Gson gson;
	
	@Autowired
	private EvaluadorMulta evaluadorMulta;
	
	public void run() {
		for (;;) {
			DatosVehiculo datosVehiculo = sensorVelocidad.sensarVehiculo();
			TipoClima clima = sensorClimaProxy.sensar();

			logger.info(clima.toString());
			
			evaluadorMulta.evaluar(datosVehiculo, clima);
		}
	}
}
