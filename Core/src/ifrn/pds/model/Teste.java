package ifrn.pds.model;

import ifrn.pds.dao.Dao;


public class Teste {
	public static void main(String[] args) {
		ServicoAtendente s = new ServicoAtendente();
		Agenda a = new Dao<Agenda>().findById("Agenda", 1);
		//s.confirmarAgendamento(a);
		/*Receita r = dao.findByExample("Receita", "procedimento_id", "1");
		System.out.println(r.getProntuario().getId());*/
		
	}
	
}
