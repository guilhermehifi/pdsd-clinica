using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dominio
{
    class Prontuario
    {
        int id;
        int idPaciente;
        List<Procedimento> procedimentos;
        List<Receita> receitas;
    }
}
