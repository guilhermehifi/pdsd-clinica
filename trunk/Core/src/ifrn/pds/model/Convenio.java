package ifrn.pds.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Convenio")
@SequenceGenerator(name = "seq", sequenceName = "Convenio_id_seq")
public class Convenio {
	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.AUTO)
	private int id;
	private String nome;

	public Convenio() {
	}

	public Convenio(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}
}
