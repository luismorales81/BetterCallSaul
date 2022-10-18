package edu.it.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.it.dtos.UsuarioDTO;
import edu.it.dtos.UsuarioEntity;
import edu.it.errores.BadRequestException;
import edu.it.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void postNuevoUsuario(@RequestBody UsuarioDTO usuario) {
		System.out.println(usuario.toString());
		// fijarme si existe
		var usuNom = usuarioRepository.findByNombre(usuario.nombre);
		if (usuNom != null) {
			throw new BadRequestException();
		}
		
		var newUsu = UsuarioEntity
			.builder()
			.id(UUID.randomUUID().toString())
			.nombre(usuario.nombre)
			.password(usuario.password)
			.salt("AcA FALTA DEFINIR SALT")
			.role("FALTA TB")
			.build();
		
		usuarioRepository.save(newUsu);
	}
}
