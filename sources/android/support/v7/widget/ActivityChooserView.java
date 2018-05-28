package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.g.ae;
import android.support.v4.g.e;
import android.support.v7.b.a.f;
import android.support.v7.b.a.g;
import android.support.v7.b.a.h;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

public class ActivityChooserView extends ViewGroup {
    e a;
    private final a b;
    private final b c;
    private final ah d;
    private final FrameLayout e;
    private final ImageView f;
    private final FrameLayout g;
    private final int h;
    private final DataSetObserver i;
    private final OnGlobalLayoutListener j;
    private ai k;
    private OnDismissListener l;
    private boolean m;
    private int n;
    private boolean o;
    private int p;

    public static class InnerLayout extends ah {
        private static final int[] a = new int[]{16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            av a = av.a(context, attributeSet, a);
            setBackgroundDrawable(a.a(0));
            a.a();
        }
    }

    private class a extends BaseAdapter {
        final /* synthetic */ ActivityChooserView a;
        private e b;
        private int c;
        private boolean d;
        private boolean e;
        private boolean f;

        public int a() {
            int i = 0;
            int i2 = this.c;
            this.c = Integer.MAX_VALUE;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i3 = 0;
            while (i < count) {
                view = getView(i, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
                i++;
            }
            this.c = i2;
            return i3;
        }

        public void a(int i) {
            if (this.c != i) {
                this.c = i;
                notifyDataSetChanged();
            }
        }

        public void a(e eVar) {
            e d = this.a.b.d();
            if (d != null && this.a.isShown()) {
                d.unregisterObserver(this.a.i);
            }
            this.b = eVar;
            if (eVar != null && this.a.isShown()) {
                eVar.registerObserver(this.a.i);
            }
            notifyDataSetChanged();
        }

        public void a(boolean z) {
            if (this.f != z) {
                this.f = z;
                notifyDataSetChanged();
            }
        }

        public void a(boolean z, boolean z2) {
            if (this.d != z || this.e != z2) {
                this.d = z;
                this.e = z2;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo b() {
            return this.b.b();
        }

        public int c() {
            return this.b.a();
        }

        public e d() {
            return this.b;
        }

        public boolean e() {
            return this.d;
        }

        public int getCount() {
            int a = this.b.a();
            if (!(this.d || this.b.b() == null)) {
                a--;
            }
            a = Math.min(a, this.c);
            return this.f ? a + 1 : a;
        }

        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!(this.d || this.b.b() == null)) {
                        i++;
                    }
                    return this.b.a(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            return (this.f && i == getCount() - 1) ? 1 : 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != f.list_item) {
                        view = LayoutInflater.from(this.a.getContext()).inflate(g.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = this.a.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(f.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(f.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.d && i == 0 && this.e) {
                        ae.b(view, true);
                        return view;
                    }
                    ae.b(view, false);
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    view = LayoutInflater.from(this.a.getContext()).inflate(g.abc_activity_chooser_view_list_item, viewGroup, false);
                    view.setId(1);
                    ((TextView) view.findViewById(f.title)).setText(this.a.getContext().getString(h.abc_activity_chooser_view_see_all));
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public int getViewTypeCount() {
            return 3;
        }
    }

    private class b implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
        final /* synthetic */ ActivityChooserView a;

        private void a() {
            if (this.a.l != null) {
                this.a.l.onDismiss();
            }
        }

        public void onClick(View view) {
            if (view == this.a.g) {
                this.a.b();
                Intent b = this.a.b.d().b(this.a.b.d().a(this.a.b.b()));
                if (b != null) {
                    b.addFlags(524288);
                    this.a.getContext().startActivity(b);
                }
            } else if (view == this.a.e) {
                this.a.m = false;
                this.a.a(this.a.n);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void onDismiss() {
            a();
            if (this.a.a != null) {
                this.a.a.a(false);
            }
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    this.a.b();
                    if (!this.a.m) {
                        if (!this.a.b.e()) {
                            i++;
                        }
                        Intent b = this.a.b.d().b(i);
                        if (b != null) {
                            b.addFlags(524288);
                            this.a.getContext().startActivity(b);
                            return;
                        }
                        return;
                    } else if (i > 0) {
                        this.a.b.d().c(i);
                        return;
                    } else {
                        return;
                    }
                case 1:
                    this.a.a(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            if (view == this.a.g) {
                if (this.a.b.getCount() > 0) {
                    this.a.m = true;
                    this.a.a(this.a.n);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    private void a(int i) {
        if (this.b.d() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.j);
        boolean z = this.g.getVisibility() == 0;
        int c = this.b.c();
        int i2 = z ? 1 : 0;
        if (i == Integer.MAX_VALUE || c <= i2 + i) {
            this.b.a(false);
            this.b.a(i);
        } else {
            this.b.a(true);
            this.b.a(i - 1);
        }
        ai listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.d()) {
            if (this.m || !z) {
                this.b.a(true, z);
            } else {
                this.b.a(false, false);
            }
            listPopupWindow.g(Math.min(this.b.a(), this.h));
            listPopupWindow.a();
            if (this.a != null) {
                this.a.a(true);
            }
            listPopupWindow.e().setContentDescription(getContext().getString(h.abc_activitychooserview_choose_application));
        }
    }

    private ai getListPopupWindow() {
        if (this.k == null) {
            this.k = new ai(getContext());
            this.k.a(this.b);
            this.k.a((View) this);
            this.k.a(true);
            this.k.a(this.c);
            this.k.a(this.c);
        }
        return this.k;
    }

    public boolean a() {
        if (c() || !this.o) {
            return false;
        }
        this.m = false;
        a(this.n);
        return true;
    }

    public boolean b() {
        if (c()) {
            getListPopupWindow().c();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.j);
            }
        }
        return true;
    }

    public boolean c() {
        return getListPopupWindow().d();
    }

    public e getDataModel() {
        return this.b.d();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e d = this.b.d();
        if (d != null) {
            d.registerObserver(this.i);
        }
        this.o = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e d = this.b.d();
        if (d != null) {
            d.unregisterObserver(this.i);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.j);
        }
        if (c()) {
            b();
        }
        this.o = false;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.d.layout(0, 0, i3 - i, i4 - i2);
        if (!c()) {
            b();
        }
    }

    protected void onMeasure(int i, int i2) {
        View view = this.d;
        if (this.g.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(e eVar) {
        this.b.a(eVar);
        if (c()) {
            b();
            a();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.p = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.n = i;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.l = onDismissListener;
    }

    public void setProvider(e eVar) {
        this.a = eVar;
    }
}
