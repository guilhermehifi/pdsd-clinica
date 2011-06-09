/**
 * FachadaCore.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ifrn.pds.fachada.webservice;


import ifrn.pds.dao.Dao;
import ifrn.pds.interfaces.IServicoMedico;
import ifrn.pds.model.Especialidade;
import ifrn.pds.model.Medico;

public class ServicoMedico {
	private Dao<Medico> medicodDao = new Dao<Medico>();

	

	public Medico[] listarMedicos() {
		return  null; //(Medico[]) medicodDao.findAll(Medico.class).toArray();
	}
	
}
