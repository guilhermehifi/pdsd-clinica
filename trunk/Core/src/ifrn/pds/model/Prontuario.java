package ifrn.pds.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "Prontuario")
@SequenceGenerator(name = "seq", sequenceName = "Prontuario_id_seq")
public class Prontuario implements Serializable {
	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.AUTO)
	private int id;

	
	@OneToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "procedimento_id")
	private Procedimento procedimento;

//	//@OneToMany(mappedBy = "id")
//	@IndexColumn(name = "id")
//	private Procedimento[] procedimentos;
//
//	//@OneToMany(mappedBy = "id") 
//	@IndexColumn(name = "id")
//	private Receita[] receitas;

	public Prontuario() {
		
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

//	public Procedimento[] getProcedimentos() {
//		return procedimentos;
//	}
//
//	public void setProcedimentos(Procedimento[] procedimentos) {
//		this.procedimentos = procedimentos;
//	}
//
//	public Receita[] getReceitas() {
//		return receitas;
//	}
//
//	public void setReceitas(Receita[] receitas) {
//		this.receitas = receitas;
//	}

	public int getId() {
		return id;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}

}
