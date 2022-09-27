package edu.it.dtos;

import com.bolivarsoft.sensorclima.TipoClima;
import com.bolivarsoft.sensorvelocidad.TipoVehiculo;

public class Ticket {
	public String IDTicket;
	public Long fechaHora;
	public String patente;
	public TipoVehiculo tipoVehiculo;
	public TipoClima tipoClima;
	public Integer limitePermitido;
	public Integer VelocidadMedida;
	
	public Ticket(String iDTicket, Long fechaHora, String patente, TipoVehiculo tipoVehiculo, TipoClima tipoClima,
			Integer limitePermitido, Integer VelocidadMedida) {
		
		IDTicket = iDTicket;
		this.fechaHora = fechaHora;
		this.patente = patente;
		this.tipoVehiculo = tipoVehiculo;
		this.tipoClima = tipoClima;
		this.limitePermitido = limitePermitido;
		this.VelocidadMedida = VelocidadMedida;
	}
}
