package ifrn.pds.model;
import ifrn.pds.dao.Dao;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Teste {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Dao<Medico> medicoDAO = new Dao<Medico>();
		//Dao<Endereco> enderecoDAO = new Dao<Endereco>();
		
		Medico m = new Medico();
		
		//Endereco e = new Endereco();
		//m.setNome("oi");
		//medicoDAO.persist(m);
		/*e.setBairro("sdfsdff");
		e.setCep(12323);
		e.setCidade("sdfsdf");
		e.setComplemento("sdfds");
		e.setEstado("sdfsdf");
		e.setNumero(124);*/
		
		//u.setNome("Ronaldo");
		//u.setEndereco(e);
		
		//enderecoDAO.persist(e);
		medicoDAO.persist(m);
		
	}

}
