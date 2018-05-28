package android.support.v4.g;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class as {
    static final g a;
    private WeakReference<View> b;
    private Runnable c = null;
    private Runnable d = null;
    private int e = -1;

    interface g {
        long a(as asVar, View view);

        void a(as asVar, View view, float f);

        void a(as asVar, View view, long j);

        void a(as asVar, View view, aw awVar);

        void a(as asVar, View view, ay ayVar);

        void a(as asVar, View view, Interpolator interpolator);

        void b(as asVar, View view);

        void b(as asVar, View view, float f);

        void b(as asVar, View view, long j);

        void c(as asVar, View view);
    }

    static class a implements g {
        WeakHashMap<View, Runnable> a = null;

        class a implements Runnable {
            WeakReference<View> a;
            as b;
            final /* synthetic */ a c;

            private a(a aVar, as asVar, View view) {
                this.c = aVar;
                this.a = new WeakReference(view);
                this.b = asVar;
            }

            public void run() {
                View view = (View) this.a.get();
                if (view != null) {
                    this.c.d(this.b, view);
                }
            }
        }

        a() {
        }

        private void a(View view) {
            if (this.a != null) {
                Runnable runnable = (Runnable) this.a.get(view);
                if (runnable != null) {
                    view.removeCallbacks(runnable);
                }
            }
        }

        private void d(as asVar, View view) {
            Object tag = view.getTag(2113929216);
            aw awVar = tag instanceof aw ? (aw) tag : null;
            Runnable a = asVar.c;
            Runnable b = asVar.d;
            asVar.c = null;
            asVar.d = null;
            if (a != null) {
                a.run();
            }
            if (awVar != null) {
                awVar.a(view);
                awVar.b(view);
            }
            if (b != null) {
                b.run();
            }
            if (this.a != null) {
                this.a.remove(view);
            }
        }

        private void e(as asVar, View view) {
            Runnable runnable = this.a != null ? (Runnable) this.a.get(view) : null;
            if (runnable == null) {
                runnable = new a(asVar, view);
                if (this.a == null) {
                    this.a = new WeakHashMap();
                }
                this.a.put(view, runnable);
            }
            view.removeCallbacks(runnable);
            view.post(runnable);
        }

        public long a(as asVar, View view) {
            return 0;
        }

        public void a(as asVar, View view, float f) {
            e(asVar, view);
        }

        public void a(as asVar, View view, long j) {
        }

        public void a(as asVar, View view, aw awVar) {
            view.setTag(2113929216, awVar);
        }

        public void a(as asVar, View view, ay ayVar) {
        }

        public void a(as asVar, View view, Interpolator interpolator) {
        }

        public void b(as asVar, View view) {
            e(asVar, view);
        }

        public void b(as asVar, View view, float f) {
            e(asVar, view);
        }

        public void b(as asVar, View view, long j) {
        }

        public void c(as asVar, View view) {
            a(view);
            d(asVar, view);
        }
    }

    static class b extends a {
        WeakHashMap<View, Integer> b = null;

        static class a implements aw {
            as a;
            boolean b;

            a(as asVar) {
                this.a = asVar;
            }

            public void a(View view) {
                this.b = false;
                if (this.a.e >= 0) {
                    ae.a(view, 2, null);
                }
                if (this.a.c != null) {
                    Runnable a = this.a.c;
                    this.a.c = null;
                    a.run();
                }
                Object tag = view.getTag(2113929216);
                aw awVar = tag instanceof aw ? (aw) tag : null;
                if (awVar != null) {
                    awVar.a(view);
                }
            }

            public void b(View view) {
                if (this.a.e >= 0) {
                    ae.a(view, this.a.e, null);
                    this.a.e = -1;
                }
                if (VERSION.SDK_INT >= 16 || !this.b) {
                    if (this.a.d != null) {
                        Runnable b = this.a.d;
                        this.a.d = null;
                        b.run();
                    }
                    Object tag = view.getTag(2113929216);
                    aw awVar = tag instanceof aw ? (aw) tag : null;
                    if (awVar != null) {
                        awVar.b(view);
                    }
                    this.b = true;
                }
            }

            public void c(View view) {
                Object tag = view.getTag(2113929216);
                aw awVar = tag instanceof aw ? (aw) tag : null;
                if (awVar != null) {
                    awVar.c(view);
                }
            }
        }

        b() {
        }

        public long a(as asVar, View view) {
            return at.a(view);
        }

        public void a(as asVar, View view, float f) {
            at.a(view, f);
        }

        public void a(as asVar, View view, long j) {
            at.a(view, j);
        }

        public void a(as asVar, View view, aw awVar) {
            view.setTag(2113929216, awVar);
            at.a(view, new a(asVar));
        }

        public void a(as asVar, View view, Interpolator interpolator) {
            at.a(view, interpolator);
        }

        public void b(as asVar, View view) {
            at.b(view);
        }

        public void b(as asVar, View view, float f) {
            at.b(view, f);
        }

        public void b(as asVar, View view, long j) {
            at.b(view, j);
        }

        public void c(as asVar, View view) {
            at.c(view);
        }
    }

    static class d extends b {
        d() {
        }

        public void a(as asVar, View view, aw awVar) {
            au.a(view, awVar);
        }
    }

    static class c extends d {
        c() {
        }
    }

    static class e extends c {
        e() {
        }

        public void a(as asVar, View view, ay ayVar) {
            av.a(view, ayVar);
        }
    }

    static class f extends e {
        f() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            a = new f();
        } else if (i >= 19) {
            a = new e();
        } else if (i >= 18) {
            a = new c();
        } else if (i >= 16) {
            a = new d();
        } else if (i >= 14) {
            a = new b();
        } else {
            a = new a();
        }
    }

    as(View view) {
        this.b = new WeakReference(view);
    }

    public long a() {
        View view = (View) this.b.get();
        return view != null ? a.a(this, view) : 0;
    }

    public as a(float f) {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view, f);
        }
        return this;
    }

    public as a(long j) {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view, j);
        }
        return this;
    }

    public as a(aw awVar) {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view, awVar);
        }
        return this;
    }

    public as a(ay ayVar) {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view, ayVar);
        }
        return this;
    }

    public as a(Interpolator interpolator) {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view, interpolator);
        }
        return this;
    }

    public as b(float f) {
        View view = (View) this.b.get();
        if (view != null) {
            a.b(this, view, f);
        }
        return this;
    }

    public as b(long j) {
        View view = (View) this.b.get();
        if (view != null) {
            a.b(this, view, j);
        }
        return this;
    }

    public void b() {
        View view = (View) this.b.get();
        if (view != null) {
            a.b(this, view);
        }
    }

    public void c() {
        View view = (View) this.b.get();
        if (view != null) {
            a.c(this, view);
        }
    }
}
