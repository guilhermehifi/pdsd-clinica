package ifrn.pds.model;
import java.io.Serializable;

public abstract class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String senha;
	private String login;
	private Endereco endereco;
	private String nome;
	private String cpf;

	public Usuario(int id, String senha, String login, Endereco endereco, String nome, String cpf){
		this.setId(id);
		this.senha=senha;
		this.login=login;
		this.setEndereco(endereco);
		this.nome=nome;
		this.cpf=cpf;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
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

}
