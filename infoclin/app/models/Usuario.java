package models;

import java.io.Serializable;
import play.db.jpa.Model;

public class Usuario extends Model implements Serializable {
	
	int id;
	public String senha;
	public String login;
	
	public Usuario(int id, String senha, String login){
		this.id=id;
		this.senha=senha;
		this.login=login;
	}

}
