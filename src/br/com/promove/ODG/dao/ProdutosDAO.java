package br.com.promove.ODG.dao;

import br.com.promove.ODG.entidades.Produtos;
import br.com.promove.ODG.util.GenericTable;

public class ProdutosDAO extends GenericDAO<Produtos>{

	public ProdutosDAO() {
		super(Produtos.class);
	}

}
