/**
 * FachadaCore.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ifrn.pds.fachada.webservice;



import ifrn.pds.dao.Dao;
import ifrn.pds.interfaces.IServicoMedico;
import ifrn.pds.model.Endereco;
import ifrn.pds.model.Especialidade;
import ifrn.pds.model.Medico;

public class ServicoMedico implements IServicoMedico{

	Dao<Medico> daoMedico = new Dao<Medico>();
	
	public Medico buscarMedico() {
	
		return null;
	}

	public void cadastrarM�dico(Medico medico) {
		Endereco endereco = new Endereco();
	}

	
	public Especialidade [] listarEspecialidadeMedico() {
		
		return null;
	}

	
	public Medico[]listarMedico() {
		
		return null;
	}
	
	
}