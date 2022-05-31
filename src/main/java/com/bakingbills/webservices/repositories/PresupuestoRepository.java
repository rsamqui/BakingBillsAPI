package com.bakingbills.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bakingbills.webservices.models.Presupuesto;

public interface PresupuestoRepository extends JpaRepository<Presupuesto, Integer> {

}