package br.com.DragonsGamers.ODG.entidades;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.DragonsGamers.ODG.util.GenericTable;

@Entity
@Table(name = "sf_compras")
public class Compras extends GenericTable<Compras> {

	@Id
	@GeneratedValue
	@Column(name = "id_compra")
	private int id_compra;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_fornecedor")
	@Column(name = "id_fornecedor")
	private Fornecedor sfFornecedor;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_produto")
	@Column(name = "id_produto")
	private Produtos sfProdutos;

	@Column(name = "valor_compra", precision=2)
	private BigDecimal valor_compra;

	@Column(name = "quantidade_compra")
	private int quantidade_compra;

	public Compras() {
	}
	
	public Compras(Fornecedor sfFornecedor, Produtos sfProdutos, BigDecimal valorCompra, int quantidadeCompra) {
		this.sfFornecedor = sfFornecedor;
		this.sfProdutos = sfProdutos;
		this.valor_compra = valorCompra;
		this.quantidade_compra = quantidadeCompra;
	}

	@Override
	public int getID() {
		return this.id_compra;
	}

	@Override
	public Compras setID(int ID) {
		this.id_compra = ID;
		return this;
	}

	public Fornecedor getSfFornecedor() {
		return this.sfFornecedor;
	}

	public void setSfFornecedor(Fornecedor sfFornecedor) {
		this.sfFornecedor = sfFornecedor;
	}

	public Produtos getSfProdutos() {
		return this.sfProdutos;
	}

	public void setSfProdutos(Produtos sfProdutos) {
		this.sfProdutos = sfProdutos;
	}

	public BigDecimal getValorCompra() {
		return this.valor_compra;
	}

	public void setValorCompra(BigDecimal valorCompra) {
		this.valor_compra = valorCompra;
	}

	public int getQuantidadeCompra() {
		return this.quantidade_compra;
	}

	public void setQuantidadeCompra(int quantidadeCompra) {
		this.quantidade_compra = quantidadeCompra;
	}

}
