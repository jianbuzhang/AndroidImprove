package android.support.v4.g;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.view.View;
import java.util.WeakHashMap;

public class ae {
    static final l a;

    interface l {
        int a(int i, int i2, int i3);

        az a(View view, az azVar);

        void a(View view);

        void a(View view, float f);

        void a(View view, int i, int i2);

        void a(View view, int i, Paint paint);

        void a(View view, ColorStateList colorStateList);

        void a(View view, Mode mode);

        void a(View view, b bVar);

        void a(View view, z zVar);

        void a(View view, Runnable runnable);

        void a(View view, Runnable runnable, long j);

        void a(View view, boolean z);

        boolean a(View view, int i);

        int b(View view);

        void b(View view, float f);

        void b(View view, boolean z);

        int c(View view);

        void c(View view, float f);

        int d(View view);

        int e(View view);

        boolean f(View view);

        float g(View view);

        int h(View view);

        as i(View view);

        int j(View view);

        void k(View view);

        void l(View view);

        ColorStateList m(View view);

        Mode n(View view);

        void o(View view);

        boolean p(View view);

        boolean q(View view);

        boolean r(View view);
    }

    static class b implements l {
        WeakHashMap<View, as> a = null;

        b() {
        }

        private boolean a(aa aaVar, int i) {
            int computeVerticalScrollOffset = aaVar.computeVerticalScrollOffset();
            int computeVerticalScrollRange = aaVar.computeVerticalScrollRange() - aaVar.computeVerticalScrollExtent();
            return computeVerticalScrollRange == 0 ? false : i < 0 ? computeVerticalScrollOffset > 0 : computeVerticalScrollOffset < computeVerticalScrollRange + -1;
        }

        public int a(int i, int i2, int i3) {
            return View.resolveSize(i, i2);
        }

        long a() {
            return 10;
        }

        public az a(View view, az azVar) {
            return azVar;
        }

        public void a(View view) {
            view.invalidate();
        }

        public void a(View view, float f) {
        }

        public void a(View view, int i, int i2) {
        }

        public void a(View view, int i, Paint paint) {
        }

        public void a(View view, ColorStateList colorStateList) {
            af.a(view, colorStateList);
        }

        public void a(View view, Mode mode) {
            af.a(view, mode);
        }

        public void a(View view, b bVar) {
        }

        public void a(View view, z zVar) {
        }

        public void a(View view, Runnable runnable) {
            view.postDelayed(runnable, a());
        }

