package com.bakingbills.webservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakingbills.webservices.models.Producto;
import com.bakingbills.webservices.repositories.ProductoRepository;


@Service
public class ProductoService {

	@Autowired
	ProductoRepository dIProducto;
	
	public List<Producto> getAllProductos() {
		return dIProducto.findAll();
	}
	
	public Producto guardarProd (Producto producto) {
		return dIProducto.save(producto);
	}
	
	public Producto editarProd (Producto producto) {
		return dIProducto.save(producto);
	}
	
	public void deleteProd (Integer id) {
		dIProducto.deleteById(id);
	}

	public Optional<Producto> findById(Integer idProducto) {
		return dIProducto.findById(idProducto);
	}
	
}
