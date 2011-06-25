package ifrn.pds.model;

import java.util.List;

import javax.persistence.NoResultException;

import ifrn.pds.dao.Dao;
import ifrn.pds.interfaces.IServicoAtendente;

public class ServicoAtendente implements IServicoAtendente {

	private Dao<Paciente> pacienteDao;
	private Dao<Agenda> agendaDao;
	private Dao<Medico> medicoDao;
	private Dao<Convenio> convenioDao;
	private Dao<Usuario> usuarioDao;
	private Dao<Prontuario> prontuarioDao;
	private Dao<Procedimento> procedimentoDao;

	public Paciente buscarPaciente(int cpf) {
		pacienteDao = new Dao<Paciente>();
		return pacienteDao.findByExample("Paciente", "cpf",
				new Integer(cpf).toString());
	}

	public void cadastrarPaciente(Paciente paciente) {
		pacienteDao = new Dao<Paciente>();
		pacienteDao.persist(paciente);
	}

	public void excluirAgendamento(int id) {
		agendaDao = new Dao<Agenda>();
		Agenda agenda = agendaDao.findById("Agenda", id);
		agendaDao.remove(agenda);
	}

	public Procedimento getProcedimento(Prontuario p) {
		procedimentoDao = new Dao<Procedimento>();
		Procedimento pr = procedimentoDao.findByExample("Procedimento", "id",
				new Integer(p.getId()).toString());
		return pr;
	}

	public Prontuario getProntuario(Paciente p) {
		prontuarioDao = new Dao<Prontuario>();
		Prontuario pr = prontuarioDao.findByExample("Prontuario",
				"paciente_id", new Integer(p.getId()).toString());
		return pr;
	}

	@Override
	public boolean confirmarAgendamento(int id) {
		agendaDao = new Dao<Agenda>();
		Agenda agenda = agendaDao.findById("Agenda", id); 
		if (!agenda.isAgendado()) {
			agenda.setAgendado(true);
			agendaDao.update(agenda);
			return true;
		}
		return false;
	}

	@Override
	public Medico[] listarEspecialista() {
		medicoDao = new Dao<Medico>();
		List<Medico> lista = medicoDao.findAll("Medico");
		Medico[] m = new Medico[lista.size()];
		for (int i = 0; i < m.length; i++) {
			m[i] = lista.get(i);
		}
		return m;
	}

	@Override
	public Agenda[] listarAgendamento(int id, String data) {
		agendaDao = new Dao<Agenda>();
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

	@Override
	public Convenio[] listarConvenio() {
		convenioDao = new Dao<Convenio>();
		List<Convenio> lista = convenioDao.findAll("Convenio");
		Convenio[] c = new Convenio[lista.size()];
		for (int i = 0; i < c.length; i++) {
			c[i] = lista.get(i);
		}
		return c;
	}

	@Override
	public boolean verificaDisponibilidade(String usuario) {
		usuarioDao = new Dao<Usuario>();
		try {
			usuarioDao.findByExample("Usuario", "usuario", "'" + usuario + "'");
		} catch (NoResultException e) {
			return true;
		}
		return false;
	}

	public Atendente efetuarLogin(String usuario, String senha) {
		try {
			usuarioDao = new Dao<Usuario>();
			Usuario u = usuarioDao.findByExample("Usuario", "usuario", "'"
					+ usuario + "'");
			if (u != null) {
				Dao<Atendente> atendenteDao = new Dao<Atendente>();
				Atendente a = atendenteDao.findById("Atendente", u.getId());
				if(a.getUsuario().getSenha().equals(senha))
					return a;
			}
		} catch (NoResultException e) {
			return null;
		}
		return null;
	}

}
