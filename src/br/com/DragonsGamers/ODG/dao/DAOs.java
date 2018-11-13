package br.com.DragonsGamers.ODG.dao;

import java.io.Serializable;
import java.util.List;

public interface DAOs<T> {

	public Serializable insert(T obj);

	public void update(T obj);

	public List<T> recuperarTodos();

	public T recuperar(Serializable id);

	public void delete(T obj);

}
