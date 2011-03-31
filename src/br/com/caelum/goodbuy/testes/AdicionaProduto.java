package br.com.caelum.goodbuy.testes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.goodbuy.dao.ProdutoDao;
import br.com.caelum.goodbuy.infra.CriadorDeSession;
import br.com.caelum.goodbuy.infra.CriadorDeSessionFactory;
import br.com.caelum.goodbuy.modelo.Produto;

public class AdicionaProduto {
	public static void main(String[] args) {
		SessionFactory factory = new CriadorDeSessionFactory().getInstance();
		Session session = new CriadorDeSession(factory).getInstance();
		Produto p = criaProduto();
		new ProdutoDao(session).salva(p);
		System.out.println("Produto Adicionado");
	}

	private static Produto criaProduto() {
		Produto p = new Produto();
		// p.setNome("Prateleira");
		// p.setDescricao("Uma boa prateleira para colocar livros");
		// p.setPreco(39.90);

		p.setNome("Cama");
		p.setDescricao("Uma boa cama para colocar livros");
		p.setPreco(39.90);
		return p;
	}
}
