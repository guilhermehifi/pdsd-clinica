package ifrn.pds.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "\"Receita\"")
@SequenceGenerator(name="seq", sequenceName="\"Endereco_id_seq\"")
public class Receita {
	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.AUTO)
	private int id;
	private String receituario;
	@OneToOne
	@JoinColumn(name = "procedimento")
	private Procedimento procedimento;
	@OneToOne
	private Prontuario prontuario;

	public Receita() {

	}

	public Receita(String receituario, Procedimento procedimento,
			Prontuario prontuario) {
		this.receituario = receituario;
		this.procedimento = procedimento;
		this.prontuario = prontuario;
	}

	public String getReceituario() {
		return receituario;
	}

	public void setReceituario(String receituario) {
		this.receituario = receituario;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
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
