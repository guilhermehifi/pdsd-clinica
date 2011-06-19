package ifrn.pds.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Paciente")
public class Paciente extends Usuario {

	private static final long serialVersionUID = 134L;

	@JoinColumn(name = "convenio_id")
	@OneToOne
	private Convenio convenio;

	public Paciente() {

	}

	public Paciente(String senha, String usuario, Endereco endereco,
			String nome, int cpf, int rg, String sexo, int telefone,
			String email, Convenio convenio) {
		super(senha, usuario, endereco, nome, cpf, rg, sexo, telefone, email);
		this.convenio = convenio;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

}
