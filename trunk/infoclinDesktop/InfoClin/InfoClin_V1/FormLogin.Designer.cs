namespace InfoClin_V1
{
    partial class JanelaLogin
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(JanelaLogin));
            this.Usuario = new System.Windows.Forms.TextBox();
            this.Senha = new System.Windows.Forms.TextBox();
            this.BotaoLogin = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.AtendenteRadio = new System.Windows.Forms.RadioButton();
            this.MedicoRadio = new System.Windows.Forms.RadioButton();
            this.AdministraadorRadio = new System.Windows.Forms.RadioButton();
            this.Logo = new System.Windows.Forms.PictureBox();
            ((System.ComponentModel.ISupportInitialize)(this.Logo)).BeginInit();
            this.SuspendLayout();
            // 
            // Usuario
            // 
            this.Usuario.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Usuario.ForeColor = System.Drawing.Color.DarkRed;
            this.Usuario.Location = new System.Drawing.Point(280, 133);
            this.Usuario.Name = "Usuario";
            this.Usuario.Size = new System.Drawing.Size(246, 26);
            this.Usuario.TabIndex = 1;
            // 
            // Senha
            // 
            this.Senha.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Senha.ForeColor = System.Drawing.Color.DarkRed;
            this.Senha.Location = new System.Drawing.Point(280, 172);
            this.Senha.Name = "Senha";
            this.Senha.PasswordChar = '•';
            this.Senha.Size = new System.Drawing.Size(246, 26);
            this.Senha.TabIndex = 2;
            // 
            // BotaoLogin
            // 
            this.BotaoLogin.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BotaoLogin.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.BotaoLogin.Location = new System.Drawing.Point(549, 133);
            this.BotaoLogin.Name = "BotaoLogin";
            this.BotaoLogin.Size = new System.Drawing.Size(110, 65);
            this.BotaoLogin.TabIndex = 3;
            this.BotaoLogin.Text = "Entrar";
            this.BotaoLogin.UseVisualStyleBackColor = true;
            this.BotaoLogin.Click += new System.EventHandler(this.BotaoLogin_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(210, 139);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(68, 20);
            this.label1.TabIndex = 4;
            this.label1.Text = "Usuário:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(218, 178);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(60, 20);
            this.label2.TabIndex = 5;
            this.label2.Text = "Senha:";
            // 
            // AtendenteRadio
            // 
            this.AtendenteRadio.AutoSize = true;
            this.AtendenteRadio.Checked = true;
            this.AtendenteRadio.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.AtendenteRadio.Location = new System.Drawing.Point(214, 271);
            this.AtendenteRadio.Name = "AtendenteRadio";
            this.AtendenteRadio.Size = new System.Drawing.Size(96, 20);
            this.AtendenteRadio.TabIndex = 6;
            this.AtendenteRadio.TabStop = true;
            this.AtendenteRadio.Text = "Atendente";
            this.AtendenteRadio.UseVisualStyleBackColor = true;
            // 
            // MedicoRadio
            // 
            this.MedicoRadio.AutoSize = true;
            this.MedicoRadio.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.MedicoRadio.Location = new System.Drawing.Point(382, 271);
            this.MedicoRadio.Name = "MedicoRadio";
            this.MedicoRadio.Size = new System.Drawing.Size(77, 20);
            this.MedicoRadio.TabIndex = 7;
            this.MedicoRadio.Text = "Médico";
            this.MedicoRadio.UseVisualStyleBackColor = true;
            // 
            // AdministraadorRadio
            // 
            this.AdministraadorRadio.AutoSize = true;
            this.AdministraadorRadio.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.AdministraadorRadio.Location = new System.Drawing.Point(537, 271);
            this.AdministraadorRadio.Name = "AdministraadorRadio";
            this.AdministraadorRadio.Size = new System.Drawing.Size(122, 20);
            this.AdministraadorRadio.TabIndex = 8;
            this.AdministraadorRadio.Text = "Administrador";
            this.AdministraadorRadio.UseVisualStyleBackColor = true;
            // 
            // Logo
            // 
            this.Logo.BackgroundImage = global::InfoClin_V1.Properties.Resources.logo;
            this.Logo.Location = new System.Drawing.Point(0, 1);
            this.Logo.Name = "Logo";
            this.Logo.Size = new System.Drawing.Size(177, 362);
            this.Logo.TabIndex = 0;
            this.Logo.TabStop = false;
            // 
            // JanelaLogin
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.White;
            this.ClientSize = new System.Drawing.Size(684, 362);
            this.Controls.Add(this.AdministraadorRadio);
            this.Controls.Add(this.MedicoRadio);
            this.Controls.Add(this.AtendenteRadio);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.BotaoLogin);
            this.Controls.Add(this.Senha);
            this.Controls.Add(this.Usuario);
            this.Controls.Add(this.Logo);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.Name = "JanelaLogin";
            this.Text = "InfoClin - Módulo Desktop";
            ((System.ComponentModel.ISupportInitialize)(this.Logo)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox Logo;
        private System.Windows.Forms.TextBox Usuario;
        private System.Windows.Forms.TextBox Senha;
        private System.Windows.Forms.Button BotaoLogin;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.RadioButton AtendenteRadio;
        private System.Windows.Forms.RadioButton MedicoRadio;
        private System.Windows.Forms.RadioButton AdministraadorRadio;
    }
}

