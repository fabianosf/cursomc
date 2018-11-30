package br.com.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.domain.Pedido;
import br.com.springboot.repositories.PedidoRepository;
import br.com.springboot.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Pedido obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException
			("objeto nao encontrado! Id: "+id + ",Tipo: "+Pedido.class.getName());
		}
		return obj;
	}
	
	

}
