package edu.it.proxy;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.bolivarsoft.sensorclima.TipoClima;

@Service
@Primary
public class SensorClimaProxyCadaXSeg implements SensorClimaProxy {
	private SensorClimaProxyNormal sensorClimaProxy;
	private Long lastTs;
	private TipoClima ultimoTipoClima; 

	public SensorClimaProxyCadaXSeg(SensorClimaProxyNormal sensorClimaProxy) {
		this.sensorClimaProxy = sensorClimaProxy;
		lastTs = System.currentTimeMillis() / 1000;
		ultimoTipoClima = sensorClimaProxy.sensar();
	}

	@Override
	public TipoClima sensar() {
		Long actualTs = System.currentTimeMillis() / 1000;
		
		if (actualTs - lastTs > 30) {
			System.out.println("VUELVO A SENSAR ....");
			ultimoTipoClima = sensorClimaProxy.sensar();
			lastTs = actualTs;
		}
		return ultimoTipoClima;
	}
}
