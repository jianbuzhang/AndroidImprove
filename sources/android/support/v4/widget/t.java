package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

public final class t {
    OverScroller a;
    private final boolean b;

    t(boolean z, Context context, Interpolator interpolator) {
        this.b = z;
        this.a = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    public static t a(Context context) {
        return a(context, null);
    }

    public static t a(Context context, Interpolator interpolator) {
        return new t(VERSION.SDK_INT >= 14, context, interpolator);
    }

    public void a(int i, int i2, int i3, int i4) {
        this.a.startScroll(i, i2, i3, i4);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.a.fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.a.fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public boolean a() {
        return this.a.isFinished();
    }

    public boolean a(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.a.springBack(i, i2, i3, i4, i5, i6);
    }

    public int b() {
        return this.a.getCurrX();
    }

    public int c() {
        return this.a.getCurrY();
    }

    public int d() {
        return this.a.getFinalY();
    }

    public float e() {
        return this.b ? u.a(this.a) : 0.0f;
    }

    public boolean f() {
        return this.a.computeScrollOffset();
    }

    public void g() {
        this.a.abortAnimation();
    }
}
