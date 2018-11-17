package br.com.DragonsGamers.ODG.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import br.com.DragonsGamers.ODG.dao.GenericDAO;
import br.com.DragonsGamers.ODG.entidades.Marca;
import br.com.DragonsGamers.ODG.util.Helpers;

@ManagedBean(name="marcaMB")
@ViewScoped
public class MarcasMB {

	public Marca marca;
	public List<Marca> marcas;
	public GenericDAO<Marca> DAO;
	
	@PostConstruct
	public void init() {
		this.marca = new Marca();
		this.DAO = new GenericDAO<Marca>(Marca.class);
		this.marcas = DAO.recuperarTodos();

	}

	public void alterar(ActionEvent actionEvent) {
		for (Marca categ : marcas) {
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
		Marca marca = DAO.recuperar(Integer.parseInt(parametro));
		DAO.delete(marca);
		Helpers.addMessage("Tudo Pronto a Marca " + marca.getNomeMarca() + " Foi deletada com sucesso!");
		marcas = DAO.recuperarTodos();
		return null;
	}

	public void gravar(ActionEvent actionEvent) {
		if (this != null) {
			DAO.insert(marca);
		}
		
		Helpers.addMessage("Prontinho! A Marca "+ marca.getNomeMarca() + " Foi cadastrada com sucesso!");
		marca = new Marca();
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	public GenericDAO<Marca> getDAO() {
		return DAO;
	}

	public void setDAO(GenericDAO<Marca> dAO) {
		DAO = dAO;
	}

}
