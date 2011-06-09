package models;

public class Procedimento {
	
	
	
	private int id;
	private TipoProcedimento tipoProcedimento;
	private Medico medico;
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
