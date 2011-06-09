/**
 * FachadaCore.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ifrn.pds.fachada.webservice;

import ifrn.pds.dao.Dao;
import ifrn.pds.interfaces.CrudMedico;
import ifrn.pds.model.Especialidade;
import ifrn.pds.model.Medico;
import tads.ed.excecoes.BoundaryViolationException;
import tads.ed.excecoes.InvalidPositionException;

public class FachadaMedico implements CrudMedico {

	private Dao<Medico> medicodDao = new Dao<Medico>();

	public Medico buscarMedico(String login) {
		Medico m = medicodDao.findByExample(Medico.class, "usuario", login);
		return m;
	}

	public void cadastrarMedico(Medico medico) {
		medicodDao.persist(medico);
	}

	public Especialidade[] listarEspecialidadeMedico(Medico medico) {
		Especialidade[] es = new Especialidade[medico.getEspecialidades().size()];
		for (int i = 0; i < medico.getEspecialidades().size(); i++) {
			try {
				es[i] = medico.getEspecialidades().elementAtRank(i);
			} catch (BoundaryViolationException e) {
				e.printStackTrace();
			} catch (InvalidPositionException e) {
				e.printStackTrace();
			}
		}
		return es;
	}

	public Medico[] listarMedicos() {
		return (Medico[]) medicodDao.findAll(Medico.class).toArray();
	}

}
