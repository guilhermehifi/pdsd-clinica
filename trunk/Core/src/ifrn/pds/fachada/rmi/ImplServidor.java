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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

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
	
	public void agendar(TipoProcedimento tipoProcedimento, Date data, String hora, Medico medico,Paciente paciente)
	throws RemoteException{
		agendaDAO = new Dao<Agenda>();	
		Agenda agenda = new Agenda();
			agenda.setTipoProcedimento(tipoProcedimento);
			agenda.setData(data);
			agenda.setHorario(hora);
			agenda.setMedico(medico);
			agenda.setPaciente(paciente);
			agendaDAO.persist(agenda);
	}

	//funcionando e testado
	public Paciente fazerLogin(String usuario, String senha) throws RemoteException, PacienteException{
		Paciente p = new Paciente();
		try{
			usuarioDao = new Dao<Usuario>();
			pacienteDAO = new Dao<Paciente>();

			List<Paciente> pacientes = pacienteDAO.findAll("Paciente");
			for(int i=0; i<pacientes.size(); i++){
				if(((pacientes.get(i).getUsuario().getUsuario().equals(usuario)) && pacientes.get(i).getUsuario().equals(senha))){
					p = pacientes.get(i);
				}
			}
		}
		catch(NoResultException e){
			throw new PacienteException();
		}
		return p;

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
	public List<String> horariosDisponiveis(Date data) throws RemoteException {
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
		try{
			List<Agenda> listaAgenda = agendaDAO.findByExampleLista("Agenda", "data", "\"" + data + "\"");

			for(Agenda a : listaAgenda){
				horarios.remove(a.getHorario());
			}
		}finally{
			return horarios;
		}
			
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

}
