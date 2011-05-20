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

        AutoCompleteStringCollection acsc = new AutoCompleteStringCollection();

        public Form1()
        {
            InitializeComponent();
        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label8_Click(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (validaCampos())
            {
                Endereco endereco = new Endereco(textBox2.Text, textBox3.Text, textBox4.Text, textBox17.Text,
                textBox5.Text, textBox7.Text, comboBox1.Text);

                Medico medico = new Medico(textBox15.Text, textBox16.Text, endereco, textBox1.Text,
                    textBox11.Text, textBox9.Text);

                MessageBox.Show(medico.getNome());

                limpaCampos();
            }
            else
                MessageBox.Show("Preenche essa porra, caralho!");
        }

        private bool validaCampos()
        {
            if (textBox1.Text.Length == 0 || textBox2.Text.Length == 0 || textBox3.Text.Length == 0 || textBox4.Text.Length == 0
                || textBox5.Text.Length == 0 || textBox17.Text.Length == 0 || textBox7.Text.Length == 0 || textBox11.Text.Length == 0
                || textBox9.Text.Length == 0 || textBox10.Text.Length == 0 || textBox15.Text.Length == 0 || textBox16.Text.Length == 0
                || textBox17.Text.Length == 0 || comboBox1.Text.Length == 0
                )
            {
                return false;
            }
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
            textBox15.Clear();
            textBox16.Clear();
            textBox17.Clear();
            comboBox1.ResetText();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void textBox14_TextChanged(object sender, EventArgs e)
        {
            
        }
    }
}
