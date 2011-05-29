using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using Dominio;


namespace FormCadastrarMedico
{
    public partial class Form1 : Form
    {

        List<string> especialidades = new List<string>();

        public Form1()
        {
            InitializeComponent();
            cadastrar.Enabled = false;
            
        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label8_Click(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            
            liberarCadastrar();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                if (validaCampos())
                {
                    Endereco endereco = new Endereco(textBox2.Text, int.Parse(textBox3.Text), textBox4.Text, textBox17.Text,
                    textBox5.Text, int.Parse(textBox7.Text), comboBox1.Text);

                    Medico medico = new Medico(textBox15.Text, textBox16.Text, endereco, textBox1.Text,
                        int.Parse(textBox11.Text), int.Parse(textBox9.Text),
                        especialidades);

                    StringBuilder dadosMedico = new StringBuilder();
                    dadosMedico.AppendLine(medico.Nome + " cadastrado com sucesso!");
                    dadosMedico.AppendLine("\tEspecialidades:\n"+medico.listarEspecialidades());
                    MessageBox.Show(dadosMedico.ToString(), "Médico cadastrado");
                    
                    limpaCampos();
                    
                }
                else
                    MessageBox.Show("Preencha todos os campos.");
            }catch(FormatException fe){

                MessageBox.Show("Digite um número válido", "Valor inválido");
                
            }
        }

        private bool validaCampos()
        {
            if (textBox1.Text.Length == 0 || textBox2.Text.Length == 0 || textBox3.Text.Length == 0 || textBox4.Text.Length == 0
                || textBox5.Text.Length == 0 || textBox17.Text.Length == 0 || textBox7.Text.Length == 0 || textBox11.Text.Length == 0
                || textBox9.Text.Length == 0 || tbListaEspecs.Text.Length == 0 || textBox15.Text.Length == 0 || textBox16.Text.Length == 0
                || textBox17.Text.Length == 0 || comboBox1.Text.Length == 0
                )
                return false;
            return true;
        }

        private void limpaCampos()
        {
            textBox1.Clear();
            textBox2.Clear();
            textBox3.Clear();
            textBox4.Clear();
            textBox5.Clear();
            textBox17.Clear();
            textBox7.Clear();
            textBox11.Clear();
            textBox9.Clear();
            textBox10.Clear();
            tbListaEspecs.Clear();
            textBox15.Clear();
            textBox16.Clear();
            textBox17.Clear();
            comboBox1.ResetText();
        }

        private void liberarCadastrar()
        {
            if (textBox1.Text.Length > 0 
                && textBox2.Text.Length > 0 
                && textBox3.Text.Length > 0 
                && textBox4.Text.Length > 0
                && textBox5.Text.Length > 0 
                && textBox17.Text.Length > 0 
                && textBox7.Text.Length > 0 
                && textBox11.Text.Length > 0
                && textBox9.Text.Length > 0 
                && tbListaEspecs.Text.Length > 0 
                && textBox15.Text.Length > 0 
                && textBox16.Text.Length > 0
                && textBox17.Text.Length > 0 
                && comboBox1.Text.Length > 0
                )
                cadastrar.Enabled = true;
            else
                cadastrar.Enabled = false;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        

        private void textBox3_TextChanged(object sender, EventArgs e)
        {
            liberarCadastrar();
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {
            
            liberarCadastrar();
        }

        private void textBox4_TextChanged(object sender, EventArgs e)
        {
            liberarCadastrar();
        }

        private void textBox5_TextChanged(object sender, EventArgs e)
        {
            liberarCadastrar();
        }

        private void textBox17_TextChanged(object sender, EventArgs e)
        {
            liberarCadastrar();
        }

        private void textBox7_TextChanged(object sender, EventArgs e)
        {
            liberarCadastrar();
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            liberarCadastrar();
        }

        private void textBox11_TextChanged(object sender, EventArgs e)
        {
            liberarCadastrar();
        }

        private void textBox9_TextChanged(object sender, EventArgs e)
        {
            liberarCadastrar();
        }

        private void textBox10_TextChanged(object sender, EventArgs e)
        {
            
        }

        private void textBox15_TextChanged(object sender, EventArgs e)
        {
            liberarCadastrar();
        }

        private void textBox16_TextChanged(object sender, EventArgs e)
        {
            liberarCadastrar();
        }

        private void btAddEspc_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(textBox10.Text))
            {
                MessageBox.Show("Digite uma especialidade válida.",
                    "Especialidade inválida");
            }
            else
            {
                tbListaEspecs.Text += textBox10.Text;
                tbListaEspecs.Text += Environment.NewLine;
                especialidades.Add(textBox10.Text);
                textBox10.Clear();
                textBox10.Select();
            }

        }

        private void tbListaEspecs_TextChanged(object sender, EventArgs e)
        {
            liberarCadastrar();
        }

        /*private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            MessageBoxButtons key = MessageBox.Show(
                "Está certo disso?",
                "Confirmar",
                MessageBoxButtons.YesNo,
                MessageBoxIcon.Question);
            e.Cancel = (key == MessageBoxDefaultButton.Button2);
        }*/
    }
}
