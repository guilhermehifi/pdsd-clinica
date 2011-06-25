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
@Table(name = "Atendente")
@SequenceGenerator(name="seq", sequenceName="Usuario_id_seq")
public class Atendente {

	private static final long serialVersionUID = 1223L;

	@Id
	@GeneratedValue(generator="seq", strategy = GenerationType.AUTO)
	private int id;
	
	@JoinColumn(name = "id")
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;
	
	public Atendente() {
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

}
