package com.bakingbills.webservices.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bakingbills.webservices.models.Producto;
import com.bakingbills.webservices.services.ProductoService;

@RestController
@RequestMapping(path = "/producto")
public class ProductoController {

	@Autowired
	private ProductoService prodS;

	@GetMapping(path = "/listar")
	public List<Producto> listar() {

		return prodS.getAllProductos();
	}

	@PostMapping(path = "/agregar")
	private ResponseEntity<Producto> guardar(@RequestBody Producto prod) {
		Producto temporal = prodS.guardarProd(prod);

		try {
			return ResponseEntity.created(new URI("/producto" + temporal.getIdProducto())).body(temporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping(path = "/actualizar/{id}")
	private ResponseEntity<Producto> editar(@RequestBody Producto prod, @PathVariable int id, Model model) {
		prod.setIdProducto(id);
		Producto temporal = prodS.editarProd(prod);

		try {
			return ResponseEntity.created(new URI("/producto" + temporal.getIdProducto())).body(temporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping(path = "/eliminar/{id}")
	public void delete(@PathVariable("id") Integer id) {
		prodS.deleteProd(id);
	}

}
