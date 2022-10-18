package edu.it.dtos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="alumnos")
public class Alumno {
	@Id
	public String id;
	public String nombre;
    public String apellido;
    public String calle;
    @Column(name="calle_numero")
    public String calleNumero;
    public String estado;
    public String pais;
}
