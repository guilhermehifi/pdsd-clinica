package ifrn.pds.fachada.rmi;

import ifrn.pds.excecao.PacienteException;
import ifrn.pds.model.Medico;
import ifrn.pds.model.Paciente;
import ifrn.pds.model.TipoProcedimento;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;


public interface InterfaceRemotaServidor extends Remote, Serializable{

	public Paciente fazerLogin(String usuario, String senha) throws RemoteException, PacienteException;
	public void agendar(TipoProcedimento tipoProcedimento, Date data, String hora, Medico medico,Paciente paciente) throws RemoteException;
	public TipoProcedimento[] listarProcedimentos() throws RemoteException;
	public List<String> horariosDisponiveis(Date data) throws RemoteException;
	public Medico [] listarNomeMedicos()throws RemoteException;
	
}
