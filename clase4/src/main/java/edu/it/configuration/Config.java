package edu.it.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bolivarsoft.sensorclima.SensorClima;
import com.bolivarsoft.sensorvelocidad.SensorVelocidad;
import com.google.gson.Gson;

@Configuration
public class Config {
	@Bean
	SensorClima crearSensorClima() {
		return new SensorClima();
	}
	@Bean 
	SensorVelocidad crearSensorVelocidad() {
		return new SensorVelocidad();
	}
	@Bean
	Gson crearGson() {
		return new Gson();
	}
}
