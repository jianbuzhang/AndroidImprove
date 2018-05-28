package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CompoundButton;

public final class b {
    private static final c a;

    interface c {
        Drawable a(CompoundButton compoundButton);

        void a(CompoundButton compoundButton, ColorStateList colorStateList);

        void a(CompoundButton compoundButton, Mode mode);
    }

    static class b implements c {
        b() {
        }

        public Drawable a(CompoundButton compoundButton) {
            return d.a(compoundButton);
        }

        public void a(CompoundButton compoundButton, ColorStateList colorStateList) {
            d.a(compoundButton, colorStateList);
        }

        public void a(CompoundButton compoundButton, Mode mode) {
            d.a(compoundButton, mode);
        }
    }

    static class d extends b {
        d() {
        }

        public void a(CompoundButton compoundButton, ColorStateList colorStateList) {
            e.a(compoundButton, colorStateList);
        }

        public void a(CompoundButton compoundButton, Mode mode) {
            e.a(compoundButton, mode);
        }
    }

    static class a extends d {
        a() {
        }

        public Drawable a(CompoundButton compoundButton) {
            return c.a(compoundButton);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            a = new a();
        } else if (i >= 21) {
            a = new d();
        } else {
            a = new b();
        }
    }

    public static Drawable a(CompoundButton compoundButton) {
        return a.a(compoundButton);
    }

    public static void a(CompoundButton compoundButton, ColorStateList colorStateList) {
        a.a(compoundButton, colorStateList);
    }

    public static void a(CompoundButton compoundButton, Mode mode) {
        a.a(compoundButton, mode);
    }
}
