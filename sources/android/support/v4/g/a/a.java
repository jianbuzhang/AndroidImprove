package android.support.v4.g.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public final class a {
    private static final e a;

    interface e {
    }

    static class d implements e {
        d() {
        }
    }

    static class a extends d {
        a() {
        }
    }

    static class b extends a {
        b() {
        }
    }

    static class c extends b {
        c() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            a = new c();
        } else if (VERSION.SDK_INT >= 16) {
            a = new b();
        } else if (VERSION.SDK_INT >= 14) {
            a = new a();
        } else {
            a = new d();
        }
    }

    public static h a(AccessibilityEvent accessibilityEvent) {
        return new h(accessibilityEvent);
    }
}
