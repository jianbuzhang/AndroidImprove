package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.g.ae;
import android.support.v4.g.f;
import android.support.v4.g.q;
import android.support.v4.g.t;
import android.support.v7.view.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.u;
import android.support.v7.widget.ActionMenuView.e;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private int A;
    private boolean B;
    private boolean C;
    private final ArrayList<View> D;
    private final ArrayList<View> E;
    private final int[] F;
    private c G;
    private final e H;
    private aw I;
    private d J;
    private a K;
    private android.support.v7.view.menu.o.a L;
    private android.support.v7.view.menu.h.a M;
    private boolean N;
    private final Runnable O;
    View a;
    private ActionMenuView b;
    private TextView c;
    private TextView d;
    private ImageButton e;
    private ImageView f;
    private Drawable g;
    private CharSequence h;
    private ImageButton i;
    private Context j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private an t;
    private int u;
    private int v;
    private int w;
    private CharSequence x;
    private CharSequence y;
    private int z;

    private class a implements o {
        h a;
        j b;
        final /* synthetic */ Toolbar c;

        private a(Toolbar toolbar) {
            this.c = toolbar;
        }

        public void a(Context context, h hVar) {
            if (!(this.a == null || this.b == null)) {
                this.a.d(this.b);
            }
            this.a = hVar;
        }

        public void a(h hVar, boolean z) {
        }

        public void a(android.support.v7.view.menu.o.a aVar) {
        }

        public boolean a(h hVar, j jVar) {
            this.c.p();
            if (this.c.i.getParent() != this.c) {
                this.c.addView(this.c.i);
            }
            this.c.a = jVar.getActionView();
            this.b = jVar;
            if (this.c.a.getParent() != this.c) {
                LayoutParams i = this.c.i();
                i.a = 8388611 | (this.c.n & android.support.v7.b.a.j.AppCompatTheme_spinnerStyle);
                i.b = 2;
                this.c.a.setLayoutParams(i);
                this.c.addView(this.c.a);
            }
            this.c.j();
            this.c.requestLayout();
            jVar.e(true);
            if (this.c.a instanceof android.support.v7.view.c) {
                ((android.support.v7.view.c) this.c.a).a();
            }
            return true;
        }

        public boolean a(u uVar) {
            return false;
        }

        public void b(boolean z) {
            Object obj = null;
            if (this.b != null) {
                if (this.a != null) {
                    int size = this.a.size();
                    for (int i = 0; i < size; i++) {
                        if (this.a.getItem(i) == this.b) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    b(this.a, this.b);
                }
            }
        }

        public boolean b() {
            return false;
        }

        public boolean b(h hVar, j jVar) {
            if (this.c.a instanceof android.support.v7.view.c) {
                ((android.support.v7.view.c) this.c.a).b();
            }
            this.c.removeView(this.c.a);
            this.c.removeView(this.c.i);
            this.c.a = null;
            this.c.k();
            this.b = null;
            this.c.requestLayout();
            jVar.e(false);
            return true;
        }
    }

    public static class b extends android.support.v7.a.a.a {
        int b;

        public b(int i, int i2) {
            super(i, i2);
            this.b = 0;
            this.a = 8388627;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = 0;
        }

        public b(android.support.v7.a.a.a aVar) {
            super(aVar);
            this.b = 0;
        }

        public b(b bVar) {
            super((android.support.v7.a.a.a) bVar);
            this.b = 0;
            this.b = bVar.b;
        }

        public b(LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }

        public b(MarginLayoutParams marginLayoutParams) {
            super((LayoutParams) marginLayoutParams);
            this.b = 0;
            a(marginLayoutParams);
        }

        void a(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public interface c {
        boolean a(MenuItem menuItem);
    }

    public static class d extends android.support.v4.g.a {
        public static final Creator<d> CREATOR = android.support.v4.e.d.a(new android.support.v4.e.e<d>() {
            public /* synthetic */ Object a(Parcel parcel, ClassLoader classLoader) {
                return b(parcel, classLoader);
            }

            public /* synthetic */ Object[] a(int i) {
                return b(i);
            }

            public d b(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            public d[] b(int i) {
                return new d[i];
            }
        });
        int b;
        boolean c;

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.b = parcel.readInt();
            this.c = parcel.readInt() != 0;
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
        }
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.b.a.a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.w = 8388627;
        this.D = new ArrayList();
        this.E = new ArrayList();
        this.F = new int[2];
        this.H = new e(this) {
            final /* synthetic */ Toolbar a;

            {
                this.a = r1;
            }

            public boolean a(MenuItem menuItem) {
                return this.a.G != null ? this.a.G.a(menuItem) : false;
            }
        };
        this.O = new Runnable(this) {
            final /* synthetic */ Toolbar a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.d();
            }
        };
        av a = av.a(getContext(), attributeSet, android.support.v7.b.a.j.Toolbar, i, 0);
        this.l = a.g(android.support.v7.b.a.j.Toolbar_titleTextAppearance, 0);
        this.m = a.g(android.support.v7.b.a.j.Toolbar_subtitleTextAppearance, 0);
        this.w = a.c(android.support.v7.b.a.j.Toolbar_android_gravity, this.w);
        this.n = a.c(android.support.v7.b.a.j.Toolbar_buttonGravity, 48);
        int d = a.d(android.support.v7.b.a.j.Toolbar_titleMargin, 0);
        if (a.g(android.support.v7.b.a.j.Toolbar_titleMargins)) {
            d = a.d(android.support.v7.b.a.j.Toolbar_titleMargins, d);
        }
        this.s = d;
        this.r = d;
        this.q = d;
        this.p = d;
        d = a.d(android.support.v7.b.a.j.Toolbar_titleMarginStart, -1);
        if (d >= 0) {
            this.p = d;
        }
        d = a.d(android.support.v7.b.a.j.Toolbar_titleMarginEnd, -1);
        if (d >= 0) {
            this.q = d;
        }
        d = a.d(android.support.v7.b.a.j.Toolbar_titleMarginTop, -1);
        if (d >= 0) {
            this.r = d;
        }
        d = a.d(android.support.v7.b.a.j.Toolbar_titleMarginBottom, -1);
        if (d >= 0) {
            this.s = d;
        }
        this.o = a.e(android.support.v7.b.a.j.Toolbar_maxButtonHeight, -1);
        d = a.d(android.support.v7.b.a.j.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int d2 = a.d(android.support.v7.b.a.j.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int e = a.e(android.support.v7.b.a.j.Toolbar_contentInsetLeft, 0);
        int e2 = a.e(android.support.v7.b.a.j.Toolbar_contentInsetRight, 0);
        s();
        this.t.b(e, e2);
        if (!(d == Integer.MIN_VALUE && d2 == Integer.MIN_VALUE)) {
            this.t.a(d, d2);
        }
        this.u = a.d(android.support.v7.b.a.j.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.v = a.d(android.support.v7.b.a.j.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.g = a.a(android.support.v7.b.a.j.Toolbar_collapseIcon);
        this.h = a.c(android.support.v7.b.a.j.Toolbar_collapseContentDescription);
        CharSequence c = a.c(android.support.v7.b.a.j.Toolbar_title);
        if (!TextUtils.isEmpty(c)) {
            setTitle(c);
        }
        c = a.c(android.support.v7.b.a.j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c)) {
            setSubtitle(c);
        }
        this.j = getContext();
        setPopupTheme(a.g(android.support.v7.b.a.j.Toolbar_popupTheme, 0));
        Drawable a2 = a.a(android.support.v7.b.a.j.Toolbar_navigationIcon);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        c = a.c(android.support.v7.b.a.j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c)) {
            setNavigationContentDescription(c);
        }
        a2 = a.a(android.support.v7.b.a.j.Toolbar_logo);
        if (a2 != null) {
            setLogo(a2);
        }
        c = a.c(android.support.v7.b.a.j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c)) {
            setLogoDescription(c);
        }
        if (a.g(android.support.v7.b.a.j.Toolbar_titleTextColor)) {
            setTitleTextColor(a.b(android.support.v7.b.a.j.Toolbar_titleTextColor, -1));
        }
        if (a.g(android.support.v7.b.a.j.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.b(android.support.v7.b.a.j.Toolbar_subtitleTextColor, -1));
        }
        a.a();
    }

    private int a(int i) {
        int i2 = i & android.support.v7.b.a.j.AppCompatTheme_spinnerStyle;
        switch (i2) {
            case 16:
            case android.support.v7.b.a.j.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
            case android.support.v7.b.a.j.AppCompatTheme_panelMenuListWidth /*80*/:
                return i2;
            default:
                return this.w & android.support.v7.b.a.j.AppCompatTheme_spinnerStyle;
        }
    }

    private int a(View view, int i) {
        b bVar = (b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (a(bVar.a)) {
            case android.support.v7.b.a.j.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                return getPaddingTop() - i2;
            case android.support.v7.b.a.j.AppCompatTheme_panelMenuListWidth /*80*/:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - bVar.bottomMargin) - i2;
            default:
                int i3;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i2 < bVar.topMargin) {
                    i3 = bVar.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - paddingTop;
                    i3 = measuredHeight < bVar.bottomMargin ? Math.max(0, i2 - (bVar.bottomMargin - measuredHeight)) : i2;
                }
                return i3 + paddingTop;
        }
    }

    private int a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private int a(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (bVar.rightMargin + measuredWidth) + max;
    }

    private int a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = (View) list.get(i3);
            b bVar = (b) view.getLayoutParams();
            i6 = bVar.leftMargin - i6;
            i = bVar.rightMargin - i5;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i);
            i6 = Math.max(0, -i6);
            i5 = Math.max(0, -i);
            i3++;
            i4 += (view.getMeasuredWidth() + max) + max2;
        }
        return i4;
    }

    private void a(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void a(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = i();
        } else if (checkLayoutParams(layoutParams)) {
            b bVar = (b) layoutParams;
        } else {
            layoutParams = a(layoutParams);
        }
        layoutParams.b = 1;
        if (!z || this.a == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.E.add(view);
    }

    private void a(List<View> list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (ae.c(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int a = f.a(i, ae.c(this));
        list.clear();
        b bVar;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                bVar = (b) childAt.getLayoutParams();
                if (bVar.b == 0 && a(childAt) && b(bVar.a) == a) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            bVar = (b) childAt2.getLayoutParams();
            if (bVar.b == 0 && a(childAt2) && b(bVar.a) == a) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private boolean a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int b(int i) {
        int c = ae.c(this);
        int a = f.a(i, c) & 7;
        switch (a) {
            case 1:
            case 3:
            case 5:
                return a;
            default:
                return c == 1 ? 5 : 3;
        }
    }

    private int b(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return android.support.v4.g.o.b(marginLayoutParams) + android.support.v4.g.o.a(marginLayoutParams);
    }

    private int b(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (bVar.leftMargin + measuredWidth);
    }

    private int c(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    private boolean d(View view) {
        return view.getParent() == this || this.E.contains(view);
    }

    private MenuInflater getMenuInflater() {
        return new g(getContext());
    }

    private void l() {
        if (this.f == null) {
            this.f = new p(getContext());
        }
    }

    private void m() {
        n();
        if (this.b.d() == null) {
            h hVar = (h) this.b.getMenu();
            if (this.K == null) {
                this.K = new a();
            }
            this.b.setExpandedActionViewsExclusive(true);
            hVar.a(this.K, this.j);
        }
    }

    private void n() {
        if (this.b == null) {
            this.b = new ActionMenuView(getContext());
            this.b.setPopupTheme(this.k);
            this.b.setOnMenuItemClickListener(this.H);
            this.b.a(this.L, this.M);
            LayoutParams i = i();
            i.a = 8388613 | (this.n & android.support.v7.b.a.j.AppCompatTheme_spinnerStyle);
            this.b.setLayoutParams(i);
            a(this.b, false);
        }
    }

    private void o() {
        if (this.e == null) {
            this.e = new n(getContext(), null, android.support.v7.b.a.a.toolbarNavigationButtonStyle);
            LayoutParams i = i();
            i.a = 8388611 | (this.n & android.support.v7.b.a.j.AppCompatTheme_spinnerStyle);
            this.e.setLayoutParams(i);
        }
    }

    private void p() {
        if (this.i == null) {
            this.i = new n(getContext(), null, android.support.v7.b.a.a.toolbarNavigationButtonStyle);
            this.i.setImageDrawable(this.g);
            this.i.setContentDescription(this.h);
            LayoutParams i = i();
            i.a = 8388611 | (this.n & android.support.v7.b.a.j.AppCompatTheme_spinnerStyle);
            i.b = 2;
            this.i.setLayoutParams(i);
            this.i.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ Toolbar a;

                {
                    this.a = r1;
                }

                public void onClick(View view) {
                    this.a.h();
                }
            });
        }
    }

    private void q() {
        removeCallbacks(this.O);
        post(this.O);
    }

    private boolean r() {
        if (!this.N) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private void s() {
        if (this.t == null) {
            this.t = new an();
        }
    }

    public b a(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    protected b a(LayoutParams layoutParams) {
        return layoutParams instanceof b ? new b((b) layoutParams) : layoutParams instanceof android.support.v7.a.a.a ? new b((android.support.v7.a.a.a) layoutParams) : layoutParams instanceof MarginLayoutParams ? new b((MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    public void a(int i, int i2) {
        s();
        this.t.a(i, i2);
    }

    public void a(Context context, int i) {
        this.l = i;
        if (this.c != null) {
            this.c.setTextAppearance(context, i);
        }
    }

    public void a(h hVar, d dVar) {
        if (hVar != null || this.b != null) {
            n();
            h d = this.b.d();
            if (d != hVar) {
                if (d != null) {
                    d.b(this.J);
                    d.b(this.K);
                }
                if (this.K == null) {
                    this.K = new a();
                }
                dVar.d(true);
                if (hVar != null) {
                    hVar.a((o) dVar, this.j);
                    hVar.a(this.K, this.j);
                } else {
                    dVar.a(this.j, null);
                    this.K.a(this.j, null);
                    dVar.b(true);
                    this.K.b(true);
                }
                this.b.setPopupTheme(this.k);
                this.b.setPresenter(dVar);
                this.J = dVar;
            }
        }
    }

    public void a(android.support.v7.view.menu.o.a aVar, android.support.v7.view.menu.h.a aVar2) {
        this.L = aVar;
        this.M = aVar2;
        if (this.b != null) {
            this.b.a(aVar, aVar2);
        }
    }

    public boolean a() {
        return getVisibility() == 0 && this.b != null && this.b.a();
    }

    public void b(Context context, int i) {
        this.m = i;
        if (this.d != null) {
            this.d.setTextAppearance(context, i);
        }
    }

    public boolean b() {
        return this.b != null && this.b.g();
    }

    public boolean c() {
        return this.b != null && this.b.h();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof b);
    }

    public boolean d() {
        return this.b != null && this.b.e();
    }

    public boolean e() {
        return this.b != null && this.b.f();
    }

    public void f() {
        if (this.b != null) {
            this.b.i();
        }
    }

    public boolean g() {
        return (this.K == null || this.K.b == null) ? false : true;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return i();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public int getContentInsetEnd() {
        return this.t != null ? this.t.d() : 0;
    }

    public int getContentInsetEndWithActions() {
        return this.v != Integer.MIN_VALUE ? this.v : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        return this.t != null ? this.t.a() : 0;
    }

    public int getContentInsetRight() {
        return this.t != null ? this.t.b() : 0;
    }

    public int getContentInsetStart() {
        return this.t != null ? this.t.c() : 0;
    }

    public int getContentInsetStartWithNavigation() {
        return this.u != Integer.MIN_VALUE ? this.u : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        int i;
        if (this.b != null) {
            h d = this.b.d();
            i = (d == null || !d.hasVisibleItems()) ? 0 : 1;
        } else {
            i = 0;
        }
        return i != 0 ? Math.max(getContentInsetEnd(), Math.max(this.v, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return ae.c(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return ae.c(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        return this.f != null ? this.f.getDrawable() : null;
    }

    public CharSequence getLogoDescription() {
        return this.f != null ? this.f.getContentDescription() : null;
    }

    public Menu getMenu() {
        m();
        return this.b.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        return this.e != null ? this.e.getContentDescription() : null;
    }

    public Drawable getNavigationIcon() {
        return this.e != null ? this.e.getDrawable() : null;
    }

    public Drawable getOverflowIcon() {
        m();
        return this.b.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.k;
    }

    public CharSequence getSubtitle() {
        return this.y;
    }

    public CharSequence getTitle() {
        return this.x;
    }

    public int getTitleMarginBottom() {
        return this.s;
    }

    public int getTitleMarginEnd() {
        return this.q;
    }

    public int getTitleMarginStart() {
        return this.p;
    }

    public int getTitleMarginTop() {
        return this.r;
    }

    public ac getWrapper() {
        if (this.I == null) {
            this.I = new aw(this, true);
        }
        return this.I;
    }

    public void h() {
        j jVar = this.K == null ? null : this.K.b;
        if (jVar != null) {
            jVar.collapseActionView();
        }
    }

    protected b i() {
        return new b(-2, -2);
    }

    void j() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((b) childAt.getLayoutParams()).b == 2 || childAt == this.b)) {
                removeViewAt(childCount);
                this.E.add(childAt);
            }
        }
    }

    void k() {
        for (int size = this.E.size() - 1; size >= 0; size--) {
            addView((View) this.E.get(size));
        }
        this.E.clear();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.O);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = t.a(motionEvent);
        if (a == 9) {
            this.C = false;
        }
        if (!this.C) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.C = true;
            }
        }
        if (a == 10 || a == 3) {
            this.C = false;
        }
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredHeight;
        int measuredWidth;
        Object obj = ae.c(this) == 1 ? 1 : null;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i5 = width - paddingRight;
        int[] iArr = this.F;
        iArr[1] = 0;
        iArr[0] = 0;
        int g = ae.g(this);
        int min = g >= 0 ? Math.min(g, i4 - i2) : 0;
        if (!a(this.e)) {
            g = i5;
            i5 = paddingLeft;
        } else if (obj != null) {
            g = b(this.e, i5, iArr, min);
            i5 = paddingLeft;
        } else {
            int i6 = i5;
            i5 = a(this.e, paddingLeft, iArr, min);
            g = i6;
        }
        if (a(this.i)) {
            if (obj != null) {
                g = b(this.i, g, iArr, min);
            } else {
                i5 = a(this.i, i5, iArr, min);
            }
        }
        if (a(this.b)) {
            if (obj != null) {
                i5 = a(this.b, i5, iArr, min);
            } else {
                g = b(this.b, g, iArr, min);
            }
        }
        int currentContentInsetLeft = getCurrentContentInsetLeft();
        int currentContentInsetRight = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft - i5);
        iArr[1] = Math.max(0, currentContentInsetRight - ((width - paddingRight) - g));
        i5 = Math.max(i5, currentContentInsetLeft);
        g = Math.min(g, (width - paddingRight) - currentContentInsetRight);
        if (a(this.a)) {
            if (obj != null) {
                g = b(this.a, g, iArr, min);
            } else {
                i5 = a(this.a, i5, iArr, min);
            }
        }
        if (!a(this.f)) {
            currentContentInsetLeft = g;
            currentContentInsetRight = i5;
        } else if (obj != null) {
            currentContentInsetLeft = b(this.f, g, iArr, min);
            currentContentInsetRight = i5;
        } else {
            currentContentInsetLeft = g;
            currentContentInsetRight = a(this.f, i5, iArr, min);
        }
        boolean a = a(this.c);
        boolean a2 = a(this.d);
        i5 = 0;
        if (a) {
            b bVar = (b) this.c.getLayoutParams();
            i5 = 0 + (bVar.bottomMargin + (bVar.topMargin + this.c.getMeasuredHeight()));
        }
        if (a2) {
            bVar = (b) this.d.getLayoutParams();
            measuredHeight = (bVar.bottomMargin + (bVar.topMargin + this.d.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (a || a2) {
            int paddingTop2;
            bVar = (b) (a ? this.c : this.d).getLayoutParams();
            b bVar2 = (b) (a2 ? this.d : this.c).getLayoutParams();
            Object obj2 = ((!a || this.c.getMeasuredWidth() <= 0) && (!a2 || this.d.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.w & android.support.v7.b.a.j.AppCompatTheme_spinnerStyle) {
                case android.support.v7.b.a.j.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                    paddingTop2 = (bVar.topMargin + getPaddingTop()) + this.r;
                    break;
                case android.support.v7.b.a.j.AppCompatTheme_panelMenuListWidth /*80*/:
                    paddingTop2 = (((height - paddingBottom) - bVar2.bottomMargin) - this.s) - measuredHeight;
                    break;
                default:
                    paddingTop2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop2 < bVar.topMargin + this.r) {
                        g = bVar.topMargin + this.r;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop2) - paddingTop;
                        g = measuredHeight < bVar.bottomMargin + this.s ? Math.max(0, paddingTop2 - ((bVar2.bottomMargin + this.s) - measuredHeight)) : paddingTop2;
                    }
                    paddingTop2 = paddingTop + g;
                    break;
            }
            if (obj != null) {
                g = (obj2 != null ? this.p : 0) - iArr[1];
                i5 = currentContentInsetLeft - Math.max(0, g);
                iArr[1] = Math.max(0, -g);
                if (a) {
                    bVar = (b) this.c.getLayoutParams();
                    measuredWidth = i5 - this.c.getMeasuredWidth();
                    currentContentInsetLeft = this.c.getMeasuredHeight() + paddingTop2;
                    this.c.layout(measuredWidth, paddingTop2, i5, currentContentInsetLeft);
                    paddingTop2 = currentContentInsetLeft + bVar.bottomMargin;
                    currentContentInsetLeft = measuredWidth - this.q;
                } else {
                    currentContentInsetLeft = i5;
                }
                if (a2) {
                    bVar = (b) this.d.getLayoutParams();
                    measuredWidth = bVar.topMargin + paddingTop2;
                    measuredHeight = this.d.getMeasuredHeight() + measuredWidth;
                    this.d.layout(i5 - this.d.getMeasuredWidth(), measuredWidth, i5, measuredHeight);
                    g = bVar.bottomMargin + measuredHeight;
                    g = i5 - this.q;
                } else {
                    g = i5;
                }
                currentContentInsetLeft = obj2 != null ? Math.min(currentContentInsetLeft, g) : i5;
            } else {
                g = (obj2 != null ? this.p : 0) - iArr[0];
                currentContentInsetRight += Math.max(0, g);
                iArr[0] = Math.max(0, -g);
                if (a) {
                    bVar = (b) this.c.getLayoutParams();
                    i5 = this.c.getMeasuredWidth() + currentContentInsetRight;
                    measuredWidth = this.c.getMeasuredHeight() + paddingTop2;
                    this.c.layout(currentContentInsetRight, paddingTop2, i5, measuredWidth);
                    g = bVar.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.q;
                    i5 = g;
                } else {
                    measuredWidth = currentContentInsetRight;
                    i5 = paddingTop2;
                }
                if (a2) {
                    bVar = (b) this.d.getLayoutParams();
                    i5 += bVar.topMargin;
                    paddingTop2 = this.d.getMeasuredWidth() + currentContentInsetRight;
                    measuredHeight = this.d.getMeasuredHeight() + i5;
                    this.d.layout(currentContentInsetRight, i5, paddingTop2, measuredHeight);
                    g = bVar.bottomMargin + measuredHeight;
                    g = this.q + paddingTop2;
                } else {
                    g = currentContentInsetRight;
                }
                if (obj2 != null) {
                    currentContentInsetRight = Math.max(measuredWidth, g);
                }
            }
        }
        a(this.D, 3);
        int size = this.D.size();
        i5 = currentContentInsetRight;
        for (measuredWidth = 0; measuredWidth < size; measuredWidth++) {
            i5 = a((View) this.D.get(measuredWidth), i5, iArr, min);
        }
        a(this.D, 5);
        currentContentInsetRight = this.D.size();
        for (measuredWidth = 0; measuredWidth < currentContentInsetRight; measuredWidth++) {
            currentContentInsetLeft = b((View) this.D.get(measuredWidth), currentContentInsetLeft, iArr, min);
        }
        a(this.D, 1);
        measuredWidth = a(this.D, iArr);
        g = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        measuredWidth += g;
        if (g < i5) {
            g = i5;
        } else if (measuredWidth > currentContentInsetLeft) {
            g -= measuredWidth - currentContentInsetLeft;
        }
        paddingLeft = this.D.size();
        measuredWidth = g;
        for (i5 = 0; i5 < paddingLeft; i5++) {
            measuredWidth = a((View) this.D.get(i5), measuredWidth, iArr, min);
        }
        this.D.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.F;
        if (ay.a(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i7 = 0;
        if (a(this.e)) {
            a(this.e, i, 0, i2, 0, this.o);
            i7 = this.e.getMeasuredWidth() + b(this.e);
            max = Math.max(0, this.e.getMeasuredHeight() + c(this.e));
            i6 = ay.a(0, ae.e(this.e));
            i5 = max;
        }
        if (a(this.i)) {
            a(this.i, i, 0, i2, 0, this.o);
            i7 = this.i.getMeasuredWidth() + b(this.i);
            i5 = Math.max(i5, this.i.getMeasuredHeight() + c(this.i));
            i6 = ay.a(i6, ae.e(this.i));
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max2 = 0 + Math.max(currentContentInsetStart, i7);
        iArr[i4] = Math.max(0, currentContentInsetStart - i7);
        i7 = 0;
        if (a(this.b)) {
            a(this.b, i, max2, i2, 0, this.o);
            i7 = this.b.getMeasuredWidth() + b(this.b);
            i5 = Math.max(i5, this.b.getMeasuredHeight() + c(this.b));
            i6 = ay.a(i6, ae.e(this.b));
        }
        currentContentInsetStart = getCurrentContentInsetEnd();
        max2 += Math.max(currentContentInsetStart, i7);
        iArr[i3] = Math.max(0, currentContentInsetStart - i7);
        if (a(this.a)) {
            max2 += a(this.a, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.a.getMeasuredHeight() + c(this.a));
            i6 = ay.a(i6, ae.e(this.a));
        }
        if (a(this.f)) {
            max2 += a(this.f, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f.getMeasuredHeight() + c(this.f));
            i6 = ay.a(i6, ae.e(this.f));
        }
        i4 = getChildCount();
        i3 = 0;
        int i8 = i5;
        i5 = i6;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((b) childAt.getLayoutParams()).b != 0) {
                i7 = i5;
                currentContentInsetStart = i8;
            } else if (a(childAt)) {
                max2 += a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + c(childAt));
                i7 = ay.a(i5, ae.e(childAt));
                currentContentInsetStart = max;
            } else {
                i7 = i5;
                currentContentInsetStart = i8;
            }
            i3++;
            i5 = i7;
            i8 = currentContentInsetStart;
        }
        currentContentInsetStart = 0;
        i7 = 0;
        i6 = this.r + this.s;
        max = this.p + this.q;
        if (a(this.c)) {
            a(this.c, i, max2 + max, i2, i6, iArr);
            currentContentInsetStart = b(this.c) + this.c.getMeasuredWidth();
            i7 = this.c.getMeasuredHeight() + c(this.c);
            i5 = ay.a(i5, ae.e(this.c));
        }
        if (a(this.d)) {
            currentContentInsetStart = Math.max(currentContentInsetStart, a(this.d, i, max2 + max, i2, i6 + i7, iArr));
            i7 += this.d.getMeasuredHeight() + c(this.d);
            i5 = ay.a(i5, ae.e(this.d));
        }
        currentContentInsetStart += max2;
        i7 = Math.max(i8, i7) + (getPaddingTop() + getPaddingBottom());
        currentContentInsetStart = ae.a(Math.max(currentContentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, -16777216 & i5);
        i7 = ae.a(Math.max(i7, getSuggestedMinimumHeight()), i2, i5 << 16);
        if (r()) {
            i7 = 0;
        }
        setMeasuredDimension(currentContentInsetStart, i7);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof d) {
            d dVar = (d) parcelable;
            super.onRestoreInstanceState(dVar.a());
            Menu d = this.b != null ? this.b.d() : null;
            if (!(dVar.b == 0 || this.K == null || d == null)) {
                MenuItem findItem = d.findItem(dVar.b);
                if (findItem != null) {
                    q.b(findItem);
                }
            }
            if (dVar.c) {
                q();
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        s();
        an anVar = this.t;
        if (i != 1) {
            z = false;
        }
        anVar.a(z);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable dVar = new d(super.onSaveInstanceState());
        if (!(this.K == null || this.K.b == null)) {
            dVar.b = this.K.b.getItemId();
        }
        dVar.c = b();
        return dVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = t.a(motionEvent);
        if (a == 0) {
            this.B = false;
        }
        if (!this.B) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.B = true;
            }
        }
        if (a == 1 || a == 3) {
            this.B = false;
        }
        return true;
    }

    public void setCollapsible(boolean z) {
        this.N = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.v) {
            this.v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.u) {
            this.u = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i) {
        setLogo(android.support.v7.c.a.b.b(getContext(), i));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!d(this.f)) {
                a(this.f, true);
            }
        } else if (this.f != null && d(this.f)) {
            removeView(this.f);
            this.E.remove(this.f);
        }
        if (this.f != null) {
            this.f.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        if (this.f != null) {
            this.f.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            o();
        }
        if (this.e != null) {
            this.e.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(android.support.v7.c.a.b.b(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            o();
            if (!d(this.e)) {
                a(this.e, true);
            }
        } else if (this.e != null && d(this.e)) {
            removeView(this.e);
            this.E.remove(this.e);
        }
        if (this.e != null) {
            this.e.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        o();
        this.e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(c cVar) {
        this.G = cVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        m();
        this.b.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.k != i) {
            this.k = i;
            if (i == 0) {
                this.j = getContext();
            } else {
                this.j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.d == null) {
                Context context = getContext();
                this.d = new aa(context);
                this.d.setSingleLine();
                this.d.setEllipsize(TruncateAt.END);
                if (this.m != 0) {
                    this.d.setTextAppearance(context, this.m);
                }
                if (this.A != 0) {
                    this.d.setTextColor(this.A);
                }
            }
            if (!d(this.d)) {
                a(this.d, true);
            }
        } else if (this.d != null && d(this.d)) {
            removeView(this.d);
            this.E.remove(this.d);
        }
        if (this.d != null) {
            this.d.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setSubtitleTextColor(int i) {
        this.A = i;
        if (this.d != null) {
            this.d.setTextColor(i);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.c == null) {
                Context context = getContext();
                this.c = new aa(context);
                this.c.setSingleLine();
                this.c.setEllipsize(TruncateAt.END);
                if (this.l != 0) {
                    this.c.setTextAppearance(context, this.l);
                }
                if (this.z != 0) {
                    this.c.setTextColor(this.z);
                }
            }
            if (!d(this.c)) {
                a(this.c, true);
            }
        } else if (this.c != null && d(this.c)) {
            removeView(this.c);
            this.E.remove(this.c);
        }
        if (this.c != null) {
            this.c.setText(charSequence);
        }
        this.x = charSequence;
    }

    public void setTitleMarginBottom(int i) {
        this.s = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.q = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.p = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.r = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        this.z = i;
        if (this.c != null) {
            this.c.setTextColor(i);
        }
    }
}
