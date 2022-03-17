package com.pizzaria.mvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pizza {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long idpizza;
		
		private String sabor;
		private String ingredientes;
		private String tamanho;
		private double preco;
		
		public long getIdpizza() {
			return idpizza;
		}
		public void setIdpizza(long idpizza) {
			this.idpizza = idpizza;
		}
		public String getSabor() {
			return sabor;
		}
		public void setSabor(String sabor) {
			this.sabor = sabor;
		}
		public String getIngredientes() {
			return ingredientes;
		}
		public void setIngredientes(String ingredientes) {
			this.ingredientes = ingredientes;
		}
		public String getTamanho() {
			return tamanho;
		}
		public void setTamanho(String tamanho) {
			this.tamanho = tamanho;
		}
		public double getPreco() {
			return preco;
		}
		public void setPreco(double preco) {
			this.preco = preco;
		}
		
		
		
	
}
