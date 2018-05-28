package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.d.a.b;
import android.support.v4.g.e;
import android.support.v4.g.q;
import android.support.v7.view.menu.p.a;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

public final class j implements b {
    private static String w;
    private static String x;
    private static String y;
    private static String z;
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private CharSequence e;
    private CharSequence f;
    private Intent g;
    private char h;
    private char i;
    private Drawable j;
    private int k = 0;
    private h l;
    private u m;
    private Runnable n;
    private OnMenuItemClickListener o;
    private int p = 16;
    private int q = 0;
    private View r;
    private e s;
    private q.e t;
    private boolean u = false;
    private ContextMenuInfo v;

    j(h hVar, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.l = hVar;
        this.a = i2;
        this.b = i;
        this.c = i3;
        this.d = i4;
        this.e = charSequence;
        this.q = i5;
    }

    public b a(int i) {
        Context e = this.l.e();
        a(LayoutInflater.from(e).inflate(i, new LinearLayout(e), false));
        return this;
    }

    public b a(e eVar) {
        if (this.s != null) {
            this.s.f();
        }
        this.r = null;
        this.s = eVar;
        this.l.b(true);
        if (this.s != null) {
            this.s.a(new e.b(this) {
                final /* synthetic */ j a;

                {
                    this.a = r1;
                }

                public void a(boolean z) {
                    this.a.l.a(this.a);
                }
            });
        }
        return this;
    }

    public b a(q.e eVar) {
        this.t = eVar;
        return this;
    }

    public b a(View view) {
        this.r = view;
        this.s = null;
        if (view != null && view.getId() == -1 && this.a > 0) {
            view.setId(this.a);
        }
        this.l.b(this);
        return this;
    }

    public e a() {
        return this.s;
    }

    CharSequence a(a aVar) {
        return (aVar == null || !aVar.a()) ? getTitle() : getTitleCondensed();
    }

    public void a(u uVar) {
        this.m = uVar;
        uVar.setHeaderTitle(getTitle());
    }

    void a(ContextMenuInfo contextMenuInfo) {
        this.v = contextMenuInfo;
    }

    public void a(boolean z) {
        this.p = (z ? 4 : 0) | (this.p & -5);
    }

    public b b(int i) {
        setShowAsAction(i);
        return this;
    }

    void b(boolean z) {
        int i = this.p;
        this.p = (z ? 2 : 0) | (this.p & -3);
        if (i != this.p) {
            this.l.b(false);
        }
    }

    public boolean b() {
        if ((this.o != null && this.o.onMenuItemClick(this)) || this.l.a(this.l.p(), (MenuItem) this)) {
            return true;
        }
        if (this.n != null) {
            this.n.run();
            return true;
        }
        if (this.g != null) {
            try {
                this.l.e().startActivity(this.g);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        return this.s != null && this.s.d();
    }

    public int c() {
        return this.d;
    }

    boolean c(boolean z) {
        int i = this.p;
        this.p = (z ? 0 : 8) | (this.p & -9);
        return i != this.p;
    }

    public boolean collapseActionView() {
        return (this.q & 8) == 0 ? false : this.r == null ? true : (this.t == null || this.t.b(this)) ? this.l.d(this) : false;
    }

    char d() {
        return this.l.b() ? this.i : this.h;
    }

    public void d(boolean z) {
        if (z) {
            this.p |= 32;
        } else {
            this.p &= -33;
        }
    }

    String e() {
        char d = d();
        if (d == '\u0000') {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(w);
        switch (d) {
            case '\b':
                stringBuilder.append(y);
                break;
            case '\n':
                stringBuilder.append(x);
                break;
            case android.support.v7.b.a.j.AppCompatTheme_actionModeCutDrawable /*32*/:
                stringBuilder.append(z);
                break;
            default:
                stringBuilder.append(d);
                break;
        }
        return stringBuilder.toString();
    }

    public void e(boolean z) {
        this.u = z;
        this.l.b(false);
    }

    public boolean expandActionView() {
        return !n() ? false : (this.t == null || this.t.a(this)) ? this.l.c(this) : false;
    }

    boolean f() {
        return this.l.c() && d() != '\u0000';
    }

    public boolean g() {
        return (this.p & 4) != 0;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        if (this.r != null) {
            return this.r;
        }
        if (this.s == null) {
            return null;
        }
        this.r = this.s.a((MenuItem) this);
        return this.r;
    }

    public char getAlphabeticShortcut() {
        return this.i;
    }

    public int getGroupId() {
        return this.b;
    }

    public Drawable getIcon() {
        if (this.j != null) {
            return this.j;
        }
        if (this.k == 0) {
            return null;
        }
        Drawable b = android.support.v7.c.a.b.b(this.l.e(), this.k);
        this.k = 0;
        this.j = b;
        return b;
    }

    public Intent getIntent() {
        return this.g;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.a;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.v;
    }

    public char getNumericShortcut() {
        return this.h;
    }

    public int getOrder() {
        return this.c;
    }

    public SubMenu getSubMenu() {
        return this.m;
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f != null ? this.f : this.e;
        return (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public void h() {
        this.l.b(this);
    }

    public boolean hasSubMenu() {
        return this.m != null;
    }

    public boolean i() {
        return this.l.q();
    }

    public boolean isActionViewExpanded() {
        return this.u;
    }

    public boolean isCheckable() {
        return (this.p & 1) == 1;
    }

    public boolean isChecked() {
        return (this.p & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.p & 16) != 0;
    }

    public boolean isVisible() {
        return (this.s == null || !this.s.b()) ? (this.p & 8) == 0 : (this.p & 8) == 0 && this.s.c();
    }

    public boolean j() {
        return (this.p & 32) == 32;
    }

    public boolean k() {
        return (this.q & 1) == 1;
    }

    public boolean l() {
        return (this.q & 2) == 2;
    }

    public boolean m() {
        return (this.q & 4) == 4;
    }

    public boolean n() {
        if ((this.q & 8) == 0) {
            return false;
        }
        if (this.r == null && this.s != null) {
            this.r = this.s.a((MenuItem) this);
        }
        return this.r != null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return a(view);
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.i != c) {
            this.i = Character.toLowerCase(c);
            this.l.b(false);
        }
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.p;
        this.p = (z ? 1 : 0) | (this.p & -2);
        if (i != this.p) {
            this.l.b(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.p & 4) != 0) {
            this.l.a((MenuItem) this);
        } else {
            b(z);
        }
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.p |= 16;
        } else {
            this.p &= -17;
        }
        this.l.b(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.j = null;
        this.k = i;
        this.l.b(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.k = 0;
        this.j = drawable;
        this.l.b(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.h != c) {
            this.h = c;
            this.l.b(false);
        }
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.o = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.h = c;
        this.i = Character.toLowerCase(c2);
        this.l.b(false);
        return this;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.q = i;
                this.l.b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return b(i);
    }

    public MenuItem setTitle(int i) {
        return setTitle(this.l.e().getString(i));
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.e = charSequence;
        this.l.b(false);
        if (this.m != null) {
            this.m.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.e;
        }
        this.l.b(false);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        if (c(z)) {
            this.l.a(this);
        }
        return this;
    }

    public String toString() {
        return this.e != null ? this.e.toString() : null;
    }
}
