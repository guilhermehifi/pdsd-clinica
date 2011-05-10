package controllers;

import java.rmi.RemoteException;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;
import models.Usuario;
import rmi.Login;

public class ImplLogin implements Login{

	public ImplLogin() throws RemoteException{
		UnicastRemoteObject.exportObject(this);
	}
	
	public void conectar(Usuario id) throws RemoteException {
		
	}



	public void desconectar(Usuario id) throws RemoteException {
		
	}

}
