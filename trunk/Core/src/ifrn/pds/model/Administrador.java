package ifrn.pds.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Administrador")
public class Administrador extends Usuario {

	private static final long serialVersionUID = 1213L;

	public Administrador(String senha, String usuario, Endereco endereco,
			String nome, int cpf, int rg, String sexo, int telefone, String email)  {
		super(senha, usuario, endereco, nome, cpf, rg, sexo, telefone, email);
	}
	
	public Administrador(){
	}

}
