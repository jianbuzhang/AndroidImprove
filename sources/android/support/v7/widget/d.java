package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.b.a.g;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.n;
import android.support.v7.view.menu.p;
import android.support.v7.view.menu.s;
import android.support.v7.view.menu.u;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

class d extends android.support.v7.view.menu.b implements android.support.v4.g.e.a {
    private b A;
    final f g = new f();
    int h;
    private d i;
    private Drawable j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private int u;
    private final SparseBooleanArray v = new SparseBooleanArray();
    private View w;
    private e x;
    private a y;
    private c z;

    private class a extends n {
        final /* synthetic */ d a;

        public a(d dVar, Context context, u uVar, View view) {
            this.a = dVar;
            super(context, uVar, view, false, android.support.v7.b.a.a.actionOverflowMenuStyle);
            if (!((j) uVar.getItem()).j()) {
                a(dVar.i == null ? (View) dVar.f : dVar.i);
            }
            a(dVar.g);
        }

        protected void e() {
            this.a.y = null;
            this.a.h = 0;
            super.e();
        }
    }

    private class b extends android.support.v7.view.menu.ActionMenuItemView.b {
        final /* synthetic */ d a;

        private b(d dVar) {
            this.a = dVar;
        }

        public s a() {
            return this.a.y != null ? this.a.y.b() : null;
        }
    }

    private class c implements Runnable {
        final /* synthetic */ d a;
        private e b;

        public c(d dVar, e eVar) {
            this.a = dVar;
            this.b = eVar;
        }

        public void run() {
            if (this.a.c != null) {
                this.a.c.f();
            }
            View view = (View) this.a.f;
            if (!(view == null || view.getWindowToken() == null || !this.b.c())) {
                this.a.x = this.b;
            }
            this.a.z = null;
        }
    }

    private class d extends p implements android.support.v7.widget.ActionMenuView.a {
        final /* synthetic */ d a;
        private final float[] b = new float[2];

        public d(final d dVar, Context context) {
            this.a = dVar;
            super(context, null, android.support.v7.b.a.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new ag(this, this) {
                final /* synthetic */ d b;

                public s a() {
                    return this.b.a.x == null ? null : this.b.a.x.b();
                }

                public boolean b() {
                    this.b.a.d();
                    return true;
                }

                public boolean c() {
                    if (this.b.a.z != null) {
                        return false;
                    }
                    this.b.a.e();
                    return true;
                }
            });
        }

        public boolean c() {
            return false;
        }

