package ifrn.pds.dao;

import java.util.Collection;
import java.util.List;

import ifrn.pds.model.Agenda;
import ifrn.pds.model.Endereco;
import ifrn.pds.model.Medico;

public class tesate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dao <Endereco> end = new Dao<Endereco>();
		Dao<Medico> medicoDao = new Dao<Medico>();
		Agenda a = new Agenda();
		Dao<Agenda> agendaDao = new Dao<Agenda>();
		agendaDao.persist(a);
		Medico m = new Medico();
		m.setNome("Ronaldo");
		medicoDao.persist(m);
		List <Endereco> endereco = end.findAll(Endereco.class);
		for(Endereco e : endereco){
			System.out.println(e.getRua() + e.getBairro());
		}
	}

}
