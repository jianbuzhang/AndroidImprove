package android.support.v4.a;

import android.content.Context;
import android.os.Build.VERSION;

public final class d {
    private static final b a;

    private static class b {
        private b() {
        }

        public int a(Context context, String str, String str2) {
            return 1;
        }

        public String a(String str) {
            return null;
        }
    }

    private static class a extends b {
        private a() {
            super();
        }

        public int a(Context context, String str, String str2) {
            return e.a(context, str, str2);
        }

        public String a(String str) {
            return e.a(str);
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            a = new a();
        } else {
            a = new b();
        }
    }

    public static int a(Context context, String str, String str2) {
        return a.a(context, str, str2);
    }

    public static String a(String str) {
        return a.a(str);
    }
}
