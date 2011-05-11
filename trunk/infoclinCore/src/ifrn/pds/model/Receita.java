package ifrn.pds.model;

public class Receita {
	private int id;
	private Procedimento idProc;
	private Paciente idPaciente;
	private Medico idMedico;
	private String receituario;
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setIdProc(Procedimento idProc) {
		this.idProc = idProc;
	}
	public Procedimento getIdProc() {
		return idProc;
	}
	public void setIdPaciente(Paciente idPaciente) {
		this.idPaciente = idPaciente;
	}
	public Paciente getIdPaciente() {
		return idPaciente;
	}
	public void setIdMedico(Medico idMedico) {
		this.idMedico = idMedico;
	}
	public Medico getIdMedico() {
		return idMedico;
	}
	public void setReceituario(String receituario) {
		this.receituario = receituario;
	}
	public String getReceituario() {
		return receituario;
	}

}
