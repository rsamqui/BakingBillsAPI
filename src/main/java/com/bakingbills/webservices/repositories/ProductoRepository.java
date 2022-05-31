package com.bakingbills.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bakingbills.webservices.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
