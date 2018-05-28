package tdd.usi.scansocket;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.a.d;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class MainActivity extends d implements OnClickListener {
    MainActivity m;
    TextView n;
    EditText o;
    EditText p;
    EditText q;
    SharedPreferences r;
    Button s;
    boolean t = false;
    Thread u;
    Socket v;
    private Runnable w = new Runnable(this) {
        final /* synthetic */ MainActivity a;

        {
            this.a = r1;
        }

        public void run() {
            this.a.m.runOnUiThread(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.a.n.append("\nStart to connect socket...\n");
                    this.a.a.s.setEnabled(false);
                }
            });
            try {
                String obj = this.a.p.getText().toString();
                int parseInt = Integer.parseInt(this.a.q.getText().toString());
                this.a.v = new Socket(obj, parseInt);
                this.a.t = true;
            } catch (IOException e) {
                final String message = e.getMessage();
                this.a.t = false;
                this.a.m.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 b;

                    public void run() {
                        this.b.a.n.append(message + "\n");
                        this.b.a.p.setFocusableInTouchMode(true);
                        this.b.a.q.setFocusableInTouchMode(true);
                        this.b.a.s.setEnabled(true);
                    }
                });
                e.printStackTrace();
            }
            if (this.a.t) {
                this.a.m.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 a;

                    {
                        this.a = r1;
                    }

                    public void run() {
                        this.a.a.n.append("\nSocket is connected\n");
                        this.a.a.s.setText("Disconnect");
                        this.a.a.s.setEnabled(true);
                    }
                });
            }
        }
    };

    private void a(final String str) {
        if (this.v.isConnected()) {
            new Thread(new Runnable(this) {
                final /* synthetic */ MainActivity b;

                public void run() {
                    try {
                        this.b.m.runOnUiThread(new Runnable(this) {
                            final /* synthetic */ AnonymousClass3 a;

                            {
                                this.a = r1;
                            }

                            public void run() {
                                this.a.b.o.getText().clear();
                            }
                        });
                        if (this.b.v.isClosed()) {
                            Log.d("MFG_TEST", "socket is closed");
                            this.b.v.connect(new InetSocketAddress(this.b.p.getText().toString(), Integer.parseInt(this.b.q.getText().toString())));
                            SystemClock.sleep(5000);
                        }
                        PrintWriter printWriter = new PrintWriter(this.b.v.getOutputStream());
                        printWriter.println(str);
                        printWriter.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.b.finish();
                    }
                }
            }).start();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_send:
                MainActivity mainActivity = this.m;
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
                if (this.t) {
                    Log.d("MFG_TEST", "bConnect = true, start disconnect");
                    this.r.edit().putString("IP", this.p.getText().toString()).putString("Port", this.q.getText().toString()).commit();
                    Log.d("MFG_TEST", "save IP: \"" + this.p.getText().toString() + "\", port: \"" + this.q.getText().toString() + "\" to SharedPreferences.");
                    try {
                        if (this.v.isConnected() && !this.v.isClosed()) {
                            this.v.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    SystemClock.sleep(500);
                    finish();
                    return;
                } else if (!this.t) {
                    Log.d("MFG_TEST", "bConnect = false, start connect");
                    this.p.setFocusableInTouchMode(false);
                    this.q.setFocusableInTouchMode(false);
                    this.o.requestFocus();
                    this.u = new Thread(this.w);
                    this.u.start();
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
        this.m = this;
        this.s = (Button) findViewById(R.id.btn_send);
        this.o = (EditText) findViewById(R.id.edt_send_message);
        this.o.setInputType(0);
        this.n = (TextView) findViewById(R.id.tv_reply_from_server);
        this.p = (EditText) findViewById(R.id.edt_IP);
        this.q = (EditText) findViewById(R.id.edt_port);
        this.r = getSharedPreferences("User", 0);
        CharSequence string = this.r.getString("IP", "Not Value");
        CharSequence string2 = this.r.getString("Port", "Not Value");
        if (!string.equals("Not Value")) {
            this.p.setText(string);
        }
        if (!string2.equals("Not Value")) {
            this.q.setText(string2);
        }
        this.s.setOnClickListener(this);
        this.o.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ MainActivity a;

            {
                this.a = r1;
            }

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                SystemClock.sleep(300);
                if (!this.a.o.getText().toString().equals("")) {
                    this.a.m.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 a;

                        {
                            this.a = r1;
                        }

                        public void run() {
                            this.a.a.a(this.a.a.o.getText().toString());
                            this.a.a.n.append("send \"" + this.a.a.o.getText().toString() + "\" to Server\n");
                        }
                    });
                }
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
