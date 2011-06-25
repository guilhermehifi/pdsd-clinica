package ifrn.pds.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Paciente")
@SequenceGenerator(name = "seq", sequenceName = "Usuario_id_seq")
public class Paciente {

	private static final long serialVersionUID = 134L;

	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.AUTO)
	private int id;

	@JoinColumn(name = "convenio_id")
	@OneToOne(cascade = CascadeType.ALL)
	private Convenio convenio;

	@JoinColumn(name = "id")
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;

	public Paciente() {

	}

	public Paciente(Convenio convenio, Usuario usuario) {
		this.convenio = convenio;
		this.usuario = usuario;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public int getId() {
		return id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
