package br.com.DragonsGamers.ODG.entidades;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.DragonsGamers.ODG.util.GenericTable;

@Entity
@Table(name = "sf_fornecedor")
public class Fornecedor extends GenericTable<Fornecedor> {

	@Id
	@GeneratedValue
	@Column(name = "id_fornecedor", length = 11)
	private int id_fornecedor;

	@Column(name = "nome_fornecedor")
	private String nome_fornecedor;

	@Column(name = "contato_fornecedor", length = 16)
	private String contato_fornecedor;

	@Column(name = "nomeContato_fornecedor", length = 100)
	private String nomeContato_fornecedor;

	@Column(name = "nomeFantasia_fornecedor")
	private String nomeFantasia_fornecedor;

	@Column(name = "email_fornecedor", length = 100)
	private String email_fornecedor;

	@Column(name = "rua_fornecedor", length = 100)
	private String rua_fornecedor;

	@Column(name = "numero_fornecedor", length = 5)
	private int numero_fornecedor;

	@Column(name = "complemento_fornecedor", length = 10)
	private String complemento_fornecedor;

	@Column(name = "bairro_fornecedor", length = 80)
	private String bairro_fornecedor;

	@OneToMany(mappedBy = "id_compra", cascade = CascadeType.ALL)
	private Set<Compras> sfComprases;

	public Fornecedor(String nomeFornecedor) {
		this.nome_fornecedor = nomeFornecedor;
	}

	public Fornecedor(String nomeFornecedor, String contatoFornecedor, String nomeContatoFornecedor,
			String nomeFantasiaFornecedor, String emailFornecedor, String ruaFornecedor, int numeroFornecedor,
			String bairroFornecedor, String complementoFornecedor) {
		this.nome_fornecedor = nomeFornecedor;
		this.contato_fornecedor = contatoFornecedor;
		this.nomeContato_fornecedor = nomeContatoFornecedor;
		this.nomeFantasia_fornecedor = nomeFantasiaFornecedor;
		this.email_fornecedor = emailFornecedor;
		this.rua_fornecedor = ruaFornecedor;
		this.numero_fornecedor = numeroFornecedor;
		this.complemento_fornecedor = complementoFornecedor;
		this.bairro_fornecedor = bairroFornecedor;
	}

	public String getNomeFornecedor() {
		return this.nome_fornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nome_fornecedor = nomeFornecedor;
	}

	public String getContatoFornecedor() {
		return this.contato_fornecedor;
	}

	public void setContatoFornecedor(String contatoFornecedor) {
		this.contato_fornecedor = contatoFornecedor;
	}

	public String getNomeContatoFornecedor() {
		return this.nomeContato_fornecedor;
	}

	public void setNomeContatoFornecedor(String nomeContatoFornecedor) {
		this.nomeContato_fornecedor = nomeContatoFornecedor;
	}

	public String getNomeFantasiaFornecedor() {
		return this.nomeFantasia_fornecedor;
	}

	public void setNomeFantasiaFornecedor(String nomeFantasiaFornecedor) {
		this.nomeFantasia_fornecedor = nomeFantasiaFornecedor;
	}

	public String getEmailFornecedor() {
		return this.email_fornecedor;
	}

	public void setEmailFornecedor(String emailFornecedor) {
		this.email_fornecedor = emailFornecedor;
	}

	public String getRuaFornecedor() {
		return this.rua_fornecedor;
	}

	public void setRuaFornecedor(String ruaFornecedor) {
		this.rua_fornecedor = ruaFornecedor;
	}

	public String getComplementoFornecedor() {
		return complemento_fornecedor;
	}

	public void setComplementoFornecedor(String complemento_fornecedor) {
		this.complemento_fornecedor = complemento_fornecedor;
	}

	public int getNumeroFornecedor() {
		return this.numero_fornecedor;
	}

	public void setNumeroFornecedor(int numeroFornecedor) {
		this.numero_fornecedor = numeroFornecedor;
	}

	public String getBairroFornecedor() {
		return this.bairro_fornecedor;
	}

	public void setBairroFornecedor(String bairroFornecedor) {
		this.bairro_fornecedor = bairroFornecedor;
	}

	public Set<?> getSfComprases() {
		return this.sfComprases;
	}

	public void setSfComprases(Set<Compras> sfComprases) {
		this.sfComprases = sfComprases;
	}

	@Override
	public int getID() {
		return this.id_fornecedor;
	}

	@Override
	public Fornecedor setID(int ID) {
		this.id_fornecedor = ID;
		return this;
	}

}
