package ifrn.pds.fachada.rmi;

import ifrn.pds.model.Medico;
import ifrn.pds.model.Paciente;
import ifrn.pds.model.Procedimento;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;


public interface ObjetoRemotoServidor extends Remote, Serializable{
	
	public Paciente fazerLogin(String usuario, String senha) throws RemoteException;
	public void agendar(Procedimento procedimento, Calendar horario, Medico medico,
			Paciente paciente) throws RemoteException;
	public List <Procedimento> listarProcedimento() throws RemoteException;
	

}
