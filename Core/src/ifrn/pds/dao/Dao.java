package ifrn.pds.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


//TODO Tratar algumas possíveis exceções!
public class Dao<E> {
	private EntityManager entityManager;
	
	public Dao() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("infoclinPersistenceUnit");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	/*
	 * GATO! Usando session ao inves do EntityManager. Nao esta muito elegante,  mas esta funcionando ;D
	 */
	public void persist(E entity) {
		//conecta();
		//getTransaction();
		Session session = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		 
		Transaction tx = session.beginTransaction();
		 session.persist(entity);
		 tx.commit();
		//entityManager.persist(entity);
		session.close();
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
