package com.bakingbills.webservices.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bakingbills.webservices.models.Presupuesto;
import com.bakingbills.webservices.services.PresupuestoService;

@RestController
@RequestMapping(path = "/presupuesto")
public class PresupuestoController {

	@Autowired
	private PresupuestoService presS;

	@GetMapping(path = "/listar")
	public List<Presupuesto> listar() {
		return presS.getAllPresupuestos();
	}

	@PostMapping(path = "/agregar")
	private ResponseEntity<Presupuesto> guardar(@RequestBody Presupuesto pres) {
		Presupuesto temporal = presS.guardarPres(pres);

		try {
			return ResponseEntity.created(new URI("/presupuesto" + temporal.getIdPresupuesto())).body(temporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping(path = "/actualizar/{id}")
	private ResponseEntity<Presupuesto> editar(@RequestBody Presupuesto pres, @PathVariable int id, Model model) {
		pres.setIdPresupuesto(id);
		Presupuesto temporal = presS.guardarPres(pres);

		try {
			return ResponseEntity.created(new URI("/presupuesto" + temporal.getIdPresupuesto())).body(temporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping(path = "/eliminar/{id}")
	public void delete(@PathVariable("id") Integer id) {
		presS.deletePres(id);
	}
}
