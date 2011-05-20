using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dominio
{
    public class Endereco
    {
         string Rua;
         string Numero;
         string Bairro;
         string Complemento;
         string Cidade;
         string Cep;
         string Estado;

        public Endereco(string rua, string numero, string bairro, string complemento,
            string cidade, string cep, string estado)
        {
            Rua = rua;
            Numero = numero;
            Bairro = bairro;
            Complemento = complemento;
            Cidade = cidade;
            Cep = cep;
            Estado = estado;
        }

    }
}
