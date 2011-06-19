package ifrn.pds.model;

import java.util.List;

import ifrn.pds.dao.Dao;
import ifrn.pds.interfaces.IServicoAtendente;

public class ServicoAtendente implements IServicoAtendente {

	private Dao<Paciente> pacienteDAO ;
	private Dao<Agenda> agendaDAO ;
	private Dao<Medico> medicoDAO ;
	private Dao<Convenio> convenioDao ;
	private Dao<Usuario> usuarioDao ;
	private Dao<Prontuario> prontuarioDao ;
	private Dao<Procedimento> procedimentoDao ;

	public Paciente buscarPaciente(int cpf) {
		pacienteDAO = new Dao<Paciente>();
		return pacienteDAO.findByExample("Paciente", "cpf", new Integer(cpf).toString());
	}

	public void cadastrarPaciente(Paciente paciente) {
		pacienteDAO = new Dao<Paciente>();
		pacienteDAO.persist(paciente);
	}

	public void excluirAgendamento(Agenda id) {
		agendaDAO = new Dao<Agenda>();
		agendaDAO.remove(id);

	}

	public Procedimento getProcedimento(Prontuario p){
		procedimentoDao = new Dao<Procedimento>();
		Procedimento pr = procedimentoDao.findByExample("Procedimento", "id", new Integer(p.getId()).toString());
		return pr;
	}
	
	public Prontuario getProntuario(Paciente p){
		prontuarioDao = new Dao<Prontuario>();
		Prontuario pr = prontuarioDao.findByExample("Prontuario", "paciente_id", new Integer(p.getId()).toString());
		return pr;
	}
	
	public Medico[] listarMedico() {
		medicoDAO = new Dao<Medico>();
		return (Medico[]) medicoDAO.findAll("Medico").toArray();
	}

	@Override
	public boolean confirmarAgendamento(Agenda agenda) {
		if(!agenda.isAgendado()){
			agendaDAO = new Dao<Agenda>();
			agenda.setAgendado(true);
			agendaDAO.update(agenda);
			return true;
		}
		return false;
	}

	@Override
	public Medico[] listarEspecialista() {
		medicoDAO = new Dao<Medico>();
		List<Medico> lista = medicoDAO.findAll("Medico");
		Medico[] m = new Medico[lista.size()];
		for (int i = 0; i < m.length; i++) {
			m[i] = lista.get(i);
			//System.out.println(m[i].getId());
		}
		return m;
	}

	@Override
	public Agenda[] listarAgendamento(int id, String data) {
		agendaDAO = new Dao<Agenda>();
		System.out.println(id);
		List<Agenda> lista = agendaDAO.findByExampleLista("Agenda", "medico_id", new Integer(id).toString() + " and data = '" + data + "'");
		Agenda[] a = new Agenda[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			a[i] = lista.get(i);
		}
		return a;
	}

	@Override
	public Convenio[] listarConvenio() {
		convenioDao = new Dao<Convenio>();
		return (Convenio[]) convenioDao.findAll("Convenio").toArray();
	}

	@Override
	public boolean isUsuario(String usuario) {
		usuarioDao = new Dao<Usuario>();
		Usuario u = usuarioDao.findByExample("Usuario", "usuario", usuario);
		return u != null;
	}
	
}
