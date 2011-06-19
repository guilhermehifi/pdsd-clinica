package ifrn.pds.model;

import ifrn.pds.dao.Dao;

public class Teste {
	public static void main(String[] args) {
		Dao<Receita> dao = new Dao<Receita>();
		Receita r = dao.findByExample("Receita", "procedimento_id", "1");
		System.out.println(r.getProntuario().getId());
		
	}
	
}
