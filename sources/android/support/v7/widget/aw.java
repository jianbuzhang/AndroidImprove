package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.g.ae;
import android.support.v4.g.as;
import android.support.v4.g.ax;
import android.support.v7.b.a.a;
import android.support.v7.b.a.e;
import android.support.v7.b.a.f;
import android.support.v7.b.a.h;
import android.support.v7.b.a.j;
import android.support.v7.c.a.b;
import android.support.v7.view.menu.o;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public class aw implements ac {
    private Toolbar a;
    private int b;
    private View c;
    private View d;
    private Drawable e;
    private Drawable f;
    private Drawable g;
    private boolean h;
    private CharSequence i;
    private CharSequence j;
    private CharSequence k;
    private Callback l;
    private boolean m;
    private d n;
    private int o;
    private int p;
    private Drawable q;

    public aw(Toolbar toolbar, boolean z) {
        this(toolbar, z, h.abc_action_bar_up_description, e.abc_ic_ab_back_material);
    }

    public aw(Toolbar toolbar, boolean z, int i, int i2) {
        this.o = 0;
        this.p = 0;
        this.a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.h = this.i != null;
        this.g = toolbar.getNavigationIcon();
        av a = av.a(toolbar.getContext(), null, j.ActionBar, a.actionBarStyle, 0);
        this.q = a.a(j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence c = a.c(j.ActionBar_title);
            if (!TextUtils.isEmpty(c)) {
                b(c);
            }
            c = a.c(j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c)) {
                c(c);
            }
            Drawable a2 = a.a(j.ActionBar_logo);
            if (a2 != null) {
                b(a2);
            }
            a2 = a.a(j.ActionBar_icon);
            if (a2 != null) {
                a(a2);
            }
            if (this.g == null && this.q != null) {
                c(this.q);
            }
            c(a.a(j.ActionBar_displayOptions, 0));
            int g = a.g(j.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                a(LayoutInflater.from(this.a.getContext()).inflate(g, this.a, false));
                c(this.b | 16);
            }
            g = a.f(j.ActionBar_height, 0);
            if (g > 0) {
                LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = g;
                this.a.setLayoutParams(layoutParams);
            }
            g = a.d(j.ActionBar_contentInsetStart, -1);
            int d = a.d(j.ActionBar_contentInsetEnd, -1);
            if (g >= 0 || d >= 0) {
                this.a.a(Math.max(g, 0), Math.max(d, 0));
            }
            g = a.g(j.ActionBar_titleTextStyle, 0);
            if (g != 0) {
                this.a.a(this.a.getContext(), g);
            }
            g = a.g(j.ActionBar_subtitleTextStyle, 0);
            if (g != 0) {
                this.a.b(this.a.getContext(), g);
            }
            int g2 = a.g(j.ActionBar_popupTheme, 0);
            if (g2 != 0) {
                this.a.setPopupTheme(g2);
            }
        } else {
            this.b = s();
        }
        a.a();
        e(i);
        this.k = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new OnClickListener(this) {
            final android.support.v7.view.menu.a a = new android.support.v7.view.menu.a(this.b.a.getContext(), 0, 16908332, 0, 0, this.b.i);
            final /* synthetic */ aw b;

            {
                this.b = r8;
            }

            public void onClick(View view) {
                if (this.b.l != null && this.b.m) {
                    this.b.l.onMenuItemSelected(0, this.a);
                }
            }
        });
    }

    private void e(CharSequence charSequence) {
        this.i = charSequence;
        if ((this.b & 8) != 0) {
            this.a.setTitle(charSequence);
        }
    }

    private int s() {
        if (this.a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.a.getNavigationIcon();
        return 15;
    }

    private void t() {
        Drawable drawable = null;
        if ((this.b & 2) != 0) {
            drawable = (this.b & 1) != 0 ? this.f != null ? this.f : this.e : this.e;
        }
        this.a.setLogo(drawable);
    }

    private void u() {
        if ((this.b & 4) != 0) {
            this.a.setNavigationIcon(this.g != null ? this.g : this.q);
        } else {
            this.a.setNavigationIcon(null);
        }
    }

    private void v() {
        if ((this.b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.k)) {
            this.a.setNavigationContentDescription(this.p);
        } else {
            this.a.setNavigationContentDescription(this.k);
        }
    }

    public as a(final int i, long j) {
        return ae.h(this.a).a(i == 0 ? 1.0f : 0.0f).a(j).a(new ax(this) {
            final /* synthetic */ aw b;
            private boolean c = false;

            public void a(View view) {
                this.b.a.setVisibility(0);
            }

            public void b(View view) {
                if (!this.c) {
                    this.b.a.setVisibility(i);
                }
            }

            public void c(View view) {
                this.c = true;
            }
        });
    }

    public ViewGroup a() {
        return this.a;
    }

    public void a(int i) {
        a(i != 0 ? b.b(b(), i) : null);
    }

    public void a(Drawable drawable) {
        this.e = drawable;
        t();
    }

    public void a(o.a aVar, android.support.v7.view.menu.h.a aVar2) {
        this.a.a(aVar, aVar2);
    }

    public void a(ao aoVar) {
        if (this.c != null && this.c.getParent() == this.a) {
            this.a.removeView(this.c);
        }
        this.c = aoVar;
        if (aoVar != null && this.o == 2) {
            this.a.addView(this.c, 0);
            Toolbar.b bVar = (Toolbar.b) this.c.getLayoutParams();
            bVar.width = -2;
            bVar.height = -2;
            bVar.a = 8388691;
            aoVar.setAllowCollapse(true);
        }
    }

    public void a(Menu menu, o.a aVar) {
        if (this.n == null) {
            this.n = new d(this.a.getContext());
            this.n.a(f.action_menu_presenter);
        }
        this.n.a(aVar);
        this.a.a((android.support.v7.view.menu.h) menu, this.n);
    }

    public void a(View view) {
        if (!(this.d == null || (this.b & 16) == 0)) {
            this.a.removeView(this.d);
        }
        this.d = view;
        if (view != null && (this.b & 16) != 0) {
            this.a.addView(this.d);
        }
    }

    public void a(Callback callback) {
        this.l = callback;
    }

    public void a(CharSequence charSequence) {
        if (!this.h) {
            e(charSequence);
        }
    }

    public void a(boolean z) {
        this.a.setCollapsible(z);
    }

    public Context b() {
        return this.a.getContext();
    }

    public void b(int i) {
        b(i != 0 ? b.b(b(), i) : null);
    }

    public void b(Drawable drawable) {
        this.f = drawable;
        t();
    }

    public void b(CharSequence charSequence) {
        this.h = true;
        e(charSequence);
    }

    public void b(boolean z) {
    }

    public void c(int i) {
        int i2 = this.b ^ i;
        this.b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    v();
                }
                u();
            }
            if ((i2 & 3) != 0) {
                t();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.a.setTitle(this.i);
                    this.a.setSubtitle(this.j);
                } else {
                    this.a.setTitle(null);
                    this.a.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.d != null) {
                if ((i & 16) != 0) {
                    this.a.addView(this.d);
                } else {
                    this.a.removeView(this.d);
                }
            }
        }
    }

    public void c(Drawable drawable) {
        this.g = drawable;
        u();
    }

    public void c(CharSequence charSequence) {
        this.j = charSequence;
        if ((this.b & 8) != 0) {
            this.a.setSubtitle(charSequence);
        }
    }

    public boolean c() {
        return this.a.g();
    }

    public void d() {
        this.a.h();
    }

    public void d(int i) {
        this.a.setVisibility(i);
    }

    public void d(CharSequence charSequence) {
        this.k = charSequence;
        v();
    }

    public CharSequence e() {
        return this.a.getTitle();
    }

    public void e(int i) {
        if (i != this.p) {
            this.p = i;
            if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
                f(this.p);
            }
        }
    }

    public void f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void f(int i) {
        d(i == 0 ? null : b().getString(i));
    }

    public void g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public boolean h() {
        return this.a.a();
    }

    public boolean i() {
        return this.a.b();
    }

    public boolean j() {
        return this.a.c();
    }

    public boolean k() {
        return this.a.d();
    }

    public boolean l() {
        return this.a.e();
    }

    public void m() {
        this.m = true;
    }

    public void n() {
        this.a.f();
    }

    public int o() {
        return this.b;
    }

    public int p() {
        return this.o;
    }

    public int q() {
        return this.a.getVisibility();
    }

    public Menu r() {
        return this.a.getMenu();
    }
}
