package br.com.DragonsGamers.ODG.util;

import br.com.DragonsGamers.ODG.dao.GenericDAO;
import br.com.DragonsGamers.ODG.entidades.Marca;

public class Testes {

	public static void main(String[] args) {
		GenericDAO<Marca> b = new GenericDAO<Marca>(Marca.class);
		
		
		System.out.println(b.recuperar("nome_marca", "kibon").get(0));
	}
	
}
