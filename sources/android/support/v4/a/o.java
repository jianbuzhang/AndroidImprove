package android.support.v4.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v4.f.h;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class o<E> extends m {
    private final Activity a;
    final Context b;
    final int c;
    final q d;
    private final Handler e;
    private h<String, w> f;
    private boolean g;
    private x h;
    private boolean i;
    private boolean j;

    o(Activity activity, Context context, Handler handler, int i) {
        this.d = new q();
        this.a = activity;
        this.b = context;
        this.e = handler;
        this.c = i;
    }

    o(l lVar) {
        this(lVar, lVar, lVar.c, 0);
    }

    x a(String str, boolean z, boolean z2) {
        if (this.f == null) {
            this.f = new h();
        }
        x xVar = (x) this.f.get(str);
        if (xVar != null) {
            xVar.a(this);
            return xVar;
        } else if (!z2) {
            return xVar;
        } else {
            xVar = new x(str, this, z);
            this.f.put(str, xVar);
            return xVar;
        }
    }

    public View a(int i) {
        return null;
    }

    void a(h<String, w> hVar) {
        this.f = hVar;
    }

    void a(String str) {
        if (this.f != null) {
            x xVar = (x) this.f.get(str);
            if (xVar != null && !xVar.f) {
                xVar.h();
                this.f.remove(str);
            }
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    void a(boolean z) {
        this.g = z;
        if (this.h != null && this.j) {
            this.j = false;
            if (z) {
                this.h.d();
            } else {
                this.h.c();
            }
        }
    }

    public boolean a() {
        return true;
    }

    public boolean a(k kVar) {
        return true;
    }

    public LayoutInflater b() {
        return (LayoutInflater) this.b.getSystemService("layout_inflater");
    }

    void b(k kVar) {
    }

    void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.j);
        if (this.h != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.h)));
            printWriter.println(":");
            this.h.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public void c() {
    }

    public boolean d() {
        return true;
    }

    public int e() {
        return this.c;
    }

    Activity f() {
        return this.a;
    }

    Context g() {
        return this.b;
    }

    Handler h() {
        return this.e;
    }

    q i() {
        return this.d;
    }

    boolean j() {
        return this.g;
    }

    void k() {
        if (!this.j) {
            this.j = true;
            if (this.h != null) {
                this.h.b();
            } else if (!this.i) {
                this.h = a("(root)", this.j, false);
                if (!(this.h == null || this.h.e)) {
                    this.h.b();
                }
            }
            this.i = true;
        }
    }

    void l() {
        if (this.h != null) {
            this.h.h();
        }
    }

    void m() {
        if (this.f != null) {
            int size = this.f.size();
            x[] xVarArr = new x[size];
            for (int i = size - 1; i >= 0; i--) {
                xVarArr[i] = (x) this.f.c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                x xVar = xVarArr[i2];
                xVar.e();
                xVar.g();
            }
        }
    }

    h<String, w> n() {
        int i;
        int i2 = 0;
        if (this.f != null) {
            int size = this.f.size();
            x[] xVarArr = new x[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                xVarArr[i3] = (x) this.f.c(i3);
            }
            boolean j = j();
            i = 0;
            while (i2 < size) {
                x xVar = xVarArr[i2];
                if (!xVar.f && j) {
                    if (!xVar.e) {
                        xVar.b();
                    }
                    xVar.d();
                }
                if (xVar.f) {
                    i = 1;
                } else {
                    xVar.h();
                    this.f.remove(xVar.d);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        return i != 0 ? this.f : null;
    }
}
