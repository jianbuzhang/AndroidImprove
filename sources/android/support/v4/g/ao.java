package android.support.v4.g;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public final class ao {
    static final d a;

    interface d {
        boolean a(ViewConfiguration viewConfiguration);
    }

    static class a implements d {
        a() {
        }

        public boolean a(ViewConfiguration viewConfiguration) {
            return true;
        }
    }

    static class b extends a {
        b() {
        }

        public boolean a(ViewConfiguration viewConfiguration) {
            return false;
        }
    }

    static class c extends b {
        c() {
        }

        public boolean a(ViewConfiguration viewConfiguration) {
            return ap.a(viewConfiguration);
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            a = new c();
        } else if (VERSION.SDK_INT >= 11) {
            a = new b();
        } else {
            a = new a();
        }
    }

    public static boolean a(ViewConfiguration viewConfiguration) {
        return a.a(viewConfiguration);
    }
}
