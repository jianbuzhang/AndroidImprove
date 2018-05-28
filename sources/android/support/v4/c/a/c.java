package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class c {
    public static Drawable a(Drawable drawable) {
        return !(drawable instanceof m) ? new i(drawable) : drawable;
    }

    public static void a(Drawable drawable, int i) {
        if (drawable instanceof m) {
            ((m) drawable).setTint(i);
        }
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof m) {
            ((m) drawable).setTintList(colorStateList);
        }
    }

    public static void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet);
    }

    public static void a(Drawable drawable, Mode mode) {
        if (drawable instanceof m) {
            ((m) drawable).setTintMode(mode);
        }
    }
}
