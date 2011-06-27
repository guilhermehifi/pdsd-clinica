package ifrn.pds.fachada.rmi;

import ifrn.pds.dao.Dao;
import ifrn.pds.excecao.PacienteException;
import ifrn.pds.model.Agenda;
import ifrn.pds.model.Medico;
import ifrn.pds.model.Paciente;
import ifrn.pds.model.TipoProcedimento;
import ifrn.pds.model.Usuario;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImplServidor implements InterfaceRemotaServidor{
	
	private static final long serialVersionUID = 1L;
	Dao<Paciente> pacienteDAO;
	Dao<TipoProcedimento> tipoDAO;
	Dao<Agenda> agendaDAO;
	Dao<Medico> medicoDAO;
	Dao<Usuario> usuarioDao;
	
	public ImplServidor() throws RemoteException{
		UnicastRemoteObject.exportObject(this);
	}
	
	public void agendar(Date data, String hora, Medico medico, Paciente paciente, boolean agendado, TipoProcedimento tipoProcedimento)
	throws RemoteException{
		agendaDAO = new Dao<Agenda>();	
		Agenda agenda = new Agenda();
			agenda.setTipoProcedimento(tipoProcedimento);
			agenda.setData(data);
			agenda.setHorario(hora);
			agenda.setMedico(medico);
			agenda.setPaciente(paciente);
			agenda.setAgendado(false);
			agendaDAO.persist(agenda);
	}
	
	public int acharUsuario(String usuario)throws RemoteException, PacienteException {
		Dao<Usuario> usuarioDAO = new Dao<Usuario>();
		Usuario u = usuarioDAO.findByExample("Usuario", "usuario", "'"+usuario+"'");
				return u.getId();
	}

	public Usuario usuarioId(int id){
		usuarioDao = new Dao<Usuario>();
		return usuarioDao.findById("Usuario", id);
	}
	
	
	//funcionando e testado
	public TipoProcedimento [] listarProcedimentos() throws RemoteException{
		tipoDAO = new Dao<TipoProcedimento>();
		List <TipoProcedimento> proc = tipoDAO.findAll("TipoProcedimento");
		int qtd = proc.size();
		TipoProcedimento [] tipo = new TipoProcedimento[qtd];
			for(int i=0; i<proc.size(); i++){
				tipo[i]=proc.get(i);
			}
		return tipo;
	}
	
	@SuppressWarnings("finally")
	public List<String> horariosDisponiveis(String data) throws RemoteException, ParseException {
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
			
		agendaDAO = new Dao<Agenda>();
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        Date dat = (java.util.Date)formatter.parse(data);
		try{
			List<Agenda> listaAgenda = agendaDAO.findByExampleLista("Agenda", "data", "'" + dat + "'");
			for(Agenda a : listaAgenda){
				horarios.remove(a.getHorario());
			}
		}finally{
			return horarios;
		}
			
	}
	
	public Medico medicoId(int id){
		medicoDAO = new Dao<Medico>();
		return medicoDAO.findById("Medico", id);
	}
	
	public TipoProcedimento tipoId(int id){
		tipoDAO = new Dao<TipoProcedimento>();
		return tipoDAO.findById("TipoProcedimento", id);
	}
	
	public Medico [] listarNomeMedicos()throws RemoteException{
		medicoDAO = new Dao<Medico>();
		List<Medico> lista = medicoDAO.findAll("Medico");
		Medico[] m = new Medico[lista.size()];
		for (int i = 0; i < m.length; i++) {
			m[i] = lista.get(i);
		}
		return m;
	}

	public Paciente pacienteId(int id){
		pacienteDAO = new Dao<Paciente>();
		return pacienteDAO.findById("Paciente", id);
	}

}
