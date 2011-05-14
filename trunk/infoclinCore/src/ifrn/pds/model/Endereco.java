package ifrn.pds.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String rua;
	private String numero;
	private String bairro;
	private String complemento;
	private String cidade;
	private String estado;
	private String cep;
	
	public Endereco() {
		
	}

	public Endereco(String rua, String numero, String bairro,
			String complemento, String cidade, String estado, String cep) {
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	public void setLogradouro(String logradouro) {
		this.rua = logradouro;
	}

	public String getLogradouro() {
		return rua;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCep() {
		return cep;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public int getId() {
		return id;
	}

}
