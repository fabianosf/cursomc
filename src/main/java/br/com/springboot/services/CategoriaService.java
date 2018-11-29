package br.com.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.domain.Categoria;
import br.com.springboot.repositories.CategoriaRepository;
import br.com.springboot.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException
			("objeto nao encontrado! Id: "+id + ",Tipo: "+Categoria.class.getName());
		}
		return obj;
	}
	
	

}
