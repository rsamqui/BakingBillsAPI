package com.bakingbills.webservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakingbills.webservices.models.Presupuesto;
import com.bakingbills.webservices.repositories.PresupuestoRepository;


@Service
public class PresupuestoService {

	
	@Autowired
	PresupuestoRepository dIPresupuesto;
	
	public List<Presupuesto> getAllPresupuestos(){
		return dIPresupuesto.findAll();
	}
	
	public Presupuesto guardarPres (Presupuesto presupuesto) {
		return dIPresupuesto.save(presupuesto);
	}
	
	public Presupuesto editarPres (Presupuesto presupuesto) {
		return dIPresupuesto.save(presupuesto);
	}
	
	public void deletePres (Integer id) {
		dIPresupuesto.deleteById(id);
	}
	
	public Optional<Presupuesto> findById(Integer idPresupuesto) {
		return dIPresupuesto.findById(idPresupuesto);
	}
}
