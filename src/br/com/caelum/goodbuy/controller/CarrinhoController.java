package br.com.caelum.goodbuy.controller;

import br.com.caelum.goodbuy.dao.ProdutoDao;
import br.com.caelum.goodbuy.modelo.Carrinho;
import br.com.caelum.goodbuy.modelo.Item;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class CarrinhoController {

	private final ProdutoDao dao;
	private final Result result;
	private final Carrinho carrinho;

	public CarrinhoController(ProdutoDao dao, Result result, Carrinho carrinho) {
		this.dao = dao;
		this.result = result;
		this.carrinho = carrinho;
	}

	@Post
	@Path("/carrinho")
	public void adiciona(Item item) {
		dao.recarrega(item.getProduto());
		carrinho.adiciona(item);
		result.redirectTo(this).visualiza();
	}

	@Get
	@Path("/carrinho")
	public void visualiza() {
	}

	@Delete
	@Path("/carrinho/{indiceItem}")
	public void remove(int indiceItem) {
		carrinho.remove(indiceItem);
		result.redirectTo(this).visualiza();
	}
}
