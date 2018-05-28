package android.support.v4.c.a;

import android.graphics.drawable.Drawable;

class d {
    public static void a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static Drawable b(Drawable drawable) {
        return !(drawable instanceof m) ? new j(drawable) : drawable;
    }
}
