package android.support.v4.g;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class av {
    public static void a(final View view, final ay ayVar) {
        AnimatorUpdateListener animatorUpdateListener = null;
        if (ayVar != null) {
            animatorUpdateListener = new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ayVar.a(view);
                }
            };
        }
        view.animate().setUpdateListener(animatorUpdateListener);
    }
}
