package android.support.v4.g;

import android.os.Build.VERSION;
import android.view.KeyEvent;

public final class h {
    static final c a;

    interface c {
        boolean a(KeyEvent keyEvent);
    }

    static class a implements c {
        a() {
        }

        public boolean a(KeyEvent keyEvent) {
            return false;
        }
    }

    static class b extends a {
        b() {
        }

        public boolean a(KeyEvent keyEvent) {
            return i.a(keyEvent);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            a = new b();
        } else {
            a = new a();
        }
    }

    public static boolean a(KeyEvent keyEvent) {
        return a.a(keyEvent);
    }
}
