using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dominio
{
    class Procedimento
    {
        int Id;
        int IdPaciente;
        int IdMedico;
        enum Tipo {Consulta, Retorno, Exame, Internamento, Observacao};
        string Anamnese;
        string Diagnostico;

        
    }
}
