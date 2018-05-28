package android.support.v4.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class au {
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
}
