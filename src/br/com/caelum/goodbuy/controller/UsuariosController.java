package br.com.caelum.goodbuy.controller;

import br.com.caelum.goodbuy.dao.UsuarioDao;
import br.com.caelum.goodbuy.modelo.Usuario;
import br.com.caelum.goodbuy.modelo.UsuarioWeb;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Resource
public class UsuariosController {

	private final UsuarioDao dao;
	private final Result result;
	private final Validator validator;
	private final UsuarioWeb usuarioWeb;

	public UsuariosController(UsuarioDao dao, Result result,
			Validator validator, UsuarioWeb usuarioWeb) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
	}

	@Get
	@Path("/logout")
	public void logout() {
		this.usuarioWeb.logout();
		this.result.redirectTo(ProdutosController.class).lista();
	}

	@Post
	@Path("/login")
	public void login(Usuario usuario) {
		Usuario carregado = this.dao.carrega(usuario);
		if (carregado == null) {
			validator.add(new ValidationMessage("Login e/ou senha incorretos",
					"usuario.login"));
		}
		validator.onErrorUsePageOf(this).loginForm();
		this.usuarioWeb.login(carregado);
		this.result.redirectTo(ProdutosController.class).lista();
	}

	@Get
	@Path("/usuarios/login")
	public void loginForm() {

	}

	@Post
	@Path("/usuarios")
	public void adiciona(Usuario usuario) {
		if (dao.existeUsuario(usuario)) {
			validator.add(new ValidationMessage("Lógin já existe",
					"usuario.login"));
		}
		validator.onErrorUsePageOf(this).novo();
		dao.adiciona(usuario);
		result.redirectTo(ProdutosController.class).lista();
	}

	@Get
	@Path("/usuarios/novo")
	public void novo() {

	}
}
