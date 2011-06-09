package models;

import java.io.Serializable;
import java.util.Calendar;

	public class Agenda implements Serializable{
		
		private int id;

		private Procedimento procedimento;
		private Calendar horario;
		private Medico medico;
		private Paciente paciente;

		public Agenda() {

		}

		public Agenda(Procedimento procedimento, Calendar horario, Medico medico,
				Paciente paciente) {
			this.procedimento = procedimento;
			this.horario = horario;
			this.medico = medico;
			this.paciente = paciente;
		}

		public Procedimento getProcedimento() {
			return procedimento;
		}

		public void setProcedimento(Procedimento procedimento) {
			this.procedimento = procedimento;
		}

		public Calendar getHorario() {
			return horario;
		}

		public void setHorario(Calendar horario) {
			this.horario = horario;
		}

		public Medico getMedico() {
			return medico;
		}

		public void setMedico(Medico medico) {
			this.medico = medico;
		}

		public Paciente getPaciente() {
			return paciente;
		}

		public void setPaciente(Paciente paciente) {
			this.paciente = paciente;
		}

		public int getId() {
			return id;
		}

}
