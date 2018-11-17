package br.com.DragonsGamers.ODG.util;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class Helpers {

	public static void redirect(String page) {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ec = context.getExternalContext();

		try {
			ec.redirect(ec.getRequestContextPath() + "/pages/" + page + ".xhtml");
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}
	
	public static void addMessage(String summary) {
		addMessage(summary,FacesMessage.SEVERITY_INFO);
	}
	
	public static void addMessage(String summary, Severity f) {
		FacesMessage message = new FacesMessage(f, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	
}
