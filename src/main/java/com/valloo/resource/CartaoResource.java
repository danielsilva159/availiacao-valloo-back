package com.valloo.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valloo.models.Cartao;
import com.valloo.repositories.CartaoRepository;

@RestController
@RequestMapping(path="/cartao")
public class CartaoResource {
	
	private CartaoRepository cartaoRepository;
	
	public CartaoResource(CartaoRepository cartaoRepository) {
		super();
		this.cartaoRepository = cartaoRepository;
	}
	
	@PostMapping
	public ResponseEntity<Cartao> save(@RequestBody Cartao cartao){
		cartao.setDataValidade(new Date());
		cartaoRepository.save(cartao);
		return new ResponseEntity<>(cartao, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Cartao>> getAll(){
		List<Cartao> cartoes = new ArrayList<>();
		cartoes = cartaoRepository.findAll();
		return new ResponseEntity<>(cartoes, HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Optional<Cartao>> getById(@PathVariable Integer id){
		Optional<Cartao> cartao;
		try {
			cartao = cartaoRepository.findById(id);
			return new ResponseEntity<Optional<Cartao>>(cartao, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Optional<Cartao>>(HttpStatus.NOT_FOUND);
			
		}
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Optional<Cartao>> deleteById(@PathVariable Integer id){
		
		try {
			cartaoRepository.deleteById(id);
			return new ResponseEntity<Optional<Cartao>>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Optional<Cartao>>(HttpStatus.NOT_FOUND);
			
		}
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Cartao> update(@PathVariable Integer id, @RequestBody Cartao cartao){
		return cartaoRepository.findById(id).map(c ->{
			c.setNumero(cartao.getNumero());
			c.setNomeUsuario(cartao.getNomeUsuario());
			c.setCodigoSeguranca(cartao.getCodigoSeguranca());
			c.setDataValidade(cartao.getDataValidade());
			Cartao cartaoUpdated = cartaoRepository.save(c);
			return ResponseEntity.ok().body(cartaoUpdated);
		}).orElse(ResponseEntity.notFound().build());
		
	}
	
}
