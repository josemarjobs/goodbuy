package br.com.caelum.goodbuy.interceptor;

import br.com.caelum.goodbuy.annotation.Restrito;
import br.com.caelum.goodbuy.controller.UsuariosController;
import br.com.caelum.goodbuy.modelo.UsuarioWeb;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;

@Intercepts
public class AutenticacaoInterceptor implements Interceptor {

	private final Result result;
	private final UsuarioWeb usuarioWeb;

	public AutenticacaoInterceptor(UsuarioWeb usuarioWeb, Result result) {
		this.usuarioWeb = usuarioWeb;
		this.result = result;
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		return !usuarioWeb.isLogado()
				&& method.containsAnnotation(Restrito.class);
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {
		this.result.redirectTo(UsuariosController.class).loginForm();
	}

}
