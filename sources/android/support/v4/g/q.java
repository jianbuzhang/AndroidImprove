package android.support.v4.g;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public final class q {
    static final d a;

    interface d {
        MenuItem a(MenuItem menuItem, View view);

        View a(MenuItem menuItem);

        void a(MenuItem menuItem, int i);

        MenuItem b(MenuItem menuItem, int i);

        boolean b(MenuItem menuItem);

        boolean c(MenuItem menuItem);
    }

    static class a implements d {
        a() {
        }

        public MenuItem a(MenuItem menuItem, View view) {
            return menuItem;
        }

        public View a(MenuItem menuItem) {
            return null;
        }

        public void a(MenuItem menuItem, int i) {
        }

        public MenuItem b(MenuItem menuItem, int i) {
            return menuItem;
        }

        public boolean b(MenuItem menuItem) {
            return false;
        }

        public boolean c(MenuItem menuItem) {
            return false;
        }
    }

    static class b implements d {
        b() {
        }

        public MenuItem a(MenuItem menuItem, View view) {
            return r.a(menuItem, view);
        }

        public View a(MenuItem menuItem) {
            return r.a(menuItem);
        }

        public void a(MenuItem menuItem, int i) {
            r.a(menuItem, i);
        }

        public MenuItem b(MenuItem menuItem, int i) {
            return r.b(menuItem, i);
        }

        public boolean b(MenuItem menuItem) {
            return false;
        }

        public boolean c(MenuItem menuItem) {
            return false;
        }
    }

    static class c extends b {
        c() {
        }

        public boolean b(MenuItem menuItem) {
            return s.a(menuItem);
        }

        public boolean c(MenuItem menuItem) {
            return s.b(menuItem);
        }
    }

    public interface e {
        boolean a(MenuItem menuItem);

        boolean b(MenuItem menuItem);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            a = new c();
        } else if (i >= 11) {
            a = new b();
        } else {
            a = new a();
        }
    }

    public static MenuItem a(MenuItem menuItem, e eVar) {
        if (menuItem instanceof android.support.v4.d.a.b) {
            return ((android.support.v4.d.a.b) menuItem).a(eVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static MenuItem a(MenuItem menuItem, View view) {
        return menuItem instanceof android.support.v4.d.a.b ? ((android.support.v4.d.a.b) menuItem).setActionView(view) : a.a(menuItem, view);
    }

    public static View a(MenuItem menuItem) {
        return menuItem instanceof android.support.v4.d.a.b ? ((android.support.v4.d.a.b) menuItem).getActionView() : a.a(menuItem);
    }

    public static void a(MenuItem menuItem, int i) {
        if (menuItem instanceof android.support.v4.d.a.b) {
            ((android.support.v4.d.a.b) menuItem).setShowAsAction(i);
        } else {
            a.a(menuItem, i);
        }
    }

    public static MenuItem b(MenuItem menuItem, int i) {
        return menuItem instanceof android.support.v4.d.a.b ? ((android.support.v4.d.a.b) menuItem).setActionView(i) : a.b(menuItem, i);
    }

    public static boolean b(MenuItem menuItem) {
        return menuItem instanceof android.support.v4.d.a.b ? ((android.support.v4.d.a.b) menuItem).expandActionView() : a.b(menuItem);
    }

    public static boolean c(MenuItem menuItem) {
        return menuItem instanceof android.support.v4.d.a.b ? ((android.support.v4.d.a.b) menuItem).isActionViewExpanded() : a.c(menuItem);
    }
}
