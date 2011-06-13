package ifrn.pds.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

import com.sun.accessibility.internal.resources.accessibility;

import sun.management.resources.agent;
import tads.ed.sequencia.NodeSequence;

@Entity
@Table(name = "Medico")
public class Medico extends Usuario {

	private static final long serialVersionUID = 13L;
	
	@JoinColumn(name = "Especialidade")
	@OneToMany@IndexColumn(name = "especialidade")
	private Especialidade[] especialidades;

	@JoinColumn(name = "Procedimento")
	@OneToMany@IndexColumn(name = "procedimentos")
	private Procedimento[] procedimentos;
	
	@JoinColumn(name="Agenda")
	@OneToMany @IndexColumn(name = "agenda")
	private Agenda[] agenda;
	
	private int quantidadeProcedimento;
	
	private int quantidadeAgenda;
	
	private int quantidadeEspecialidade;
	
	
//	@JoinColumn(name = "Especialidade")
//	@OneToMany
//	private List<Especialidade> especialidades;
//	
//	@JoinColumn(name = "Procedimento")
//	@OneToMany
//	private List<Procedimento> procedimentos;
//	
//	@JoinColumn(name="Agenda")
//	@OneToMany
//	private List<Agenda> agenda;

	public Medico() {
		//procedimentos = new ArrayList<Procedimento>();
		//agenda = new ArrayList<Agenda>();
		//especialidades = new ArrayList<Especialidade>();
		/*quantidadeAgenda = 2;
		quantidadeProcedimento = 2;
		quantidadeEspecialidade = 2;
		procedimentos = new Procedimento[quantidadeProcedimento];
		agenda = new Agenda[quantidadeAgenda];
		especialidades = new Especialidade[quantidadeEspecialidade];*/
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

	public Especialidade[] getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Especialidade[] especialidades) {
		this.especialidades = especialidades;
	}
//	public List<Procedimento> getProcedimentos() {
//		return procedimentos;
//	}
//	
//	public void setProcedimentos(List<Procedimento> procedimentos) {
//		this.procedimentos = procedimentos;
//	}
//	
//	public List<Agenda> getAgenda() {
//		return agenda;
//	}
//	
//	public void setAgenda(List<Agenda> agenda) {
//		this.agenda = agenda;
//	}
//	
//	public List<Especialidade> getEspecialidades() {
//		return especialidades;
//	}
//	
//	public void setEspecialidades(List<Especialidade> especialidades) {
//		this.especialidades = especialidades;
//	}


	public int getQuantidadeProcedimento() {
		return quantidadeProcedimento;
	}


	public int getQuantidadeAgenda() {
		return quantidadeAgenda;
	}


	public int getQuantidadeEspecialidade() {
		return quantidadeEspecialidade;
	}
	
}
