package br.com.arfaxtec.mps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arfaxtec.mps.entities.Usuario;
import br.com.arfaxtec.mps.repositorios.UsuarioRepositorio;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	public List<Usuario> findAll() {
		return usuarioRepositorio.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> obj = usuarioRepositorio.findById(id);
		return obj.get();
	}
	
	public Usuario insert(Usuario obj) {
		return usuarioRepositorio.save(obj);
	}
	
	public void delete(Long id) {
		usuarioRepositorio.deleteById(id);
	}
	
	public Usuario update(Long id, Usuario obj) {
		Usuario entity = usuarioRepositorio.getOne(id);
		updateData(entity, obj);
		return usuarioRepositorio.save(entity);
	}

	private void updateData(Usuario entity, Usuario obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
	}

}
