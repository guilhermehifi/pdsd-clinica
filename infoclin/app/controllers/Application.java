package controllers;

import play.*;
import interfaces.ObjetoRemotoServidor;
import java.rmi.Remote;
import play.mvc.*;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.NoSuchAlgorithmException;
import java.util.*;



import models.*;

public class Application extends Controller{
	
	@Before
	public static void registroCliente()throws RemoteException, NotBoundException{
		Registry reg = LocateRegistry.getRegistry();
		ObjetoRemotoServidor servico = (ObjetoRemotoServidor) reg.lookup("servidor");
	}
	
	public static void index() {
		render();
	}

	public static void login(){
		render();
	}
	
	public static void efetuarLogin() throws RemoteException{
		ObjetoRemotoServidor servidor = null;
//		if (params.get("usuario").equals("dani") && params.get("senha").equals("lely")) 
//			paciente();
	try{
			Paciente paciente = new Paciente();
			paciente.setUsuario(params.get("usuario"));
			paciente.setSenha(params.get("senha"));
			
			if(paciente.equals(servidor.fazerLogin(paciente.getUsuario(), paciente.getSenha()))){
				session.put("current_usuario", paciente);
				paciente();
			}
			else{
				flash.error("Por favor verifique o usuario ou a senha! ");
				index();
			}
	}	
		catch (NullPointerException e) {
			flash.error("Usuário e/ou Senha inválidos.");
			login();
		}
	}

	
	public static void efetuarLogout() {
			session.remove("current_usuario");
			flash.put("info","Saindo do sistema!");
			index();
	}
	
	public static void esqueciSenha(){
		
	}

	public static void paciente(){
		render();
	}

	public static void agendar(){
		render();
	}

	public static void listar(){
		render();
	}
}