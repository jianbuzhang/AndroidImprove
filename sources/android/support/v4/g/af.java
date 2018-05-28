package android.support.v4.g;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import java.lang.reflect.Field;

class af {
    private static Field a;
    private static boolean b;

    static ColorStateList a(View view) {
        return view instanceof ab ? ((ab) view).getSupportBackgroundTintList() : null;
    }

    static void a(View view, ColorStateList colorStateList) {
        if (view instanceof ab) {
            ((ab) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    static void a(View view, Mode mode) {
        if (view instanceof ab) {
            ((ab) view).setSupportBackgroundTintMode(mode);
        }
    }

    static Mode b(View view) {
        return view instanceof ab ? ((ab) view).getSupportBackgroundTintMode() : null;
    }

    static boolean c(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    static int d(View view) {
        if (!b) {
            try {
                a = View.class.getDeclaredField("mMinHeight");
                a.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            b = true;
        }
        if (a != null) {
            try {
                return ((Integer) a.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static boolean e(View view) {
        return view.getWindowToken() != null;
    }
}
