package br.com.DragonsGamers.ODG.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import br.com.DragonsGamers.ODG.dao.GenericDAO;
import br.com.DragonsGamers.ODG.entidades.Categoria;
import br.com.DragonsGamers.ODG.util.Helpers;

@ManagedBean(name="categoriaMB")
@ViewScoped
public class CategoriaMB {

	public Categoria categoria;
	public List<Categoria> categorias;
	public GenericDAO<Categoria> DAO;
	
	@PostConstruct
	public void init() {
		this.categoria = new Categoria();
		this.DAO = new GenericDAO<Categoria>(Categoria.class);
		this.categorias = DAO.recuperarTodos();

	}

	public void alterar(ActionEvent actionEvent) {
		for (Categoria categ : categorias) {
			DAO.update(categ);
		}
		
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
		Categoria categoria = DAO.recuperar(Integer.parseInt(parametro));
		DAO.delete(categoria);
		Helpers.addMessage("Tudo Pronto a Categoria " + categoria.getNome() + " Foi deletada com sucesso!");
		categorias = DAO.recuperarTodos();
		return null;
	}

	public void gravar(ActionEvent actionEvent) {
		if (this != null) {
			DAO.insert(categoria);
		}
		
		Helpers.addMessage("Prontinho! A Categoria "+ categoria.nome + " Foi cadastrada com sucesso!");
		categoria = new Categoria();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public GenericDAO<Categoria> getDAO() {
		return DAO;
	}

	public void setDAO(GenericDAO<Categoria> dAO) {
		DAO = dAO;
	}
	
	
	

}
