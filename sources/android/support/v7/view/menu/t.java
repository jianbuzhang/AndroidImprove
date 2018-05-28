package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.b.a.d;
import android.support.v7.b.a.g;
import android.support.v7.view.menu.o.a;
import android.support.v7.widget.al;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

final class t extends m implements o, OnKeyListener, OnItemClickListener, OnDismissListener {
    private final Context a;
    private final h b;
    private final g c;
    private final boolean d;
    private final int e;
    private final int f;
    private final int g;
    private final al h;
    private final OnGlobalLayoutListener i = new OnGlobalLayoutListener(this) {
        final /* synthetic */ t a;

        {
            this.a = r1;
        }

        public void onGlobalLayout() {
            if (this.a.d() && !this.a.h.g()) {
                View b = this.a.l;
                if (b == null || !b.isShown()) {
                    this.a.c();
                } else {
                    this.a.h.a();
                }
            }
        }
    };
    private OnDismissListener j;
    private View k;
    private View l;
    private a m;
    private ViewTreeObserver n;
    private boolean o;
    private boolean p;
    private int q;
    private int r = 0;
    private boolean s;

    public t(Context context, h hVar, View view, int i, int i2, boolean z) {
        this.a = context;
        this.b = hVar;
        this.d = z;
        this.c = new g(hVar, LayoutInflater.from(context), this.d);
        this.f = i;
        this.g = i2;
        Resources resources = context.getResources();
        this.e = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.abc_config_prefDialogWidth));
        this.k = view;
        this.h = new al(this.a, null, this.f, this.g);
        hVar.a((o) this, context);
    }

    private boolean h() {
        if (d()) {
            return true;
        }
        if (this.o || this.k == null) {
            return false;
        }
        this.l = this.k;
        this.h.a((OnDismissListener) this);
        this.h.a((OnItemClickListener) this);
        this.h.a(true);
        View view = this.l;
        boolean z = this.n == null;
        this.n = view.getViewTreeObserver();
        if (z) {
            this.n.addOnGlobalLayoutListener(this.i);
        }
        this.h.a(view);
        this.h.e(this.r);
        if (!this.p) {
            this.q = m.a(this.c, null, this.a, this.e);
            this.p = true;
        }
        this.h.g(this.q);
        this.h.h(2);
        this.h.a(g());
        this.h.a();
        ViewGroup e = this.h.e();
        e.setOnKeyListener(this);
        if (this.s && this.b.m() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.a).inflate(g.abc_popup_menu_header_item_layout, e, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.b.m());
            }
            frameLayout.setEnabled(false);
            e.addHeaderView(frameLayout, null, false);
        }
        this.h.a(this.c);
        this.h.a();
        return true;
    }

    public void a() {
        if (!h()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void a(int i) {
        this.r = i;
    }

    public void a(h hVar) {
    }

    public void a(h hVar, boolean z) {
        if (hVar == this.b) {
            c();
            if (this.m != null) {
                this.m.a(hVar, z);
            }
        }
    }

    public void a(a aVar) {
        this.m = aVar;
    }

    public void a(View view) {
        this.k = view;
    }

    public void a(OnDismissListener onDismissListener) {
        this.j = onDismissListener;
    }

    public void a(boolean z) {
        this.c.a(z);
    }

    public boolean a(u uVar) {
        if (uVar.hasVisibleItems()) {
            n nVar = new n(this.a, uVar, this.l, this.d, this.f, this.g);
            nVar.a(this.m);
            nVar.a(m.b((h) uVar));
            nVar.a(this.j);
            this.j = null;
            this.b.a(false);
            if (nVar.a(this.h.j(), this.h.k())) {
                if (this.m != null) {
                    this.m.a(uVar);
                }
                return true;
            }
        }
        return false;
    }

    public void b(int i) {
        this.h.c(i);
    }

    public void b(boolean z) {
        this.p = false;
        if (this.c != null) {
            this.c.notifyDataSetChanged();
        }
    }

    public boolean b() {
        return false;
    }

    public void c() {
        if (d()) {
            this.h.c();
        }
    }

    public void c(int i) {
        this.h.d(i);
    }

    public void c(boolean z) {
        this.s = z;
    }

    public boolean d() {
        return !this.o && this.h.d();
    }

    public ListView e() {
        return this.h.e();
    }

    public void onDismiss() {
        this.o = true;
        this.b.close();
        if (this.n != null) {
            if (!this.n.isAlive()) {
                this.n = this.l.getViewTreeObserver();
            }
            this.n.removeGlobalOnLayoutListener(this.i);
            this.n = null;
        }
        if (this.j != null) {
            this.j.onDismiss();
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        c();
        return true;
    }
}
