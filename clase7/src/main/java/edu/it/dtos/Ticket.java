package edu.it.dtos;

import javax.persistence.*;

import com.bolivarsoft.sensorclima.TipoClima;
import com.bolivarsoft.sensorvelocidad.TipoVehiculo;

@Entity
@Table(name="tickets")
public class Ticket {
	@Id
	@Column(name="id_ticket")
	public String IDTicket;
	@Column(name="fecha_hora")
	public Long fechaHora;
	@Column(name="patente")
	public String patente;
	@Column(name="tipo_vehiculo")
	public TipoVehiculo tipoVehiculo;
	@Column(name="tipo_clima")
	public TipoClima tipoClima;
	@Column(name="limite_permitido")
	public Integer limitePermitido;
	@Column(name="velocidad_medida")
	public Integer VelocidadMedida;
	
	public Ticket() {}
	
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
