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
	private String nomeFornecedor;

	@Column(name = "contato_fornecedor", length = 16)
	private String contatoFornecedor;

	@Column(name = "nomeContato_fornecedor", length = 100)
	private String nomeContatoFornecedor;

	@Column(name = "nomeFantasia_fornecedor")
	private String nomeFantasiaFornecedor;

	@Column(name = "email_fornecedor", length = 100)
	private String emailFornecedor;

	@Column(name = "rua_fornecedor", length = 100)
	private String ruaFornecedor;

	@Column(name = "numero_fornecedor", length = 5)
	private int numeroFornecedor;

	@Column(name = "complemento_fornecedor", length = 10)
	private String complementoFornecedor;

	@Column(name = "bairro_fornecedor", length = 80)
	private String bairroFornecedor;

//	@OneToMany(mappedBy = "id_compra", cascade = CascadeType.ALL)
//	private Set<Compras> sfComprases;

	public Fornecedor() {
		// TODO Auto-generated constructor stub
	}

	public Fornecedor(int id_fornecedor, String nomeFornecedor, String contatoFornecedor, String nomeContatoFornecedor,
			String nomeFantasiaFornecedor, String emailFornecedor, String ruaFornecedor, int numeroFornecedor,
			String complementoFornecedor, String bairroFornecedor) {
		super();
		this.id_fornecedor = id_fornecedor;
		this.nomeFornecedor = nomeFornecedor;
		this.contatoFornecedor = contatoFornecedor;
		this.nomeContatoFornecedor = nomeContatoFornecedor;
		this.nomeFantasiaFornecedor = nomeFantasiaFornecedor;
		this.emailFornecedor = emailFornecedor;
		this.ruaFornecedor = ruaFornecedor;
		this.numeroFornecedor = numeroFornecedor;
		this.complementoFornecedor = complementoFornecedor;
		this.bairroFornecedor = bairroFornecedor;
	}

	public int getId_fornecedor() {
		return id_fornecedor;
	}

	public void setId_fornecedor(int id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public String getContatoFornecedor() {
		return contatoFornecedor;
	}

	public void setContatoFornecedor(String contatoFornecedor) {
		this.contatoFornecedor = contatoFornecedor;
	}

	public String getNomeContatoFornecedor() {
		return nomeContatoFornecedor;
	}

	public void setNomeContatoFornecedor(String nomeContatoFornecedor) {
		this.nomeContatoFornecedor = nomeContatoFornecedor;
	}

	public String getNomeFantasiaFornecedor() {
		return nomeFantasiaFornecedor;
	}

	public void setNomeFantasiaFornecedor(String nomeFantasiaFornecedor) {
		this.nomeFantasiaFornecedor = nomeFantasiaFornecedor;
	}

	public String getEmailFornecedor() {
		return emailFornecedor;
	}

	public void setEmailFornecedor(String emailFornecedor) {
		this.emailFornecedor = emailFornecedor;
	}

	public String getRuaFornecedor() {
		return ruaFornecedor;
	}

	public void setRuaFornecedor(String ruaFornecedor) {
		this.ruaFornecedor = ruaFornecedor;
	}

	public int getNumeroFornecedor() {
		return numeroFornecedor;
	}

	public void setNumeroFornecedor(int numeroFornecedor) {
		this.numeroFornecedor = numeroFornecedor;
	}

	public String getComplementoFornecedor() {
		return complementoFornecedor;
	}

	public void setComplementoFornecedor(String complementoFornecedor) {
		this.complementoFornecedor = complementoFornecedor;
	}

	public String getBairroFornecedor() {
		return bairroFornecedor;
	}

	public void setBairroFornecedor(String bairroFornecedor) {
		this.bairroFornecedor = bairroFornecedor;
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

	@Override
	public String toString() {
		return "Fornecedor [id_fornecedor=" + id_fornecedor + ", nomeFornecedor=" + nomeFornecedor
				+ ", contatoFornecedor=" + contatoFornecedor + ", nomeContatoFornecedor=" + nomeContatoFornecedor
				+ ", nomeFantasiaFornecedor=" + nomeFantasiaFornecedor + ", emailFornecedor=" + emailFornecedor
				+ ", ruaFornecedor=" + ruaFornecedor + ", numeroFornecedor=" + numeroFornecedor
				+ ", complementoFornecedor=" + complementoFornecedor + ", bairroFornecedor=" + bairroFornecedor + "]";
	}	
	
}
