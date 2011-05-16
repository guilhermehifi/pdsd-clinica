package ifrn.pds.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Medico")
public class Medico extends Usuario {

	private static final long serialVersionUID = 13L;

	@JoinColumn(name = "Especialidade")
	@OneToOne
	private Especialidade especialidade;

	@JoinColumn(name = "Procedimento")
	@OneToMany
	private List<Procedimento> procedimentos;
	
	@JoinColumn(name="Agenda")
	@OneToMany
	private List<Agenda> agenda;

	public Medico(String senha, String login, Endereco endereco, String nome,
			int cpf, Especialidade especialidade) {
		super(senha, login, endereco, nome, cpf);
		this.especialidade = especialidade;
	}

	public Medico() {
		procedimentos = new ArrayList<Procedimento>();
		agenda = new ArrayList<Agenda>();
	}


	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public List<Agenda> getAgenda() {
		return agenda;
	}

	public void setAgenda(List<Agenda> agenda) {
		this.agenda = agenda;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

}
