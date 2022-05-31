package com.bakingbills.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bakingbills.webservices.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}