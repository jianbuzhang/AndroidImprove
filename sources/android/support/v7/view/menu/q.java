package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.d.a.a;
import android.support.v4.d.a.b;
import android.support.v4.d.a.c;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class q {
    public static Menu a(Context context, a aVar) {
        if (VERSION.SDK_INT >= 14) {
            return new r(context, aVar);
        }
        throw new UnsupportedOperationException();
    }

    public static MenuItem a(Context context, b bVar) {
        if (VERSION.SDK_INT >= 16) {
            return new l(context, bVar);
        }
        if (VERSION.SDK_INT >= 14) {
            return new k(context, bVar);
        }
        throw new UnsupportedOperationException();
    }

    public static SubMenu a(Context context, c cVar) {
        if (VERSION.SDK_INT >= 14) {
            return new v(context, cVar);
        }
        throw new UnsupportedOperationException();
    }
}
