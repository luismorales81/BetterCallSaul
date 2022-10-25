package edu.it.dtos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name="usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioEntity {
	@Id
	public String id;
	public String nombre;
	public String password;
	public String salt;
	public String role;
}
