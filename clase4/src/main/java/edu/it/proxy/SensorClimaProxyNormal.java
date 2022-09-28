package edu.it.proxy;

import org.springframework.stereotype.Service;

import com.bolivarsoft.sensorclima.SensorClima;
import com.bolivarsoft.sensorclima.TipoClima;

@Service
public class SensorClimaProxyNormal implements SensorClimaProxy {

	private SensorClima sc = new SensorClima();
	
	@Override
	public TipoClima sensar() {
		return sc.sensar();
	}
	
}
