package com.bakingbills.webservices.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bakingbills.webservices.models.Usuario;
import com.bakingbills.webservices.services.UsuarioService;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService userS;

	@GetMapping(path = "/listar")
	public List<Usuario> listar() {
		return userS.getAllUsuarios();
	}

	@PostMapping(path = "/agregar")
	private ResponseEntity<Usuario> guardar(@RequestBody Usuario user) {
		Usuario temporal = userS.guardarUser(user);

		try {
			return ResponseEntity.created(new URI("/usuario" + temporal.getIdUsuario())).body(temporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping(path = "/actualizar/{id}")
	private ResponseEntity<Usuario> editar(@RequestBody Usuario user, @PathVariable int id, Model model) {
		user.setIdUsuario(id);
		Usuario temporal = userS.guardarUser(user);

		try {
			return ResponseEntity.created(new URI("/usuario" + temporal.getIdUsuario())).body(temporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping(path = "/eliminar/{id}")
	public void delete(@PathVariable("id") Integer id) {
		userS.deleteUsuario(id);
	}
}
