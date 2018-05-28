package android.support.v4.g.a;

import android.os.Build.VERSION;

public class h {
    private static final c a;
    private final Object b;

    interface c {
        void a(Object obj, int i);

        void a(Object obj, boolean z);

        void b(Object obj, int i);

        void c(Object obj, int i);

        void d(Object obj, int i);
    }

    static class e implements c {
        e() {
        }

        public void a(Object obj, int i) {
        }

        public void a(Object obj, boolean z) {
        }

        public void b(Object obj, int i) {
        }

        public void c(Object obj, int i) {
        }

        public void d(Object obj, int i) {
        }
    }

    static class a extends e {
        a() {
        }

        public void a(Object obj, int i) {
            i.a(obj, i);
        }

        public void a(Object obj, boolean z) {
            i.a(obj, z);
        }

        public void b(Object obj, int i) {
            i.b(obj, i);
        }
    }

    static class b extends a {
        b() {
        }

        public void c(Object obj, int i) {
            j.a(obj, i);
        }

        public void d(Object obj, int i) {
            j.b(obj, i);
        }
    }

    static class d extends b {
        d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            a = new d();
        } else if (VERSION.SDK_INT >= 15) {
            a = new b();
        } else if (VERSION.SDK_INT >= 14) {
            a = new a();
        } else {
            a = new e();
        }
    }

    @Deprecated
    public h(Object obj) {
        this.b = obj;
    }

    public void a(int i) {
        a.a(this.b, i);
    }

    public void a(boolean z) {
        a.a(this.b, z);
    }

    public void b(int i) {
        a.b(this.b, i);
    }

    public void c(int i) {
        a.c(this.b, i);
    }

    public void d(int i) {
        a.d(this.b, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.b == null ? hVar.b == null : this.b.equals(hVar.b);
    }

    public int hashCode() {
        return this.b == null ? 0 : this.b.hashCode();
    }
}
