package edu.it.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.it.dtos.Alumno;
import edu.it.errores.NotFoundException;
import edu.it.repository.AlumnoRepository;
import edu.it.util.Utiles;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoController {
	
	@Autowired
	AlumnoRepository alumnoRepo;
	
	@GetMapping
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public Object getTodosLosAlumnos() {
		var alumnos = alumnoRepo.findAll();
		return alumnos;
	}
	@GetMapping(path="/{id}")
	public Object getUnSoloAlumno(@PathVariable("id") String id) {
		var optAlumno = alumnoRepo.findById(id);
		if (optAlumno.isEmpty()) {
			throw new NotFoundException();
		}
		return optAlumno.get();
	}
	
	@GetMapping(path="/inventar")
	public Alumno inventarAlumno() {
		return Utiles.crearAlumnoRandom();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void postNuevoAlumno(@RequestBody Alumno alumno) {
		alumnoRepo.save(alumno);
	}
	
	@PutMapping(path="/{id}")
	public void putSobreAlumno(@RequestBody Alumno alumno, @PathVariable("id") String id) {
		var optAlumno = alumnoRepo.findById(id);
		if (optAlumno.isEmpty()) {
			throw new NotFoundException();
		}
		alumnoRepo.save(alumno);
	}
	
	@DeleteMapping(path="/{id}")
	@Secured({"ROLE_ADMIN"})
	public void deleteSobreAlumno(@PathVariable("id") String id) {
		var optAlumno = alumnoRepo.findById(id);
		if (optAlumno.isEmpty()) {
			throw new NotFoundException();
		}
		alumnoRepo.delete(optAlumno.get());
	}
}
