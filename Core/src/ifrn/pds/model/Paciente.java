package ifrn.pds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="Paciente")
public class Paciente extends Usuario {

	private static final long serialVersionUID = 134L;
	
	@Column(name="numero_cartao_plano")
	private int numeroCartao;
	
	@Column(name="nome_plano")
	private String nomePlano;
	
	public Paciente(String senha, String login, Endereco endereco,
			String nome, int cpf, int rg, String sexo, int telefone, String email) {
		super(senha, login, endereco, nome, cpf, rg, sexo, telefone, email);
	}
	
	public Paciente() {
		
	}

	public int getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(int numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getNomePlano() {
		return nomePlano;
	}

	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}

}
