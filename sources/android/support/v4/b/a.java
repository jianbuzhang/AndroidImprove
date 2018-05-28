package android.support.v4.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.TypedValue;

public class a {
    private static final Object a = new Object();
    private static TypedValue b;

    public static final Drawable a(Context context, int i) {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 21) {
            return b.a(context, i);
        }
        if (i2 >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (a) {
            if (b == null) {
                b = new TypedValue();
            }
            context.getResources().getValue(i, b, true);
            i2 = b.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    public static boolean a(Context context, Intent[] intentArr, Bundle bundle) {
        int i = VERSION.SDK_INT;
        if (i >= 16) {
            e.a(context, intentArr, bundle);
            return true;
        } else if (i < 11) {
            return false;
        } else {
            d.a(context, intentArr);
            return true;
        }
    }

    public static final ColorStateList b(Context context, int i) {
        return VERSION.SDK_INT >= 23 ? c.a(context, i) : context.getResources().getColorStateList(i);
    }
}
