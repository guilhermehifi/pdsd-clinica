package ifrn.pds.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Prontuario")
public class Prontuario {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@OneToOne
	private Paciente paciente;

	@OneToMany(mappedBy = "id")
	private List<Procedimento> procedimentos;
	
	@OneToMany(mappedBy = "id")
	private List<Receita> receitas;
	
	public Prontuario() {
		
	}
	
	
	public Prontuario(Paciente paciente, List<Procedimento> procedimentos,
			List<Receita> receitas) {
		this.paciente = paciente;
		this.procedimentos = procedimentos;
		this.receitas = receitas;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public List<Receita> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}

	public int getId() {
		return id;
	}
	
}
