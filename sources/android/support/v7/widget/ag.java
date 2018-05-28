package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v4.g.t;
import android.support.v7.view.menu.s;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;

public abstract class ag implements OnTouchListener {
    private final float a;
    private final int b;
    private final int c;
    private final View d;
    private Runnable e;
    private Runnable f;
    private boolean g;
    private int h;
    private final int[] i = new int[2];

    private class a implements Runnable {
        final /* synthetic */ ag a;

        private a(ag agVar) {
            this.a = agVar;
        }

        public void run() {
            ViewParent parent = this.a.d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class b implements Runnable {
        final /* synthetic */ ag a;

        private b(ag agVar) {
            this.a = agVar;
        }

        public void run() {
            this.a.e();
        }
    }

    public ag(View view) {
        this.d = view;
        this.a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.b = ViewConfiguration.getTapTimeout();
        this.c = (this.b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private boolean a(MotionEvent motionEvent) {
        View view = this.d;
        if (!view.isEnabled()) {
            return false;
        }
        switch (t.a(motionEvent)) {
            case 0:
                this.h = motionEvent.getPointerId(0);
                if (this.e == null) {
                    this.e = new a();
                }
                view.postDelayed(this.e, (long) this.b);
                if (this.f == null) {
                    this.f = new b();
                }
                view.postDelayed(this.f, (long) this.c);
                return false;
            case 1:
            case 3:
                d();
                return false;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.h);
                if (findPointerIndex < 0 || a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.a)) {
                    return false;
                }
                d();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            default:
                return false;
        }
    }

    private static boolean a(View view, float f, float f2, float f3) {
        return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        int[] iArr = this.i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    private boolean b(MotionEvent motionEvent) {
        View view = this.d;
        s a = a();
        if (a == null || !a.d()) {
            return false;
        }
        ae aeVar = (ae) a.e();
        if (aeVar == null || !aeVar.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        b(view, obtainNoHistory);
        a(aeVar, obtainNoHistory);
        boolean a2 = aeVar.a(obtainNoHistory, this.h);
        obtainNoHistory.recycle();
        int a3 = t.a(motionEvent);
        boolean z = (a3 == 1 || a3 == 3) ? false : true;
        z = a2 && z;
        return z;
    }

    private boolean b(View view, MotionEvent motionEvent) {
        int[] iArr = this.i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    private void d() {
        if (this.f != null) {
            this.d.removeCallbacks(this.f);
        }
        if (this.e != null) {
            this.d.removeCallbacks(this.e);
        }
    }

    private void e() {
        d();
        View view = this.d;
        if (view.isEnabled() && !view.isLongClickable() && b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.g = true;
        }
    }

    public abstract s a();

    protected boolean b() {
        s a = a();
        if (!(a == null || a.d())) {
            a.a();
        }
        return true;
    }

    protected boolean c() {
        s a = a();
        if (a != null && a.d()) {
            a.c();
        }
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.g;
        if (z2) {
            z = b(motionEvent) || !c();
        } else {
            boolean z3 = a(motionEvent) && b();
            if (z3) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.d.onTouchEvent(obtain);
                obtain.recycle();
            }
            z = z3;
        }
        this.g = z;
        return z || z2;
    }
}
