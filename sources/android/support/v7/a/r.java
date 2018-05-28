package android.support.v7.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.g.ae;
import android.support.v4.g.as;
import android.support.v4.g.aw;
import android.support.v4.g.ax;
import android.support.v4.g.ay;
import android.support.v7.b.a.f;
import android.support.v7.b.a.j;
import android.support.v7.view.b;
import android.support.v7.view.g;
import android.support.v7.view.h;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ac;
import android.support.v7.widget.ao;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class r extends a implements android.support.v7.widget.ActionBarOverlayLayout.a {
    static final /* synthetic */ boolean h = (!r.class.desiredAssertionStatus());
    private static final Interpolator i = new AccelerateInterpolator();
    private static final Interpolator j = new DecelerateInterpolator();
    private static final boolean k;
    private boolean A;
    private int B = 0;
    private boolean C = true;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G = true;
    private h H;
    private boolean I;
    a a;
    b b;
    android.support.v7.view.b.a c;
    boolean d;
    final aw e = new ax(this) {
        final /* synthetic */ r a;

        {
            this.a = r1;
        }

        public void b(View view) {
            if (this.a.C && this.a.t != null) {
                ae.a(this.a.t, 0.0f);
                ae.a(this.a.q, 0.0f);
            }
            this.a.q.setVisibility(8);
            this.a.q.setTransitioning(false);
            this.a.H = null;
            this.a.i();
            if (this.a.p != null) {
                ae.j(this.a.p);
            }
        }
    };
    final aw f = new ax(this) {
        final /* synthetic */ r a;

        {
            this.a = r1;
        }

        public void b(View view) {
            this.a.H = null;
            this.a.q.requestLayout();
        }
    };
    final ay g = new ay(this) {
        final /* synthetic */ r a;

        {
            this.a = r1;
        }

        public void a(View view) {
            ((View) this.a.q.getParent()).invalidate();
        }
    };
    private Context l;
    private Context m;
    private Activity n;
    private Dialog o;
    private ActionBarOverlayLayout p;
    private ActionBarContainer q;
    private ac r;
    private ActionBarContextView s;
    private View t;
    private ao u;
    private ArrayList<Object> v = new ArrayList();
    private int w = -1;
    private boolean x;
    private boolean y;
    private ArrayList<a.b> z = new ArrayList();

    public class a extends b implements android.support.v7.view.menu.h.a {
        final /* synthetic */ r a;
        private final Context b;
        private final android.support.v7.view.menu.h c;
        private android.support.v7.view.b.a d;
        private WeakReference<View> e;

        public a(r rVar, Context context, android.support.v7.view.b.a aVar) {
            this.a = rVar;
            this.b = context;
            this.d = aVar;
            this.c = new android.support.v7.view.menu.h(context).a(1);
            this.c.a((android.support.v7.view.menu.h.a) this);
        }

        public MenuInflater a() {
            return new g(this.b);
        }

        public void a(int i) {
            b(this.a.l.getResources().getString(i));
        }

        public void a(android.support.v7.view.menu.h hVar) {
            if (this.d != null) {
                d();
                this.a.s.a();
            }
        }

        public void a(View view) {
            this.a.s.setCustomView(view);
            this.e = new WeakReference(view);
        }

        public void a(CharSequence charSequence) {
            this.a.s.setSubtitle(charSequence);
        }

        public void a(boolean z) {
            super.a(z);
            this.a.s.setTitleOptional(z);
        }

        public boolean a(android.support.v7.view.menu.h hVar, MenuItem menuItem) {
            return this.d != null ? this.d.a((b) this, menuItem) : false;
        }

        public Menu b() {
            return this.c;
        }

        public void b(int i) {
            a(this.a.l.getResources().getString(i));
        }

        public void b(CharSequence charSequence) {
            this.a.s.setTitle(charSequence);
        }

        public void c() {
            if (this.a.a == this) {
                if (r.b(this.a.D, this.a.E, false)) {
                    this.d.a(this);
                } else {
                    this.a.b = this;
                    this.a.c = this.d;
                }
                this.d = null;
                this.a.j(false);
                this.a.s.b();
                this.a.r.a().sendAccessibilityEvent(32);
                this.a.p.setHideOnContentScrollEnabled(this.a.d);
                this.a.a = null;
            }
        }

        public void d() {
            if (this.a.a == this) {
                this.c.g();
                try {
                    this.d.b(this, this.c);
                } finally {
                    this.c.h();
                }
            }
        }

        public boolean e() {
            this.c.g();
            try {
                boolean a = this.d.a((b) this, this.c);
                return a;
            } finally {
                this.c.h();
            }
        }

        public CharSequence f() {
            return this.a.s.getTitle();
        }

        public CharSequence g() {
            return this.a.s.getSubtitle();
        }

        public boolean h() {
            return this.a.s.d();
        }

        public View i() {
            return this.e != null ? (View) this.e.get() : null;
        }
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 14) {
            z = false;
        }
        k = z;
    }

    public r(Activity activity, boolean z) {
        this.n = activity;
        View decorView = activity.getWindow().getDecorView();
        a(decorView);
        if (!z) {
            this.t = decorView.findViewById(16908290);
        }
    }

    public r(Dialog dialog) {
        this.o = dialog;
        a(dialog.getWindow().getDecorView());
    }

    private void a(View view) {
        this.p = (ActionBarOverlayLayout) view.findViewById(f.decor_content_parent);
        if (this.p != null) {
            this.p.setActionBarVisibilityCallback(this);
        }
        this.r = b(view.findViewById(f.action_bar));
        this.s = (ActionBarContextView) view.findViewById(f.action_context_bar);
        this.q = (ActionBarContainer) view.findViewById(f.action_bar_container);
        if (this.r == null || this.s == null || this.q == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.l = this.r.b();
        boolean z = (this.r.o() & 4) != 0;
        if (z) {
            this.x = true;
        }
        android.support.v7.view.a a = android.support.v7.view.a.a(this.l);
        z = a.f() || z;
        a(z);
        k(a.d());
        TypedArray obtainStyledAttributes = this.l.obtainStyledAttributes(null, j.ActionBar, android.support.v7.b.a.a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(j.ActionBar_hideOnContentScroll, false)) {
            b(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private ac b(View view) {
        if (view instanceof ac) {
            return (ac) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException(new StringBuilder().append("Can't make a decor toolbar out of ").append(view).toString() != null ? view.getClass().getSimpleName() : "null");
    }

    private static boolean b(boolean z, boolean z2, boolean z3) {
        return z3 ? true : (z || z2) ? false : true;
    }

    private void k(boolean z) {
        boolean z2 = true;
        this.A = z;
        if (this.A) {
            this.q.setTabContainer(null);
            this.r.a(this.u);
        } else {
            this.r.a(null);
            this.q.setTabContainer(this.u);
        }
        boolean z3 = j() == 2;
        if (this.u != null) {
            if (z3) {
                this.u.setVisibility(0);
                if (this.p != null) {
                    ae.j(this.p);
                }
            } else {
                this.u.setVisibility(8);
            }
        }
        ac acVar = this.r;
        boolean z4 = !this.A && z3;
        acVar.a(z4);
        ActionBarOverlayLayout actionBarOverlayLayout = this.p;
        if (this.A || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    private void l(boolean z) {
        if (b(this.D, this.E, this.F)) {
            if (!this.G) {
                this.G = true;
                h(z);
            }
        } else if (this.G) {
            this.G = false;
            i(z);
        }
    }

    private void p() {
        if (!this.F) {
            this.F = true;
            if (this.p != null) {
                this.p.setShowingForActionMode(true);
            }
            l(false);
        }
    }

    private void q() {
        if (this.F) {
            this.F = false;
            if (this.p != null) {
                this.p.setShowingForActionMode(false);
            }
            l(false);
        }
    }

    private boolean r() {
        return ae.p(this.q);
    }

    public int a() {
        return this.r.o();
    }

    public b a(android.support.v7.view.b.a aVar) {
        if (this.a != null) {
            this.a.c();
        }
        this.p.setHideOnContentScrollEnabled(false);
        this.s.c();
        b aVar2 = new a(this, this.s.getContext(), aVar);
        if (!aVar2.e()) {
            return null;
        }
        this.a = aVar2;
        aVar2.d();
        this.s.a(aVar2);
        j(true);
        this.s.sendAccessibilityEvent(32);
        return aVar2;
    }

    public void a(float f) {
        ae.c(this.q, f);
    }

    public void a(int i) {
        this.B = i;
    }

    public void a(int i, int i2) {
        int o = this.r.o();
        if ((i2 & 4) != 0) {
            this.x = true;
        }
        this.r.c((o & (i2 ^ -1)) | (i & i2));
    }

    public void a(Configuration configuration) {
        k(android.support.v7.view.a.a(this.l).d());
    }

    public void a(CharSequence charSequence) {
        this.r.a(charSequence);
    }

    public void a(boolean z) {
        this.r.b(z);
    }

    public void b(boolean z) {
        if (!z || this.p.a()) {
            this.d = z;
            this.p.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public boolean b() {
        int k = k();
        return this.G && (k == 0 || d() < k);
    }

    public Context c() {
        if (this.m == null) {
            TypedValue typedValue = new TypedValue();
            this.l.getTheme().resolveAttribute(android.support.v7.b.a.a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.m = new ContextThemeWrapper(this.l, i);
            } else {
                this.m = this.l;
            }
        }
        return this.m;
    }

    public void c(boolean z) {
        if (!this.x) {
            f(z);
        }
    }

    public int d() {
        return this.p.getActionBarHideOffset();
    }

    public void d(boolean z) {
        this.I = z;
        if (!z && this.H != null) {
            this.H.b();
        }
    }

    public void e(boolean z) {
        if (z != this.y) {
            this.y = z;
            int size = this.z.size();
            for (int i = 0; i < size; i++) {
                ((a.b) this.z.get(i)).a(z);
            }
        }
    }

    public void f(boolean z) {
        a(z ? 4 : 0, 4);
    }

    public boolean f() {
        if (this.r == null || !this.r.c()) {
            return false;
        }
        this.r.d();
        return true;
    }

    public void g(boolean z) {
        this.C = z;
    }

    public boolean g() {
        ViewGroup a = this.r.a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    public void h(boolean z) {
        if (this.H != null) {
            this.H.b();
        }
        this.q.setVisibility(0);
        if (this.B == 0 && k && (this.I || z)) {
            ae.a(this.q, 0.0f);
            float f = (float) (-this.q.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            ae.a(this.q, f);
            h hVar = new h();
            as b = ae.h(this.q).b(0.0f);
            b.a(this.g);
            hVar.a(b);
            if (this.C && this.t != null) {
                ae.a(this.t, f);
                hVar.a(ae.h(this.t).b(0.0f));
            }
            hVar.a(j);
            hVar.a(250);
            hVar.a(this.f);
            this.H = hVar;
            hVar.a();
        } else {
            ae.b(this.q, 1.0f);
            ae.a(this.q, 0.0f);
            if (this.C && this.t != null) {
                ae.a(this.t, 0.0f);
            }
            this.f.b(null);
        }
        if (this.p != null) {
            ae.j(this.p);
        }
    }

    void i() {
        if (this.c != null) {
            this.c.a(this.b);
            this.b = null;
            this.c = null;
        }
    }

    public void i(boolean z) {
        if (this.H != null) {
            this.H.b();
        }
        if (this.B == 0 && k && (this.I || z)) {
            ae.b(this.q, 1.0f);
            this.q.setTransitioning(true);
            h hVar = new h();
            float f = (float) (-this.q.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            as b = ae.h(this.q).b(f);
            b.a(this.g);
            hVar.a(b);
            if (this.C && this.t != null) {
                hVar.a(ae.h(this.t).b(f));
            }
            hVar.a(i);
            hVar.a(250);
            hVar.a(this.e);
            this.H = hVar;
            hVar.a();
            return;
        }
        this.e.b(null);
    }

    public int j() {
        return this.r.p();
    }

    public void j(boolean z) {
        if (z) {
            p();
        } else {
            q();
        }
        if (r()) {
            as a;
            as a2;
            if (z) {
                a = this.r.a(4, 100);
                a2 = this.s.a(0, 200);
            } else {
                a2 = this.r.a(0, 200);
                a = this.s.a(8, 100);
            }
            h hVar = new h();
            hVar.a(a, a2);
            hVar.a();
        } else if (z) {
            this.r.d(4);
            this.s.setVisibility(0);
        } else {
            this.r.d(0);
            this.s.setVisibility(8);
        }
    }

    public int k() {
        return this.q.getHeight();
    }

    public void l() {
        if (this.E) {
            this.E = false;
            l(true);
        }
    }

    public void m() {
        if (!this.E) {
            this.E = true;
            l(true);
        }
    }

    public void n() {
        if (this.H != null) {
            this.H.b();
            this.H = null;
        }
    }

    public void o() {
    }
}
