package ifrn.pds.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "\"Medico\"")
public class Medico extends Usuario {

	private static final long serialVersionUID = 13L;
	
	@JoinColumn(name = "Especialidade")
	@OneToMany
	private List<Especialidade> especialidades;

	@JoinColumn(name = "Procedimento")
	@OneToMany
	private List<Procedimento> procedimentos;
	
	@JoinColumn(name="Agenda")
	@OneToMany
	private List<Agenda> agenda;

	public Medico(String senha, String login, Endereco endereco, String nome,
			int cpf, List<Especialidade> especialidades, List<Procedimento> procedimentos) {
		super(senha, login, endereco, nome, cpf);
		this.especialidades = especialidades;
		this.procedimentos = procedimentos;
	}
	
	public Medico() {
		procedimentos = new ArrayList<Procedimento>();
		agenda = new ArrayList<Agenda>();
		especialidades = new ArrayList<Especialidade>();
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

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}
	
}
