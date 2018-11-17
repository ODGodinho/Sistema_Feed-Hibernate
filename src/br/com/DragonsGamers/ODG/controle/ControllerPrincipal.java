package br.com.DragonsGamers.ODG.controle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
public class ControllerPrincipal {

	
	@PostConstruct
	public void init() {
		
	}

	public String test() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest a = (HttpServletRequest) ctx.getExternalContext().getRequest();
		
		return a.getRequestURI();
	}
}
