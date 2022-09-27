package edu.it.service;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivarsoft.sensorclima.TipoClima;
import com.bolivarsoft.sensorvelocidad.DatosVehiculo;
import com.bolivarsoft.sensorvelocidad.TipoVehiculo;
import com.google.gson.Gson;

import edu.it.dtos.Ticket;
import edu.it.dtos.VehiculoClima;
import edu.it.repository.GrabadorMulta;

@Service
public class EvaluadorMulta {
	private HashMap<VehiculoClima, Integer> mapa = new HashMap<>();
	
	@Autowired
	Gson gson;
	
	private GrabadorMulta grabadorMulta;
	
	public EvaluadorMulta(GrabadorMulta grabadorMulta) {
		this.grabadorMulta = grabadorMulta;
		
		mapa.put(new VehiculoClima(TipoVehiculo.Auto, TipoClima.NORMAL), 130);
		mapa.put(new VehiculoClima(TipoVehiculo.Auto, TipoClima.LLUVIAS_MODERADAS), 110);
		mapa.put(new VehiculoClima(TipoVehiculo.Auto, TipoClima.LLUVIAS_TORRENCIALES), 90);
		
		mapa.put(new VehiculoClima(TipoVehiculo.Camion, TipoClima.NORMAL), 90);
		mapa.put(new VehiculoClima(TipoVehiculo.Camion, TipoClima.LLUVIAS_MODERADAS), 80);
		mapa.put(new VehiculoClima(TipoVehiculo.Camion, TipoClima.LLUVIAS_TORRENCIALES), 70);
		
		mapa.put(new VehiculoClima(TipoVehiculo.Moto, TipoClima.NORMAL), 130);
		mapa.put(new VehiculoClima(TipoVehiculo.Moto, TipoClima.LLUVIAS_MODERADAS), 110);
		mapa.put(new VehiculoClima(TipoVehiculo.Moto, TipoClima.LLUVIAS_TORRENCIALES), 90);
		
		mapa.put(new VehiculoClima(TipoVehiculo.Tractor, TipoClima.NORMAL), 60);
		mapa.put(new VehiculoClima(TipoVehiculo.Tractor, TipoClima.LLUVIAS_MODERADAS), 60);
		mapa.put(new VehiculoClima(TipoVehiculo.Tractor, TipoClima.LLUVIAS_TORRENCIALES), 60);
	}
	
	public void evaluar(DatosVehiculo datosVehiculo, TipoClima tipoClima) {
		/*
		 * Logica para evaluar si un vehiculo es elegible para multa
		 */
		
		var limiteEstablecido = mapa.get(new VehiculoClima(datosVehiculo.tipoVehiculo, tipoClima));
		
		if (datosVehiculo.velocidadMedida <= limiteEstablecido) {
			return;
		}
		
		var tkt = new Ticket(
				UUID.randomUUID().toString(),
				System.currentTimeMillis() / 1000,
				datosVehiculo.patente,
				datosVehiculo.tipoVehiculo,
				tipoClima,
				limiteEstablecido,
				datosVehiculo.velocidadMedida
				);
		
		grabadorMulta.grabar(tkt);
	}
}
