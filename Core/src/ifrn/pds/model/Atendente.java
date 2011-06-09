package ifrn.pds.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Atendente")
public class Atendente extends Usuario {

	private static final long serialVersionUID = 1223L;

	public Atendente(String senha, String usuario, Endereco endereco,
			String nome, int cpf, int rg, String sexo, int telefone, String email)  {
		super(senha, usuario, endereco, nome, cpf, rg, sexo, telefone, email);
	}
	
	public Atendente() {
	}

}
