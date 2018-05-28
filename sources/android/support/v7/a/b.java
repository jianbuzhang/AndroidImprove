package android.support.v7.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.g.ae;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.b.a.f;
import android.support.v7.b.a.j;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class b {
    private TextView A;
    private TextView B;
    private View C;
    private ListAdapter D;
    private int E = -1;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L = 0;
    private Handler M;
    private final OnClickListener N = new OnClickListener(this) {
        final /* synthetic */ b a;

        {
            this.a = r1;
        }

        public void onClick(View view) {
            Message obtain = (view != this.a.n || this.a.p == null) ? (view != this.a.q || this.a.s == null) ? (view != this.a.t || this.a.v == null) ? null : Message.obtain(this.a.v) : Message.obtain(this.a.s) : Message.obtain(this.a.p);
            if (obtain != null) {
                obtain.sendToTarget();
            }
            this.a.M.obtainMessage(1, this.a.b).sendToTarget();
        }
    };
    private final Context a;
    private final m b;
    private final Window c;
    private CharSequence d;
    private CharSequence e;
    private ListView f;
    private View g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean m = false;
    private Button n;
    private CharSequence o;
    private Message p;
    private Button q;
    private CharSequence r;
    private Message s;
    private Button t;
    private CharSequence u;
    private Message v;
    private NestedScrollView w;
    private int x = 0;
    private Drawable y;
    private ImageView z;

    public static class a {
        public int A;
        public boolean B = false;
        public boolean[] C;
        public boolean D;
        public boolean E;
        public int F = -1;
        public OnMultiChoiceClickListener G;
        public Cursor H;
        public String I;
        public String J;
        public OnItemSelectedListener K;
        public a L;
        public boolean M = true;
        public final Context a;
        public final LayoutInflater b;
        public int c = 0;
        public Drawable d;
        public int e = 0;
        public CharSequence f;
        public View g;
        public CharSequence h;
        public CharSequence i;
        public DialogInterface.OnClickListener j;
        public CharSequence k;
        public DialogInterface.OnClickListener l;
        public CharSequence m;
        public DialogInterface.OnClickListener n;
        public boolean o;
        public OnCancelListener p;
        public OnDismissListener q;
        public OnKeyListener r;
        public CharSequence[] s;
        public ListAdapter t;
        public DialogInterface.OnClickListener u;
        public int v;
        public View w;
        public int x;
        public int y;
        public int z;

        public interface a {
            void a(ListView listView);
        }

        public a(Context context) {
            this.a = context;
            this.o = true;
            this.b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void b(final b bVar) {
            ListAdapter simpleCursorAdapter;
            final ListView listView = (ListView) this.b.inflate(bVar.H, null);
            if (!this.D) {
                int m = this.E ? bVar.J : bVar.K;
                simpleCursorAdapter = this.H != null ? new SimpleCursorAdapter(this.a, m, this.H, new String[]{this.I}, new int[]{16908308}) : this.t != null ? this.t : new c(this.a, m, 16908308, this.s);
            } else if (this.H == null) {
                simpleCursorAdapter = new ArrayAdapter<CharSequence>(this, this.a, bVar.I, 16908308, this.s) {
                    final /* synthetic */ a b;

                    public View getView(int i, View view, ViewGroup viewGroup) {
                        View view2 = super.getView(i, view, viewGroup);
                        if (this.b.C != null && this.b.C[i]) {
                            listView.setItemChecked(i, true);
                        }
                        return view2;
                    }
                };
            } else {
                final b bVar2 = bVar;
                Object anonymousClass2 = new CursorAdapter(this, this.a, this.H, false) {
                    final /* synthetic */ a c;
                    private final int d;
                    private final int e;

                    public void bindView(View view, Context context, Cursor cursor) {
                        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.d));
                        listView.setItemChecked(cursor.getPosition(), cursor.getInt(this.e) == 1);
                    }

                    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                        return this.c.b.inflate(bVar2.I, viewGroup, false);
                    }
                };
            }
            if (this.L != null) {
                this.L.a(listView);
            }
            bVar.D = simpleCursorAdapter;
            bVar.E = this.F;
            if (this.u != null) {
                listView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ a b;

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.b.u.onClick(bVar.b, i);
                        if (!this.b.E) {
                            bVar.b.dismiss();
                        }
                    }
                });
            } else if (this.G != null) {
                listView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ a c;

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (this.c.C != null) {
                            this.c.C[i] = listView.isItemChecked(i);
                        }
                        this.c.G.onClick(bVar.b, i, listView.isItemChecked(i));
                    }
                });
            }
            if (this.K != null) {
                listView.setOnItemSelectedListener(this.K);
            }
            if (this.E) {
                listView.setChoiceMode(1);
            } else if (this.D) {
                listView.setChoiceMode(2);
            }
            bVar.f = listView;
        }

        public void a(b bVar) {
            if (this.g != null) {
                bVar.b(this.g);
            } else {
                if (this.f != null) {
                    bVar.a(this.f);
                }
                if (this.d != null) {
                    bVar.a(this.d);
                }
                if (this.c != 0) {
                    bVar.b(this.c);
                }
                if (this.e != 0) {
                    bVar.b(bVar.c(this.e));
                }
            }
            if (this.h != null) {
                bVar.b(this.h);
            }
            if (this.i != null) {
                bVar.a(-1, this.i, this.j, null);
            }
            if (this.k != null) {
                bVar.a(-2, this.k, this.l, null);
            }
            if (this.m != null) {
                bVar.a(-3, this.m, this.n, null);
            }
            if (!(this.s == null && this.H == null && this.t == null)) {
                b(bVar);
            }
            if (this.w != null) {
                if (this.B) {
                    bVar.a(this.w, this.x, this.y, this.z, this.A);
                    return;
                }
                bVar.c(this.w);
            } else if (this.v != 0) {
                bVar.a(this.v);
            }
        }
    }

    private static final class b extends Handler {
        private WeakReference<DialogInterface> a;

        public b(DialogInterface dialogInterface) {
            this.a = new WeakReference(dialogInterface);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case -3:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.a.get(), message.what);
                    return;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    private static class c extends ArrayAdapter<CharSequence> {
        public c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public b(Context context, m mVar, Window window) {
        this.a = context;
        this.b = mVar;
        this.c = window;
        this.M = new b(mVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, j.AlertDialog, android.support.v7.b.a.a.alertDialogStyle, 0);
        this.F = obtainStyledAttributes.getResourceId(j.AlertDialog_android_layout, 0);
        this.G = obtainStyledAttributes.getResourceId(j.AlertDialog_buttonPanelSideLayout, 0);
        this.H = obtainStyledAttributes.getResourceId(j.AlertDialog_listLayout, 0);
        this.I = obtainStyledAttributes.getResourceId(j.AlertDialog_multiChoiceItemLayout, 0);
        this.J = obtainStyledAttributes.getResourceId(j.AlertDialog_singleChoiceItemLayout, 0);
        this.K = obtainStyledAttributes.getResourceId(j.AlertDialog_listItemLayout, 0);
        obtainStyledAttributes.recycle();
        mVar.a(1);
    }

    private ViewGroup a(View view, View view2) {
        if (view == null) {
            return (ViewGroup) (view2 instanceof ViewStub ? ((ViewStub) view2).inflate() : view2);
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        return (ViewGroup) (view instanceof ViewStub ? ((ViewStub) view).inflate() : view);
    }

    private void a(ViewGroup viewGroup) {
        boolean z = false;
        View inflate = this.g != null ? this.g : this.h != 0 ? LayoutInflater.from(this.a).inflate(this.h, viewGroup, false) : null;
        if (inflate != null) {
            z = true;
        }
        if (!(z && a(inflate))) {
            this.c.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.c.findViewById(f.custom);
            frameLayout.addView(inflate, new LayoutParams(-1, -1));
            if (this.m) {
                frameLayout.setPadding(this.i, this.j, this.k, this.l);
            }
            if (this.f != null) {
                ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void a(ViewGroup viewGroup, View view, int i, int i2) {
        View view2 = null;
        View findViewById = this.c.findViewById(f.scrollIndicatorUp);
        View findViewById2 = this.c.findViewById(f.scrollIndicatorDown);
        if (VERSION.SDK_INT >= 23) {
            ae.a(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.e != null) {
                this.w.setOnScrollChangeListener(new android.support.v4.widget.NestedScrollView.b(this) {
                    final /* synthetic */ b c;

                    public void a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                        b.b(nestedScrollView, findViewById, view2);
                    }
                });
                this.w.post(new Runnable(this) {
                    final /* synthetic */ b c;

                    public void run() {
                        b.b(this.c.w, findViewById, view2);
                    }
                });
            } else if (this.f != null) {
                this.f.setOnScrollListener(new OnScrollListener(this) {
                    final /* synthetic */ b c;

                    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                        b.b(absListView, findViewById, view2);
                    }

                    public void onScrollStateChanged(AbsListView absListView, int i) {
                    }
                });
                this.f.post(new Runnable(this) {
                    final /* synthetic */ b c;

                    public void run() {
                        b.b(this.c.f, findViewById, view2);
                    }
                });
            } else {
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (view2 != null) {
                    viewGroup.removeView(view2);
                }
            }
        }
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private int b() {
        return this.G == 0 ? this.F : this.L == 1 ? this.G : this.F;
    }

    private static void b(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(ae.a(view, -1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!ae.a(view, 1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    private void b(ViewGroup viewGroup) {
        if (this.C != null) {
            viewGroup.addView(this.C, 0, new LayoutParams(-1, -2));
            this.c.findViewById(f.title_template).setVisibility(8);
            return;
        }
        this.z = (ImageView) this.c.findViewById(16908294);
        if ((!TextUtils.isEmpty(this.d) ? 1 : 0) != 0) {
            this.A = (TextView) this.c.findViewById(f.alertTitle);
            this.A.setText(this.d);
            if (this.x != 0) {
                this.z.setImageResource(this.x);
                return;
            } else if (this.y != null) {
                this.z.setImageDrawable(this.y);
                return;
            } else {
                this.A.setPadding(this.z.getPaddingLeft(), this.z.getPaddingTop(), this.z.getPaddingRight(), this.z.getPaddingBottom());
                this.z.setVisibility(8);
                return;
            }
        }
        this.c.findViewById(f.title_template).setVisibility(8);
        this.z.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    private void c() {
        View findViewById = this.c.findViewById(f.parentPanel);
        View findViewById2 = findViewById.findViewById(f.topPanel);
        View findViewById3 = findViewById.findViewById(f.contentPanel);
        View findViewById4 = findViewById.findViewById(f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(f.customPanel);
        a(viewGroup);
        View findViewById5 = viewGroup.findViewById(f.topPanel);
        View findViewById6 = viewGroup.findViewById(f.contentPanel);
        View findViewById7 = viewGroup.findViewById(f.buttonPanel);
        ViewGroup a = a(findViewById5, findViewById2);
        ViewGroup a2 = a(findViewById6, findViewById3);
        ViewGroup a3 = a(findViewById7, findViewById4);
        c(a2);
        d(a3);
        b(a);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a == null || a.getVisibility() == 8) ? false : true;
        boolean z3 = (a3 == null || a3.getVisibility() == 8) ? false : true;
        if (!(z3 || a2 == null)) {
            findViewById3 = a2.findViewById(f.textSpacerNoButtons);
            if (findViewById3 != null) {
                findViewById3.setVisibility(0);
            }
        }
        if (z2 && this.w != null) {
            this.w.setClipToPadding(true);
        }
        if (!z) {
            findViewById3 = this.f != null ? this.f : this.w;
            if (findViewById3 != null) {
                a(a2, findViewById3, (z3 ? 2 : 0) | (z2 ? 1 : 0), 3);
            }
        }
        ListView listView = this.f;
        if (listView != null && this.D != null) {
            listView.setAdapter(this.D);
            int i = this.E;
            if (i > -1) {
                listView.setItemChecked(i, true);
                listView.setSelection(i);
            }
        }
    }

    private void c(ViewGroup viewGroup) {
        this.w = (NestedScrollView) this.c.findViewById(f.scrollView);
        this.w.setFocusable(false);
        this.w.setNestedScrollingEnabled(false);
        this.B = (TextView) viewGroup.findViewById(16908299);
        if (this.B != null) {
            if (this.e != null) {
                this.B.setText(this.e);
                return;
            }
            this.B.setVisibility(8);
            this.w.removeView(this.B);
            if (this.f != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.w.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.w);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f, indexOfChild, new LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void d(ViewGroup viewGroup) {
        int i;
        int i2 = 1;
        this.n = (Button) viewGroup.findViewById(16908313);
        this.n.setOnClickListener(this.N);
        if (TextUtils.isEmpty(this.o)) {
            this.n.setVisibility(8);
            i = 0;
        } else {
            this.n.setText(this.o);
            this.n.setVisibility(0);
            i = 1;
        }
        this.q = (Button) viewGroup.findViewById(16908314);
        this.q.setOnClickListener(this.N);
        if (TextUtils.isEmpty(this.r)) {
            this.q.setVisibility(8);
        } else {
            this.q.setText(this.r);
            this.q.setVisibility(0);
            i |= 2;
        }
        this.t = (Button) viewGroup.findViewById(16908315);
        this.t.setOnClickListener(this.N);
        if (TextUtils.isEmpty(this.u)) {
            this.t.setVisibility(8);
        } else {
            this.t.setText(this.u);
            this.t.setVisibility(0);
            i |= 4;
        }
        if (i == 0) {
            i2 = 0;
        }
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public void a() {
        this.b.setContentView(b());
        c();
    }

    public void a(int i) {
        this.g = null;
        this.h = i;
        this.m = false;
    }

    public void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.M.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.u = charSequence;
                this.v = message;
                return;
            case -2:
                this.r = charSequence;
                this.s = message;
                return;
            case -1:
                this.o = charSequence;
                this.p = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void a(Drawable drawable) {
        this.y = drawable;
        this.x = 0;
        if (this.z == null) {
            return;
        }
        if (drawable != null) {
            this.z.setVisibility(0);
            this.z.setImageDrawable(drawable);
            return;
        }
        this.z.setVisibility(8);
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        this.g = view;
        this.h = 0;
        this.m = true;
        this.i = i;
        this.j = i2;
        this.k = i3;
        this.l = i4;
    }

    public void a(CharSequence charSequence) {
        this.d = charSequence;
        if (this.A != null) {
            this.A.setText(charSequence);
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        return this.w != null && this.w.a(keyEvent);
    }

    public void b(int i) {
        this.y = null;
        this.x = i;
        if (this.z == null) {
            return;
        }
        if (i != 0) {
            this.z.setVisibility(0);
            this.z.setImageResource(this.x);
            return;
        }
        this.z.setVisibility(8);
    }

    public void b(View view) {
        this.C = view;
    }

    public void b(CharSequence charSequence) {
        this.e = charSequence;
        if (this.B != null) {
            this.B.setText(charSequence);
        }
    }

    public boolean b(int i, KeyEvent keyEvent) {
        return this.w != null && this.w.a(keyEvent);
    }

    public int c(int i) {
        TypedValue typedValue = new TypedValue();
        this.a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public void c(View view) {
        this.g = view;
        this.h = 0;
        this.m = false;
    }
}
