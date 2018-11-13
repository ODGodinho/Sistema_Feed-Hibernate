package br.com.promove.ODG.entidades;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.promove.ODG.util.GenericTable;

public class Vendas extends GenericTable<Vendas> {

	@Id
	@GeneratedValue
	@Column(name="id_venda")
	private int id_venda;
	
	
	@ManyToOne
	@JoinColumn(name="id_produto")
	private Produtos sfProdutos;
	
	@Column(name="data_venda")
	private Date data_venda;
	
	@Column(name="valor_venda")
	private BigDecimal valor_venda;
	
	@Column(name="quantidade_venda")
	private int quantidade_venda;

	public Vendas() {
	}

	public Vendas(int id_venda, Produtos sfProdutos, Date dataVenda, BigDecimal valorVenda, int quantidadeVenda) {
		this.id_venda = id_venda;
		this.sfProdutos = sfProdutos;
		this.data_venda = dataVenda;
		this.valor_venda = valorVenda;
		this.quantidade_venda = quantidadeVenda;
	}

	public Produtos getSfProdutos() {
		return this.sfProdutos;
	}

	public Vendas setSfProdutos(Produtos sfProdutos) {
		this.sfProdutos = sfProdutos;
		return this;
	}

	public Date getDataVenda() {
		return this.data_venda;
	}

	public Vendas setDataVenda(Date dataVenda) {
		this.data_venda = dataVenda;
		return this;
	}

	public BigDecimal getValorVenda() {
		return this.valor_venda;
	}

	public Vendas setValorVenda(BigDecimal valorVenda) {
		this.valor_venda = valorVenda;
		return this;
	}

	public int getQuantidadeVenda() {
		return this.quantidade_venda;
	}

	public Vendas setQuantidadeVenda(int quantidadeVenda) {
		this.quantidade_venda = quantidadeVenda;
		return this;
	}

	@Override
	public int getID() {
		return this.id_venda;
	}

	@Override
	public Vendas setID(int ID) {
		this.id_venda = ID;
		return this;
	}

}
