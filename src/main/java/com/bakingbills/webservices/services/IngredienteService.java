package com.bakingbills.webservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakingbills.webservices.models.Ingrediente;
import com.bakingbills.webservices.repositories.IngredienteRepository;

@Service
public class IngredienteService {

	@Autowired
	IngredienteRepository dIIngrediente;

	public List<Ingrediente> getAllIngredientes() {
		return dIIngrediente.findAll();
	}

	public Ingrediente guardarIng(Ingrediente ingrediente) {
		return dIIngrediente.save(ingrediente);
	}

	public Ingrediente editarIng(Ingrediente ingrediente) {
		return dIIngrediente.save(ingrediente);
	}

	public void deleteIng(Integer id) {
		dIIngrediente.deleteById(id);
	}

	public Optional<Ingrediente> findById(Integer idIngrediente) {
		return dIIngrediente.findById(idIngrediente);
	}

}
