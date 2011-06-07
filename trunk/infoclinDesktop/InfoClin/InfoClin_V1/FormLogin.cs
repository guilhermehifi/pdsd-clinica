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
    public partial class JanelaLogin : Form
    {
        public JanelaLogin()
        {
            InitializeComponent();
        }
        private void BotaoLogin_Click(object sender, EventArgs e)
        {
            AtendenteForm f = new AtendenteForm();
            AdministradorForm g = new AdministradorForm();
            if (AtendenteRadio.Checked)
            {
                ActiveForm.Hide();
                f.Show();
            }
            else if (AdministraadorRadio.Checked)
            {
                ActiveForm.Hide();
                g.Show();
            }
            else
            {
                MessageBox.Show("Não existe este Módulo", "Não existe este Módulo", MessageBoxButtons.OKCancel, MessageBoxIcon.Warning);
            }
        }
        private void Fechar()
        {
            this.Close();
        }

        
    }
}
