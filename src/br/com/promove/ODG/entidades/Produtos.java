package br.com.promove.ODG.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.promove.ODG.util.GenericTable;

@Entity
@Table(name="sf_produtos")
public class Produtos extends GenericTable<Produtos> {

	@Id
	@GeneratedValue
	@Column(name = "id_produto")
	private int id_produto;

	@Column(name = "nome_produto", length = 50)
	private String nome_produto;

	@Column(name = "codigo_produto", length = 122)
	private String codigo_produto;

	@Column(name = "porcao_produto", precision = 3)
	private double porcao_produto;

	
//	private SfCompras SfCompra;
//	private SfFornecedor SfFornecedor;
//	private SfProdutos SfProduto;

	private Set<?> sfComprases = new HashSet<Object>(0);
	
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="sfProdutos")
//	private Set<SfVendas> sfVendases = new HashSet<SfVendas>(0);

	public Produtos() {
	}

	public Produtos(int id, String nomeProduto, String codigoProduto, double porcaoProduto) {
		this.id_produto = id;
		this.nome_produto = nomeProduto;
		this.codigo_produto = codigoProduto;
		this.porcao_produto = porcaoProduto;
	}

	public String getNomeProduto() {
		return this.nome_produto;
	}

	public Produtos setNomeProduto(String nomeProduto) {
		this.nome_produto = nomeProduto;
		return this;
	}

	public String getCodigoProduto() {
		return this.codigo_produto;
	}

	public Produtos setCodigoProduto(String codigoProduto) {
		this.codigo_produto = codigoProduto;
		return this;
	}

	public double getPorcaoProduto() {
		return this.porcao_produto;
	}

	public Produtos setPorcaoProduto(double porcaoProduto) {
		this.porcao_produto = porcaoProduto;
		return this;
	}

	public Set<?> getSfComprases() {
		return this.sfComprases;
	}

	public Produtos setSfComprases(Set<?> sfComprases) {
		this.sfComprases = sfComprases;
		return this;
	}

//	public Set<?> getSfVendases() {
//		return this.sfVendases;
//	}
//
//	public Produtos setSfVendases(Set<SfVendas> sfVendases) {
//		this.sfVendases = sfVendases;
//		return this;
//	}

	@Override
	public int getID() {
		return this.id_produto;
	}

	@Override
	public Produtos setID(int ID) {
		this.id_produto = ID;
		return this;
	}

}
