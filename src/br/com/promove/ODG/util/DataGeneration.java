package br.com.promove.ODG.util;

import org.hibernate.cfg.Configuration;

import br.com.promove.ODG.entidades.Produtos;

public class DataGeneration {

	public static void main(String[] args) {

		new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Produtos.class)
			.buildSessionFactory();

		System.exit(1);

	}

}
