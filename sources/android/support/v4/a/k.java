package android.support.v4.a;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.f.c;
import android.support.v4.f.h;
import android.support.v4.g.j;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class k implements ComponentCallbacks, OnCreateContextMenuListener {
    static final Object a = new Object();
    private static final h<String, Class<?>> aa = new h();
    boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    boolean F = true;
    boolean G;
    int H;
    ViewGroup I;
    View J;
    View K;
    boolean L;
    boolean M = true;
    x N;
    boolean O;
    boolean P;
    Object Q = null;
    Object R = a;
    Object S = null;
    Object T = a;
    Object U = null;
    Object V = a;
    Boolean W;
    Boolean X;
    ab Y = null;
    ab Z = null;
    int b = 0;
    View c;
    int d;
    Bundle e;
    SparseArray<Parcelable> f;
    int g = -1;
    String h;
    Bundle i;
    k j;
    int k = -1;
    int l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    int r;
    q s;
    o t;
    q u;
    r v;
    k w;
    int x;
    int y;
    String z;

    public static class a extends RuntimeException {
        public a(String str, Exception exception) {
            super(str, exception);
        }
    }

    public static k a(Context context, String str) {
        return a(context, str, null);
    }

    public static k a(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) aa.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                aa.put(str, cls);
            }
            k kVar = (k) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(kVar.getClass().getClassLoader());
                kVar.i = bundle;
            }
            return kVar;
        } catch (Exception e) {
            throw new a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (Exception e2) {
            throw new a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e22);
        }
    }

    static boolean b(Context context, String str) {
        try {
            Class cls = (Class) aa.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                aa.put(str, cls);
            }
            return k.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    void A() {
        if (this.u != null) {
            this.u.i();
            this.u.d();
        }
        this.b = 5;
        this.G = false;
        i();
        if (!this.G) {
            throw new ac("Fragment " + this + " did not call through to super.onResume()");
        } else if (this.u != null) {
            this.u.m();
            this.u.d();
        }
    }

    void B() {
        onLowMemory();
        if (this.u != null) {
            this.u.s();
        }
    }

    void C() {
        if (this.u != null) {
            this.u.n();
        }
        this.b = 4;
        this.G = false;
        j();
        if (!this.G) {
            throw new ac("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    void D() {
        if (this.u != null) {
            this.u.o();
        }
        this.b = 3;
        this.G = false;
        k();
        if (!this.G) {
            throw new ac("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    void E() {
        if (this.u != null) {
            this.u.p();
        }
        this.b = 2;
        if (this.O) {
            this.O = false;
            if (!this.P) {
                this.P = true;
                this.N = this.t.a(this.h, this.O, false);
            }
            if (this.N == null) {
                return;
            }
            if (this.t.j()) {
                this.N.d();
            } else {
                this.N.c();
            }
        }
    }

    void F() {
        if (this.u != null) {
            this.u.q();
        }
        this.b = 1;
        this.G = false;
        l();
        if (!this.G) {
            throw new ac("Fragment " + this + " did not call through to super.onDestroyView()");
        } else if (this.N != null) {
            this.N.f();
        }
    }

    void G() {
        if (this.u != null) {
            this.u.r();
        }
        this.b = 0;
        this.G = false;
        m();
        if (this.G) {
            this.u = null;
            return;
        }
        throw new ac("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void H() {
        this.G = false;
        o();
        if (!this.G) {
            throw new ac("Fragment " + this + " did not call through to super.onDetach()");
        } else if (this.u == null) {
        } else {
            if (this.D) {
                this.u.r();
                this.u = null;
                return;
            }
            throw new IllegalStateException("Child FragmentManager of " + this + " was not " + " destroyed and this fragment is not retaining instance");
        }
    }

    k a(String str) {
        return str.equals(this.h) ? this : this.u != null ? this.u.b(str) : null;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public Animation a(int i, boolean z, int i2) {
        return null;
    }

    public void a(int i, int i2, Intent intent) {
    }

    final void a(int i, k kVar) {
        this.g = i;
        if (kVar != null) {
            this.h = kVar.h + ":" + this.g;
        } else {
            this.h = "android:fragment:" + this.g;
        }
    }

    public void a(int i, String[] strArr, int[] iArr) {
    }

    @Deprecated
    public void a(Activity activity) {
        this.G = true;
    }

    @Deprecated
    public void a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.G = true;
    }

    public void a(Context context) {
        this.G = true;
        Activity f = this.t == null ? null : this.t.f();
        if (f != null) {
            this.G = false;
            a(f);
        }
    }

    public void a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.G = true;
        Activity f = this.t == null ? null : this.t.f();
        if (f != null) {
            this.G = false;
            a(f, attributeSet, bundle);
        }
    }

    void a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.u != null) {
            this.u.a(configuration);
        }
    }

    final void a(Bundle bundle) {
        if (this.f != null) {
            this.K.restoreHierarchyState(this.f);
            this.f = null;
        }
        this.G = false;
        f(bundle);
        if (!this.G) {
            throw new ac("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void a(k kVar) {
    }

    public void a(Menu menu) {
    }

    public void a(Menu menu, MenuInflater menuInflater) {
    }

    public void a(View view, Bundle bundle) {
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.x));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.y));
        printWriter.print(" mTag=");
        printWriter.println(this.z);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.b);
        printWriter.print(" mIndex=");
        printWriter.print(this.g);
        printWriter.print(" mWho=");
        printWriter.print(this.h);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.r);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.m);
        printWriter.print(" mRemoving=");
        printWriter.print(this.n);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.o);
        printWriter.print(" mInLayout=");
        printWriter.println(this.p);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.A);
        printWriter.print(" mDetached=");
        printWriter.print(this.B);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.F);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.E);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.C);
        printWriter.print(" mRetaining=");
        printWriter.print(this.D);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.M);
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.s);
        }
        if (this.t != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.t);
        }
        if (this.w != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.w);
        }
        if (this.i != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.i);
        }
        if (this.e != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.e);
        }
        if (this.f != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f);
        }
        if (this.j != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.j);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.l);
        }
        if (this.H != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.H);
        }
        if (this.I != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.I);
        }
        if (this.J != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.J);
        }
        if (this.K != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.J);
        }
        if (this.c != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.c);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.d);
        }
        if (this.N != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.N.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.u != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.u + ":");
            this.u.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public void a(boolean z) {
    }

    final boolean a() {
        return this.r > 0;
    }

    public boolean a(MenuItem menuItem) {
        return false;
    }

    public final l b() {
        return this.t == null ? null : (l) this.t.f();
    }

    public LayoutInflater b(Bundle bundle) {
        LayoutInflater b = this.t.b();
        d();
        j.a(b, this.u.t());
        return b;
    }

    View b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.u != null) {
            this.u.i();
        }
        return a(layoutInflater, viewGroup, bundle);
    }

    public void b(Menu menu) {
    }

    public void b(boolean z) {
    }

    boolean b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.A) {
            return false;
        }
        if (this.E && this.F) {
            z = true;
            a(menu, menuInflater);
        }
        return this.u != null ? z | this.u.a(menu, menuInflater) : z;
    }

    public boolean b(MenuItem menuItem) {
        return false;
    }

    public final Resources c() {
        if (this.t != null) {
            return this.t.g().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void c(Bundle bundle) {
        this.G = true;
        d(bundle);
        if (this.u != null && !this.u.a(1)) {
            this.u.j();
        }
    }

    public void c(boolean z) {
    }

    boolean c(Menu menu) {
        boolean z = false;
        if (this.A) {
            return false;
        }
        if (this.E && this.F) {
            z = true;
            a(menu);
        }
        return this.u != null ? z | this.u.a(menu) : z;
    }

    boolean c(MenuItem menuItem) {
        if (!this.A) {
            if (this.E && this.F && a(menuItem)) {
                return true;
            }
            if (this.u != null && this.u.a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final p d() {
        if (this.u == null) {
            y();
            if (this.b >= 5) {
                this.u.m();
            } else if (this.b >= 4) {
                this.u.l();
            } else if (this.b >= 2) {
                this.u.k();
            } else if (this.b >= 1) {
                this.u.j();
            }
        }
        return this.u;
    }

    void d(Bundle bundle) {
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.u == null) {
                    y();
                }
                this.u.a(parcelable, this.v);
                this.v = null;
                this.u.j();
            }
        }
    }

    void d(Menu menu) {
        if (!this.A) {
            if (this.E && this.F) {
                b(menu);
            }
            if (this.u != null) {
                this.u.b(menu);
            }
        }
    }

    void d(boolean z) {
        b(z);
        if (this.u != null) {
            this.u.a(z);
        }
    }

    boolean d(MenuItem menuItem) {
        if (!this.A) {
            if (b(menuItem)) {
                return true;
            }
            if (this.u != null && this.u.b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void e(Bundle bundle) {
        this.G = true;
    }

    void e(boolean z) {
        c(z);
        if (this.u != null) {
            this.u.b(z);
        }
    }

    public final boolean e() {
        return this.t != null && this.m;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void f(Bundle bundle) {
        this.G = true;
    }

    public final boolean f() {
        return this.A;
    }

    public View g() {
        return this.J;
    }

    public void g(Bundle bundle) {
    }

    public void h() {
        this.G = true;
        if (!this.O) {
            this.O = true;
            if (!this.P) {
                this.P = true;
                this.N = this.t.a(this.h, this.O, false);
            }
            if (this.N != null) {
                this.N.b();
            }
        }
    }

    void h(Bundle bundle) {
        if (this.u != null) {
            this.u.i();
        }
        this.b = 1;
        this.G = false;
        c(bundle);
        if (!this.G) {
            throw new ac("Fragment " + this + " did not call through to super.onCreate()");
        }
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void i() {
        this.G = true;
    }

    void i(Bundle bundle) {
        if (this.u != null) {
            this.u.i();
        }
        this.b = 2;
        this.G = false;
        e(bundle);
        if (!this.G) {
            throw new ac("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.u != null) {
            this.u.k();
        }
    }

    public void j() {
        this.G = true;
    }

    void j(Bundle bundle) {
        g(bundle);
        if (this.u != null) {
            Parcelable h = this.u.h();
            if (h != null) {
                bundle.putParcelable("android:support:fragments", h);
            }
        }
    }

    public void k() {
        this.G = true;
    }

    public void l() {
        this.G = true;
    }

    public void m() {
        this.G = true;
        if (!this.P) {
            this.P = true;
            this.N = this.t.a(this.h, this.O, false);
        }
        if (this.N != null) {
            this.N.h();
        }
    }

    void n() {
        this.g = -1;
        this.h = null;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = 0;
        this.s = null;
        this.u = null;
        this.t = null;
        this.x = 0;
        this.y = 0;
        this.z = null;
        this.A = false;
        this.B = false;
        this.D = false;
        this.N = null;
        this.O = false;
        this.P = false;
    }

    public void o() {
        this.G = true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.G = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        b().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onLowMemory() {
        this.G = true;
    }

    public void p() {
    }

    public Object q() {
        return this.Q;
    }

    public Object r() {
        return this.R == a ? q() : this.R;
    }

    public Object s() {
        return this.S;
    }

    public Object t() {
        return this.T == a ? s() : this.T;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        c.a(this, stringBuilder);
        if (this.g >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.g);
        }
        if (this.x != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.x));
        }
        if (this.z != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.z);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public Object u() {
        return this.U;
    }

    public Object v() {
        return this.V == a ? u() : this.V;
    }

    public boolean w() {
        return this.X == null ? true : this.X.booleanValue();
    }

    public boolean x() {
        return this.W == null ? true : this.W.booleanValue();
    }

    void y() {
        this.u = new q();
        this.u.a(this.t, new m(this) {
            final /* synthetic */ k a;

            {
                this.a = r1;
            }

            public View a(int i) {
                if (this.a.J != null) {
                    return this.a.J.findViewById(i);
                }
                throw new IllegalStateException("Fragment does not have a view");
            }

            public boolean a() {
                return this.a.J != null;
            }
        }, this);
    }

    void z() {
        if (this.u != null) {
            this.u.i();
            this.u.d();
        }
        this.b = 4;
        this.G = false;
        h();
        if (this.G) {
            if (this.u != null) {
                this.u.l();
            }
            if (this.N != null) {
                this.N.g();
                return;
            }
            return;
        }
        throw new ac("Fragment " + this + " did not call through to super.onStart()");
    }
}
