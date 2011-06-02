package ifrn.pds.fachada.rmi;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainServidor {

	public static void main(String[] args) throws MalformedURLException {

		try{
			ImplServidor server = new ImplServidor();
			Registry reg = LocateRegistry.createRegistry(1099);
			reg.rebind("servidor", server);
			System.out.println("Servidor rodando!!!!!");
		}
		catch (RemoteException re) {
			System.out.println("Exception in ServidorImpl.main: " + re);
		}

}

}
