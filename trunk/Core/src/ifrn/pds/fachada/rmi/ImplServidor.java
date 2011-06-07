package ifrn.pds.fachada.rmi;

import ifrn.pds.dao.Dao;
import ifrn.pds.interfaces.ObjetoRemotoServidor;
import ifrn.pds.model.Agenda;
import ifrn.pds.model.Medico;
import ifrn.pds.model.Paciente;
import ifrn.pds.model.Procedimento;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;

public class ImplServidor implements ObjetoRemotoServidor{

	Dao<Paciente> pacienteDAO = new Dao<Paciente>();
	Dao<Procedimento> procDAO = new Dao<Procedimento>();
	Dao<Agenda> agendaDAO = new Dao<Agenda>();
	
	public ImplServidor() throws RemoteException{
		UnicastRemoteObject.exportObject(this);
	}
	
	public void agendar(Procedimento procedimento, Calendar horario, Medico medico,
			Paciente paciente)
			throws RemoteException {
			Agenda agenda = new Agenda(procedimento, horario, medico, paciente);
			agendaDAO.persist(agenda);
	}

	
	public Paciente fazerLogin(String usuario, String senha)
	throws RemoteException {
		Paciente p= null;
		p = pacienteDAO.findByExample(Paciente.class, "usuario", usuario);
		if(p==null)
			return null;
		else{
			if(p.getSenha().equals(senha))
				return p;
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Procedimento [] listarProcedimento() throws RemoteException {
		ArrayList<Procedimento> proc = (ArrayList<Procedimento>) procDAO.findAll(Procedimento.class);
		Procedimento [] procedimentos = (Procedimento[]) proc.toArray();
		return procedimentos;
	}

}
