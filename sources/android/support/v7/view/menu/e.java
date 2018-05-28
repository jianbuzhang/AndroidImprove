package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.g.ae;
import android.support.v4.g.f;
import android.support.v7.b.a.d;
import android.support.v7.b.a.g;
import android.support.v7.widget.ak;
import android.support.v7.widget.al;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class e extends m implements o, OnKeyListener, OnDismissListener {
    private final Context a;
    private final int b;
    private final int c;
    private final int d;
    private final boolean e;
    private final Handler f;
    private final List<h> g = new LinkedList();
    private final List<a> h = new ArrayList();
    private final OnGlobalLayoutListener i = new OnGlobalLayoutListener(this) {
        final /* synthetic */ e a;

        {
            this.a = r1;
        }

        public void onGlobalLayout() {
            if (this.a.d() && this.a.h.size() > 0 && !((a) this.a.h.get(0)).a.g()) {
                View b = this.a.n;
                if (b == null || !b.isShown()) {
                    this.a.c();
                    return;
                }
                for (a aVar : this.a.h) {
                    aVar.a.a();
                }
            }
        }
    };
    private final ak j = new ak(this) {
        final /* synthetic */ e a;

        {
            this.a = r1;
        }

        public void a(h hVar, MenuItem menuItem) {
            this.a.f.removeCallbacksAndMessages(hVar);
        }

        public void b(final h hVar, final MenuItem menuItem) {
            int i;
            this.a.f.removeCallbacksAndMessages(null);
            int size = this.a.h.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (hVar == ((a) this.a.h.get(i2)).b) {
                    i = i2;
                    break;
                }
            }
            i = -1;
            if (i != -1) {
                i++;
                final a aVar = i < this.a.h.size() ? (a) this.a.h.get(i) : null;
                this.a.f.postAtTime(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 d;

                    public void run() {
                        if (aVar != null) {
                            this.d.a.y = true;
                            aVar.b.a(false);
                            this.d.a.y = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            hVar.a(menuItem, 0);
                        }
                    }
                }, hVar, SystemClock.uptimeMillis() + 200);
            }
        }
    };
    private int k = 0;
    private int l = 0;
    private View m;
    private View n;
    private int o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private android.support.v7.view.menu.o.a v;
    private ViewTreeObserver w;
    private OnDismissListener x;
    private boolean y;

    private static class a {
        public final al a;
        public final h b;
        public final int c;

        public a(al alVar, h hVar, int i) {
            this.a = alVar;
            this.b = hVar;
            this.c = i;
        }

        public ListView a() {
            return this.a.e();
        }
    }

    public e(Context context, View view, int i, int i2, boolean z) {
        this.a = context;
        this.m = view;
        this.c = i;
        this.d = i2;
        this.e = z;
        this.t = false;
        this.o = i();
        Resources resources = context.getResources();
        this.b = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.abc_config_prefDialogWidth));
        this.f = new Handler();
    }

    private MenuItem a(h hVar, h hVar2) {
        int size = hVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = hVar.getItem(i);
            if (item.hasSubMenu() && hVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View a(a aVar, h hVar) {
        int i = 0;
        MenuItem a = a(aVar.b, hVar);
        if (a == null) {
            return null;
        }
        int headersCount;
        g gVar;
        int i2;
        ListView a2 = aVar.a();
        ListAdapter adapter = a2.getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            gVar = (g) headerViewListAdapter.getWrappedAdapter();
        } else {
            gVar = (g) adapter;
            headersCount = 0;
        }
        int count = gVar.getCount();
        while (i < count) {
            if (a == gVar.a(i)) {
                i2 = i;
                break;
            }
            i++;
        }
        i2 = -1;
        if (i2 == -1) {
            return null;
        }
        i2 = (i2 + headersCount) - a2.getFirstVisiblePosition();
        return (i2 < 0 || i2 >= a2.getChildCount()) ? null : a2.getChildAt(i2);
    }

    private void c(h hVar) {
        View a;
        a aVar;
        LayoutInflater from = LayoutInflater.from(this.a);
        Object gVar = new g(hVar, from, this.e);
        if (!d() && this.t) {
            gVar.a(true);
        } else if (d()) {
            gVar.a(m.b(hVar));
        }
        int a2 = m.a(gVar, null, this.a, this.b);
        al h = h();
        h.a((ListAdapter) gVar);
        h.g(a2);
        h.e(this.l);
        if (this.h.size() > 0) {
            a aVar2 = (a) this.h.get(this.h.size() - 1);
            a = a(aVar2, hVar);
            aVar = aVar2;
        } else {
            a = null;
            aVar = null;
        }
        if (a != null) {
            h.b(false);
            h.a(null);
            int d = d(a2);
            boolean z = d == 1;
            this.o = d;
            int[] iArr = new int[2];
            a.getLocationInWindow(iArr);
            int j = aVar.a.j() + iArr[0];
            int k = iArr[1] + aVar.a.k();
            int width = (this.l & 5) == 5 ? z ? j + a2 : j - a.getWidth() : z ? a.getWidth() + j : j - a2;
            h.c(width);
            h.d(k);
        } else {
            if (this.p) {
                h.c(this.r);
            }
            if (this.q) {
                h.d(this.s);
            }
            h.a(g());
        }
        this.h.add(new a(h, hVar, this.o));
        h.a();
        if (aVar == null && this.u && hVar.m() != null) {
            ViewGroup e = h.e();
            FrameLayout frameLayout = (FrameLayout) from.inflate(g.abc_popup_menu_header_item_layout, e, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            frameLayout.setEnabled(false);
            textView.setText(hVar.m());
            e.addHeaderView(frameLayout, null, false);
            h.a();
        }
    }

    private int d(int i) {
        ListView a = ((a) this.h.get(this.h.size() - 1)).a();
        int[] iArr = new int[2];
        a.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.n.getWindowVisibleDisplayFrame(rect);
        if (this.o != 1) {
            return iArr[0] - i < 0 ? 1 : 0;
        } else {
            return (a.getWidth() + iArr[0]) + i > rect.right ? 0 : 1;
        }
    }

    private int d(h hVar) {
        int size = this.h.size();
        for (int i = 0; i < size; i++) {
            if (hVar == ((a) this.h.get(i)).b) {
                return i;
            }
        }
        return -1;
    }

    private al h() {
        al alVar = new al(this.a, null, this.c, this.d);
        alVar.a(this.j);
        alVar.a((OnItemClickListener) this);
        alVar.a((OnDismissListener) this);
        alVar.a(this.m);
        alVar.e(this.l);
        alVar.a(true);
        return alVar;
    }

    private int i() {
        return ae.c(this.m) == 1 ? 0 : 1;
    }

    public void a() {
        if (!d()) {
            for (h c : this.g) {
                c(c);
            }
            this.g.clear();
            this.n = this.m;
            if (this.n != null) {
                Object obj = this.w == null ? 1 : null;
                this.w = this.n.getViewTreeObserver();
                if (obj != null) {
                    this.w.addOnGlobalLayoutListener(this.i);
                }
            }
        }
    }

    public void a(int i) {
        if (this.k != i) {
            this.k = i;
            this.l = f.a(i, ae.c(this.m));
        }
    }

    public void a(h hVar) {
        hVar.a((o) this, this.a);
        if (d()) {
            c(hVar);
        } else {
            this.g.add(hVar);
        }
    }

    public void a(h hVar, boolean z) {
        int d = d(hVar);
        if (d >= 0) {
            int i = d + 1;
            if (i < this.h.size()) {
                ((a) this.h.get(i)).b.a(false);
            }
            a aVar = (a) this.h.remove(d);
            aVar.b.b((o) this);
            if (this.y) {
                aVar.a.b(null);
                aVar.a.b(0);
            }
            aVar.a.c();
            d = this.h.size();
            if (d > 0) {
                this.o = ((a) this.h.get(d - 1)).c;
            } else {
                this.o = i();
            }
            if (d == 0) {
                c();
                if (this.v != null) {
                    this.v.a(hVar, true);
                }
                if (this.w != null) {
                    if (this.w.isAlive()) {
                        this.w.removeGlobalOnLayoutListener(this.i);
                    }
                    this.w = null;
                }
                this.x.onDismiss();
            } else if (z) {
                ((a) this.h.get(0)).b.a(false);
            }
        }
    }

    public void a(android.support.v7.view.menu.o.a aVar) {
        this.v = aVar;
    }

    public void a(View view) {
        if (this.m != view) {
            this.m = view;
            this.l = f.a(this.k, ae.c(this.m));
        }
    }

    public void a(OnDismissListener onDismissListener) {
        this.x = onDismissListener;
    }

    public void a(boolean z) {
        this.t = z;
    }

    public boolean a(u uVar) {
        for (a aVar : this.h) {
            if (uVar == aVar.b) {
                aVar.a().requestFocus();
                return true;
            }
        }
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        a((h) uVar);
        if (this.v != null) {
            this.v.a(uVar);
        }
        return true;
    }

    public void b(int i) {
        this.p = true;
        this.r = i;
    }

    public void b(boolean z) {
        for (a a : this.h) {
            m.a(a.a().getAdapter()).notifyDataSetChanged();
        }
    }

    public boolean b() {
        return false;
    }

    public void c() {
        int size = this.h.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.h.toArray(new a[size]);
            for (size--; size >= 0; size--) {
                a aVar = aVarArr[size];
                if (aVar.a.d()) {
                    aVar.a.c();
                }
            }
        }
    }

    public void c(int i) {
        this.q = true;
        this.s = i;
    }

    public void c(boolean z) {
        this.u = z;
    }

    public boolean d() {
        return this.h.size() > 0 && ((a) this.h.get(0)).a.d();
    }

    public ListView e() {
        return this.h.isEmpty() ? null : ((a) this.h.get(this.h.size() - 1)).a();
    }

    protected boolean f() {
        return false;
    }

    public void onDismiss() {
        a aVar;
        int size = this.h.size();
        for (int i = 0; i < size; i++) {
            aVar = (a) this.h.get(i);
            if (!aVar.a.d()) {
                break;
            }
        }
        aVar = null;
        if (aVar != null) {
            aVar.b.a(false);
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
