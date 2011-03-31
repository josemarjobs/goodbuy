package br.com.caelum.goodbuy.controller;

import java.io.File;

import br.com.caelum.goodbuy.imagens.Imagens;
import br.com.caelum.goodbuy.modelo.Produto;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Resource
public class ImagensController {
	private final Validator validator;
	private final Imagens imagens;
	private final Result result;

	public ImagensController(Validator validator, Imagens imagens, Result result) {
		this.validator = validator;
		this.imagens = imagens;
		this.result = result;
	}

	@Post
	@Path("/produtos/{produto.id}/imagem")
	public void upload(Produto produto, final UploadedFile imagem) {
		if (imagem == null) {
			validator.add(new ValidationMessage("Selecione uma imagem", "imagem"));
		}
		if (imagem != null && !imagem.getContentType().startsWith("image")) {
			validator.add(new ValidationMessage("Não é uma imagem", "imagem"));
		}
		validator.onErrorRedirectTo(ProdutosController.class).edita(
				produto.getId());
		this.imagens.salva(imagem, produto);
		this.result.redirectTo(ProdutosController.class).edita(produto.getId());
	}

	@Get
	@Path("/produtos/{produto.id}/imagem")
	public File download(Produto produto) {
		return imagens.mostra(produto);
	}
}
