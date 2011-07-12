package ifrn.pds.model;

import ifrn.pds.dao.Dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.NoResultException;

public class ServicoAtendente{

	private Dao dao = Dao.getDao();

	public ServicoAtendente() {
		//dao = new Dao();
	}
	
	public Paciente[] buscarPaciente(String nome) {
		List<Usuario> u = dao.findByExampleLikeLista("Usuario", "nome", nome);
		List<Paciente> pacientes = new ArrayList<Paciente>();
		
		for (Usuario us : u) {
			System.out.println(us.getId());
			Paciente pa;
			try {
				pa = dao.findByExample("Paciente", "id_usuario", new Integer(us.getId()).toString());
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

	public void cadastrarPaciente(String usuario, String senha, String nome, Date nascimento, String sexo, int telefone, 
			String email, int cpf, int rg, String rua,
			int numero, String complemento, String bairro, int cep, String cidade, String estado,
			int idConvenio, int numeroConvenio) {
		Endereco endereco = new Endereco(rua, numero, bairro, complemento, cidade, estado, cep);
		Usuario u = new Usuario(senha, usuario, endereco, nome, cpf, rg, sexo, telefone, email);
		u.setEndereco(endereco);
		
		Convenio convenio = dao.findById("Convenio", idConvenio);
		
		Paciente paciente = new Paciente(convenio, u, numeroConvenio);
		Calendar c = new GregorianCalendar();
		c.setTime(nascimento);
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH ) + 1);
		paciente.setNascimento(nascimento);
		
		dao.persist(paciente);
		
		Prontuario prontuario = new Prontuario();
		prontuario.setPaciente(paciente);
		dao.persist(prontuario);
	}

	public void excluirAgendamento(int id) {
		Agenda agenda = dao.findById("Agenda", id);
		agenda.setAgendado(false);
		dao.update(agenda);
	}

	public Procedimento getProcedimento(Prontuario p) {
		Procedimento pr = dao.findByExample("Procedimento", "id",
				new Integer(p.getId()).toString());
		return pr;
	}

	public Prontuario getProntuario(int idPaciente) {
		Prontuario pr;
		try {
			pr = dao.findByExample("Prontuario",
					"paciente_id", new Integer(idPaciente).toString());
			return pr;
		} catch (NoResultException e) {
			return null;
		}
	}

	public void salvarAlteracoes(int id, String novoHorario, int idNovoEspecialista, int idConvenio, int dia, int mes, int ano) {
		Agenda agenda = dao.findById("Agenda", id);
		//agenda.setAgendado(true);
		agenda.setHorario(novoHorario);
		Calendar c = new GregorianCalendar();
		c.set(ano, mes, dia);
		System.out.println(c.getTime());
		agenda.setData(c.getTime());
		
		Convenio co = dao.findById("Convenio", idConvenio);
		agenda.getPaciente().setConvenio(co);
		
		Medico m = dao.findById("Medico", idNovoEspecialista);
		agenda.setMedico(m);
		
		dao.update(agenda);
	}

	public void confirmarAgendamento(int id) {
		Agenda agenda = dao.findById("Agenda", id);
		agenda.setAgendado(true);
		dao.update(agenda);
	}

	public Medico[] listarEspecialista() {
		List<Medico> lista = dao.findAll("Medico");
		Medico[] m = new Medico[lista.size()];
		for (int i = 0; i < m.length; i++) {
			m[i] = lista.get(i);
		}
		return m;
	}

	public Agenda[] listarAgendamento(int id, String data) {
		System.out.println(id);
		List<Agenda> lista = dao.findByExampleLista("Agenda",
				"medico_id", new Integer(id).toString() + " and data = '"
						+ data + "'");
		Agenda[] a = new Agenda[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			a[i] = lista.get(i);
		}
		return a;
	}

	public Convenio[] listarConvenio() {
		List<Convenio> lista = dao.findAll("Convenio");
		Convenio[] c = new Convenio[lista.size()];
		for (int i = 0; i < c.length; i++) {
			c[i] = lista.get(i);
		}
		return c;
	}

	public boolean verificaDisponibilidade(String usuario) {
		try {
			dao.findByExample("Usuario", "usuario", "'" + usuario + "'");
		} catch (NoResultException e) {
			return true;
		}
		return false;
	}

	public Atendente efetuarLogin(String usuario, String senha) {
		try {
			Usuario u = dao.findByExample("Usuario", "usuario", "'"
					+ usuario + "'");
			if (u != null) {
				Atendente a = dao.findByExample("Atendente", "id_usuario", new Integer(u.getId()).toString());
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
			
		try{
			List<Agenda> listaAgenda = dao.findByExampleLista("Agenda", "data", "'" + data + "'");

			for(Agenda a : listaAgenda){
				horarios.remove(a.getHorario());
			}
		}finally{
			return horarios;
		}
			
	}
	
	public TipoProcedimento[] listarTipoProcedimento(){
		List<TipoProcedimento> tipos = dao.findAll("TipoProcedimento");
		TipoProcedimento[] lista = new TipoProcedimento[tipos.size()];
		for (int i = 0; i < lista.length; i++) {
			lista[i] = tipos.get(i);
		}
		return lista;
	}
	
	public void novoAgendamento(int idPaciente, int idMedico, Date data, int idTipoProcediemtno, String horario, int idConvenio){
		TipoProcedimento tipo;
		try {
			Medico medico = dao.findById("Medico", idMedico);
			Paciente paciente = dao.findById("Paciente", idPaciente);
			
			tipo = dao.findById("TipoProcedimento", idTipoProcediemtno);
			Agenda agenda = new Agenda();
			agenda.setAgendado(false);
			agenda.setData(data);
			agenda.setHorario(horario);
			agenda.setMedico(medico);
			agenda.setPaciente(paciente);
			agenda.setTipoProcedimento(tipo);
			dao.persist(agenda);
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		
	}

}
