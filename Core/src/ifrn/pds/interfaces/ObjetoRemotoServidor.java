package ifrn.pds.interfaces;

import ifrn.pds.model.Medico;
import ifrn.pds.model.Paciente;
import ifrn.pds.model.Procedimento;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Calendar;


public interface ObjetoRemotoServidor extends Remote{
	
	public Paciente fazerLogin(String usuario, String senha) throws RemoteException;
	public void agendar(Procedimento procedimento, Calendar horario, Medico medico,
			Paciente paciente) throws RemoteException;
	public Procedimento []listarProcedimento() throws RemoteException;
	

}
