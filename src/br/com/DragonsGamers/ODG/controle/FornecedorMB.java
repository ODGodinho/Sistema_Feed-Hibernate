package br.com.DragonsGamers.ODG.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import br.com.DragonsGamers.ODG.dao.GenericDAO;
import br.com.DragonsGamers.ODG.entidades.Fornecedor;
import br.com.DragonsGamers.ODG.util.Helpers;

@ManagedBean(name = "fornecedorMB")
@ViewScoped
public class FornecedorMB {

	public Fornecedor fornecedor = new Fornecedor();
	public List<Fornecedor> fornecedors;
	public GenericDAO<Fornecedor> DAO;
	public boolean editpage = false;

	@PostConstruct
	public void init() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		this.DAO = new GenericDAO<Fornecedor>(Fornecedor.class);

		try {

			int parametro = Integer.valueOf(req.getParameter("id"));
			this.fornecedor = DAO.recuperar(parametro);
			if (this.fornecedor == null)
				Helpers.redirect("Fornecedores");
			this.editpage = true;

		} catch (Exception e) {
			this.fornecedor = new Fornecedor();
		}
		this.fornecedors = DAO.recuperarTodos();

	}

	public void alterar(ActionEvent actionEvent) {
		for (Fornecedor categ : fornecedors) {
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
		Fornecedor fornecedor = DAO.recuperar(Integer.parseInt(parametro));
		DAO.delete(fornecedor);
		Helpers.addMessage("Tudo Pronto o Fornecedor " + fornecedor.getNomeFornecedor() + " Foi deletada com sucesso!");
		fornecedors = DAO.recuperarTodos();
		return null;
	}

	public void gravar(ActionEvent actionEvent) {
		String status;
		if (editpage) {
			DAO.update(fornecedor);
			status = "atualizado";
		} else {
			DAO.insert(fornecedor);
			status = "cadastrado";
		}

		Helpers.addMessage(
				"Prontinho! O Fornecedor " + fornecedor.getNomeFornecedor() + " Foi " + status + " com sucesso!");
		fornecedor = new Fornecedor();
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getFornecedors() {
		return fornecedors;
	}

	public void setFornecedors(List<Fornecedor> fornecedors) {
		this.fornecedors = fornecedors;
	}

	public GenericDAO<Fornecedor> getDAO() {
		return DAO;
	}

	public void setDAO(GenericDAO<Fornecedor> dAO) {
		DAO = dAO;
	}

}
