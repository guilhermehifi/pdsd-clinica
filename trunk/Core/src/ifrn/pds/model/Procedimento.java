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
@Table(name = "Procedimento")
@SequenceGenerator(name = "seq", sequenceName = "Procedimento_id_seq")
public class Procedimento implements Serializable {
	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.AUTO)
	private int id;
	
	@JoinColumn(name = "tipoprocedimento_id")
	@OneToOne
	private TipoProcedimento tipoProcedimento;
	
	@JoinColumn(name = "medico_id")
	@OneToOne
	private Medico medico;
	
	@JoinColumn(name = "paciente_id")
	@OneToOne
	private Paciente paciente;
	
	@JoinColumn(name = "prontuario_id")
	@OneToOne
	private Prontuario prontuario;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	private String anamnese;
	
	private String diagnostico;

	public Procedimento() {

	}



	public Procedimento(TipoProcedimento tipoProcedimento, Medico medico,
			Paciente paciente, Prontuario prontuario, Date data,
			String anamnese, String diagnostico) {
		this.tipoProcedimento = tipoProcedimento;
		this.medico = medico;
		this.paciente = paciente;
		this.prontuario = prontuario;
		this.data = data;
		this.anamnese = anamnese;
		this.diagnostico = diagnostico;
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

	public String getAnamnese() {
		return anamnese;
	}

	public void setAnamnese(String anamnese) {
		this.anamnese = anamnese;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public int getId() {
		return id;
	}

	public TipoProcedimento getTipoProcedimento() {
		return tipoProcedimento;
	}

	public void setTipoProcedimento(TipoProcedimento tipoProcedimento) {
		this.tipoProcedimento = tipoProcedimento;
	}

	public Prontuario getProntuario() {
		return prontuario;
	}

	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}

	public java.sql.Date getData() {
		return new java.sql.Date(data.getTime());
	}

	public void setData(Date data) {
		this.data = data;
	}

}
