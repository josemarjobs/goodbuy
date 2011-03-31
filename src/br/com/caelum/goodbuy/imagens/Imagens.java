package br.com.caelum.goodbuy.imagens;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import br.com.caelum.goodbuy.modelo.Produto;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class Imagens {

	private File pastaImagens;

	public Imagens(ServletContext context) {
		String caminho = context.getRealPath("/WEB-INF/imagens");
		pastaImagens = new File(caminho);
		pastaImagens.mkdir();
	}

	public void salva(UploadedFile imagem, Produto produto) {
		File caminho = new File(pastaImagens, produto.getId() + ".imagem");
		try {
			IOUtils.copyLarge(imagem.getFile(), new FileOutputStream(caminho));
		} catch (IOException e) {
			throw new RuntimeException("Erro ao copiar imagem\n" + e);
		}
	}

	public File mostra(Produto produto) {
		return new File(pastaImagens, produto.getId() + ".imagem");
	}
}
