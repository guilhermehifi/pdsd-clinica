package ifrn.pds.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import tads.ed.sequencia.NodeSequence;

@Entity
@Table(name = "Medico")
public class Medico extends Usuario {

	private static final long serialVersionUID = 13L;
	
	@JoinColumn(name = "Especialidade")
	@OneToMany
	private NodeSequence<Especialidade> especialidades;

	@JoinColumn(name = "Procedimento")
	@OneToMany
	private NodeSequence<Procedimento> procedimentos;
	
	@JoinColumn(name="Agenda")
	@OneToMany
	private NodeSequence<Agenda> agenda;

	public Medico(String senha, String usuario, Endereco endereco, String nome,
			int cpf, int rg, String sexo, int telefone, String email) {
		super(senha, usuario, endereco, nome, cpf, rg, sexo, telefone, email);
		this.especialidades = new NodeSequence<Especialidade>();
		this.procedimentos = new NodeSequence<Procedimento>();
	}
	
	public Medico() {
		procedimentos = new NodeSequence<Procedimento>();
		agenda = new NodeSequence<Agenda>();
		especialidades = new NodeSequence<Especialidade>();
	}


	public NodeSequence<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(NodeSequence<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public NodeSequence<Agenda> getAgenda() {
		return agenda;
	}

	public void setAgenda(NodeSequence<Agenda> agenda) {
		this.agenda = agenda;
	}

	public NodeSequence<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(NodeSequence<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}
	
}
