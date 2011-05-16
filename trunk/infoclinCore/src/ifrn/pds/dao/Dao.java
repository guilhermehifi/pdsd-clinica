package ifrn.pds.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Dao<E> {
	private Session session;
	private Transaction tx;
	
	
	public void persist(E entity){
		conecta();
		tx = session.beginTransaction();
		session.persist(entity);
		tx.commit();
		fechaConexao();
	}
	
	@SuppressWarnings("unchecked")
	public List<E> findAll(Class<E> classe){
		List<E> lista;
		conecta();
		Query q = session.createQuery("SELECT e FROM " + classe.getName() + " e");
		lista = q.list();
		fechaConexao();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public E find(Class<E> classe, int id){
		E e;
		conecta();
		Query q = session.createQuery("SELECT e FROM " + classe.getName() + " e where e.id = " + id);
		e = (E) q.uniqueResult();
		fechaConexao();
		return e;
	}
	
	private void conecta(){
		Configuration cf = new AnnotationConfiguration();
		cf.configure("hibernate.cfg.xml");
		SessionFactory factory = cf.buildSessionFactory();
		session = factory.openSession();
	}
	
	private void fechaConexao(){
		session.close();
	}

}
