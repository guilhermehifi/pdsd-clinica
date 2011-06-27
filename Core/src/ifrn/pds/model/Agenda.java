
package ifrn.pds.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Agenda")
@SequenceGenerator(name = "seq", sequenceName = "Agenda_id_seq")
public class Agenda implements Serializable {
	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date data;
	
	private String horario;

	@ManyToOne/*(cascade = CascadeType.ALL)*/
	@JoinColumn(name = "medico_id")
	private Medico medico;	

	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	
	private boolean agendado;
	
	@OneToOne
	@JoinColumn(name = "tipoprocedimento_id")
	private TipoProcedimento tipoProcedimento;
	

	public Agenda() {

	}

	public Agenda(TipoProcedimento tipo, Date data, String horario,
			Medico medico, Paciente paciente, boolean agendado) {
		this.data = data;
		this.horario = horario;
		this.medico = medico;
		this.paciente = paciente;
		this.agendado = agendado;
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

	public boolean isAgendado() {
		return agendado;
	}

	public void setAgendado(boolean agendado) {
		this.agendado = agendado;
	}

	public java.sql.Date getData() {
		return new java.sql.Date(data.getTime());
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getHorario() {
		return horario;
	}

	public TipoProcedimento getTipoProcedimento() {
		return tipoProcedimento;
	}

	public void setTipoProcedimento(TipoProcedimento tipoProcedimento) {
		this.tipoProcedimento = tipoProcedimento;
	}
	
}
