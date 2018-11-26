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
@Table(name="sf_marcas")
public class Marca extends GenericTable<Marca> {

	@Id
	@GeneratedValue
	@Column(name = "id_marca")
	private Integer idMarca;

	@Column(name = "nome_marca", length = 50)
	private String nomeMarca;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "marca")
	public Set<Produto> produto;

	public Marca() {
	}

	public Marca(String nomeMarca) {
		super();
		this.nomeMarca = nomeMarca;
	}
	
	public String getNomeMarca() {
		return nomeMarca;
	}


	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}


	@Override
	public int getID() {
		return this.idMarca;
	}

	@Override
	public Marca setID(int ID) {
		this.idMarca = ID;
		return this;
	}


//	@Override
//	public String toString() {
//		return "Marca [id_marca=" + id_marca + ", nomeMarca=" + nomeMarca + "]";
//	}

	
	
}
