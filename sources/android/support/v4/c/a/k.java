package android.support.v4.c.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class k extends j {

    private static class a extends a {
        a(a aVar, Resources resources) {
            super(aVar, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new k(this, resources);
        }
    }

    k(Drawable drawable) {
        super(drawable);
    }

    k(a aVar, Resources resources) {
        super(aVar, resources);
    }

    a b() {
        return new a(this.b, null);
    }

    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    public void setAutoMirrored(boolean z) {
        this.c.setAutoMirrored(z);
    }
}
