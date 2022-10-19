package edu.it.controllers;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.it.dtos.UsuarioDTO;
import edu.it.errores.NotFoundException;
import edu.it.errores.Unauthorized;
import edu.it.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/login")
public class LoginController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@PostMapping
	public Object postNuevoUsuario(@RequestBody UsuarioDTO usuario) {
		var usuNom = usuarioRepository.findByNombre(usuario.nombre);
		if (usuNom == null) {
			throw new NotFoundException();
		}
		
		var salt = usuNom.salt;
		var passwordParaEncriptar = String.join("__", usuario.password, salt);
		var passwordEncriptada = DigestUtils.sha256Hex(passwordParaEncriptar);
		
		if (!(passwordEncriptada.equals(usuNom.password))) {
			throw new Unauthorized();
		}
		
		return "ACA VA A IR UN TOKEN";
	}
}
