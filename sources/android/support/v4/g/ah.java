package android.support.v4.g;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class ah {
    public static void a(View view, Object obj) {
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }

    public static boolean a(View view, int i) {
        return view.canScrollVertically(i);
    }
}
