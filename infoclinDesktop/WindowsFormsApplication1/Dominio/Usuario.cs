using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dominio
{
    public class Usuario
    {
        //int Id; vem do web service
        private string login;
        private string senha;
        private Endereco endereco { get; set; }
        private string nome;
        private int cpf;
        
        public Usuario(/*int id,*/ string login, string senha, Endereco endereco,
            string nome, int cpf)
        {
            //Id = id;
            this.login = login;
            this.senha = senha;
            this.endereco = endereco;
            this.nome = nome;
            this.cpf = cpf;
        }

        public string Nome
        {
            get { return this.nome; }
            set { this.nome = value; }
        }

        

        public void conectar()
        {

        }

        
    }
}
