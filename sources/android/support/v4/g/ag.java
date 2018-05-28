package android.support.v4.g;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

class ag {
    public static int a(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    public static int a(View view) {
        return view.getLayerType();
    }

    static long a() {
        return ValueAnimator.getFrameDelay();
    }

    public static void a(View view, float f) {
        view.setTranslationY(f);
    }

    public static void a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static void a(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    public static int b(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static void b(View view, float f) {
        view.setAlpha(f);
    }

    public static void b(View view, boolean z) {
        view.setActivated(z);
    }

    public static int c(View view) {
        return view.getMeasuredState();
    }

    public static float d(View view) {
        return view.getTranslationY();
    }

    public static void e(View view) {
        view.jumpDrawablesToCurrentState();
    }
}
