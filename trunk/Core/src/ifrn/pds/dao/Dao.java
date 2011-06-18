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


//TODO Tratar algumas poss�veis exce��es!
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
	public List<E> findAll(String classe) {
		List<E> lista;
		conecta();
		Query q = entityManager.createQuery("select e from " + classe + " e");
		lista = q.getResultList();
		return lista;
	}

	//m�todo ser� usuado para fazer o controle de login
	@SuppressWarnings("unchecked")
	public E findByExample(String classe, String nomeCampo, String valorCampo) {
		conecta();
		Query q = entityManager.createQuery("SELECT e FROM " + classe + " e where " + nomeCampo + " = " + valorCampo);
		return (E) q.getSingleResult();
	}
	
	//Tirar a duvida duvida sobre o hibernate
	public E findUsuario(Class<E> classe, String usuario){
//		conecta();
//		Query q = entityManager.createQuery("SELECT FROM usuario WHERE usuario = ?");
		return null;
		
	}

	public E findById(Class<E> classe, int id) {
		conecta();
		E e = entityManager.find(classe, id);
		return e;
	}
	
	public E findByCPF(Class<E> classe, int cpf) {
		conecta();
		E e = entityManager.find(classe, cpf);
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