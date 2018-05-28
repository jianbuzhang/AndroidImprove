package android.support.v4.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Interpolator;

class at {
    public static long a(View view) {
        return view.animate().getDuration();
    }

    public static void a(View view, float f) {
        view.animate().alpha(f);
    }

    public static void a(View view, long j) {
        view.animate().setDuration(j);
    }

    public static void a(final View view, final aw awVar) {
        if (awVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    awVar.c(view);
                }

                public void onAnimationEnd(Animator animator) {
                    awVar.b(view);
                }

                public void onAnimationStart(Animator animator) {
                    awVar.a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public static void a(View view, Interpolator interpolator) {
        view.animate().setInterpolator(interpolator);
    }

    public static void b(View view) {
        view.animate().cancel();
    }

    public static void b(View view, float f) {
        view.animate().translationY(f);
    }

    public static void b(View view, long j) {
        view.animate().setStartDelay(j);
    }

    public static void c(View view) {
        view.animate().start();
    }
}
