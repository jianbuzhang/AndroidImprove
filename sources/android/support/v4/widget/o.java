package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.v4.g.ae;
import android.support.v4.g.f;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public final class o {
    static final e a;

    interface e {
        void a(PopupWindow popupWindow, int i);

        void a(PopupWindow popupWindow, View view, int i, int i2, int i3);

        void a(PopupWindow popupWindow, boolean z);
    }

    static class c implements e {
        private static Method a;
        private static boolean b;

        c() {
        }

        public void a(PopupWindow popupWindow, int i) {
            if (!b) {
                try {
                    a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                    a.setAccessible(true);
                } catch (Exception e) {
                }
                b = true;
            }
            if (a != null) {
                try {
                    a.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
                } catch (Exception e2) {
                }
            }
        }

        public void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            if ((f.a(i3, ae.c(view)) & 7) == 5) {
                i -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i, i2);
        }

        public void a(PopupWindow popupWindow, boolean z) {
        }
    }

    static class d extends c {
        d() {
        }

        public void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            r.a(popupWindow, view, i, i2, i3);
        }
    }

    static class a extends d {
        a() {
        }

        public void a(PopupWindow popupWindow, boolean z) {
            p.a(popupWindow, z);
        }
    }

    static class b extends a {
        b() {
        }

        public void a(PopupWindow popupWindow, int i) {
            q.a(popupWindow, i);
        }

        public void a(PopupWindow popupWindow, boolean z) {
            q.a(popupWindow, z);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            a = new b();
        } else if (i >= 21) {
            a = new a();
        } else if (i >= 19) {
            a = new d();
        } else {
            a = new c();
        }
    }

    public static void a(PopupWindow popupWindow, int i) {
        a.a(popupWindow, i);
    }

    public static void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        a.a(popupWindow, view, i, i2, i3);
    }

    public static void a(PopupWindow popupWindow, boolean z) {
        a.a(popupWindow, z);
    }
}
