package android.support.v4.g.a;

import android.view.accessibility.AccessibilityRecord;

class i {
    public static void a(Object obj, int i) {
        ((AccessibilityRecord) obj).setScrollX(i);
    }

    public static void a(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setScrollable(z);
    }

    public static void b(Object obj, int i) {
        ((AccessibilityRecord) obj).setScrollY(i);
    }
}
