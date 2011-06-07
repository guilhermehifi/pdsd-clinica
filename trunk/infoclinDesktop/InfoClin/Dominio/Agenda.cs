using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dominio
{
    class Agenda
    {
        List<Procedimento> procedimentos;
        List<DateTime> horarios;

        public List<Procedimento> listarProcedimentos()
        {
            return procedimentos;
        }

        /*
        public List<Procedimento> listarProcedimentosUsuario(int idUsuario)
        {
            if (procedimentos.Find(idUsuario))
            {
                int index = procedimentos.IndexOf(idUsuario);
                return procedimentos.ElementAt(index);
            }
            return null;
        }
         */
        
    }
}
