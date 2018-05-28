package android.support.v4.b.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public final class d {
    public static Drawable a(Resources resources, int i, Theme theme) {
        return VERSION.SDK_INT >= 21 ? e.a(resources, i, theme) : resources.getDrawable(i);
    }
}
