package ifrn.pds.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
@SequenceGenerator(name="seq", sequenceName="Usuario_id_seq")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator="seq", strategy = GenerationType.AUTO)
	private int id;
	private String usuario;
	private String senha;
	private String nome;
	private int cpf;
	private int rg;
	private String sexo;
	private int telefone;
	private String email;
	
	@JoinColumn(name="id_endereco")
	@OneToOne
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
