package br.com.DragonsGamers.ODG.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.DragonsGamers.ODG.util.GenericTable;
import br.com.DragonsGamers.ODG.util.HibernateUtil;

public class GenericDAO<T extends GenericTable<?>> implements DAOs<T> {

	private Class<T> c;
	private Transaction t;
	private Session s;

	public GenericDAO(Class<T> clazz) {

		c = clazz;

	}

	@Override
	public Serializable insert(T obj) {
		IniciarOperacao();
		Serializable id = s.save(obj);
		finalizarOperacao();
		return id;
	}

	@Override
	public void update(T obj) {
		IniciarOperacao();
		s.saveOrUpdate(obj);
		finalizarOperacao();

	}

	@Override
	public List<T> recuperarTodos() {
		s = HibernateUtil.getSession();
		List<T> results = s.createQuery("FROM " + c.getName(), c).list();
		finalizarOperacao();
		return results;
	}

	@Override
	public T recuperar(Serializable id) {
		s = HibernateUtil.getSession();
		T r = s.get(c, id);
		finalizarOperacao();
		return r;
	}

	public List<T> recuperar(String Campo, String Value) {
		s = HibernateUtil.getSession();
		Query<T> r = s.createQuery("FROM " + c.getName() + " WHERE " + Campo + " = :campo", c).setParameter("campo",
				Value);
		return r.list();
	}

	@Override
	public void delete(T obj) {
		IniciarOperacao();
		s.delete(obj);
		finalizarOperacao(null);
	}

	protected void IniciarOperacao() {
		s = HibernateUtil.getSession();
		t = s.beginTransaction();
	}

	protected void finalizarOperacao() {
		finalizarOperacao(null);
	}

	protected void finalizarOperacao(T obj) {
		if (t != null) {
			t.commit();
		}
		try {
			s.flush();
		} catch (Exception e) {
			System.out.print("");
		}
		if (obj != null) {
			s.refresh(obj);
		}
		s.close();
		t = null;
	}

}
