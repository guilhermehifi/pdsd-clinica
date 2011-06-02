package ifrn.pds.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Especialidade")
@SequenceGenerator(name = "seq", sequenceName = "Especialidade_id_seq")
public class Especialidade {
	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.AUTO)
	private int id;

	private String especialidade;

	@ManyToOne
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
