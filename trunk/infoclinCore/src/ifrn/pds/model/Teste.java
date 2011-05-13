package ifrn.pds.model;
import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Teste {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Configuration cfc = new AnnotationConfiguration();
		cfc.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfc.buildSessionFactory();
		Session session = sf.openSession();
		//Cria uma transação
		Transaction tx = session.beginTransaction();
		Endereco endereco = new Endereco("a", "b,", "c", "d", "e", "f", "g", "r");
		
		session.save(endereco);
		tx.commit();
		session.close();
		
		
	}

}
