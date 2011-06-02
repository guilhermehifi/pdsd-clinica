package ifrn.pds.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Administrador")
public class Administrador extends Usuario {

	private static final long serialVersionUID = 1213L;

	public Administrador(String senha, String login, Endereco endereco,
			String nome, int cpf) {
		super(senha, login, endereco, nome, cpf);
	}

}
