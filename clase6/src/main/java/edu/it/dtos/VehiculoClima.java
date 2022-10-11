package edu.it.dtos;

import java.util.Objects;

import com.bolivarsoft.sensorclima.TipoClima;
import com.bolivarsoft.sensorvelocidad.TipoVehiculo;


public class VehiculoClima {
	public final TipoVehiculo tipoVehiculo;
	public final TipoClima tipoClima;
	
	public VehiculoClima(TipoVehiculo tipoVehiculo, TipoClima tipoClima) {
		this.tipoVehiculo = tipoVehiculo;
		this.tipoClima = tipoClima;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipoClima, tipoVehiculo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehiculoClima other = (VehiculoClima) obj;
		return tipoClima == other.tipoClima && tipoVehiculo == other.tipoVehiculo;
	}	
}
