package ifrn.pds.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Agenda")
@SequenceGenerator(name = "seq", sequenceName = "Agenda_id_seq")
public class Agenda {
	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	private Procedimento procedimento;

	private Calendar horario;

	@ManyToOne
	private Medico medico;

	@ManyToOne
	private Paciente paciente;

	public Agenda() {

	}

	public Agenda(Procedimento procedimento, Calendar horario, Medico medico,
			Paciente paciente) {
		this.procedimento = procedimento;
		this.horario = horario;
		this.medico = medico;
		this.paciente = paciente;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}

	public Calendar getHorario() {
		return horario;
	}

	public void setHorario(Calendar horario) {
		this.horario = horario;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public int getId() {
		return id;
	}

}
