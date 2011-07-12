/**
 * FachadaCore.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ifrn.pds.model;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import ifrn.pds.dao.Dao;



public class ServicoMedico{
	private Dao dao = Dao.getDao();
	
	public ServicoMedico() {
		//dao = getDao();
	}
	
	public Medico efetuarLogin(String usuario, String senha) {
		try {
			Usuario u = dao.findByExample("Usuario", "usuario", "'"
					+ usuario + "'");
			if (u != null) {
				Medico m = dao.findByExample("Medico", "id_usuario", new Integer(u.getId()).toString());
				if(m.getUsuario().getSenha().equals(senha))
					return m;
			}
		} catch (NoResultException e) {
			return null;
		}
		return null;
	}
	
	public Agenda[] listarAgendamento(int id, String data) {
		System.out.println(id);
		List<Agenda> lista = dao.findByExampleLista("Agenda",
				"medico_id", new Integer(id).toString() + " and data = '"
						+ data + "'");
		Agenda[] a = new Agenda[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			a[i] = lista.get(i);
		}
		return a;
	}
	
	public Procedimento[] listarProcedimentos(int idProntuario){
		List<Procedimento> p = dao.findByExampleLista("Procedimento", "prontuario_id", new Integer(idProntuario).toString());
		Procedimento[] procedimentos = new Procedimento[p.size()];
		for (int i = 0; i < procedimentos.length; i++) {
			procedimentos[i] = p.get(i);
		}
		return procedimentos;
	}
	
	public void novoProcedimento(int idTipoProcedimento, int idMedico, int idProntuario, String anamnese, String diagnostico, Date data){
		TipoProcedimento tipoProcedimento = dao.findById("TipoProcedimento", idTipoProcedimento);
		Medico medico = dao.findById("Medico", idMedico);
		Prontuario prontuario = dao.findById("Prontuario", idProntuario);
		Paciente paciente = prontuario.getPaciente();
		
		Procedimento procedimento = new Procedimento(tipoProcedimento, medico, paciente, prontuario, data, anamnese, diagnostico);
		dao.persist(procedimento);
	}
	
	public Receita inserirReceita(int idProntuario, String receituario){
		Prontuario prontuario = dao.findById("Prontuario", idProntuario);
		Receita receita = new Receita(receituario, prontuario);
		dao.persist(receita);
		return receita;
	}
	
	public Receita[] listarReceitas(int idProntuario){
		try {
			List<Receita> lista = dao.findByExampleLista("Receita", "prontuario_id", new Integer(idProntuario).toString());
			Receita[] receitas = new Receita[lista.size()];
			for (int i = 0; i < receitas.length; i++) {
				receitas[i] = lista.get(i);
			}
			return receitas;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Prontuario getProntuario(int idPaciente){
		Prontuario p = dao.findByExample("Prontuario", "paciente_id", new Integer(idPaciente).toString());
		return p;
	}
	
	
	public Medico buscarMedico(String login) {
		Medico m = dao.findByExample("Medico", "usuario", login);
		return m;
	}
}
