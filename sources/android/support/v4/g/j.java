package android.support.v4.g;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

public final class j {
    static final a a;

    interface a {
        n a(LayoutInflater layoutInflater);

        void a(LayoutInflater layoutInflater, n nVar);
    }

    static class b implements a {
        b() {
        }

        public n a(LayoutInflater layoutInflater) {
            return k.a(layoutInflater);
        }

        public void a(LayoutInflater layoutInflater, n nVar) {
            k.a(layoutInflater, nVar);
        }
    }

    static class c extends b {
        c() {
        }

        public void a(LayoutInflater layoutInflater, n nVar) {
            l.a(layoutInflater, nVar);
        }
    }

    static class d extends c {
        d() {
        }

        public void a(LayoutInflater layoutInflater, n nVar) {
            m.a(layoutInflater, nVar);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            a = new d();
        } else if (i >= 11) {
            a = new c();
        } else {
            a = new b();
        }
    }

    public static n a(LayoutInflater layoutInflater) {
        return a.a(layoutInflater);
    }

    public static void a(LayoutInflater layoutInflater, n nVar) {
        a.a(layoutInflater, nVar);
    }
}
