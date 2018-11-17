package br.com.DragonsGamers.ODG.util;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.ColumnDefault;

@MappedSuperclass
public abstract class GenericTable<T>{
	
	@ColumnDefault("CURRENT_TIMESTAMP")
	@Column(name="data_criacao",nullable=true)
	private Date data_criacao = new Date();
	
	@Column(name="data_atualizacao")
	private Date data_atualizacao;

	public Date getCriacao() {
		return data_criacao;
	}


	public GenericTable<T> setCriacao(Date data_criacao) {
		this.data_criacao = data_criacao;
		return this;
	}

	public Date getAtualizacao() {
		return data_atualizacao;
	}

	@SuppressWarnings("unchecked")
	protected T setAtualizacao(Date data_atualizacao) {
		this.data_atualizacao = data_atualizacao;
		return (T) this;
	}
	
	public abstract int getID();
	public abstract T setID(int ID);	
	
	
	
}
