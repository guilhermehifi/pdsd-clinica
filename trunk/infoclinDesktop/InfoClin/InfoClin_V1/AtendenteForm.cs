using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace InfoClin_V1
{
    public partial class AtendenteForm : Form
    {
        public AtendenteForm()
        {
            InitializeComponent();
            monthCalendar1.MaxSelectionCount = 1;
            label2.Text = "Agenda do dia: " + monthCalendar1.SelectionEnd.ToShortDateString();
        }

        //Este método é para quando clicarem na data para selecionar um dia diferente
        //Deve-se chamar o webservice e retornar os dados em relação aquela data e especialista selecionado no topo da janela
        private void monthCalendar1_DateChanged(object sender, DateRangeEventArgs e)
        {
            label2.Text = "Agenda do dia: " + monthCalendar1.SelectionEnd.ToShortDateString();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            CadastrarPaciente cp = new CadastrarPaciente();
            cp.Show();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Agendar a = new Agendar();
            a.Show();
        }
    }
}
