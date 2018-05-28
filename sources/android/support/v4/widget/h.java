package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public final class h {
    private static final c b;
    private Object a;

    interface c {
        Object a(Context context);

        void a(Object obj, int i, int i2);

        boolean a(Object obj);

        boolean a(Object obj, float f, float f2);

        boolean a(Object obj, int i);

        boolean a(Object obj, Canvas canvas);

        boolean b(Object obj);
    }

    static class a implements c {
        a() {
        }

        public Object a(Context context) {
            return null;
        }

        public void a(Object obj, int i, int i2) {
        }

        public boolean a(Object obj) {
            return true;
        }

        public boolean a(Object obj, float f, float f2) {
            return false;
        }

        public boolean a(Object obj, int i) {
            return false;
        }

        public boolean a(Object obj, Canvas canvas) {
            return false;
        }

        public boolean b(Object obj) {
            return false;
        }
    }

    static class b implements c {
        b() {
        }

        public Object a(Context context) {
            return i.a(context);
        }

        public void a(Object obj, int i, int i2) {
            i.a(obj, i, i2);
        }

        public boolean a(Object obj) {
            return i.a(obj);
        }

        public boolean a(Object obj, float f, float f2) {
            return i.a(obj, f);
        }

        public boolean a(Object obj, int i) {
            return i.a(obj, i);
        }

        public boolean a(Object obj, Canvas canvas) {
            return i.a(obj, canvas);
        }

        public boolean b(Object obj) {
            return i.b(obj);
        }
    }

    static class d extends b {
        d() {
        }

        public boolean a(Object obj, float f, float f2) {
            return j.a(obj, f, f2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            b = new d();
        } else if (VERSION.SDK_INT >= 14) {
            b = new b();
        } else {
            b = new a();
        }
    }

    public h(Context context) {
        this.a = b.a(context);
    }

    public void a(int i, int i2) {
        b.a(this.a, i, i2);
    }

    public boolean a() {
        return b.a(this.a);
    }

    public boolean a(float f, float f2) {
        return b.a(this.a, f, f2);
    }

    public boolean a(int i) {
        return b.a(this.a, i);
    }

    public boolean a(Canvas canvas) {
        return b.a(this.a, canvas);
    }

    public boolean b() {
        return b.b(this.a);
    }
}
