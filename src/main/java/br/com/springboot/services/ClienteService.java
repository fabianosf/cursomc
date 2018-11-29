package br.com.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.domain.Cliente;
import br.com.springboot.repositories.ClienteRepository;
import br.com.springboot.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente buscar(Integer id) {
		Cliente obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"objeto nao encontrado! Id: " + id + ",Tipo: " + Cliente.class.getName());
		}
		return obj;
	}

}