        public void a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, a() + j);
        }

        public void a(View view, boolean z) {
        }

        public boolean a(View view, int i) {
            return (view instanceof aa) && a((aa) view, i);
        }

        public int b(View view) {
            return 0;
        }

        public void b(View view, float f) {
        }

        public void b(View view, boolean z) {
        }

        public int c(View view) {
            return 0;
        }

        public void c(View view, float f) {
        }

        public int d(View view) {
            return view.getMeasuredWidth();
        }

        public int e(View view) {
            return 0;
        }

        public boolean f(View view) {
            return true;
        }

        public float g(View view) {
            return 0.0f;
        }

        public int h(View view) {
            return af.d(view);
        }

        public as i(View view) {
            return new as(view);
        }

        public int j(View view) {
            return 0;
        }

        public void k(View view) {
        }

        public void l(View view) {
        }

        public ColorStateList m(View view) {
            return af.a(view);
        }

        public Mode n(View view) {
            return af.b(view);
        }

        public void o(View view) {
            if (view instanceof v) {
                ((v) view).stopNestedScroll();
            }
        }

        public boolean p(View view) {
            return af.c(view);
        }

        public boolean q(View view) {
            return af.e(view);
        }

        public boolean r(View view) {
            return false;
        }
    }

    static class c extends b {
        c() {
        }

        public int a(int i, int i2, int i3) {
            return ag.a(i, i2, i3);
        }

        long a() {
            return ag.a();
        }

        public void a(View view, float f) {
            ag.a(view, f);
        }

        public void a(View view, int i, Paint paint) {
            ag.a(view, i, paint);
        }

        public void a(View view, boolean z) {
            ag.a(view, z);
        }

        public int b(View view) {
            return ag.a(view);
        }

        public void b(View view, float f) {
            ag.b(view, f);
        }

        public void b(View view, boolean z) {
            ag.b(view, z);
        }

        public int d(View view) {
            return ag.b(view);
        }

        public int e(View view) {
            return ag.c(view);
        }

        public float g(View view) {
            return ag.d(view);
        }

        public void l(View view) {
            ag.e(view);
        }
    }

    static class e extends c {
        static boolean b = false;

        e() {
        }

        public void a(View view, b bVar) {
            ah.a(view, bVar == null ? null : bVar.a());
        }

        public boolean a(View view, int i) {
            return ah.a(view, i);
        }

        public as i(View view) {
            if (this.a == null) {
                this.a = new WeakHashMap();
            }
            as asVar = (as) this.a.get(view);
            if (asVar != null) {
                return asVar;
            }
            asVar = new as(view);
            this.a.put(view, asVar);
            return asVar;
        }
    }

    static class d extends e {
        d() {
        }

        public boolean r(View view) {
            return ai.a(view);
        }
    }

    static class f extends d {
        f() {
        }

        public void a(View view) {
            aj.a(view);
        }

        public void a(View view, Runnable runnable) {
            aj.a(view, runnable);
        }

        public void a(View view, Runnable runnable, long j) {
            aj.a(view, runnable, j);
        }

        public boolean f(View view) {
            return aj.d(view);
        }

        public int h(View view) {
            return aj.b(view);
        }

        public void k(View view) {
            aj.c(view);
        }
    }

    static class g extends f {
        g() {
        }

        public int c(View view) {
            return ak.a(view);
        }

        public int j(View view) {
            return ak.b(view);
        }
    }

    static class h extends g {
        h() {
        }
    }

    static class i extends h {
        i() {
        }

        public boolean p(View view) {
            return al.a(view);
        }

        public boolean q(View view) {
            return al.b(view);
        }
    }

    static class j extends i {
        j() {
        }

        public az a(View view, az azVar) {
            return az.a(am.a(view, az.a(azVar)));
        }

        public void a(View view, ColorStateList colorStateList) {
            am.a(view, colorStateList);
        }

        public void a(View view, Mode mode) {
            am.a(view, mode);
        }

        public void a(View view, final z zVar) {
            if (zVar == null) {
                am.a(view, null);
            } else {
                am.a(view, new android.support.v4.g.am.a(this) {
                    final /* synthetic */ j b;

                    public Object a(View view, Object obj) {
                        return az.a(zVar.a(view, az.a(obj)));
                    }
                });
            }
        }

        public void c(View view, float f) {
            am.a(view, f);
        }

        public void k(View view) {
            am.a(view);
        }

        public ColorStateList m(View view) {
            return am.b(view);
        }

        public Mode n(View view) {
            return am.c(view);
        }

        public void o(View view) {
            am.d(view);
        }
    }

    static class k extends j {
        k() {
        }

        public void a(View view, int i, int i2) {
            an.a(view, i, i2);
        }
    }

    static class a extends k {
        a() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (android.support.v4.e.c.a()) {
            a = new a();
        } else if (i >= 23) {
            a = new k();
        } else if (i >= 21) {
            a = new j();
        } else if (i >= 19) {
            a = new i();
        } else if (i >= 18) {
            a = new h();
        } else if (i >= 17) {
            a = new g();
        } else if (i >= 16) {
            a = new f();
        } else if (i >= 15) {
            a = new d();
        } else if (i >= 14) {
            a = new e();
        } else if (i >= 11) {
            a = new c();
        } else {
            a = new b();
        }
    }

    public static int a(int i, int i2, int i3) {
        return a.a(i, i2, i3);
    }

    public static az a(View view, az azVar) {
        return a.a(view, azVar);
    }

    public static void a(View view) {
        a.a(view);
    }

    public static void a(View view, float f) {
        a.a(view, f);
    }

    public static void a(View view, int i, int i2) {
        a.a(view, i, i2);
    }

    public static void a(View view, int i, Paint paint) {
        a.a(view, i, paint);
    }

    public static void a(View view, ColorStateList colorStateList) {
        a.a(view, colorStateList);
    }

    public static void a(View view, Mode mode) {
        a.a(view, mode);
    }

    public static void a(View view, b bVar) {
        a.a(view, bVar);
    }

    public static void a(View view, z zVar) {
        a.a(view, zVar);
    }

    public static void a(View view, Runnable runnable) {
        a.a(view, runnable);
    }

    public static void a(View view, Runnable runnable, long j) {
        a.a(view, runnable, j);
    }

    public static void a(View view, boolean z) {
        a.a(view, z);
    }

    public static boolean a(View view, int i) {
        return a.a(view, i);
    }

    public static int b(View view) {
        return a.b(view);
    }

    public static void b(View view, float f) {
        a.b(view, f);
    }

    public static void b(View view, boolean z) {
        a.b(view, z);
    }

    public static int c(View view) {
        return a.c(view);
    }

    public static void c(View view, float f) {
        a.c(view, f);
    }

    public static int d(View view) {
        return a.d(view);
    }

    public static int e(View view) {
        return a.e(view);
    }

    public static float f(View view) {
        return a.g(view);
    }

    public static int g(View view) {
        return a.h(view);
    }

    public static as h(View view) {
        return a.i(view);
    }

    public static int i(View view) {
        return a.j(view);
    }

    public static void j(View view) {
        a.k(view);
    }

    public static void k(View view) {
        a.l(view);
    }

    public static boolean l(View view) {
        return a.f(view);
    }

    public static ColorStateList m(View view) {
        return a.m(view);
    }

    public static Mode n(View view) {
        return a.n(view);
    }

    public static void o(View view) {
        a.o(view);
    }

    public static boolean p(View view) {
        return a.p(view);
    }

    public static boolean q(View view) {
        return a.q(view);
    }

    public static boolean r(View view) {
        return a.r(view);
    }
}
