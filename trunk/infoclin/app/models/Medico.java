package models;

import java.io.Serializable;

public class Medico implements Serializable{
	
	private Especialidade[] especialidades;
	private Procedimento[] procedimentos;
	private Agenda [] agenda;

	public Medico(String senha, String usuario, Endereco endereco, String nome,
			int cpf, int rg, String sexo, int telefone, String email, Especialidade[] especialidades, Procedimento[] procedimentos) {
		super();
		this.especialidades = especialidades;
		this.procedimentos = procedimentos;
	}
	
	public Medico() {
		
	}


	public Procedimento [] getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(Procedimento[] procedimentos) {
		this.procedimentos = procedimentos;
	}

	public Agenda [] getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda[]agenda) {
		this.agenda = agenda;
	}

	public Especialidade [] getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Especialidade [] especialidades) {
		this.especialidades = especialidades;
	}
	
	
	

}
