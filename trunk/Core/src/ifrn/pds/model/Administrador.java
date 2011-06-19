package ifrn.pds.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Administrador")
@SequenceGenerator(name="seq", sequenceName="Usuario_id_seq")
public class Administrador {
	@Id
	@GeneratedValue(generator="seq", strategy = GenerationType.AUTO)
	private int id;
	
	@JoinColumn(name = "id")
	@OneToOne
	public Usuario usuario;
	
	public Administrador(){
	}

	public int getId() {
		return id;
	}
	
}
