package ifrn.pds.dao;

import ifrn.pds.model.Agenda;

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
	private Session session;
	
	public Dao() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("infoclinPersistenceUnit");
		entityManager = entityManagerFactory.createEntityManager();
		conecta();
		session = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
	}
	
	/*
	 * GATO! Usando session ao inves do EntityManager. Nao esta muito elegante,  mas esta funcionando ;D
	 */
	public void persist(E entity) {
		//conecta();
		//getTransaction();
		//Session session = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		 session.persist(entity);
		 tx.commit();
		//entityManager.persist(entity);
		session.close();
	}
	
	public void update(E entity){
		//Session session = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		//E e = findById(classe, id);
		session.merge(entity);
		session.flush();
		tx.commit();
		session.close();
	}

	private void getTransaction() {
		entityManager.getTransaction().begin();
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll(String classe) {
		List<E> lista;
		//conecta();
		Query q = entityManager.createQuery("select e from " + classe + " e");
		lista = q.getResultList();
		entityManager.close();
		return lista;
	}

	//método será usuado para fazer o controle de login
	@SuppressWarnings("unchecked")
	public E findByExample(String classe, String nomeCampo, String valorCampo) {
		//conecta();
		Query q = entityManager.createQuery("SELECT e FROM " + classe + " e where " + nomeCampo + " = " + valorCampo);
		E e = (E) q.getSingleResult();
		entityManager.close();
		return e; 
	}
	
	@SuppressWarnings("unchecked")
	public List<E> findByExampleLista(String classe, String nomeCampo, String valorCampo) {
		//conecta();
		Query q = entityManager.createQuery("SELECT e FROM " + classe + " e where " + nomeCampo + " = " + valorCampo);
		List<E> lista = q.getResultList();
		entityManager.close();
		return lista;
	}
	
	public E findById(String classe, int id) {
		//conecta();
		Query q = entityManager.createQuery("SELECT e FROM " + classe + " e where id" + " = " + id);
		@SuppressWarnings("unchecked")
		E e = (E)q.getSingleResult();
		entityManager.close();
		return e;
	}

	public void remove(E entity) {
		//conecta();
		getTransaction();
		entityManager.remove(entity);
		commit();
		entityManager.close();
	}
	
	public boolean removeById(Class<E> classe, int id) {
		//conecta();
		getTransaction();
		Query q = entityManager.createQuery("DELETE FROM " + classe.getName()
				+ " e where e.id = " + id);
		int i = q.executeUpdate();
		commit();
		entityManager.close();
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
