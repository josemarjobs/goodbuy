package br.com.caelum.goodbuy.controller;

import java.util.List;

import br.com.caelum.goodbuy.annotation.Restrito;
import br.com.caelum.goodbuy.dao.ProdutoDao;
import br.com.caelum.goodbuy.modelo.Produto;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.validator.Validations;
import br.com.caelum.vraptor.view.Results;

@Resource
public class ProdutosController {

	private final ProdutoDao dao;
	private final Result result;
	private final Validator validator;

	public ProdutosController(ProdutoDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}

	@Get
	@Path("/produtos")
	public List<Produto> lista() {
		return dao.listaTudo();
	}

	@Get
	@Path("/produtos/novo")
	@Restrito
	public void formulario() {
	}

	@Post
	@Path("/produtos")
	@Restrito
	public void adiciona(final Produto produto) {
		validator.validate(produto);
		validator.onErrorRedirectTo(this).formulario();
		this.dao.salva(produto);
		this.result.redirectTo(this).lista();
	}

	@Get
	@Path("/produtos/{id}")
	@Restrito
	public Produto edita(Long id) {
		return dao.load(id);
	}

	@Put
	@Path("/produtos/{produto.id}")
	@Restrito
	public void altera(Produto produto) {
		validator.validate(produto);
		validator.onErrorUsePageOf(ProdutosController.class).edita(
				produto.getId());
		this.dao.atualiza(produto);
		this.result.redirectTo(this).lista();
	}

	@Delete
	@Path("/produtos/{id}")
	@Restrito
	public void remove(Long id) {
		Produto produto = this.dao.load(id);
		this.dao.remove(produto);
		this.result.redirectTo(this).lista();
	}

	public List<Produto> busca(String nome) {
		result.include("nome", nome);
		return this.dao.busca(nome);
	}

	@Get
	@Path("/produtos/busca.json")
	public void buscaJson(String q) {
		this.result.use(Results.json()).withoutRoot().from(this.busca(q))
				.exclude("id", "descricao").serialize();
	}

	
}
