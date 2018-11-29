package br.com.springboot;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.springboot.domain.Categoria;
import br.com.springboot.domain.Cidade;
import br.com.springboot.domain.Cliente;
import br.com.springboot.domain.Endereco;
import br.com.springboot.domain.Estado;
import br.com.springboot.domain.Produto;
import br.com.springboot.domain.enums.TipoCliente;
import br.com.springboot.repositories.CategoriaRepository;
import br.com.springboot.repositories.CidadeRepository;
import br.com.springboot.repositories.ClienteRepository;
import br.com.springboot.repositories.EnderecoRepository;
import br.com.springboot.repositories.EstadoRepository;
import br.com.springboot.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "INFORMATICA");
		Categoria cat2 = new Categoria(null, "ESCRITORIO");
		
		Produto p1 = new Produto(null, "COMPUTADOR", 2000.00);
		Produto p2 = new Produto(null, "IMPRESSORA", 500.00);
		Produto p3 = new Produto(null, "MOUSE", 80.00);
		
		//adicionando os produtos p1,p2,p3 na categoria 
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));	
		
		
		categoriaRepository.save(Arrays.asList(cat1,cat2));
		produtoRepository.save(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Sao Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Sao Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		
		estadoRepository.save(Arrays.asList(est1, est2));
		cidadeRepository.save(Arrays.asList(c1, c2, c3));
		
		
		Cliente cli1 = new Cliente(null, "Maria Silva","maria@gmail.com", "12345678910",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("22645587","997766320"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303","Jardim", "28940000",cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos","105", "Sala 08", "Centro", "28942365",cli1,c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.save(Arrays.asList(cli1));
		enderecoRepository.save(Arrays.asList(e1, e2));
		
		
		
	}
}
