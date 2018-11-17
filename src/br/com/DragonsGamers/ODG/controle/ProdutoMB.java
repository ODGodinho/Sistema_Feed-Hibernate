package br.com.DragonsGamers.ODG.controle;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import br.com.DragonsGamers.ODG.dao.GenericDAO;
import br.com.DragonsGamers.ODG.entidades.Produto;
import br.com.DragonsGamers.ODG.util.Helpers;

@ManagedBean(name = "produtoMB")
@ViewScoped
public class ProdutoMB {

	public Produto produto = new Produto();
	public List<Produto> produtos;
	public GenericDAO<Produto> DAO;
	public boolean editpage = false;

	@PostConstruct
	public void init() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		this.DAO = new GenericDAO<Produto>(Produto.class);

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

}
