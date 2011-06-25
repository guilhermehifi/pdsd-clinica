package ifrn.pds.model;

import java.io.Serializable;

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

@Entity
@Table(name = "Procedimento")
@SequenceGenerator(name = "seq", sequenceName = "Procedimento_id_seq")
public class Procedimento implements Serializable{
	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.AUTO)
	private int id;
	@JoinColumn(name = "tipoprocedimento_id")
	@OneToOne(cascade = CascadeType.ALL)
	private TipoProcedimento tipoProcedimento;
	@JoinColumn(name = "medico_id")
	@OneToOne(cascade = CascadeType.ALL)
	private Medico medico;
	@JoinColumn(name = "paciente_id")
	@OneToOne(cascade = CascadeType.ALL)
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
