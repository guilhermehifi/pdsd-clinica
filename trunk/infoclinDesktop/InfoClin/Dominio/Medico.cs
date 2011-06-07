using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dominio
{
    public class Medico : Usuario
    {
        private List<string> especialidades;
        private Enum tipoProcedimentos;
        private int crm;

        public Medico(/*int id, */string login, string senha, Endereco endereco,
            string nome, int cpf, int crm, List<string> especialidades)
            : base(/*id, */login, senha, endereco, nome, cpf)
        {
            this.crm = crm;
            this.especialidades = especialidades;
        }

        public string listarEspecialidades()
        {
            string lista = "";
            foreach (string espec in especialidades)
            {
                lista += espec;
                lista += Environment.NewLine;
            }
            return lista;
        }

    }
}