        public boolean d() {
            return false;
        }

        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                this.a.d();
            }
            return true;
        }

        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                android.support.v4.c.a.a.a(background, width - max, height - max, width + max, height + max);
            }
            return frame;
        }
    }

    private class e extends n {
        final /* synthetic */ d a;

        public e(d dVar, Context context, h hVar, View view, boolean z) {
            this.a = dVar;
            super(context, hVar, view, z, android.support.v7.b.a.a.actionOverflowMenuStyle);
            a(8388613);
            a(dVar.g);
        }

        protected void e() {
            if (this.a.c != null) {
                this.a.c.close();
            }
            this.a.x = null;
            super.e();
        }
    }

    private class f implements android.support.v7.view.menu.o.a {
        final /* synthetic */ d a;

        private f(d dVar) {
            this.a = dVar;
        }

        public void a(h hVar, boolean z) {
            if (hVar instanceof u) {
                hVar.p().a(false);
            }
            android.support.v7.view.menu.o.a a = this.a.a();
            if (a != null) {
                a.a(hVar, z);
            }
        }

        public boolean a(h hVar) {
            if (hVar == null) {
                return false;
            }
            this.a.h = ((u) hVar).getItem().getItemId();
            android.support.v7.view.menu.o.a a = this.a.a();
            return a != null ? a.a(hVar) : false;
        }
    }

    public d(Context context) {
        super(context, g.abc_action_menu_layout, g.abc_action_menu_item_layout);
    }

    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof android.support.v7.view.menu.p.a) && ((android.support.v7.view.menu.p.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public p a(ViewGroup viewGroup) {
        p pVar = this.f;
        p a = super.a(viewGroup);
        if (pVar != a) {
            ((ActionMenuView) a).setPresenter(this);
        }
        return a;
    }

    public View a(j jVar, View view, ViewGroup viewGroup) {
        View actionView = jVar.getActionView();
        if (actionView == null || jVar.n()) {
            actionView = super.a(jVar, view, viewGroup);
        }
        actionView.setVisibility(jVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.a(layoutParams));
        }
        return actionView;
    }

    public void a(Context context, h hVar) {
        super.a(context, hVar);
        Resources resources = context.getResources();
        android.support.v7.view.a a = android.support.v7.view.a.a(context);
        if (!this.m) {
            this.l = a.b();
        }
        if (!this.s) {
            this.n = a.c();
        }
        if (!this.q) {
            this.p = a.a();
        }
        int i = this.n;
        if (this.l) {
            if (this.i == null) {
                this.i = new d(this, this.a);
                if (this.k) {
                    this.i.setImageDrawable(this.j);
                    this.j = null;
                    this.k = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.i.getMeasuredWidth();
        } else {
            this.i = null;
        }
        this.o = i;
        this.u = (int) (56.0f * resources.getDisplayMetrics().density);
        this.w = null;
    }

    public void a(Configuration configuration) {
        if (!this.q) {
            this.p = android.support.v7.view.a.a(this.b).a();
        }
        if (this.c != null) {
            this.c.b(true);
        }
    }

    public void a(Drawable drawable) {
        if (this.i != null) {
            this.i.setImageDrawable(drawable);
            return;
        }
        this.k = true;
        this.j = drawable;
    }

    public void a(h hVar, boolean z) {
        f();
        super.a(hVar, z);
    }

    public void a(j jVar, android.support.v7.view.menu.p.a aVar) {
        aVar.a(jVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.A == null) {
            this.A = new b();
        }
        actionMenuItemView.setPopupCallback(this.A);
    }

    public void a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.a(this.c);
    }

    public void a(boolean z) {
        if (z) {
            super.a(null);
        } else if (this.c != null) {
            this.c.a(false);
        }
    }

    public boolean a(int i, j jVar) {
        return jVar.j();
    }

    public boolean a(u uVar) {
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        u uVar2 = uVar;
        while (uVar2.s() != this.c) {
            uVar2 = (u) uVar2.s();
        }
        View a = a(uVar2.getItem());
        if (a == null) {
            return false;
        }
        boolean z;
        this.h = uVar.getItem().getItemId();
        int size = uVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = uVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
        }
        z = false;
        this.y = new a(this, this.b, uVar, a);
        this.y.a(z);
        this.y.a();
        super.a(uVar);
        return true;
    }

    public boolean a(ViewGroup viewGroup, int i) {
        return viewGroup.getChildAt(i) == this.i ? false : super.a(viewGroup, i);
    }

    public void b(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ViewGroup viewGroup = (ViewGroup) ((View) this.f).getParent();
        if (viewGroup != null) {
            android.support.v7.f.a.a(viewGroup);
        }
        super.b(z);
        ((View) this.f).requestLayout();
        if (this.c != null) {
            ArrayList k = this.c.k();
            int size = k.size();
            for (i = 0; i < size; i++) {
                android.support.v4.g.e a = ((j) k.get(i)).a();
                if (a != null) {
                    a.a((android.support.v4.g.e.a) this);
                }
            }
        }
        ArrayList l = this.c != null ? this.c.l() : null;
        if (this.l && l != null) {
            i = l.size();
            if (i == 1) {
                i3 = !((j) l.get(0)).isActionViewExpanded() ? 1 : 0;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.i == null) {
                this.i = new d(this, this.a);
            }
            viewGroup = (ViewGroup) this.i.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.i);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.i, actionMenuView.c());
            }
        } else if (this.i != null && this.i.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.i);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.l);
    }

    public boolean b() {
        int size;
        ArrayList arrayList;
        int i;
        if (this.c != null) {
            ArrayList i2 = this.c.i();
            size = i2.size();
            arrayList = i2;
        } else {
            size = 0;
            arrayList = null;
        }
        int i3 = this.p;
        int i4 = this.o;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f;
        int i5 = 0;
        int i6 = 0;
        Object obj = null;
        int i7 = 0;
        while (i7 < size) {
            j jVar = (j) arrayList.get(i7);
            if (jVar.l()) {
                i5++;
            } else if (jVar.k()) {
                i6++;
            } else {
                obj = 1;
            }
            i = (this.t && jVar.isActionViewExpanded()) ? 0 : i3;
            i7++;
            i3 = i;
        }
        if (this.l && (r4 != null || i5 + i6 > i3)) {
            i3--;
        }
        i7 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = this.v;
        sparseBooleanArray.clear();
        i = 0;
        if (this.r) {
            i = i4 / this.u;
            i6 = ((i4 % this.u) / i) + this.u;
        } else {
            i6 = 0;
        }
        int i8 = 0;
        i3 = 0;
        int i9 = i;
        while (i8 < size) {
            jVar = (j) arrayList.get(i8);
            int i10;
            if (jVar.l()) {
                View a = a(jVar, this.w, viewGroup);
                if (this.w == null) {
                    this.w = a;
                }
                if (this.r) {
                    i9 -= ActionMenuView.a(a, i6, i9, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i5 = a.getMeasuredWidth();
                i10 = i4 - i5;
                if (i3 != 0) {
                    i5 = i3;
                }
                i3 = jVar.getGroupId();
                if (i3 != 0) {
                    sparseBooleanArray.put(i3, true);
                }
                jVar.d(true);
                i = i10;
                i3 = i7;
            } else if (jVar.k()) {
                boolean z;
                int groupId = jVar.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i7 > 0 || z2) && i4 > 0 && (!this.r || i9 > 0);
                if (z3) {
                    View a2 = a(jVar, this.w, viewGroup);
                    if (this.w == null) {
                        this.w = a2;
                    }
                    boolean z4;
                    if (this.r) {
                        int a3 = ActionMenuView.a(a2, i6, i9, makeMeasureSpec, 0);
                        i10 = i9 - a3;
                        if (a3 == 0) {
                            i9 = 0;
                        } else {
                            z4 = z3;
                        }
                        i5 = i10;
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z5 = z3;
                        i5 = i9;
                        z4 = z5;
                    }
                    i10 = a2.getMeasuredWidth();
                    i4 -= i10;
                    if (i3 == 0) {
                        i3 = i10;
                    }
                    if (this.r) {
                        z = i9 & (i4 >= 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    } else {
                        z = i9 & (i4 + i3 > 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    }
                } else {
                    z = z3;
                    i10 = i3;
                    i3 = i9;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i9 = i7;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i5 = i7;
                    for (i7 = 0; i7 < i8; i7++) {
                        j jVar2 = (j) arrayList.get(i7);
                        if (jVar2.getGroupId() == groupId) {
                            if (jVar2.j()) {
                                i5++;
                            }
                            jVar2.d(false);
                        }
                    }
                    i9 = i5;
                } else {
                    i9 = i7;
                }
                if (z) {
                    i9--;
                }
                jVar.d(z);
                i5 = i10;
                i = i4;
                int i11 = i3;
                i3 = i9;
                i9 = i11;
            } else {
                jVar.d(false);
                i5 = i3;
                i = i4;
                i3 = i7;
            }
            i8++;
            i4 = i;
            i7 = i3;
            i3 = i5;
        }
        return true;
    }

    public Drawable c() {
        return this.i != null ? this.i.getDrawable() : this.k ? this.j : null;
    }

    public void c(boolean z) {
        this.l = z;
        this.m = true;
    }

    public void d(boolean z) {
        this.t = z;
    }

    public boolean d() {
        if (!this.l || h() || this.c == null || this.f == null || this.z != null || this.c.l().isEmpty()) {
            return false;
        }
        this.z = new c(this, new e(this, this.b, this.c, this.i, true));
        ((View) this.f).post(this.z);
        super.a(null);
        return true;
    }

    public boolean e() {
        if (this.z == null || this.f == null) {
            n nVar = this.x;
            if (nVar == null) {
                return false;
            }
            nVar.d();
            return true;
        }
        ((View) this.f).removeCallbacks(this.z);
        this.z = null;
        return true;
    }

    public boolean f() {
        return e() | g();
    }

    public boolean g() {
        if (this.y == null) {
            return false;
        }
        this.y.d();
        return true;
    }

    public boolean h() {
        return this.x != null && this.x.f();
    }

    public boolean i() {
        return this.z != null || h();
    }
}
