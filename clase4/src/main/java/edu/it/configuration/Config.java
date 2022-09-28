package edu.it.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bolivarsoft.sensorvelocidad.SensorVelocidad;
import com.google.gson.Gson;

import edu.it.proxy.SensorClimaProxy;
import edu.it.proxy.SensorClimaProxyNormal;

@Configuration
public class Config {
	@Bean 
	SensorVelocidad crearSensorVelocidad() {
		return new SensorVelocidad();
	}
	@Bean
	Gson crearGson() {
		return new Gson();
	}
}
