package ifrn.pds.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "Medico")
@SequenceGenerator(name="seq", sequenceName="Usuario_id_seq")
public class Medico  /*extends Usuario*/ implements Serializable{
	@Id
	@GeneratedValue(generator="seq", strategy = GenerationType.AUTO)
	private int id;
	
	@JoinColumn(name = "id_usuario")
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;
	/*
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
*/
	
	//private static final long serialVersionUID = 13L;
	
	//@JoinColumn(name = "Especialidade")
	//@OneToMany(fetch = FetchType.EAGER)
	@IndexColumn(name = "id")
	private Especialidade[] especialidades;

	//@JoinColumn(name = "Procedimento")
	//@OneToMany
	@IndexColumn(name = "id")
	private Procedimento[] procedimentos;
	
	//@JoinColumn(name="Agenda")
	//@OneToMany
	@IndexColumn(name = "id")
	private Agenda[] agenda;
	

	public Medico() {
		//procedimentos = new ArrayList<Procedimento>();
		//agenda = new ArrayList<Agenda>();
		//especialidades = new ArrayList<Especialidade>();
		/*quantidadeAgenda = 2;
		quantidadeProcedimento = 2;
		quantidadeEspecialidade = 2;
		 */
//		procedimentos = new Procedimento[0];
//		agenda = new Agenda[0];
//		especialidades = new Especialidade[0];
	}
	
	/*public Medico(String usuario, String senha, String nome, int cpf, int rg,
			String sexo, int telefone, String email, Endereco endereco,
			Especialidade[] especialidades, Procedimento[] procedimentos,
			Agenda[] agenda) {
		this.usuario = usuario;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.especialidades = especialidades;
		this.procedimentos = procedimentos;
		this.agenda = agenda;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
*/
	public Especialidade[] getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Especialidade[] especialidades) {
		this.especialidades = especialidades;
	}

	public Procedimento[] getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(Procedimento[] procedimentos) {
		this.procedimentos = procedimentos;
	}

	public Agenda[] getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda[] agenda) {
		this.agenda = agenda;
	}

	public int getId() {
		return id;
	}
	
	public void setMedico(int id){
		this.id=id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}
