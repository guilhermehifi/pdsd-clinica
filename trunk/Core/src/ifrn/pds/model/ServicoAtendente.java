package ifrn.pds.model;

import ifrn.pds.dao.Dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.NoResultException;

public class ServicoAtendente{

	private Dao<Paciente> pacienteDao;
	private Dao<Agenda> agendaDao;
	private Dao<Medico> medicoDao;
	private Dao<Convenio> convenioDao;
	private Dao<Usuario> usuarioDao;
	private Dao<Prontuario> prontuarioDao;
	private Dao<Procedimento> procedimentoDao;
	private Dao<TipoProcedimento> tipoProcedimentoDao;

	public Paciente[] buscarPaciente(String nome) {
		usuarioDao = new Dao<Usuario>();
		List<Usuario> u = usuarioDao.findByExampleLikeLista("Usuario", "nome", nome);
		List<Paciente> pacientes = new ArrayList<Paciente>();
		
		for (Usuario us : u) {
			pacienteDao = new Dao<Paciente>();
			System.out.println(us.getId());
			Paciente pa;
			try {
				pa = pacienteDao.findByExample("Paciente", "id_usuario", new Integer(us.getId()).toString());
				pacientes.add(pa);
			} catch (NoResultException e) {
				System.out.println("non achou");
			}
		}
		
		Paciente[] p = new Paciente[pacientes.size()];
		for (int i = 0; i < p.length; i++) {
			p[i] = pacientes.get(i);
		}
		return p;
	}

	public void cadastrarPaciente(String usuario, String senha, String nome, String sexo, int telefone, 
			String email, int cpf, int rg, String rua,
			int numero, String complemento, String bairro, int cep, String cidade, String estado,
			int idConvenio, int numeroConvenio) {
		Endereco endereco = new Endereco(rua, numero, bairro, complemento, cidade, estado, cep);
		Usuario u = new Usuario(senha, usuario, endereco, nome, cpf, rg, sexo, telefone, email);
		u.setEndereco(endereco);
		
		convenioDao = new Dao<Convenio>();
		Convenio convenio = convenioDao.findById("Convenio", idConvenio);
		
		Paciente paciente = new Paciente(convenio, u, numeroConvenio);
		
		pacienteDao = new Dao<Paciente>();
		pacienteDao.persist(paciente);
		
		prontuarioDao = new Dao<Prontuario>();
		Prontuario prontuario = new Prontuario();
		prontuario.setPaciente(paciente);
		prontuarioDao.persist(prontuario);
	}

	public void excluirAgendamento(int id) {
		agendaDao = new Dao<Agenda>();
		Agenda agenda = agendaDao.findById("Agenda", id);
		agenda.setAgendado(false);
		agendaDao.update(agenda);
	}

	public Procedimento getProcedimento(Prontuario p) {
		procedimentoDao = new Dao<Procedimento>();
		Procedimento pr = procedimentoDao.findByExample("Procedimento", "id",
				new Integer(p.getId()).toString());
		return pr;
	}

	public Prontuario getProntuario(int idPaciente) {
		Prontuario pr;
		try {
			prontuarioDao = new Dao<Prontuario>();
			pr = prontuarioDao.findByExample("Prontuario",
					"paciente_id", new Integer(idPaciente).toString());
			return pr;
		} catch (NoResultException e) {
			return null;
		}
	}

	public void salvarAlteracoes(int id, String novoHorario, int idNovoEspecialista, int idConvenio, int dia, int mes, int ano) {
		agendaDao = new Dao<Agenda>();
		Agenda agenda = agendaDao.findById("Agenda", id);
		//agenda.setAgendado(true);
		agenda.setHorario(novoHorario);
		Calendar c = new GregorianCalendar();
		c.set(ano, mes, dia);
		System.out.println(c.getTime());
		agenda.setData(c.getTime());
		
		Convenio co = new Dao<Convenio>().findById("Convenio", idConvenio);
		agenda.getPaciente().setConvenio(co);
		
		Medico m = new Dao<Medico>().findById("Medico", idNovoEspecialista);
		agenda.setMedico(m);
		
		agendaDao.update(agenda);
	}

