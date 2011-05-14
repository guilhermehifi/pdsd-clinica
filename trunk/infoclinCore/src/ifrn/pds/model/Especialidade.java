package ifrn.pds.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Especialidade")
public class Especialidade {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	private String especialidade;

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
}
