package ifrn.pds.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Medico")
public class Medico extends Usuario {

	private static final long serialVersionUID = 13L;

	@OneToMany(mappedBy = "especialidade", cascade = CascadeType.ALL)
	@JoinColumn(name = "especialidade")
	private List<Especialidade> especialidades;

	@OneToMany(mappedBy = "procedimento", cascade = CascadeType.ALL)
	@JoinColumn(name = "procedimento")
	private List<Procedimento> procedimentos;

	@OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL)
	private List<Agenda> agenda;

	public Medico(String senha, String login, Endereco endereco, String nome,
			int cpf, List<Especialidade> especialidades) {
		super(senha, login, endereco, nome, cpf);
		this.especialidades = especialidades;
	}

	public Medico() {
		especialidades = new ArrayList<Especialidade>();
		procedimentos = new ArrayList<Procedimento>();
		agenda = new ArrayList<Agenda>();
	}

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
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

}
