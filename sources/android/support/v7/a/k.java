package android.support.v7.a;

import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;

class k extends j {
    private final UiModeManager r;

    class a extends a {
        final /* synthetic */ k d;

        a(k kVar, Callback callback) {
            this.d = kVar;
            super(kVar, callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (this.d.o()) {
                switch (i) {
                    case 0:
                        return a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }
    }

    k(Context context, Window window, e eVar) {
        super(context, window, eVar);
        this.r = (UiModeManager) context.getSystemService("uimode");
    }

    Callback a(Callback callback) {
        return new a(this, callback);
    }

    int d(int i) {
        return (i == 0 && this.r.getNightMode() == 0) ? -1 : super.d(i);
    }
}
