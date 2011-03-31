package br.com.caelum.goodbuy;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class CriaBanco {
	public static void main(String[] args) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure();
		SchemaExport exp = new SchemaExport(cfg);
		exp.create(true, true);
		System.out.println("====DataBase Created====");
	}
}
