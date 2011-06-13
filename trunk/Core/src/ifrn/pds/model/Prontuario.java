package ifrn.pds.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "Prontuario")
@SequenceGenerator(name = "seq", sequenceName = "Prontuario_id_seq")
public class Prontuario {
	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.AUTO)
	private int id;

	@OneToOne
	private Paciente paciente;

	@OneToMany(mappedBy = "id") @IndexColumn(name = "procedimentos")
	private Procedimento[] procedimentos;

	@OneToMany(mappedBy = "id") @IndexColumn(name = "receitas")
	private Receita[] receitas;

	public Prontuario() {
		
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Procedimento[] getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(Procedimento[] procedimentos) {
		this.procedimentos = procedimentos;
	}

	public Receita[] getReceitas() {
		return receitas;
	}

	public void setReceitas(Receita[] receitas) {
		this.receitas = receitas;
	}

	public int getId() {
		return id;
	}

}
