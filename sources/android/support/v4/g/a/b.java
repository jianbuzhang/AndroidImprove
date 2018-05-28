package android.support.v4.g.a;

import android.graphics.Rect;
import android.os.Build.VERSION;

public class b {
    private static final f a;
    private final Object b;

    interface f {
        int a(Object obj);

        void a(Object obj, int i);

        void a(Object obj, Rect rect);

        void a(Object obj, CharSequence charSequence);

        void a(Object obj, boolean z);

        CharSequence b(Object obj);

        void b(Object obj, Rect rect);

        CharSequence c(Object obj);

        CharSequence d(Object obj);

        CharSequence e(Object obj);

        boolean f(Object obj);

        boolean g(Object obj);

        boolean h(Object obj);

        boolean i(Object obj);

        boolean j(Object obj);

        boolean k(Object obj);

        boolean l(Object obj);

        boolean m(Object obj);

        boolean n(Object obj);

        boolean o(Object obj);

        String p(Object obj);
    }

    static class k implements f {
        k() {
        }

        public int a(Object obj) {
            return 0;
        }

        public void a(Object obj, int i) {
        }

        public void a(Object obj, Rect rect) {
        }

        public void a(Object obj, CharSequence charSequence) {
        }

        public void a(Object obj, boolean z) {
        }

        public CharSequence b(Object obj) {
            return null;
        }

        public void b(Object obj, Rect rect) {
        }

        public CharSequence c(Object obj) {
            return null;
        }

        public CharSequence d(Object obj) {
            return null;
        }

        public CharSequence e(Object obj) {
            return null;
        }

        public boolean f(Object obj) {
            return false;
        }

        public boolean g(Object obj) {
            return false;
        }

        public boolean h(Object obj) {
            return false;
        }

        public boolean i(Object obj) {
            return false;
        }

        public boolean j(Object obj) {
            return false;
        }

        public boolean k(Object obj) {
            return false;
        }

        public boolean l(Object obj) {
            return false;
        }

        public boolean m(Object obj) {
            return false;
        }

        public boolean n(Object obj) {
            return false;
        }

        public boolean o(Object obj) {
            return false;
        }

        public String p(Object obj) {
            return null;
        }
    }

    static class e extends k {
        e() {
        }

        public int a(Object obj) {
            return c.a(obj);
        }

        public void a(Object obj, int i) {
            c.a(obj, i);
        }

        public void a(Object obj, Rect rect) {
            c.a(obj, rect);
        }

        public void a(Object obj, CharSequence charSequence) {
            c.a(obj, charSequence);
        }

        public void a(Object obj, boolean z) {
            c.a(obj, z);
        }

        public CharSequence b(Object obj) {
            return c.b(obj);
        }

        public void b(Object obj, Rect rect) {
            c.b(obj, rect);
        }

        public CharSequence c(Object obj) {
            return c.c(obj);
        }

        public CharSequence d(Object obj) {
            return c.d(obj);
        }

        public CharSequence e(Object obj) {
            return c.e(obj);
        }

        public boolean f(Object obj) {
            return c.f(obj);
        }

        public boolean g(Object obj) {
            return c.g(obj);
        }

        public boolean h(Object obj) {
            return c.h(obj);
        }

        public boolean i(Object obj) {
            return c.i(obj);
        }

        public boolean j(Object obj) {
            return c.j(obj);
        }

        public boolean k(Object obj) {
            return c.k(obj);
        }

        public boolean l(Object obj) {
            return c.l(obj);
        }

        public boolean m(Object obj) {
            return c.m(obj);
        }

        public boolean n(Object obj) {
            return c.n(obj);
        }

        public boolean o(Object obj) {
            return c.o(obj);
        }
    }

    static class g extends e {
        g() {
        }
    }

    static class h extends g {
        h() {
        }
    }

    static class i extends h {
        i() {
        }

        public String p(Object obj) {
            return d.a(obj);
        }
    }

    static class j extends i {
        j() {
        }
    }

    static class a extends j {
        a() {
        }
    }

    static class b extends a {
        b() {
        }
    }

    static class c extends b {
        c() {
        }
    }

    static class d extends c {
        d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 24) {
            a = new d();
        } else if (VERSION.SDK_INT >= 23) {
            a = new c();
        } else if (VERSION.SDK_INT >= 22) {
            a = new b();
        } else if (VERSION.SDK_INT >= 21) {
            a = new a();
        } else if (VERSION.SDK_INT >= 19) {
            a = new j();
        } else if (VERSION.SDK_INT >= 18) {
            a = new i();
        } else if (VERSION.SDK_INT >= 17) {
            a = new h();
        } else if (VERSION.SDK_INT >= 16) {
            a = new g();
        } else if (VERSION.SDK_INT >= 14) {
            a = new e();
        } else {
            a = new k();
        }
    }

    public b(Object obj) {
        this.b = obj;
    }

    private static String b(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case android.support.v7.b.a.j.AppCompatTheme_actionModeCutDrawable /*32*/:
                return "ACTION_LONG_CLICK";
            case android.support.v7.b.a.j.AppCompatTheme_editTextBackground /*64*/:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    public Object a() {
        return this.b;
    }

    public void a(int i) {
        a.a(this.b, i);
    }

    public void a(Rect rect) {
        a.a(this.b, rect);
    }

    public void a(CharSequence charSequence) {
        a.a(this.b, charSequence);
    }

    public void a(boolean z) {
        a.a(this.b, z);
    }

    public int b() {
        return a.a(this.b);
    }

    public void b(Rect rect) {
        a.b(this.b, rect);
    }

    public boolean c() {
        return a.f(this.b);
    }

    public boolean d() {
        return a.g(this.b);
    }

    public boolean e() {
        return a.j(this.b);
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
        b bVar = (b) obj;
        return this.b == null ? bVar.b == null : this.b.equals(bVar.b);
    }

    public boolean f() {
        return a.k(this.b);
    }

    public boolean g() {
        return a.o(this.b);
    }

    public boolean h() {
        return a.h(this.b);
    }

    public int hashCode() {
        return this.b == null ? 0 : this.b.hashCode();
    }

    public boolean i() {
        return a.l(this.b);
    }

    public boolean j() {
        return a.i(this.b);
    }

    public boolean k() {
        return a.m(this.b);
    }

    public boolean l() {
        return a.n(this.b);
    }

    public CharSequence m() {
        return a.d(this.b);
    }

    public CharSequence n() {
        return a.b(this.b);
    }

    public CharSequence o() {
        return a.e(this.b);
    }

    public CharSequence p() {
        return a.c(this.b);
    }

    public String q() {
        return a.p(this.b);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        b(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(m());
        stringBuilder.append("; className: ").append(n());
        stringBuilder.append("; text: ").append(o());
        stringBuilder.append("; contentDescription: ").append(p());
        stringBuilder.append("; viewId: ").append(q());
        stringBuilder.append("; checkable: ").append(c());
        stringBuilder.append("; checked: ").append(d());
        stringBuilder.append("; focusable: ").append(e());
        stringBuilder.append("; focused: ").append(f());
        stringBuilder.append("; selected: ").append(g());
        stringBuilder.append("; clickable: ").append(h());
        stringBuilder.append("; longClickable: ").append(i());
        stringBuilder.append("; enabled: ").append(j());
        stringBuilder.append("; password: ").append(k());
        stringBuilder.append("; scrollable: " + l());
        stringBuilder.append("; [");
        int b = b();
        while (b != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b);
            b &= numberOfTrailingZeros ^ -1;
            stringBuilder.append(b(numberOfTrailingZeros));
            if (b != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
