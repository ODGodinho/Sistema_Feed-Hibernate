package br.com.DragonsGamers.ODG.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.DragonsGamers.ODG.util.GenericTable;

@Entity
@Table(name = "sf_categoria")
public class Categorias extends GenericTable<Categorias> {

	@Id
	@GeneratedValue
	@Column(name = "id_categoria")
	public int id_categoria;

	@Column(name = "nome_categoria")
	public String nome_categoria;

	public Categorias() {
	}

	public Categorias(String nomeCategoria) {
		this.nome_categoria = nomeCategoria;
	}

	public String getNomeCategoria() {
		return this.nome_categoria;
	}

	public Categorias setNomeCategoria(String nomeCategoria) {
		this.nome_categoria = nomeCategoria;
		return this;
	}

	@Override
	public int getID() {
		return id_categoria;
	}

	@Override
	public Categorias setID(int ID) {
		this.id_categoria = ID;
		return this;
	}
	
	@Override
	public String toString() {
		return "Categorias [id_categoria=" + id_categoria + ", nome_categoria=" + nome_categoria + "]";
	}

}
