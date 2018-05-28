package android.support.v4.g;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public final class ac {
    static final c a;

    interface c {
        float a(VelocityTracker velocityTracker, int i);
    }

    static class a implements c {
        a() {
        }

        public float a(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getYVelocity();
        }
    }

    static class b implements c {
        b() {
        }

        public float a(VelocityTracker velocityTracker, int i) {
            return ad.a(velocityTracker, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            a = new b();
        } else {
            a = new a();
        }
    }

    public static float a(VelocityTracker velocityTracker, int i) {
        return a.a(velocityTracker, i);
    }
}
