package br.com.DragonsGamers.ODG.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import br.com.DragonsGamers.ODG.dao.GenericDAO;
import br.com.DragonsGamers.ODG.entidades.Categoria;
import br.com.DragonsGamers.ODG.entidades.Marca;
import br.com.DragonsGamers.ODG.entidades.Produto;
import br.com.DragonsGamers.ODG.util.Helpers;

@ManagedBean(name = "produtoMB")
@ViewScoped
public class ProdutoMB {

	public Produto produto = new Produto();
	public List<Produto> produtos;
	public List<Categoria> categorias;
	public List<Marca> marcas;
	public GenericDAO<Produto> DAO;
	public boolean editpage = false;

	@PostConstruct
	public void init() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		this.DAO = new GenericDAO<Produto>(Produto.class);
		
		GenericDAO<Categoria> daoc = new GenericDAO<Categoria>(Categoria.class);
		categorias = daoc.recuperarTodos();

		GenericDAO<Marca> daom = new GenericDAO<Marca>(Marca.class);
		marcas = daom.recuperarTodos();
		
		
		try {

			int parametro = Integer.valueOf(req.getParameter("id"));
			this.produto = DAO.recuperar(parametro);
			if (this.produto == null)
				Helpers.redirect("Produtoes");
			this.editpage = true;

		} catch (Exception e) {
			this.produto = new Produto();
		}
		this.produtos = DAO.recuperarTodos();

	}

	public void alterar(ActionEvent actionEvent) {
		for (Produto categ : produtos) {
			DAO.update(categ);
		}
		produtos = DAO.recuperarTodos();
		Helpers.addMessage("Todas as alterações foram salvas!");
	}

	public String test() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest a = (HttpServletRequest) ctx.getExternalContext().getRequest();

		return a.getRequestURI();
	}
	
	public void request() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest a = (HttpServletRequest) ctx.getExternalContext().getRequest();
		
		System.out.println(a.getAttributeNames());
	}

	public Object excluir() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String parametro = req.getParameter("id");
		Produto produto = DAO.recuperar(Integer.parseInt(parametro));
		DAO.delete(produto);
		Helpers.addMessage("Tudo Pronto o Produto " + produto.getNomeProduto() + " Foi deletada com sucesso!");
		produtos = DAO.recuperarTodos();
		return null;
	}

	public void gravar(ActionEvent actionEvent) {
		String status;
		
		if (editpage) {
			DAO.update(produto);
			status = "atualizado";
		} else {
			DAO.insert(produto);
			status = "cadastrado";
		}

		Helpers.addMessage(
				"Prontinho! O Produto " + produto.getNomeProduto() + " Foi " + status + " com sucesso!");
		produto = new Produto();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public GenericDAO<Produto> getDAO() {
		return DAO;
	}

	public void setDAO(GenericDAO<Produto> dAO) {
		DAO = dAO;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public  List<SelectItem> getMarcas() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		
		for (Marca m : marcas) {
			lista.add(new SelectItem(m.getID(), m.getNomeMarca()));
		}
		
		return lista;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}
	
	
}
