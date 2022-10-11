package edu.it.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
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
import edu.it.util.Utiles;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoController {
	@GetMapping
	public Object getTodosLosAlumnos() {
		HashMap<String, String> mapaAlumnos = new HashMap<>();
		List<HashMap<String, String>> lista = new ArrayList<HashMap<String, String>>();
		mapaAlumnos.put("nombre", "Federico");
		mapaAlumnos.put("apellido", "Fanzari");
		lista.add(mapaAlumnos);
		lista.add(mapaAlumnos);
		lista.add(mapaAlumnos);
		return lista;
	}
	@GetMapping(path="/{id}")
	public Object getUnSoloAlumno(@PathVariable("id") String id) {
		HashMap<String, String> mapaAlumnos = new HashMap<>();
		if (id.equals("0000")) {
			throw new NotFoundException();
		}
		mapaAlumnos.put("id", id);
		mapaAlumnos.put("nombre", "Federico");
		return mapaAlumnos;
	}
	
	@GetMapping(path="/inventar")
	public Alumno inventarAlumno() {
		return Utiles.crearAlumnoRandom();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void postNuevoAlumno(@RequestBody Alumno alumno) {
		System.out.println(alumno.toString());		
	}
	
	@PutMapping(path="{id}")
	public void putSobreAlumno(@RequestBody Alumno alumno, @PathVariable("id") String id) {
		System.out.println(id);
		System.out.println(alumno.toString());
	}
	
	@DeleteMapping(path="{id}")
	public void deleteSobreAlumno(@PathVariable("id") String id) {
		System.out.println(id);
	}
}
