package ifrn.pds.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Receita")
@SequenceGenerator(name="seq", sequenceName="Receita_id_seq")
public class Receita implements Serializable {
	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.AUTO)
	private int id;
	private String receituario;
	@OneToOne
	@JoinColumn(name = "prontuario_id")
	private Prontuario prontuario;

	public Receita() {

	}

	public Receita(String receituario, Prontuario prontuario) {
		this.receituario = receituario;
		this.prontuario = prontuario;
	}

	public String getReceituario() {
		return receituario;
	}

	public void setReceituario(String receituario) {
		this.receituario = receituario;
	}

	public Prontuario getProntuario() {
		return prontuario;
	}

	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}

	public int getId() {
		return id;
	}

}
