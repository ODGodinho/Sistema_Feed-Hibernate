package br.com.DragonsGamers.ODG.util;

import br.com.DragonsGamers.ODG.dao.GenericDAO;
import br.com.DragonsGamers.ODG.entidades.Categorias;

public class Testes {

	public static void main(String[] args) {
		GenericDAO<Categorias> dao = new GenericDAO<Categorias>(Categorias.class);
		
		Categorias a = new Categorias(null).setID(8);
		a.setNomeCategoria("Categoria");
		
		dao.recuperar(2);
	}
	
}
