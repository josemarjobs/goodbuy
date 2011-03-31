package br.com.caelum.goodbuy;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Resource;

@Resource
public class Mundo {
	public String boasVindas() {
		return "Alo Mundo!!";
	}

	public List<String> paises() {
		List<String> paises = new ArrayList<String>();
		paises.add("Angola");
		paises.add("Portgugal");
		paises.add("Brasil");
		return paises;
	}

}
