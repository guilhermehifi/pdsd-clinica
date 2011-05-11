package ifrn.pds.model;

import org.hibernate.*;
import org.hibernate.annotations.Entity;

@Entity

	public class Endereco {
		
		private String logradouro;
		private String numero;
		private String bairro;
		private String complemento;
		private String cidade;
		private String estado;
		private String cep;
		
		public Endereco(String logradouro, String numero, String bairro, String complemento,String cidade, String estado, String pais, String cep ){
			this.logradouro=logradouro;
			this.numero=numero;
			this.bairro=bairro;
			this.complemento=complemento;
			this.cidade=cidade;
			this.setEstado(estado);
			this.cep=cep;
		}
		
		public void setLogradouro(String logradouro) {
			this.logradouro = logradouro;
		}
		public String getLogradouro() {
			return logradouro;
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
	

}
