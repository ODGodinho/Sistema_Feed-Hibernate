package br.com.DragonsGamers.ODG.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.DragonsGamers.ODG.util.GenericTable;

@Entity
@Table(name = "sf_produtos")
public class Produto extends GenericTable<Produto> {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "id_produto")
	public int id_produto;

	@Column(name = "nome_produto", length = 80)
	public String nomeProduto;

	@Column(name = "codigo_produto", length = 122)
	public String codigoProduto;

	@Column(name = "porcao_produto", precision = 3,length=4)
	public double porcaoProduto;

//	private SfCompras SfCompra;
//	private SfFornecedor SfFornecedor;
//	private SfProdutos SfProduto;

//	private Set<?> sfComprases = new HashSet<Object>(0);

//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="sfProdutos")
//	private Set<SfVendas> sfVendases = new HashSet<SfVendas>(0);

	public Produto() {
	}

	public Produto(String nomeProduto, String codigoProduto, double porcaoProduto) {
		super();
		this.nomeProduto = nomeProduto;
		this.codigoProduto = codigoProduto;
		this.porcaoProduto = porcaoProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
//		return this;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
//		return this;
	}

	public double getPorcaoProduto() {
		return porcaoProduto;
	}

	public void setPorcaoProduto(double porcaoProduto) {
		this.porcaoProduto = porcaoProduto;
//		return this;
	}

	@Override
	public int getID() {
		return this.id_produto;
	}

	@Override
	public Produto setID(int ID) {
		this.id_produto = ID;
		return this;
	}

	@Override
	public String toString() {
		return "Produto [id_produto=" + id_produto + ", nomeProduto=" + nomeProduto + ", codigoProduto=" + codigoProduto
				+ ", porcaoProduto=" + porcaoProduto + "]";
	}

	
}
