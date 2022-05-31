package com.bakingbills.webservices.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bakingbills.webservices.models.Ingrediente;
import com.bakingbills.webservices.services.IngredienteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/ingrediente")
public class IngredienteController {

	@Autowired
	private IngredienteService ingS;

	@GetMapping(path = "/listar")
	public List<Ingrediente> listar() {
		return ingS.getAllIngredientes();
	}

	@PostMapping(path = "/agregar")
	private ResponseEntity<Ingrediente> guardar(@RequestBody Ingrediente ing) {
		Ingrediente temporal = ingS.guardarIng(ing);
		try {
			return ResponseEntity.created(new URI("/ingrediente" + temporal.getIdIngrediente())).body(temporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping(path = "/actualizar/{id}")
	private ResponseEntity<Ingrediente> editar(@RequestBody Ingrediente ing, @PathVariable int id, Model model) {
		ing.setIdIngrediente(id);
		Ingrediente temporal = ingS.editarIng(ing);

		try {
			return ResponseEntity.created(new URI("/ingrediente" + temporal.getIdIngrediente())).body(temporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping(path = "/eliminar/{id}")
	public void delete(@PathVariable("id") Integer id) {
		ingS.deleteIng(id);
	}

}
