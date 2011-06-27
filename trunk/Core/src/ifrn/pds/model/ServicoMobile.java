package ifrn.pds.model;

import java.util.List;

import ifrn.pds.dao.Dao;


public class ServicoMobile {
	Dao<Usuario> usuarioDao;
	Dao<Medico> medicoDao;
	Dao<Agenda> agendaDao;

	public int acharUsuario(String usuario){
		Dao<Usuario> usuarioDAO = new Dao<Usuario>();
		Usuario u = usuarioDAO.findByExample("Usuario", "usuario", "'"+usuario+"'");
				return u.getId();
	}
	
	public Medico medicoId(int id){
		medicoDao = new Dao<Medico>();
		return medicoDao.findById("Medico", id);
	}
	
	public Agenda agendaId(int id){
		agendaDao = new Dao<Agenda>();
		return agendaDao.findById("Agenda", id);
		
	}
	
	public Usuario usuarioId(int id){
		usuarioDao = new Dao<Usuario>();
		return usuarioDao.findById("Usuario", id);
	}
	
	public Agenda[] listarAgenda(int id, String data) {
		agendaDao = new Dao<Agenda>();
		System.out.println(id);
		List<Agenda> lista = agendaDao.findByExampleLista("Agenda",
				"medico_id", new Integer(id).toString() + " and data = '"
						+ data + "'");
		Agenda[] a = new Agenda[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).isAgendado()==true){
				a[i]=lista.get(i);
			}
		}
		return a;
	}

}
