package android.support.v4.c.a;

import android.graphics.drawable.Drawable;

class f {
    public static void a(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static boolean a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static Drawable b(Drawable drawable) {
        return !(drawable instanceof m) ? new k(drawable) : drawable;
    }

    public static int c(Drawable drawable) {
        return drawable.getAlpha();
    }
}
