package com.pizzaria.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pizzaria.mvc.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long>{
	
}
