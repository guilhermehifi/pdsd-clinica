package ifrn.pds.model;
import ifrn.pds.dao.Dao;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Teste {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Dao<Paciente> pacienteDAO = new Dao<Paciente>();
		//Dao<Endereco> enderecoDAO = new Dao<Endereco>();
		
		Paciente p = new Paciente();
		
		//Endereco e = enderecoDAO.find(Endereco.class, 1);
		//m.setNome("oi");
		/*e.setBairro("sdfsdff");
		e.setCep(12323);
		e.setCidade("sdfsdf");
		e.setComplemento("sdfds");
		e.setEstado("sdfsdf");
		e.setNumero(124);*/
		
		//u.setNome("Ronaldo");
		//u.setEndereco(e);
		
		//enderecoDAO.persist(e);
		pacienteDAO.persist(p);
	}

}
