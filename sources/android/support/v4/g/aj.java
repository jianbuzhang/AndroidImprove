package android.support.v4.g;

import android.view.View;

class aj {
    public static void a(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static int b(View view) {
        return view.getMinimumHeight();
    }

    public static void c(View view) {
        view.requestFitSystemWindows();
    }

    public static boolean d(View view) {
        return view.hasOverlappingRendering();
    }
}
