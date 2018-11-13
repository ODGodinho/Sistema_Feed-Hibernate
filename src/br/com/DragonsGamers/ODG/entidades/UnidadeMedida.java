package br.com.DragonsGamers.ODG.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.DragonsGamers.ODG.util.GenericTable;

@Entity
@Table(name="sf_unidade-medida")
public class UnidadeMedida extends GenericTable<UnidadeMedida> {

	@Id
	@GeneratedValue
	@Column(name="id_unidadem")
	private int id_unidadem;
	
	@Column(name="nome_unidadem", length=70)
	private String nome_unidadem;

	public UnidadeMedida() {
	}

	public UnidadeMedida(int idUnidadem, String nomeUnidadem) {
		this.id_unidadem = idUnidadem;
		this.nome_unidadem = nomeUnidadem;
	}

	public String getNomeUnidadem() {
		return this.nome_unidadem;
	}

	public UnidadeMedida setNomeUnidadem(String nomeUnidadem) {
		this.nome_unidadem = nomeUnidadem;
		return this;
	}

	@Override
	public int getID() {
		return this.id_unidadem;
	}

	@Override
	public UnidadeMedida setID(int ID) {
		this.id_unidadem = ID;
		return this;
	}

}
