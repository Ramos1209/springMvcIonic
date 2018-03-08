package com.pauloramos.spring;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pauloramos.spring.domain.Categoria;
import com.pauloramos.spring.domain.Cidade;
import com.pauloramos.spring.domain.Cliente;
import com.pauloramos.spring.domain.Endereco;
import com.pauloramos.spring.domain.Estado;
import com.pauloramos.spring.domain.ItemPedido;
import com.pauloramos.spring.domain.Pagamento;
import com.pauloramos.spring.domain.PagamentoComBoleto;
import com.pauloramos.spring.domain.PagamentoComCartao;
import com.pauloramos.spring.domain.Pedido;
import com.pauloramos.spring.domain.Produto;
import com.pauloramos.spring.domain.enums.EstadoPagamento;
import com.pauloramos.spring.domain.enums.TipoCliente;
import com.pauloramos.spring.repositores.CategoriaRepositorio;
import com.pauloramos.spring.repositores.CidadeRepositorio;
import com.pauloramos.spring.repositores.ClienteRepositorio;
import com.pauloramos.spring.repositores.EnderecoRepositorio;
import com.pauloramos.spring.repositores.EstadoRepositorio;
import com.pauloramos.spring.repositores.ItemPedidoRepositorio;
import com.pauloramos.spring.repositores.PagamentoRepositorio;
import com.pauloramos.spring.repositores.PedidoRepositorio;
import com.pauloramos.spring.repositores.ProdutoRepositorio;

@SpringBootApplication
public class SpringMvcIonicApplication implements CommandLineRunner {

	@Autowired
	public CategoriaRepositorio categoriaRepositorio;
	
	@Autowired
	public ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	public EstadoRepositorio estadoRepositorio;
	
	@Autowired
	public CidadeRepositorio cidadeRepositorio;
	@Autowired
	public ClienteRepositorio clienteRepositorio;
	
	@Autowired
	public EnderecoRepositorio enderecoRepositorio;
	
	@Autowired
	private PedidoRepositorio pedidoRepository;
	
	@Autowired
	private PagamentoRepositorio pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepositorio itemPedidorepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMvcIonicApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",20.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
			
		categoriaRepositorio.save(Arrays.asList(cat1,cat2));
		produtoRepositorio.save(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null,"Minas gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlandia", est1);
		Cidade c2 =new  Cidade(null,"Sao Paulo", est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
				
	    est1.getCidades().addAll(Arrays.asList(c1));
	    est2.getCidades().addAll(Arrays.asList(c2,c3));
				
		estadoRepositorio.save(Arrays.asList(est1,est2));
		cidadeRepositorio.save(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null,"Paulo Cesar Ramos","pauloramos@gmail.com","2778402258",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("25258974","557896354"));
		
		Endereco e1 = new Endereco(null,"Rua francisco de Paula","193","Bloco 29 apto 04","Jardim odete","07144001",cli1,c1);
		Endereco e2 = new Endereco(null,"Rua  Paula","13","Bloco  apto 1","Jardim pamares","07144001",cli1,c2);
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepositorio.save(Arrays.asList(cli1));
		enderecoRepositorio.save(Arrays.asList(e1,e2));
		
		        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
				
		 		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), null, cli1, e1);
		 		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), null, cli1, e2);
			
		 		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		 		ped1.setPagamento(pagto1);
		 		
		 		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		 		ped2.setPagamento(pagto2);
		 	
		 		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		 		
		 		pedidoRepository.save(Arrays.asList(ped1, ped2));
		 		pagamentoRepository.save(Arrays.asList(pagto1, pagto2));
		 		
		 		ItemPedido ip1 = new ItemPedido(ped1,p1,0.00,1,2000.00);
		 		ItemPedido ip2 = new ItemPedido(ped1,p3,0.00,2,80.00);
		 		ItemPedido ip3 = new ItemPedido(ped2,p2,100.00,1,2000.00);
		 		
		 		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		 		ped2.getItens().addAll(Arrays.asList(ip3));
		 		
		 		p1.getItens().addAll(Arrays.asList(ip1));
		 		p2.getItens().addAll(Arrays.asList(ip3));
		 		p3.getItens().addAll(Arrays.asList(ip2));
		 		
		 		itemPedidorepository.save(Arrays.asList(ip1,ip2,ip3));
		 		
	}
}
