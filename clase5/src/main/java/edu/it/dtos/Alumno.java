package edu.it.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Alumno {
	public String id;
	public String nombre;
    public String apellido;
    public String calle;
    public String calleNumero;
    public String estado;
    public String pais;
}
