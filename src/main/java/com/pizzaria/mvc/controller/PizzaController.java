package com.pizzaria.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaria.mvc.model.Pizza;

import com.pizzaria.mvc.repository.PizzaRepository;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	@GetMapping(value="/{idpizza}")
	public ResponseEntity<Pizza> Get(@PathVariable("idpizza") long idpizza){
		return pizzaRepository.findById(idpizza)
				.map(pizza -> ResponseEntity.ok().body(pizza))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping
	public List<Pizza> GetAll() {
		return pizzaRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pizza Post(@RequestBody Pizza entity) {
		return pizzaRepository.save(entity);
	}
	
	@PutMapping(value="/{idpizza}")
	public ResponseEntity<Pizza> Put(@RequestBody Pizza entity, @PathVariable("idpizza") long idpizza) {
		return pizzaRepository.findById(idpizza)
				.map(pizza -> {
					pizza.setSabor(entity.getSabor());
					pizza.setIngredientes(entity.getIngredientes());
					pizza.setTamanho(entity.getIngredientes());
					pizza.setPreco(entity.getPreco());
					Pizza updated = pizzaRepository.save(pizza);
					return ResponseEntity.ok().body(updated);
				}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(value="/{idpizza}")
	public ResponseEntity <?> Delete(@PathVariable long idpizza){
		return pizzaRepository.findById(idpizza)
				.map(pizza -> {
					pizzaRepository.deleteById(idpizza);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
}
