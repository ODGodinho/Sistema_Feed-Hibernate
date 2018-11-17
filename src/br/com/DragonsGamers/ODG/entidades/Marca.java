package br.com.DragonsGamers.ODG.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.DragonsGamers.ODG.util.GenericTable;

@Entity
@Table(name="sf_marcas")
public class Marca extends GenericTable<Marca> {

	@Id
	@GeneratedValue
	@Column(name = "id_marca")
	private Integer id_marca;

	@Column(name = "nome_marca", length = 50)
	private String nomeMarca;

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
		return this.id_marca;
	}

	@Override
	public Marca setID(int ID) {
		this.id_marca = ID;
		return this;
	}


	@Override
	public String toString() {
		return "Marca [id_marca=" + id_marca + ", nomeMarca=" + nomeMarca + "]";
	}

	
	
}
