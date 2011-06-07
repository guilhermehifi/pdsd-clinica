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
    public partial class AdministradorForm : Form
    {
        public AdministradorForm()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            CadastrarMedico cm = new CadastrarMedico();
            cm.Show();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            CadastrarPaciente cp = new CadastrarPaciente();
            cp.Show();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            CadastrarAtendente ca = new CadastrarAtendente();
            ca.Show();
        }
    }
}
