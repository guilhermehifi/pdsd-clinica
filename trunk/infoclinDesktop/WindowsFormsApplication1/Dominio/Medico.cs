using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dominio
{
    public class Medico : Usuario
    {
        private List<Array> especialidades;
        private Enum tipoProcedimentos;
        private string Crm;

        public Medico(/*int id, */string login, string senha, Endereco endereco,
            string nome, string cpf, string crm)
            : base(/*id, */login, senha, endereco, nome, cpf)
        {
            Crm = crm;
        }


    }
}
