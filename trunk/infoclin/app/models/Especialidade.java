package models;

import java.io.Serializable;

public class Especialidade implements Serializable{
	
	
	private int id;
	private String especialidade;
	private Medico medico;

	public Especialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public Especialidade() {

	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public int getId() {
		return id;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

}
