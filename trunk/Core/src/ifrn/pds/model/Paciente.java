package ifrn.pds.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Paciente")
@SequenceGenerator(name = "seq", sequenceName = "Usuario_id_seq")
public class Paciente implements Serializable {

	private static final long serialVersionUID = 134L;

	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.AUTO)
	private int id;

	@JoinColumn(name = "convenio_id")
	@OneToOne
	private Convenio convenio;

	@JoinColumn(name = "id_usuario")
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;

	@Column(name = "numero_convenio")
	private int numeroConvenio;
	
	@Temporal(TemporalType.DATE)
	private Date nascimento;

	public Paciente() {

	}

	public Paciente(Convenio convenio, Usuario usuario, int numeroConvenio) {
		this.convenio = convenio;
		this.usuario = usuario;
		this.numeroConvenio = numeroConvenio;
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

	public int getNumeroConvenio() {
		return numeroConvenio;
	}

	public void setNumeroConvenio(int numeroConvenio) {
		this.numeroConvenio = numeroConvenio;
	}

	public java.sql.Date getNascimento() {
		return new java.sql.Date(nascimento.getTime());
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

}