	public void confirmarAgendamento(int id) {
		agendaDao = new Dao<Agenda>();
		Agenda agenda = agendaDao.findById("Agenda", id);
		agenda.setAgendado(true);
		agendaDao.update(agenda);
	}

	public Medico[] listarEspecialista() {
		medicoDao = new Dao<Medico>();
		List<Medico> lista = medicoDao.findAll("Medico");
		Medico[] m = new Medico[lista.size()];
		for (int i = 0; i < m.length; i++) {
			m[i] = lista.get(i);
		}
		return m;
	}

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

	public Convenio[] listarConvenio() {
		convenioDao = new Dao<Convenio>();
		List<Convenio> lista = convenioDao.findAll("Convenio");
		Convenio[] c = new Convenio[lista.size()];
		for (int i = 0; i < c.length; i++) {
			c[i] = lista.get(i);
		}
		return c;
	}

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
				Atendente a = atendenteDao.findByExample("Atendente", "id_usuario", new Integer(u.getId()).toString());
				if(a.getUsuario().getSenha().equals(senha))
					return a;
			}
		} catch (NoResultException e) {
			return null;
		}
		return null;
	}
	
	public String[] listarHorarios(Date data){
		List<String> horarios = horariosDisponiveis(data);
		String[] lista = new String[horarios.size()];
		for (int i = 0; i < lista.length; i++) {
			lista[i] = horarios.get(i);
		}
		return lista;
	}
	
	@SuppressWarnings("finally")
	private List<String> horariosDisponiveis(Date data) {
		List <String> horarios = new ArrayList<String>();
			//9 as 13
			int x=8;
			int y=0;
			while(x <=13){
				if(y % 2==0){
					y++;
					horarios.add(x+":00");
				}
				else{
					y++;
					horarios.add(x + ":30");
					x++;
				}
			}
			
		agendaDao = new Dao<Agenda>();
		try{
			List<Agenda> listaAgenda = agendaDao.findByExampleLista("Agenda", "data", "\"" + data + "\"");

			for(Agenda a : listaAgenda){
				horarios.remove(a.getHorario());
			}
		}finally{
			return horarios;
		}
			
	}
	
	public TipoProcedimento[] listarTipoProcedimento(){
		tipoProcedimentoDao = new Dao<TipoProcedimento>();
		List<TipoProcedimento> tipos = tipoProcedimentoDao.findAll("TipoProcedimento");
		TipoProcedimento[] lista = new TipoProcedimento[tipos.size()];
		for (int i = 0; i < lista.length; i++) {
			lista[i] = tipos.get(i);
		}
		return lista;
	}
	
	public void novoAgendamento(int idPaciente, int idMedico, Date data, int idTipoProcediemtno, String horario, int idConvenio){
		agendaDao = new Dao<Agenda>();
		tipoProcedimentoDao = new Dao<TipoProcedimento>();
		medicoDao = new Dao<Medico>();
		pacienteDao = new Dao<Paciente>();
		usuarioDao = new Dao<Usuario>();
		
		TipoProcedimento tipo;
		try {
			Medico medico = medicoDao.findById("Medico", idMedico);
			Paciente paciente = pacienteDao.findById("Paciente", idPaciente);
			
			tipo = tipoProcedimentoDao.findById("TipoProcedimento", idTipoProcediemtno);
			Agenda agenda = new Agenda();
			agenda.setAgendado(false);
			agenda.setData(data);
			agenda.setHorario(horario);
			agenda.setMedico(medico);
			agenda.setPaciente(paciente);
			agenda.setTipoProcedimento(tipo);
			agendaDao.persist(agenda);
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		
	}

}
