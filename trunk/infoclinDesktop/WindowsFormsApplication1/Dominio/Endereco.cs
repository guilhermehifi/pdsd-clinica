using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dominio
{
    public class Endereco
    {
         private string rua;
         private int numero;
         private string bairro;
         private string complemento;
         private string cidade { get; set; }
         private int cep;
         private string estado;

        public Endereco(string rua, int numero, string bairro,
            string complemento, string cidade, int cep, string estado)
        {
            this.rua = rua;
            this.numero = numero;
            this.bairro = bairro;
            this.complemento = complemento;
            this.cidade = cidade;
            this.cep = cep;
            this.estado = estado;
        }

        public string Cidade
        {
            get { return this.cidade; }
            set { this.cidade = value; }
        }
    }
}
