package ifrn.pds.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
//TODO Tratar algumas possíveis exceções!
public class Dao<E> {
	private EntityManager entityManager;
	
	public Dao() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("infoclinPersistenceUnit");
		entityManager = entityManagerFactory.createEntityManager();
	}

	public void persist(E entity) {
		try {
		conecta();
		getTransaction();
			//tx = session.beginTransaction();
			//session.persist(entity);
			//tx.commit();
			entityManager.persist(entity);
		} catch (HibernateException e) {
			// e.printStackTrace();
			for (String ms : e.getMessages()) {
				System.out.println(ms);
			}
			;
		} finally {
			entityManager.flush();
		}
	}

	private void getTransaction() {
		entityManager.getTransaction().begin();
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll(Class<E> classe) {
		List<E> lista;
		conecta();
		Query q = entityManager.createQuery("select e from " + classe.getName() + " e");
		lista = q.getResultList();
		return lista;
	}

	@SuppressWarnings("unchecked")
	public E findByExample(Class<E> classe, String nomeCampo, String valorCampo) {
		conecta();
		Query q = entityManager.createQuery("SELECT e FROM " + classe.getName() + " e where " + nomeCampo + " = " + valorCampo);
		return (E) q.getSingleResult();
	}

	public E findById(Class<E> classe, int id) {
		conecta();
		E e = entityManager.find(classe, id);
		return e;
	}

	public void remove(E entity) {
		conecta();
		getTransaction();
		entityManager.remove(entity);
		commit();
	}
	
	public boolean removeById(Class<E> classe, int id) {
		conecta();
		getTransaction();
		Query q = entityManager.createQuery("DELETE FROM " + classe.getName()
				+ " e where e.id = " + id);
		int i = q.executeUpdate();
		commit();
		return i == 1;
	}

	private void commit() {
		entityManager.flush();
		entityManager.getTransaction().commit();
	}

	private void conecta() {
		Configuration cf = new AnnotationConfiguration();
		cf.configure("hibernate.cfg.xml");
	}

}
