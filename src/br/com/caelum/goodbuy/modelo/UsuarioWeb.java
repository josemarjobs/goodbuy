package br.com.caelum.goodbuy.modelo;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class UsuarioWeb {

	private Usuario logado;

	public void login(Usuario usuario) {
		this.logado = usuario;
	}

	public String getNome() {
		return this.logado.getNome();
	}

	public boolean isLogado() {
		return this.logado != null;
	}

	public void logout() {
		this.logado = null;
	}
}
