using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dominio
{
    public class Usuario
    {
        //int Id; vem do web service
        string Login ;
        string Senha ;
        Endereco Endereco ;
        string Nome ;
        string Cpf;

        public Usuario()
        {
            
        }
        
        public Usuario(/*int id,*/ string login, string senha, Endereco endereco,
            string nome, string cpf)
        {
            //Id = id;
            Login = login;
            Senha = senha;
            Endereco = endereco;
            Nome = nome;
            Cpf = cpf;
        }

        public void conectar()
        {

        }

        public string getNome()
        {
            return Nome;
        }
    }
}
