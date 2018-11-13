package br.com.DragonsGamers.ODG.entidades;

import javax.persistence.Column;

import br.com.DragonsGamers.ODG.util.GenericTable;

public class Marcas extends GenericTable<Marcas> {

	@Column(name = "id_marca")
	private Integer id_marca;

	@Column(name = "nome_marca", length = 50)
	private String nome_marca;

	public Marcas() {
	}

	public Marcas(String nomeMarca) {
		this.nome_marca = nomeMarca;
	}

	public String getNomeMarca() {
		return this.nome_marca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nome_marca = nomeMarca;
	}

	@Override
	public int getID() {
		return this.id_marca;
	}

	@Override
	public Marcas setID(int ID) {
		this.id_marca = ID;
		return this;
	}

}
