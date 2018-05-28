package android.support.v4.g;

import android.os.Build.VERSION;

public class az {
    private static final d a;
    private final Object b;

    private interface d {
        int a(Object obj);

        az a(Object obj, int i, int i2, int i3, int i4);

        int b(Object obj);

        int c(Object obj);

        int d(Object obj);
    }

    private static class c implements d {
        private c() {
        }

        public int a(Object obj) {
            return 0;
        }

        public az a(Object obj, int i, int i2, int i3, int i4) {
            return null;
        }

        public int b(Object obj) {
            return 0;
        }

        public int c(Object obj) {
            return 0;
        }

        public int d(Object obj) {
            return 0;
        }
    }

    private static class a extends c {
        private a() {
            super();
        }

        public int a(Object obj) {
            return ba.a(obj);
        }

        public az a(Object obj, int i, int i2, int i3, int i4) {
            return new az(ba.a(obj, i, i2, i3, i4));
        }

        public int b(Object obj) {
            return ba.b(obj);
        }

        public int c(Object obj) {
            return ba.c(obj);
        }

        public int d(Object obj) {
            return ba.d(obj);
        }
    }

    private static class b extends a {
        private b() {
            super();
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            a = new b();
        } else if (i >= 20) {
            a = new a();
        } else {
            a = new c();
        }
    }

    private az(Object obj) {
        this.b = obj;
    }

    static az a(Object obj) {
        return obj == null ? null : new az(obj);
    }

    static Object a(az azVar) {
        return azVar == null ? null : azVar.b;
    }

    public int a() {
        return a.b(this.b);
    }

    public az a(int i, int i2, int i3, int i4) {
        return a.a(this.b, i, i2, i3, i4);
    }

    public int b() {
        return a.d(this.b);
    }

    public int c() {
        return a.c(this.b);
    }

    public int d() {
        return a.a(this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        az azVar = (az) obj;
        return this.b == null ? azVar.b == null : this.b.equals(azVar.b);
    }

    public int hashCode() {
        return this.b == null ? 0 : this.b.hashCode();
    }
}
