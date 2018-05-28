package android.support.v7.view;

import android.support.v4.g.as;
import android.support.v4.g.aw;
import android.support.v4.g.ax;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class h {
    private final ArrayList<as> a = new ArrayList();
    private long b = -1;
    private Interpolator c;
    private aw d;
    private boolean e;
    private final ax f = new ax(this) {
        final /* synthetic */ h a;
        private boolean b = false;
        private int c = 0;

        {
            this.a = r2;
        }

        void a() {
            this.c = 0;
            this.b = false;
            this.a.c();
        }

        public void a(View view) {
            if (!this.b) {
                this.b = true;
                if (this.a.d != null) {
                    this.a.d.a(null);
                }
            }
        }

        public void b(View view) {
            int i = this.c + 1;
            this.c = i;
            if (i == this.a.a.size()) {
                if (this.a.d != null) {
                    this.a.d.b(null);
                }
                a();
            }
        }
    };

    private void c() {
        this.e = false;
    }

    public h a(long j) {
        if (!this.e) {
            this.b = j;
        }
        return this;
    }

    public h a(as asVar) {
        if (!this.e) {
            this.a.add(asVar);
        }
        return this;
    }

    public h a(as asVar, as asVar2) {
        this.a.add(asVar);
        asVar2.b(asVar.a());
        this.a.add(asVar2);
        return this;
    }

    public h a(aw awVar) {
        if (!this.e) {
            this.d = awVar;
        }
        return this;
    }

    public h a(Interpolator interpolator) {
        if (!this.e) {
            this.c = interpolator;
        }
        return this;
    }

    public void a() {
        if (!this.e) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                as asVar = (as) it.next();
                if (this.b >= 0) {
                    asVar.a(this.b);
                }
                if (this.c != null) {
                    asVar.a(this.c);
                }
                if (this.d != null) {
                    asVar.a(this.f);
                }
                asVar.c();
            }
            this.e = true;
        }
    }

    public void b() {
        if (this.e) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((as) it.next()).b();
            }
            this.e = false;
        }
    }
}
