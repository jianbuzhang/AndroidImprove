package android.support.v7.widget;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewConfiguration;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends ah implements android.support.v7.view.c {
    static final a a = new a();
    private boolean A;
    private android.support.v4.widget.f B;
    private boolean C;
    private CharSequence D;
    private boolean E;
    private boolean F;
    private int G;
    private boolean H;
    private CharSequence I;
    private boolean J;
    private int K;
    private SearchableInfo L;
    private Bundle M;
    private Runnable N;
    private final Runnable O;
    private Runnable P;
    private final WeakHashMap<String, ConstantState> Q;
    private final SearchAutoComplete b;
    private final View c;
    private final View d;
    private final ImageView e;
    private final ImageView f;
    private final ImageView g;
    private final ImageView h;
    private f i;
    private Rect j;
    private Rect k;
    private int[] l;
    private int[] m;
    private final ImageView n;
    private final Drawable o;
    private final int p;
    private final int q;
    private final Intent r;
    private final Intent s;
    private final CharSequence t;
    private c u;
    private b v;
    private OnFocusChangeListener w;
    private d x;
    private OnClickListener y;
    private boolean z;

    public static class SearchAutoComplete extends f {
        private int a;
        private SearchView b;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, android.support.v7.b.a.a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.a = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int b = android.support.v4.b.a.a.b(getResources());
            int a = android.support.v4.b.a.a.a(getResources());
            return (b < 960 || a < 720 || configuration.orientation != 2) ? (b >= 600 || (b >= 640 && a >= 480)) ? 192 : 160 : 256;
        }

        public boolean enoughToFilter() {
            return this.a <= 0 || super.enoughToFilter();
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.b.d();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.b.clearFocus();
                        this.b.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.b.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.a(getContext())) {
                    SearchView.a.a(this, true);
                }
            }
        }

        public void performCompletion() {
        }

        protected void replaceText(CharSequence charSequence) {
        }

        void setSearchView(SearchView searchView) {
            this.b = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.a = i;
        }
    }

    private static class a {
        private Method a;
        private Method b;
        private Method c;
        private Method d;

        a() {
            try {
                this.a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.a.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.b.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.c.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            try {
                this.d = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
                this.d.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            if (this.a != null) {
                try {
                    this.a.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.c != null) {
                try {
                    this.c.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
                } catch (Exception e) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            if (this.b != null) {
                try {
                    this.b.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }
    }

    public interface b {
        boolean a();
    }

    public interface c {
        boolean a(String str);
    }

    public interface d {
    }

    static class e extends android.support.v4.g.a {
        public static final Creator<e> CREATOR = android.support.v4.e.d.a(new android.support.v4.e.e<e>() {
            public /* synthetic */ Object a(Parcel parcel, ClassLoader classLoader) {
                return b(parcel, classLoader);
            }

            public /* synthetic */ Object[] a(int i) {
                return b(i);
            }

            public e b(Parcel parcel, ClassLoader classLoader) {
                return new e(parcel, classLoader);
            }

            public e[] b(int i) {
                return new e[i];
            }
        });
        boolean b;

        public e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.b = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        e(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.b + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.b));
        }
    }

    private static class f extends TouchDelegate {
        private final View a;
        private final Rect b = new Rect();
        private final Rect c = new Rect();
        private final Rect d = new Rect();
        private final int e;
        private boolean f;

        public f(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            a(rect, rect2);
            this.a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.b.set(rect);
            this.d.set(rect);
            this.d.inset(-this.e, -this.e);
            this.c.set(rect2);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r7) {
            /*
            r6 = this;
            r1 = 1;
            r0 = 0;
            r2 = r7.getX();
            r3 = (int) r2;
            r2 = r7.getY();
            r4 = (int) r2;
            r2 = r7.getAction();
            switch(r2) {
                case 0: goto L_0x003c;
                case 1: goto L_0x0048;
                case 2: goto L_0x0048;
                case 3: goto L_0x0056;
                default: goto L_0x0013;
            };
        L_0x0013:
            r2 = r0;
        L_0x0014:
            if (r2 == 0) goto L_0x003b;
        L_0x0016:
            if (r1 == 0) goto L_0x005b;
        L_0x0018:
            r0 = r6.c;
            r0 = r0.contains(r3, r4);
            if (r0 != 0) goto L_0x005b;
        L_0x0020:
            r0 = r6.a;
            r0 = r0.getWidth();
            r0 = r0 / 2;
            r0 = (float) r0;
            r1 = r6.a;
            r1 = r1.getHeight();
            r1 = r1 / 2;
            r1 = (float) r1;
            r7.setLocation(r0, r1);
        L_0x0035:
            r0 = r6.a;
            r0 = r0.dispatchTouchEvent(r7);
        L_0x003b:
            return r0;
        L_0x003c:
            r2 = r6.b;
            r2 = r2.contains(r3, r4);
            if (r2 == 0) goto L_0x0013;
        L_0x0044:
            r6.f = r1;
            r2 = r1;
            goto L_0x0014;
        L_0x0048:
            r2 = r6.f;
            if (r2 == 0) goto L_0x0014;
        L_0x004c:
            r5 = r6.d;
            r5 = r5.contains(r3, r4);
            if (r5 != 0) goto L_0x0014;
        L_0x0054:
            r1 = r0;
            goto L_0x0014;
        L_0x0056:
            r2 = r6.f;
            r6.f = r0;
            goto L_0x0014;
        L_0x005b:
            r0 = r6.c;
            r0 = r0.left;
            r0 = r3 - r0;
            r0 = (float) r0;
            r1 = r6.c;
            r1 = r1.top;
            r1 = r4 - r1;
            r1 = (float) r1;
            r7.setLocation(r0, r1);
            goto L_0x0035;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.f.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    private Intent a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.I);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.M != null) {
            intent.putExtra("app_data", this.M);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.L.getSearchActivity());
        return intent;
    }

    private void a(int i, String str, String str2) {
        getContext().startActivity(a("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    private void a(View view, Rect rect) {
        view.getLocationInWindow(this.l);
        getLocationInWindow(this.m);
        int i = this.l[1] - this.m[1];
        int i2 = this.l[0] - this.m[0];
        rect.set(i2, i, view.getWidth() + i2, view.getHeight() + i);
    }

    private void a(boolean z) {
        boolean z2 = true;
        int i = 8;
        this.A = z;
        int i2 = z ? 0 : 8;
        boolean z3 = !TextUtils.isEmpty(this.b.getText());
        this.e.setVisibility(i2);
        b(z3);
        this.c.setVisibility(z ? 8 : 0);
        if (!(this.n.getDrawable() == null || this.z)) {
            i = 0;
        }
        this.n.setVisibility(i);
        h();
        if (z3) {
            z2 = false;
        }
        c(z2);
        g();
    }

    static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private CharSequence b(CharSequence charSequence) {
        if (!this.z || this.o == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.b.getTextSize()) * 1.25d);
        this.o.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.o), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void b(boolean z) {
        int i = 8;
        if (this.C && f() && hasFocus() && (z || !this.H)) {
            i = 0;
        }
        this.f.setVisibility(i);
    }

    private void c(boolean z) {
        int i;
        if (this.H && !c() && z) {
            i = 0;
            this.f.setVisibility(8);
        } else {
            i = 8;
        }
        this.h.setVisibility(i);
    }

    private boolean e() {
        if (this.L == null || !this.L.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.L.getVoiceSearchLaunchWebSearch()) {
            intent = this.r;
        } else if (this.L.getVoiceSearchLaunchRecognizer()) {
            intent = this.s;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    private boolean f() {
        return (this.C || this.H) && !c();
    }

    private void g() {
        int i = 8;
        if (f() && (this.f.getVisibility() == 0 || this.h.getVisibility() == 0)) {
            i = 0;
        }
        this.d.setVisibility(i);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(android.support.v7.b.a.d.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(android.support.v7.b.a.d.abc_search_view_preferred_width);
    }

    private void h() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.b.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.z || this.J)) {
            i = 0;
        }
        ImageView imageView = this.g;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.g.getDrawable();
        if (drawable != null) {
            drawable.setState(i3 != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void i() {
        post(this.O);
    }

    private void k() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.b;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(b(queryHint));
    }

    private void l() {
        int i = 1;
        this.b.setThreshold(this.L.getSuggestThreshold());
        this.b.setImeOptions(this.L.getImeOptions());
        int inputType = this.L.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.L.getSuggestAuthority() != null) {
                inputType = (inputType | 65536) | 524288;
            }
        }
        this.b.setInputType(inputType);
        if (this.B != null) {
            this.B.a(null);
        }
        if (this.L.getSuggestAuthority() != null) {
            this.B = new ap(getContext(), this, this.L, this.Q);
            this.b.setAdapter(this.B);
            ap apVar = (ap) this.B;
            if (this.E) {
                i = 2;
            }
            apVar.a(i);
        }
    }

    private void m() {
        CharSequence text = this.b.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.u == null || !this.u.a(text.toString())) {
                if (this.L != null) {
                    a(0, null, text.toString());
                }
                setImeVisibility(false);
                n();
            }
        }
    }

    private void n() {
        this.b.dismissDropDown();
    }

    private void o() {
        if (!TextUtils.isEmpty(this.b.getText())) {
            this.b.setText("");
            this.b.requestFocus();
            setImeVisibility(true);
        } else if (!this.z) {
        } else {
            if (this.v == null || !this.v.a()) {
                clearFocus();
                a(true);
            }
        }
    }

    private void p() {
        a(false);
        this.b.requestFocus();
        setImeVisibility(true);
        if (this.y != null) {
            this.y.onClick(this);
        }
    }

    private void q() {
        a.a(this.b);
        a.b(this.b);
    }

    private void setImeVisibility(boolean z) {
        if (z) {
            post(this.N);
            return;
        }
        removeCallbacks(this.N);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.b.setText(charSequence);
        this.b.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public void a() {
        if (!this.J) {
            this.J = true;
            this.K = this.b.getImeOptions();
            this.b.setImeOptions(this.K | 33554432);
            this.b.setText("");
            setIconified(false);
        }
    }

    void a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void a(CharSequence charSequence, boolean z) {
        this.b.setText(charSequence);
        if (charSequence != null) {
            this.b.setSelection(this.b.length());
            this.I = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            m();
        }
    }

    public void b() {
        a((CharSequence) "", false);
        clearFocus();
        a(true);
        this.b.setImeOptions(this.K);
        this.J = false;
    }

    public boolean c() {
        return this.A;
    }

    public void clearFocus() {
        this.F = true;
        setImeVisibility(false);
        super.clearFocus();
        this.b.clearFocus();
        this.F = false;
    }

    void d() {
        a(c());
        i();
        if (this.b.hasFocus()) {
            q();
        }
    }

    public int getImeOptions() {
        return this.b.getImeOptions();
    }

    public int getInputType() {
        return this.b.getInputType();
    }

    public int getMaxWidth() {
        return this.G;
    }

    public CharSequence getQuery() {
        return this.b.getText();
    }

    public CharSequence getQueryHint() {
        return this.D != null ? this.D : (this.L == null || this.L.getHintId() == 0) ? this.t : getContext().getText(this.L.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.q;
    }

    int getSuggestionRowLayout() {
        return this.p;
    }

    public android.support.v4.widget.f getSuggestionsAdapter() {
        return this.B;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.O);
        post(this.P);
        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            a(this.b, this.j);
            this.k.set(this.j.left, 0, this.j.right, i4 - i2);
            if (this.i == null) {
                this.i = new f(this.k, this.j, this.b);
                setTouchDelegate(this.i);
                return;
            }
            this.i.a(this.k, this.j);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.G <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.G, size);
                    break;
                }
            case 0:
                if (this.G <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.G;
                    break;
                }
            case 1073741824:
                if (this.G > 0) {
                    size = Math.min(this.G, size);
                    break;
                }
                break;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        switch (mode2) {
            case Integer.MIN_VALUE:
            case 0:
                mode = Math.min(getPreferredHeight(), mode);
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(mode, 1073741824));
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof e) {
            e eVar = (e) parcelable;
            super.onRestoreInstanceState(eVar.a());
            a(eVar.b);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable eVar = new e(super.onSaveInstanceState());
        eVar.b = c();
        return eVar;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        i();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.F || !isFocusable()) {
            return false;
        }
        if (c()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.b.requestFocus(i, rect);
        if (requestFocus) {
            a(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.M = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            o();
        } else {
            p();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.z != z) {
            this.z = z;
            a(z);
            k();
        }
    }

    public void setImeOptions(int i) {
        this.b.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.b.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.G = i;
        requestLayout();
    }

    public void setOnCloseListener(b bVar) {
        this.v = bVar;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.w = onFocusChangeListener;
    }

    public void setOnQueryTextListener(c cVar) {
        this.u = cVar;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.y = onClickListener;
    }

    public void setOnSuggestionListener(d dVar) {
        this.x = dVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.D = charSequence;
        k();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.E = z;
        if (this.B instanceof ap) {
            ((ap) this.B).a(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.L = searchableInfo;
        if (this.L != null) {
            l();
            k();
        }
        this.H = e();
        if (this.H) {
            this.b.setPrivateImeOptions("nm");
        }
        a(c());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.C = z;
        a(c());
    }

    public void setSuggestionsAdapter(android.support.v4.widget.f fVar) {
        this.B = fVar;
        this.b.setAdapter(this.B);
    }
}
