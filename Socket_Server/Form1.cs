using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.Threading;
using System.Net;
using System.Net.Sockets;

namespace Socket_Server
{
    public partial class Form1 : Form
    {
        public delegate void UpdateMessage(StateObject socket);
        public UpdateMessage ShowMessage;
        public delegate void ShowException(string message);
        public ShowException showException;
        Thread t_Connect;
        public Form1()
        {
            InitializeComponent();
            ShowMessage = new UpdateMessage(ShowMessageBox);
            showException = new ShowException(exceptionShow);
            AsynchronousSocket.Form = this;
            t_Connect = new Thread(Listen);
            t_Connect.Start();
        }

        private void Listen()
        {
            try
            {
                AsynchronousSocket.StartListening();
            }
            catch (Exception ex)
            {
                //showException(ex.Message);
            }
        }

        private void exceptionShow(string message)
        {
            MessageBox.Show(message);
        }

        private void ShowMessageBox(StateObject state)
        {
            //MessageBox.Show(state.Message);
            textBoxRec.Text += state.ip + ':' + state.Message + "\r\n";
            if (state.Message == "\r\n")
                SendKeys.Send("{enter}");
            else
                SendKeys.Send(state.Message + "{enter}");
        }

        private void buttonClear_Click(object sender, EventArgs e)
        {
            textBoxRec.Clear();
        }

        private void Form1_FormClosed(object sender, FormClosedEventArgs e)
        {
            if (t_Connect != null)
                t_Connect.Abort();
        }

        private void notifyIcon1_MouseClick(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Right)
            {
                contextMenuStrip1.Show(MousePosition.X, MousePosition.Y);
            }
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void Form1_Shown(object sender, EventArgs e)
        {
            this.Hide();
            notifyIcon1.Visible = true;
        }
    }
}