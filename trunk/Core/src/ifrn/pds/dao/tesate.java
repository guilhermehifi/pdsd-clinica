package ifrn.pds.dao;

import java.util.List;

import ifrn.pds.model.Endereco;

public class tesate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dao <Endereco> end = new Dao<Endereco>();

		List <Endereco> endereco = end.findAll(Endereco.class);
		for(Endereco e : endereco){
			System.out.println(e.getRua() + e.getBairro());
		}
	}

}
