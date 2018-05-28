using System;
using System.Collections.Generic;
using System.Text;
using System.Net;
using System.Net.Sockets;
using System.Threading;

namespace Socket_Server
{
    class AsynchronousSocket
    {
         // Thread signal.
        public static ManualResetEvent allDone = new ManualResetEvent(false);
        public static Form1 Form;
        public AsynchronousSocket() { }
        public static void StartListening()
        {

            // Data buffer for incoming data.
            byte[] bytes = new Byte[1024];
            // Establish the local endpoint for the socket.
            // The DNS name of the computer
            // running the listener is "host.contoso.com".

            //IPHostEntry ipHostInfo = Dns.Resolve(Dns.GetHostName());

            IPAddress ipAddress = IPAddress.Any;
            IPEndPoint localEndPoint = new IPEndPoint(ipAddress, Global.port);
            // Create a TCP/IP socket.
            Socket listener = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
            // Bind the socket to the local endpoint and listen for incoming connections.
            try
            {
                listener.Bind(localEndPoint);
                listener.Listen(100);
                while (true)
                {
                    // Set the event to nonsignaled state.
                    allDone.Reset();
                    // Start an asynchronous socket to listen for connections.
                    Console.WriteLine("Waiting for a connection...");
                    listener.BeginAccept(new AsyncCallback(AcceptCallback), listener);
                    // Wait until a connection is made before continuing.
                    allDone.WaitOne();
                }
            }
            catch (Exception e)
            {
                throw e;
            }
        }
        public static void AcceptCallback(IAsyncResult ar)
        {
            try
            {
                // Signal the main thread to continue.
                allDone.Set();
                // Get the socket that handles the client request.
                Socket listener = (Socket)ar.AsyncState;
                Socket handler = listener.EndAccept(ar);
                // Create the state object.
                StateObject state = new StateObject();
                state.workSocket = handler;
                state.ip = handler.RemoteEndPoint.ToString().Remove(handler.RemoteEndPoint.ToString().IndexOf(':'));
                Global.client.Add(state);
                handler.BeginReceive(state.buffer, 0, StateObject.BufferSize, 0, new AsyncCallback(ReadCallback), state);
                Send(handler, "Welcome \r\n");
            }
            catch (Exception ex)
            {
                //Form.Invoke(Form.showException, new object[] { ex.Message });
            }
        }
        public static void ReadCallback(IAsyncResult ar)
        {
            StateObject state = (StateObject)ar.AsyncState;
            Socket handler = state.workSocket;
            try
            {
                String content = String.Empty;
                // Retrieve the state object and the handler socket
                // from the asynchronous state object.
                
                // Read data from the client socket.
                int bytesRead = handler.EndReceive(ar);
                if (bytesRead > 0)
                {
                    // There    might be more data, so store the data received so far.
                    state.sb.Append(Encoding.ASCII.GetString(state.buffer, 0, bytesRead));
                    // Check for end-of-file tag. If it is not there, read
                    // more data.
                    content = Encoding.ASCII.GetString(state.buffer, 0, bytesRead);
                    //if (content.TrimEnd( '\n' ).TrimEnd('\r').Contains("\r\n"))
                    //{
                    string[] tempStr = content.Split(new string[] { "\r\n" }, StringSplitOptions.RemoveEmptyEntries);
                    for (int i = 0; i < tempStr.Length; i++)
                    {
                        state.Message = tempStr[i];
                        Form.Invoke(Form.ShowMessage, new object[] { state });
                    }
                    //}
                    //else
                    //{
                    //    state.Message = content.TrimEnd('\n').TrimEnd('\r');
                    //    Form.Invoke(Form.ShowMessage, new object[] { state });
                    //}
                        // Not all data received. Get more.

                    
                    handler.BeginReceive(state.buffer, 0, StateObject.BufferSize, 0,
                    new AsyncCallback(ReadCallback), state);
                    
                }
                else
                {
                    //! 保存所有信息
                }
            }
            catch(Exception ex)
            {
                //state.Message = content.TrimEnd(new char[] { '\r', '\n' });
                //Form.Invoke(Form.showException, new object[] { ex.Message });
                handler.Close();
                Global.client.Remove(state);
            }
        }
        private static void Send(Socket handler, String data)
        {
            // Convert the string data to byte data using ASCII encoding.
            byte[] byteData = Encoding.ASCII.GetBytes(data);
            // Begin sending the data to the remote device.
            handler.BeginSend(byteData, 0, byteData.Length, 0,
            new AsyncCallback(SendCallback), handler);
        }
        private static void SendCallback(IAsyncResult ar)
        {
            try
            {
                // Retrieve the socket from the state object.
                Socket handler = (Socket)ar.AsyncState;
                // Complete sending the data to the remote device.
                int bytesSent = handler.EndSend(ar);
                Console.WriteLine("Sent {0} bytes to client.", bytesSent);
                //handler.Shutdown(SocketShutdown.Both);
                //handler.Close();
            }
            catch (Exception e)
            {
                Console.WriteLine(e.ToString());
            }
        }
    }
    public class StateObject
    {
        // Client socket.
        public Socket workSocket = null;
        // Size of receive buffer.
        public const int BufferSize = 256;
        // Receive buffer.
        public byte[] buffer = new byte[BufferSize];
        // Received data string.
        public StringBuilder sb = new StringBuilder();

        public string Message;

        public string ip;
    }
    
}
