package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public final class a {
    static final b a;

    interface b {
        void a(Drawable drawable);

        void a(Drawable drawable, float f, float f2);

        void a(Drawable drawable, int i);

        void a(Drawable drawable, int i, int i2, int i3, int i4);

        void a(Drawable drawable, ColorStateList colorStateList);

        void a(Drawable drawable, Theme theme);

        void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);

        void a(Drawable drawable, Mode mode);

        void a(Drawable drawable, boolean z);

        boolean b(Drawable drawable);

        boolean b(Drawable drawable, int i);

        Drawable c(Drawable drawable);

        int d(Drawable drawable);

        int e(Drawable drawable);

        boolean f(Drawable drawable);

        ColorFilter g(Drawable drawable);
    }

    static class a implements b {
        a() {
        }

        public void a(Drawable drawable) {
        }

        public void a(Drawable drawable, float f, float f2) {
        }

        public void a(Drawable drawable, int i) {
            c.a(drawable, i);
        }

        public void a(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        public void a(Drawable drawable, ColorStateList colorStateList) {
            c.a(drawable, colorStateList);
        }

        public void a(Drawable drawable, Theme theme) {
        }

        public void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            c.a(drawable, resources, xmlPullParser, attributeSet, theme);
        }

        public void a(Drawable drawable, Mode mode) {
            c.a(drawable, mode);
        }

        public void a(Drawable drawable, boolean z) {
        }

        public boolean b(Drawable drawable) {
            return false;
        }

        public boolean b(Drawable drawable, int i) {
            return false;
        }

        public Drawable c(Drawable drawable) {
            return c.a(drawable);
        }

        public int d(Drawable drawable) {
            return 0;
        }

        public int e(Drawable drawable) {
            return 0;
        }

        public boolean f(Drawable drawable) {
            return false;
        }

        public ColorFilter g(Drawable drawable) {
            return null;
        }
    }

    static class c extends a {
        c() {
        }

        public void a(Drawable drawable) {
            d.a(drawable);
        }

        public Drawable c(Drawable drawable) {
            return d.b(drawable);
        }
    }

    static class d extends c {
        d() {
        }

        public boolean b(Drawable drawable, int i) {
            return e.a(drawable, i);
        }

        public int d(Drawable drawable) {
            int a = e.a(drawable);
            return a >= 0 ? a : 0;
        }
    }

    static class e extends d {
        e() {
        }

        public void a(Drawable drawable, boolean z) {
            f.a(drawable, z);
        }

        public boolean b(Drawable drawable) {
            return f.a(drawable);
        }

        public Drawable c(Drawable drawable) {
            return f.b(drawable);
        }

        public int e(Drawable drawable) {
            return f.c(drawable);
        }
    }

    static class f extends e {
        f() {
        }

        public void a(Drawable drawable, float f, float f2) {
            g.a(drawable, f, f2);
        }

        public void a(Drawable drawable, int i) {
            g.a(drawable, i);
        }

        public void a(Drawable drawable, int i, int i2, int i3, int i4) {
            g.a(drawable, i, i2, i3, i4);
        }

        public void a(Drawable drawable, ColorStateList colorStateList) {
            g.a(drawable, colorStateList);
        }

        public void a(Drawable drawable, Theme theme) {
            g.a(drawable, theme);
        }

        public void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            g.a(drawable, resources, xmlPullParser, attributeSet, theme);
        }

        public void a(Drawable drawable, Mode mode) {
            g.a(drawable, mode);
        }

        public Drawable c(Drawable drawable) {
            return g.a(drawable);
        }

        public boolean f(Drawable drawable) {
            return g.b(drawable);
        }

        public ColorFilter g(Drawable drawable) {
            return g.c(drawable);
        }
    }

    static class g extends f {
        g() {
        }

        public boolean b(Drawable drawable, int i) {
            return b.a(drawable, i);
        }

        public Drawable c(Drawable drawable) {
            return drawable;
        }

        public int d(Drawable drawable) {
            return b.a(drawable);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            a = new g();
        } else if (i >= 21) {
            a = new f();
        } else if (i >= 19) {
            a = new e();
        } else if (i >= 17) {
            a = new d();
        } else if (i >= 11) {
            a = new c();
        } else {
            a = new a();
        }
    }

    public static void a(Drawable drawable) {
        a.a(drawable);
    }

    public static void a(Drawable drawable, float f, float f2) {
        a.a(drawable, f, f2);
    }

    public static void a(Drawable drawable, int i) {
        a.a(drawable, i);
    }

    public static void a(Drawable drawable, int i, int i2, int i3, int i4) {
        a.a(drawable, i, i2, i3, i4);
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        a.a(drawable, colorStateList);
    }

    public static void a(Drawable drawable, Theme theme) {
        a.a(drawable, theme);
    }

    public static void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        a.a(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static void a(Drawable drawable, Mode mode) {
        a.a(drawable, mode);
    }

    public static void a(Drawable drawable, boolean z) {
        a.a(drawable, z);
    }

    public static boolean b(Drawable drawable) {
        return a.b(drawable);
    }

    public static boolean b(Drawable drawable, int i) {
        return a.b(drawable, i);
    }

    public static int c(Drawable drawable) {
        return a.e(drawable);
    }

    public static boolean d(Drawable drawable) {
        return a.f(drawable);
    }

    public static ColorFilter e(Drawable drawable) {
        return a.g(drawable);
    }

    public static Drawable f(Drawable drawable) {
        return a.c(drawable);
    }

    public static int g(Drawable drawable) {
        return a.d(drawable);
    }
}
