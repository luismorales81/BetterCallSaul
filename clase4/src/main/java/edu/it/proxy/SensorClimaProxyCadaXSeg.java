package edu.it.proxy;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.bolivarsoft.sensorclima.TipoClima;

@Service
@Primary
public class SensorClimaProxyCadaXSeg implements SensorClimaProxy {
	private SensorClimaProxyNormal sensorClimaProxy;

	public SensorClimaProxyCadaXSeg(SensorClimaProxyNormal sensorClimaProxy) {
		this.sensorClimaProxy = sensorClimaProxy;
	}

	@Override
	public TipoClima sensar() {
		/*
		 * Hay que hacer una logica para que llame a sensar siempre que hayan pasado
		 * 30 Segundo... DESPUES VER COMO CONFIGURAR ESTO.
		 */
		System.out.println("WRAPPER INIT");
		var tc = sensorClimaProxy.sensar();
		System.out.println("WRAPPER END");
		return tc;
	}
}
