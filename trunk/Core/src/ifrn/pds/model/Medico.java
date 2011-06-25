package ifrn.pds.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "Medico")
@SequenceGenerator(name="seq", sequenceName="Usuario_id_seq")
public class Medico  /*extends Usuario*/ implements Serializable{
	@Id
	@GeneratedValue(generator="seq", strategy = GenerationType.AUTO)
	private int id;
	
	@JoinColumn(name = "id_usuario")
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;

	public Medico() {
	}
	

	public int getId() {
		return id;
	}
	
	public void setMedico(int id){
		this.id=id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}
