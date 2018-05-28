package android.support.v4.g;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public final class t {
    static final d a;

    interface d {
        float a(MotionEvent motionEvent, int i);
    }

    static class a implements d {
        a() {
        }

        public float a(MotionEvent motionEvent, int i) {
            return 0.0f;
        }
    }

    static class b extends a {
        b() {
        }

        public float a(MotionEvent motionEvent, int i) {
            return u.a(motionEvent, i);
        }
    }

    private static class c extends b {
        private c() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            a = new c();
        } else if (VERSION.SDK_INT >= 12) {
            a = new b();
        } else {
            a = new a();
        }
    }

    public static float a(MotionEvent motionEvent, int i) {
        return a.a(motionEvent, i);
    }

    public static int a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }
}
