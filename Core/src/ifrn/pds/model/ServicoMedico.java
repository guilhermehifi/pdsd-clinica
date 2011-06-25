/**
 * FachadaCore.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ifrn.pds.model;

import ifrn.pds.dao.Dao;
import ifrn.pds.interfaces.IServicoMedico;



public class ServicoMedico implements IServicoMedico{
	private Dao<Medico> medicoDao = new Dao<Medico>();
	private Dao<Especialidade> especialidadeDao = new Dao<Especialidade>();
	
	@Override
	public void cadastrarMedico(Medico medico) {
		medicoDao.persist(medico);
	}

	@Override
	public Medico buscarMedico(String login) {
		Medico m = medicoDao.findByExample(Medico.class, "usuario", login);
		return m;
	}

	@Override
	public Medico[] listarMedicos() {
		return (Medico[]) medicoDao.findAll(Medico.class).toArray();
	}

	@Override
	public Especialidade[] listarEspecialidadeMedico(Medico medico) {
		/*Especialidade[] es = (Especialidade[]) especialidadeDao.findAll(Especialidade.class).toArray();
		Especialidade[] lista;
		for (Especialidade especialidade : es) {
			if(especialidade.get)
		}
		return especialidadeDao.findByExample(Especialidade.class, "medico_id", medico.getId());*/
		return null;
	}
	
}
