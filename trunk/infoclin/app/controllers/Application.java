package controllers;

import com.sun.xml.internal.txw2.Document;

import play.*;
import play.libs.ws.*;
import play.libs.*;
import play.mvc.*;
import models.*;



public class Application extends Controller{
	
	public static void servico(String from, String to){
		String req = " 'http://rmi.fachada.pds.ifrn'" +
				" xmlns:apachesoap='http://xml.apache.org/xml-soap' " +
			" xmlns:impl='http://rmi.fachada.pds.ifrn' " +
			" xmlns:intf='http://rmi.fachada.pds.ifrn' " +
				"xmlns:tns1='http://model.pds.ifrn'" +
				" xmlns:wsdl='http://schemas.xmlsoap.org/wsdl/' " +
				"xmlns:wsdlsoap='http://schemas.xmlsoap.org/wsdl/soap/' " +
				"xmlns:xsd='http://www.w3.org/2001/XMLSchema";
		
		  org.w3c.dom.Document doc = WS.url("http://localhost:8080/Core/wsdl/ImplServidor.wsdl").setHeader("", "").body(req).post().getXml();
			  doc.getChildNodes();
//		  String rate = doc.getElementById("")
//		  String rate = doc.getElementsByTagName("ConversionRateResult").item(0).getTextContent();
			  
	}
	
	public static void index() {
		render();
	}

	public static void login(){
		render();
	}
	
	
	public static void efetuarLogin() {
		
		paciente();
			
		}
//		ObjetoRemotoServidor servidor = null;
//
//	try{
//			Paciente paciente = new Paciente();
//			paciente.setUsuario(params.get("usuario"));
//			paciente.setSenha(params.get("senha"));
//			
//			if(paciente.equals(servidor.fazerLogin(paciente.getUsuario(), paciente.getSenha()))){
//				session.put("current_usuario", paciente);
//				paciente();
//			}
//			else{
//				flash.error("Por favor verifique o usuario ou a senha! ");
//				index();
//			}
//	}	
//		catch (NullPointerException e) {
//			flash.error("Usuário e/ou Senha inválidos.");
//			login();
//		}
	

	
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