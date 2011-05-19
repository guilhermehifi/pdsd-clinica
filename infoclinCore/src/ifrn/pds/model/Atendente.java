package ifrn.pds.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "\"Atendente\"")
public class Atendente extends Usuario {

	private static final long serialVersionUID = 1223L;

	public Atendente(String senha, String login, Endereco endereco,
			String nome, int cpf) {
		super(senha, login, endereco, nome, cpf);
	}

}
