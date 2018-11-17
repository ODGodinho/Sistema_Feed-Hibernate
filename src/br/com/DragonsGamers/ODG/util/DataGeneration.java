package br.com.DragonsGamers.ODG.util;

import org.hibernate.cfg.Configuration;

import br.com.DragonsGamers.ODG.entidades.Marca;

public class DataGeneration {

	public static void main(String[] args) {

		new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Marca.class)
			.buildSessionFactory();

		System.exit(1);

	}

}
