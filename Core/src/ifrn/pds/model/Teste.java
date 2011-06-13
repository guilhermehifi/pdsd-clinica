package ifrn.pds.model;
import ifrn.pds.dao.Dao;

import java.util.List;

public class Teste {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Dao<Endereco> enderecoDAO = new Dao<Endereco>();
		//Dao<Endereco> enderecoDAO = new Dao<Endereco>();
		
		//Endereco e = enderecoDAO.findById(Endereco.class, 1);
		
		//Endereco e = enderecoDAO.find(Endereco.class, 1);
		//m.setNome("oi");
		/*e.setBairro("sdfsdff");
		e.setCep(12323);
		e.setCidade("sdfsdf");
		e.setComplemento("sdfds");
		e.setEstado("sdfsdf");
		e.setNumero(124);*/
		//Endereco e = new Endereco();
		//enderecoDAO.persist(e);
		//u.setNome("Ronaldo");
		//u.setEndereco(e);
		
		//enderecoDAO.persist(e);
		//System.out.println(e.getId() + "-");
		//enderecoDAO.remove(e);
		//pacienteDAO.remove(Paciente.class, p.getId());
		//enderecoDAO.removeById(Endereco.class, 2);
		/*
		List<Endereco> lista = enderecoDAO.findAll(Endereco.class);
		for (Endereco endereco : lista) {
			System.out.println(endereco.getId());
		}
		*/
		Dao <Paciente> pacienteDAO = new Dao<Paciente>();
		Paciente p = new Paciente();
		Endereco e = new Endereco();
		p.setEndereco(e);
		e.setRua("RUA");
		
		enderecoDAO.persist(e);
		pacienteDAO.persist(p);

		List<Endereco> lista = enderecoDAO.findAll(Endereco.class);
		System.out.println(lista.size());
		for(Endereco u : lista){
			System.out.println(u.getRua());

		}

	}

}
