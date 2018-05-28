package android.support.v4.widget;

import android.os.Build.VERSION;
import android.widget.ListView;

public final class l {
    public static void a(ListView listView, int i) {
        if (VERSION.SDK_INT >= 19) {
            n.a(listView, i);
        } else {
            m.a(listView, i);
        }
    }
}
