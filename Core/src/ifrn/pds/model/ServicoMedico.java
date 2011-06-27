/**
 * FachadaCore.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ifrn.pds.model;

import java.util.List;

import javax.persistence.NoResultException;

import ifrn.pds.dao.Dao;



public class ServicoMedico{
	private Dao<Medico> medicoDao;
	private Dao<Usuario> usuarioDao;
	
	public Medico efetuarLogin(String usuario, String senha) {
		try {
			usuarioDao = new Dao<Usuario>();
			Usuario u = usuarioDao.findByExample("Usuario", "usuario", "'"
					+ usuario + "'");
			if (u != null) {
				medicoDao = new Dao<Medico>();
				Medico m = medicoDao.findByExample("Medico", "id_usuario", new Integer(u.getId()).toString());
				if(m.getUsuario().getSenha().equals(senha))
					return m;
			}
		} catch (NoResultException e) {
			return null;
		}
		return null;
	}
	
	public Agenda[] listarAgendamento(int id, String data) {
		Dao<Agenda> agendaDao = new Dao<Agenda>();
		System.out.println(id);
		List<Agenda> lista = agendaDao.findByExampleLista("Agenda",
				"medico_id", new Integer(id).toString() + " and data = '"
						+ data + "'");
		Agenda[] a = new Agenda[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			a[i] = lista.get(i);
		}
		return a;
	}
	
	public Prontuario getProntuario(int idPaciente){
		Prontuario p = new Dao<Prontuario>().findByExample("Prontuario", "paciente_id", new Integer(idPaciente).toString());
		return p;
	}
	
	public void cadastrarMedico(Medico medico) {
		medicoDao.persist(medico);
	}

	public Medico buscarMedico(String login) {
		Medico m = medicoDao.findByExample("Medico", "usuario", login);
		return m;
	}

	//TODO
	public Medico[] listarMedicos() {
		return (Medico[]) medicoDao.findAll("Medico").toArray();
	}

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
