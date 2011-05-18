package ifrn.pds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Procedimento")
public class Procedimento {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Enumerated(EnumType.STRING)
	@Column(name = "procedimento")
	private TipoProcedimento tipoProcedimento;
	@JoinColumn(name = "Medico")
	@ManyToOne
	private Medico medico;
	@JoinColumn(name = "Paciente")
	@ManyToOne
	private Paciente paciente;
	private String anamnese;
	private String diagnostico;

	public Procedimento() {

	}

	public Procedimento(TipoProcedimento tipoProcedimento, Medico medico,
			Paciente paciente, String anamnese, String diagnostico) {
		this.tipoProcedimento = tipoProcedimento;
		this.medico = medico;
		this.paciente = paciente;
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

}
