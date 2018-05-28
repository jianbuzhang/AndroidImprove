using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace Decode
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void decodeComponent1_DecodeEvent(object sender, HandHeldProducts.Embedded.Decoding.DecodeAssembly.DecodeEventArgs e)
        {
            textBox1.Text = e.Message;
        }
    }
}