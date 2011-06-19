package ifrn.pds.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TipoProcedimento")
@SequenceGenerator(name = "seq", sequenceName = "TipoProcedimento_id_seq")
public class TipoProcedimento implements Serializable {

	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.AUTO)
	private int id;

	private String nome;

	public TipoProcedimento() {

	}

	public TipoProcedimento(String nome) {
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