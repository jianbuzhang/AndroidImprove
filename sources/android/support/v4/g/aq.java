package android.support.v4.g;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

public final class aq {
    static final b a;

    interface b {
        void a(ViewParent viewParent, View view);

        void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4);

        void a(ViewParent viewParent, View view, int i, int i2, int[] iArr);

        boolean a(ViewParent viewParent, View view, float f, float f2);

        boolean a(ViewParent viewParent, View view, float f, float f2, boolean z);

        boolean a(ViewParent viewParent, View view, View view2, int i);

        void b(ViewParent viewParent, View view, View view2, int i);
    }

    static class e implements b {
        e() {
        }

        public void a(ViewParent viewParent, View view) {
            if (viewParent instanceof x) {
                ((x) viewParent).onStopNestedScroll(view);
            }
        }

        public void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof x) {
                ((x) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        public void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof x) {
                ((x) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        public boolean a(ViewParent viewParent, View view, float f, float f2) {
            return viewParent instanceof x ? ((x) viewParent).onNestedPreFling(view, f, f2) : false;
        }

        public boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return viewParent instanceof x ? ((x) viewParent).onNestedFling(view, f, f2, z) : false;
        }

        public boolean a(ViewParent viewParent, View view, View view2, int i) {
            return viewParent instanceof x ? ((x) viewParent).onStartNestedScroll(view, view2, i) : false;
        }

        public void b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof x) {
                ((x) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }
    }

    static class a extends e {
        a() {
        }
    }

    static class c extends a {
        c() {
        }
    }

    static class d extends c {
        d() {
        }

        public void a(ViewParent viewParent, View view) {
            ar.a(viewParent, view);
        }

        public void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            ar.a(viewParent, view, i, i2, i3, i4);
        }

        public void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            ar.a(viewParent, view, i, i2, iArr);
        }

        public boolean a(ViewParent viewParent, View view, float f, float f2) {
            return ar.a(viewParent, view, f, f2);
        }

        public boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return ar.a(viewParent, view, f, f2, z);
        }

        public boolean a(ViewParent viewParent, View view, View view2, int i) {
            return ar.a(viewParent, view, view2, i);
        }

        public void b(ViewParent viewParent, View view, View view2, int i) {
            ar.b(viewParent, view, view2, i);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            a = new d();
        } else if (i >= 19) {
            a = new c();
        } else if (i >= 14) {
            a = new a();
        } else {
            a = new e();
        }
    }

    public static void a(ViewParent viewParent, View view) {
        a.a(viewParent, view);
    }

    public static void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        a.a(viewParent, view, i, i2, i3, i4);
    }

    public static void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        a.a(viewParent, view, i, i2, iArr);
    }

    public static boolean a(ViewParent viewParent, View view, float f, float f2) {
        return a.a(viewParent, view, f, f2);
    }

    public static boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return a.a(viewParent, view, f, f2, z);
    }

    public static boolean a(ViewParent viewParent, View view, View view2, int i) {
        return a.a(viewParent, view, view2, i);
    }

    public static void b(ViewParent viewParent, View view, View view2, int i) {
        a.b(viewParent, view, view2, i);
    }
}
