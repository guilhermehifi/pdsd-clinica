package rmi;

import java.io.Serializable;
import java.rmi.*;

import models.Usuario;

public interface Login extends Remote, Serializable {
	
	public void fazerLogin(String usuario, String senha) throws RemoteException;
	public void logout() throws RemoteException;
	

}
