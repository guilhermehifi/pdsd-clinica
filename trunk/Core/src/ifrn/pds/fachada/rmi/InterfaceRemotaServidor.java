package ifrn.pds.fachada.rmi;

import ifrn.pds.excecao.PacienteException;
import ifrn.pds.model.Medico;
import ifrn.pds.model.Paciente;
import ifrn.pds.model.TipoProcedimento;
import ifrn.pds.model.Usuario;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;


public interface InterfaceRemotaServidor extends Remote, Serializable{

	public int acharUsuario(String usuario) throws RemoteException, PacienteException;
	public void agendar(Date data, String hora, Medico medico, Paciente paciente, boolean agendado, TipoProcedimento tipoProcedimento)
	throws RemoteException;
	public TipoProcedimento[] listarProcedimentos() throws RemoteException;
	public List<String> horariosDisponiveis(String data) throws RemoteException, ParseException;
	public Medico [] listarNomeMedicos()throws RemoteException;
	public Medico medicoId(int id)throws RemoteException;
	public Paciente pacienteId(int id) throws RemoteException;
	public TipoProcedimento tipoId(int id)throws RemoteException;
	public Usuario usuarioId(int id) throws RemoteException;
}
