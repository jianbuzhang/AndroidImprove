package android.support.v7.a;

import android.content.Context;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import android.view.Window.Callback;
import java.util.List;

class h extends k {

    class a extends a {
        final /* synthetic */ h b;

        a(h hVar, Callback callback) {
            this.b = hVar;
            super(hVar, callback);
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            d a = this.b.a(0, true);
            if (a == null || a.j == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, a.j, i);
            }
        }
    }

    h(Context context, Window window, e eVar) {
        super(context, window, eVar);
    }

    Callback a(Callback callback) {
        return new a(this, callback);
    }
}
