package android.support.v4.c.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class j extends i {

    private static class a extends a {
        a(a aVar, Resources resources) {
            super(aVar, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new j(this, resources);
        }
    }

    j(Drawable drawable) {
        super(drawable);
    }

    j(a aVar, Resources resources) {
        super(aVar, resources);
    }

    a b() {
        return new a(this.b, null);
    }

    public void jumpToCurrentState() {
        this.c.jumpToCurrentState();
    }
}
