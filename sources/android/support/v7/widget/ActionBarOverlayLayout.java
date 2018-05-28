package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.g.ae;
import android.support.v4.g.as;
import android.support.v4.g.aw;
import android.support.v4.g.ax;
import android.support.v4.g.x;
import android.support.v4.g.y;
import android.support.v4.widget.t;
import android.support.v7.b.a.f;
import android.support.v7.b.a.j;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;

public class ActionBarOverlayLayout extends ViewGroup implements x, ab {
    static final int[] a = new int[]{android.support.v7.b.a.a.actionBarSize, 16842841};
    private final Runnable A;
    private final y B;
    private int b;
    private int c;
    private ContentFrameLayout d;
    private ActionBarContainer e;
    private ac f;
    private Drawable g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private final Rect o;
    private final Rect p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private a u;
    private final int v;
    private t w;
    private as x;
    private final aw y;
    private final Runnable z;

    public interface a {
        void a(int i);

        void g(boolean z);

        void l();

        void m();

        void n();

        void o();
    }

    public static class b extends MarginLayoutParams {
        public b(int i, int i2) {
            super(i, i2);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        this.o = new Rect();
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.v = 600;
        this.y = new ax(this) {
            final /* synthetic */ ActionBarOverlayLayout a;

            {
                this.a = r1;
            }

            public void b(View view) {
                this.a.x = null;
                this.a.l = false;
            }

            public void c(View view) {
                this.a.x = null;
                this.a.l = false;
            }
        };
        this.z = new Runnable(this) {
            final /* synthetic */ ActionBarOverlayLayout a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.k();
                this.a.x = ae.h(this.a.e).b(0.0f).a(this.a.y);
            }
        };
        this.A = new Runnable(this) {
            final /* synthetic */ ActionBarOverlayLayout a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.k();
                this.a.x = ae.h(this.a.e).b((float) (-this.a.e.getHeight())).a(this.a.y);
            }
        };
        a(context);
        this.B = new y(this);
    }

    private ac a(View view) {
        if (view instanceof ac) {
            return (ac) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void a(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(a);
        this.b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.g = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.g == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.h = z;
        this.w = t.a(context);
    }

    private boolean a(float f, float f2) {
        this.w.a(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.w.d() > this.e.getHeight();
    }

    private boolean a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        b bVar = (b) view.getLayoutParams();
        if (z && bVar.leftMargin != rect.left) {
            bVar.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && bVar.topMargin != rect.top) {
            bVar.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && bVar.rightMargin != rect.right) {
            bVar.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || bVar.bottomMargin == rect.bottom) {
            return z5;
        }
        bVar.bottomMargin = rect.bottom;
        return true;
    }

    private void k() {
        removeCallbacks(this.z);
        removeCallbacks(this.A);
        if (this.x != null) {
            this.x.b();
        }
    }

    private void l() {
        k();
        postDelayed(this.z, 600);
    }

    private void m() {
        k();
        postDelayed(this.A, 600);
    }

    private void n() {
        k();
        this.z.run();
    }

    private void o() {
        k();
        this.A.run();
    }

    public b a(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    public void a(int i) {
        c();
        switch (i) {
            case 2:
                this.f.f();
                return;
            case 5:
                this.f.g();
                return;
            case j.AppCompatTheme_ratingBarStyleIndicator /*109*/:
                setOverlayMode(true);
                return;
            default:
                return;
        }
    }

    public void a(Menu menu, android.support.v7.view.menu.o.a aVar) {
        c();
        this.f.a(menu, aVar);
    }

    public boolean a() {
        return this.i;
    }

    protected b b() {
        return new b(-1, -1);
    }

    void c() {
        if (this.d == null) {
            this.d = (ContentFrameLayout) findViewById(f.action_bar_activity_content);
            this.e = (ActionBarContainer) findViewById(f.action_bar_container);
            this.f = a(findViewById(f.action_bar));
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    public boolean d() {
        c();
        return this.f.h();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.g != null && !this.h) {
            int bottom = this.e.getVisibility() == 0 ? (int) ((((float) this.e.getBottom()) + ae.f(this.e)) + 0.5f) : 0;
            this.g.setBounds(0, bottom, getWidth(), this.g.getIntrinsicHeight() + bottom);
            this.g.draw(canvas);
        }
    }

    public boolean e() {
        c();
        return this.f.i();
    }

    public boolean f() {
        c();
        return this.f.j();
    }

    protected boolean fitSystemWindows(Rect rect) {
        boolean a;
        c();
        if ((ae.i(this) & 256) != 0) {
            a = a(this.e, rect, true, true, false, true);
            this.r.set(rect);
            ay.a(this, this.r, this.o);
        } else {
            a = a(this.e, rect, true, true, false, true);
            this.r.set(rect);
            ay.a(this, this.r, this.o);
        }
        if (!this.p.equals(this.o)) {
            this.p.set(this.o);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    public boolean g() {
        c();
        return this.f.k();
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public int getActionBarHideOffset() {
        return this.e != null ? -((int) ae.f(this.e)) : 0;
    }

    public int getNestedScrollAxes() {
        return this.B.a();
    }

    public CharSequence getTitle() {
        c();
        return this.f.e();
    }

    public boolean h() {
        c();
        return this.f.l();
    }

    public void i() {
        c();
        this.f.m();
    }

    public void j() {
        c();
        this.f.n();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a(getContext());
        ae.j(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        paddingRight = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                b bVar = (b) childAt.getLayoutParams();
                int i6 = bVar.leftMargin + paddingLeft;
                paddingRight = bVar.topMargin + paddingTop;
                childAt.layout(i6, paddingRight, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + paddingRight);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        c();
        measureChildWithMargins(this.e, i, 0, i2, 0);
        b bVar = (b) this.e.getLayoutParams();
        int max = Math.max(0, (this.e.getMeasuredWidth() + bVar.leftMargin) + bVar.rightMargin);
        int max2 = Math.max(0, bVar.bottomMargin + (this.e.getMeasuredHeight() + bVar.topMargin));
        int a = ay.a(0, ae.e(this.e));
        Object obj = (ae.i(this) & 256) != 0 ? 1 : null;
        if (obj != null) {
            i3 = this.b;
            if (this.j && this.e.getTabContainer() != null) {
                i3 += this.b;
            }
        } else {
            i3 = this.e.getVisibility() != 8 ? this.e.getMeasuredHeight() : 0;
        }
        this.q.set(this.o);
        this.s.set(this.r);
        Rect rect;
        Rect rect2;
        if (this.i || obj != null) {
            rect = this.s;
            rect.top = i3 + rect.top;
            rect2 = this.s;
            rect2.bottom += 0;
        } else {
            rect = this.q;
            rect.top = i3 + rect.top;
            rect2 = this.q;
            rect2.bottom += 0;
        }
        a(this.d, this.q, true, true, true, true);
        if (!this.t.equals(this.s)) {
            this.t.set(this.s);
            this.d.a(this.s);
        }
        measureChildWithMargins(this.d, i, 0, i2, 0);
        bVar = (b) this.d.getLayoutParams();
        int max3 = Math.max(max, (this.d.getMeasuredWidth() + bVar.leftMargin) + bVar.rightMargin);
        i3 = Math.max(max2, bVar.bottomMargin + (this.d.getMeasuredHeight() + bVar.topMargin));
        int a2 = ay.a(a, ae.e(this.d));
        setMeasuredDimension(ae.a(Math.max(max3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, a2), ae.a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, a2 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.k || !z) {
            return false;
        }
        if (a(f, f2)) {
            o();
        } else {
            n();
        }
        this.l = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.m += i2;
        setActionBarHideOffset(this.m);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.B.a(view, view2, i);
        this.m = getActionBarHideOffset();
        k();
        if (this.u != null) {
            this.u.n();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return ((i & 2) == 0 || this.e.getVisibility() != 0) ? false : this.k;
    }

    public void onStopNestedScroll(View view) {
        if (this.k && !this.l) {
            if (this.m <= this.e.getHeight()) {
                l();
            } else {
                m();
            }
        }
        if (this.u != null) {
            this.u.o();
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        c();
        int i2 = this.n ^ i;
        this.n = i;
        boolean z2 = (i & 4) == 0;
        boolean z3 = (i & 256) != 0;
        if (this.u != null) {
            a aVar = this.u;
            if (z3) {
                z = false;
            }
            aVar.g(z);
            if (z2 || !z3) {
                this.u.l();
            } else {
                this.u.m();
            }
        }
        if ((i2 & 256) != 0 && this.u != null) {
            ae.j(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.c = i;
        if (this.u != null) {
            this.u.a(i);
        }
    }

    public void setActionBarHideOffset(int i) {
        k();
        ae.a(this.e, (float) (-Math.max(0, Math.min(i, this.e.getHeight()))));
    }

    public void setActionBarVisibilityCallback(a aVar) {
        this.u = aVar;
        if (getWindowToken() != null) {
            this.u.a(this.c);
            if (this.n != 0) {
                onWindowSystemUiVisibilityChanged(this.n);
                ae.j(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.j = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.k) {
            this.k = z;
            if (!z) {
                k();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i) {
        c();
        this.f.a(i);
    }

    public void setIcon(Drawable drawable) {
        c();
        this.f.a(drawable);
    }

    public void setLogo(int i) {
        c();
        this.f.b(i);
    }

    public void setOverlayMode(boolean z) {
        this.i = z;
        boolean z2 = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.h = z2;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public void setWindowCallback(Callback callback) {
        c();
        this.f.a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        c();
        this.f.a(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
