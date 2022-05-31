package com.bakingbills.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bakingbills.webservices.models.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer>{
	
}
