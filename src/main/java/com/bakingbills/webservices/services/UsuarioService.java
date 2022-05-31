package com.bakingbills.webservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakingbills.webservices.models.Usuario;
import com.bakingbills.webservices.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	
	@Autowired
	UsuarioRepository dIUsuario;
	
	public List<Usuario> getAllUsuarios(){
		return dIUsuario.findAll();
	}
	
	public Usuario guardarUser (Usuario usuario) {
		return dIUsuario.save(usuario);
	}
	
	public Usuario editarUsuario(Usuario usuario) {
		return dIUsuario.save(usuario);
	}
	
	public void deleteUsuario (Integer id) {
		dIUsuario.deleteById(id);
	}
	
	public Optional<Usuario> findById(Integer idUsuario) {
		return dIUsuario.findById(idUsuario);
	}
}
