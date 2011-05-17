package models;

import java.io.Serializable;
import play.db.jpa.Model;

public class Usuario extends Model implements Serializable {
	
	int id;
	public String senha;
	public String login;
	public String usuario;
	public Endereco endereco;
	public String nome;
	public String cpf;
	
	public Usuario(String senha, String usuario, Endereco endereco,
			String nome, String cpf) {
		this.senha = senha;
		this.usuario = usuario;
		this.endereco = endereco;
		this.nome = nome;
		this.cpf = cpf;
	}

}
