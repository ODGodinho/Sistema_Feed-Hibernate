package br.com.promove.ODG.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.promove.ODG.dao.GenericDAO;
import br.com.promove.ODG.entidades.Categorias;

@ManagedBean
public class ControlerPrincipal {

	public List<Categorias> categorias;
	
	@PostConstruct
	public void init() {
		
	}

	public String test() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest a = (HttpServletRequest) ctx.getExternalContext().getRequest();
		
		return a.getRequestURI();
	}
	
	public List<Categorias> getCategorias() {
		GenericDAO<Categorias> dao = new GenericDAO<Categorias>(Categorias.class);
		categorias = dao.recuperarTodos();
		return categorias;
	}
}
