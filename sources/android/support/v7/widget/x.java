package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.g.ab;
import android.support.v4.g.ae;
import android.support.v7.b.a.g;
import android.support.v7.b.a.j;
import android.support.v7.view.d;
import android.support.v7.view.menu.s;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class x extends Spinner implements ab {
    private static final boolean a = (VERSION.SDK_INT >= 23);
    private static final boolean b = (VERSION.SDK_INT >= 16);
    private static final int[] c = new int[]{16843505};
    private g d;
    private Context e;
    private ag f;
    private SpinnerAdapter g;
    private boolean h;
    private b i;
    private int j;
    private final Rect k;

    private static class a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter a;
        private ListAdapter b;

        public a(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (x.a && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof ar) {
                ar arVar = (ar) spinnerAdapter;
                if (arVar.a() == null) {
                    arVar.a(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.b;
            return listAdapter != null ? listAdapter.areAllItemsEnabled() : true;
        }

        public int getCount() {
            return this.a == null ? 0 : this.a.getCount();
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return this.a == null ? null : this.a.getDropDownView(i, view, viewGroup);
        }

        public Object getItem(int i) {
            return this.a == null ? null : this.a.getItem(i);
        }

        public long getItemId(int i) {
            return this.a == null ? -1 : this.a.getItemId(i);
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            return this.a != null && this.a.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.b;
            return listAdapter != null ? listAdapter.isEnabled(i) : true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.a != null) {
                this.a.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.a != null) {
                this.a.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    private class b extends ai {
        final /* synthetic */ x a;
        private CharSequence d;
        private ListAdapter e;
        private final Rect f = new Rect();

        public b(final x xVar, Context context, AttributeSet attributeSet, int i) {
            this.a = xVar;
            super(context, attributeSet, i);
            a((View) xVar);
            a(true);
            a(0);
            a(new OnItemClickListener(this) {
                final /* synthetic */ b b;

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.b.a.setSelection(i);
                    if (this.b.a.getOnItemClickListener() != null) {
                        this.b.a.performItemClick(view, i, this.b.e.getItemId(i));
                    }
                    this.b.c();
                }
            });
        }

        private boolean b(View view) {
            return ae.q(view) && view.getGlobalVisibleRect(this.f);
        }

        public void a() {
            boolean d = d();
            f();
            h(2);
            super.a();
            e().setChoiceMode(1);
            i(this.a.getSelectedItemPosition());
            if (!d) {
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    final OnGlobalLayoutListener anonymousClass2 = new OnGlobalLayoutListener(this) {
                        final /* synthetic */ b a;

                        {
                            this.a = r1;
                        }

                        public void onGlobalLayout() {
                            if (this.a.b(this.a.a)) {
                                this.a.f();
                                super.a();
                                return;
                            }
                            this.a.c();
                        }
                    };
                    viewTreeObserver.addOnGlobalLayoutListener(anonymousClass2);
                    a(new OnDismissListener(this) {
                        final /* synthetic */ b b;

                        public void onDismiss() {
                            ViewTreeObserver viewTreeObserver = this.b.a.getViewTreeObserver();
                            if (viewTreeObserver != null) {
                                viewTreeObserver.removeGlobalOnLayoutListener(anonymousClass2);
                            }
                        }
                    });
                }
            }
        }

        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.e = listAdapter;
        }

        public void a(CharSequence charSequence) {
            this.d = charSequence;
        }

        public CharSequence b() {
            return this.d;
        }

        void f() {
            int i;
            Drawable h = h();
            if (h != null) {
                h.getPadding(this.a.k);
                i = ay.a(this.a) ? this.a.k.right : -this.a.k.left;
            } else {
                Rect b = this.a.k;
                this.a.k.right = 0;
                b.left = 0;
                i = 0;
            }
            int paddingLeft = this.a.getPaddingLeft();
            int paddingRight = this.a.getPaddingRight();
            int width = this.a.getWidth();
            if (this.a.j == -2) {
                int a = this.a.a((SpinnerAdapter) this.e, h());
                int i2 = (this.a.getContext().getResources().getDisplayMetrics().widthPixels - this.a.k.left) - this.a.k.right;
                if (a <= i2) {
                    i2 = a;
                }
                g(Math.max(i2, (width - paddingLeft) - paddingRight));
            } else if (this.a.j == -1) {
                g((width - paddingLeft) - paddingRight);
            } else {
                g(this.a.j);
            }
            c(ay.a(this.a) ? ((width - paddingRight) - l()) + i : i + paddingLeft);
        }
    }

    public x(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.b.a.a.spinnerStyle);
    }

    public x(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public x(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    public x(Context context, AttributeSet attributeSet, int i, int i2, Theme theme) {
        Throwable e;
        final b bVar;
        av a;
        CharSequence[] f;
        SpinnerAdapter arrayAdapter;
        super(context, attributeSet, i);
        this.k = new Rect();
        av a2 = av.a(context, attributeSet, j.Spinner, i, 0);
        this.d = new g(this);
        if (theme != null) {
            this.e = new d(context, theme);
        } else {
            int g = a2.g(j.Spinner_popupTheme, 0);
            if (g != 0) {
                this.e = new d(context, g);
            } else {
                this.e = !a ? context : null;
            }
        }
        if (this.e != null) {
            if (i2 == -1) {
                if (VERSION.SDK_INT >= 11) {
                    TypedArray obtainStyledAttributes;
                    try {
                        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c, i, 0);
                        try {
                            if (obtainStyledAttributes.hasValue(0)) {
                                i2 = obtainStyledAttributes.getInt(0, 0);
                            }
                            if (obtainStyledAttributes != null) {
                                obtainStyledAttributes.recycle();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                if (i2 == 1) {
                                    bVar = new b(this, this.e, attributeSet, i);
                                    a = av.a(this.e, attributeSet, j.Spinner, i, 0);
                                    this.j = a.f(j.Spinner_android_dropDownWidth, -2);
                                    bVar.a(a.a(j.Spinner_android_popupBackground));
                                    bVar.a(a2.d(j.Spinner_android_prompt));
                                    a.a();
                                    this.i = bVar;
                                    this.f = new ag(this, this) {
                                        final /* synthetic */ x b;

                                        public s a() {
                                            return bVar;
                                        }

                                        public boolean b() {
                                            if (!this.b.i.d()) {
                                                this.b.i.a();
                                            }
                                            return true;
                                        }
                                    };
                                }
                                f = a2.f(j.Spinner_android_entries);
                                if (f != null) {
                                    arrayAdapter = new ArrayAdapter(context, 17367048, f);
                                    arrayAdapter.setDropDownViewResource(g.support_simple_spinner_dropdown_item);
                                    setAdapter(arrayAdapter);
                                }
                                a2.a();
                                this.h = true;
                                if (this.g != null) {
                                    setAdapter(this.g);
                                    this.g = null;
                                }
                                this.d.a(attributeSet, i);
                            } catch (Throwable th) {
                                e = th;
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                throw e;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        obtainStyledAttributes = null;
                        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        if (i2 == 1) {
                            bVar = new b(this, this.e, attributeSet, i);
                            a = av.a(this.e, attributeSet, j.Spinner, i, 0);
                            this.j = a.f(j.Spinner_android_dropDownWidth, -2);
                            bVar.a(a.a(j.Spinner_android_popupBackground));
                            bVar.a(a2.d(j.Spinner_android_prompt));
                            a.a();
                            this.i = bVar;
                            this.f = /* anonymous class already generated */;
                        }
                        f = a2.f(j.Spinner_android_entries);
                        if (f != null) {
                            arrayAdapter = new ArrayAdapter(context, 17367048, f);
                            arrayAdapter.setDropDownViewResource(g.support_simple_spinner_dropdown_item);
                            setAdapter(arrayAdapter);
                        }
                        a2.a();
                        this.h = true;
                        if (this.g != null) {
                            setAdapter(this.g);
                            this.g = null;
                        }
                        this.d.a(attributeSet, i);
                    } catch (Throwable th2) {
                        e = th2;
                        obtainStyledAttributes = null;
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        throw e;
                    }
                }
                i2 = 1;
            }
            if (i2 == 1) {
                bVar = new b(this, this.e, attributeSet, i);
                a = av.a(this.e, attributeSet, j.Spinner, i, 0);
                this.j = a.f(j.Spinner_android_dropDownWidth, -2);
                bVar.a(a.a(j.Spinner_android_popupBackground));
                bVar.a(a2.d(j.Spinner_android_prompt));
                a.a();
                this.i = bVar;
                this.f = /* anonymous class already generated */;
            }
        }
        f = a2.f(j.Spinner_android_entries);
        if (f != null) {
            arrayAdapter = new ArrayAdapter(context, 17367048, f);
            arrayAdapter.setDropDownViewResource(g.support_simple_spinner_dropdown_item);
            setAdapter(arrayAdapter);
        }
        a2.a();
        this.h = true;
        if (this.g != null) {
            setAdapter(this.g);
            this.g = null;
        }
        this.d.a(attributeSet, i);
    }

    private int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.k);
        return (this.k.left + this.k.right) + i;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.d != null) {
            this.d.c();
        }
    }

    public int getDropDownHorizontalOffset() {
        return this.i != null ? this.i.j() : b ? super.getDropDownHorizontalOffset() : 0;
    }

    public int getDropDownVerticalOffset() {
        return this.i != null ? this.i.k() : b ? super.getDropDownVerticalOffset() : 0;
    }

    public int getDropDownWidth() {
        return this.i != null ? this.j : b ? super.getDropDownWidth() : 0;
    }

    public Drawable getPopupBackground() {
        return this.i != null ? this.i.h() : b ? super.getPopupBackground() : null;
    }

    public Context getPopupContext() {
        return this.i != null ? this.e : a ? super.getPopupContext() : null;
    }

    public CharSequence getPrompt() {
        return this.i != null ? this.i.b() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.d != null ? this.d.a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.d != null ? this.d.b() : null;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.i != null && this.i.d()) {
            this.i.c();
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.i != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.f == null || !this.f.onTouch(this, motionEvent)) ? super.onTouchEvent(motionEvent) : true;
    }

    public boolean performClick() {
        if (this.i == null) {
            return super.performClick();
        }
        if (!this.i.d()) {
            this.i.a();
        }
        return true;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.h) {
            super.setAdapter(spinnerAdapter);
            if (this.i != null) {
                this.i.a(new a(spinnerAdapter, (this.e == null ? getContext() : this.e).getTheme()));
                return;
            }
            return;
        }
        this.g = spinnerAdapter;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.d != null) {
            this.d.a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.d != null) {
            this.d.a(i);
        }
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.i != null) {
            this.i.c(i);
        } else if (b) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.i != null) {
            this.i.d(i);
        } else if (b) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public void setDropDownWidth(int i) {
        if (this.i != null) {
            this.j = i;
        } else if (b) {
            super.setDropDownWidth(i);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.i != null) {
            this.i.a(drawable);
        } else if (b) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(android.support.v7.c.a.b.b(getPopupContext(), i));
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.i != null) {
            this.i.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.d != null) {
            this.d.a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.d != null) {
            this.d.a(mode);
        }
    }
}
