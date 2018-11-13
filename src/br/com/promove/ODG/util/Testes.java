package br.com.promove.ODG.util;

import br.com.promove.ODG.dao.GenericDAO;
import br.com.promove.ODG.entidades.Categorias;

public class Testes {

	public static void main(String[] args) {
		GenericDAO<Categorias> dao = new GenericDAO<Categorias>(Categorias.class);
		
		Categorias a = new Categorias("Categoria 4").setID(8);
		
		
		dao.recuperar(2);
	}
	
}
