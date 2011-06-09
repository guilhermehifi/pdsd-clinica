package models;

import java.io.Serializable;

public abstract class Usuario implements Serializable{
	
	private int id;
	private String usuario;
	private String senha;
	private String nome;
	private int cpf;
	private int rg;
	private String sexo;
	private int telefone;
	private String email;
	
	
	private Endereco endereco;

	public Usuario() {
	}

	public Usuario(String senha, String usuario, Endereco endereco,
			String nome, int cpf, int rg, String sexo, int telefone, String email ) {
		this.senha = senha;
		this.usuario = usuario;
		this.endereco = endereco;
		this.nome = nome;
		this.cpf = cpf;
		this.rg=rg;
		this.sexo=sexo;
		this.telefone=telefone;
		this.email=email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public int getRg() {
		return rg;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
}

