package br.com.DragonsGamers.ODG.util;

import br.com.DragonsGamers.ODG.dao.GenericDAO;
import br.com.DragonsGamers.ODG.entidades.Categoria;
import br.com.DragonsGamers.ODG.entidades.Fornecedor;

public class Testes {

	public static void main(String[] args) {
		GenericDAO<Fornecedor> dao = new GenericDAO<Fornecedor>(Fornecedor.class);
		
		System.out.println(dao.recuperar(29));
	}
	
}
