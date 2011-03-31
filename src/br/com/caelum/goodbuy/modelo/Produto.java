package br.com.caelum.goodbuy.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Produto {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull(message = "Não pode ficar vazio")
	@Size(min = 3, max = 20, message = "Deve ter mais 3 letras e menos que 20")
	private String nome;
	
	@NotNull(message = "Não pode ficar vazio")
	@Size(max = 40, message = "Não pode ter mais de 40 letras")
	private String descricao;

	@NotNull(message = "Não pode ficar vazio")
	@Min(value = 0, message = "Não pode ser negativo")
	private Double preco;

	public Produto() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
