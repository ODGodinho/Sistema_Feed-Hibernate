package br.com.DragonsGamers.ODG.entidades;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.DragonsGamers.ODG.util.GenericTable;

@Entity
@Table(name = "sf_categoria")
public class Categoria extends GenericTable<Categoria> {

	@Id
	@GeneratedValue
	@Column(name = "id_categoria")
	public int id_categoria;

	@Column(name = "nome_categoria")
	public String nome;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "categoria")
	public Set<Produto> produto;

	public Categoria() {
	}

	public Categoria(String nomeCategoria) {
		this.nome = nomeCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int getID() {
		return id_categoria;
	}

	@Override
	public Categoria setID(int ID) {
		this.id_categoria = ID;
		return this;
	}

	@Override
	public String toString() {
		return "Categoria [id_categoria=" + id_categoria + ", nome=" + nome + "]";
	}

}
