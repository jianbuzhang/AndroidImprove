package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class au extends am {
    private final WeakReference<Context> a;

    public au(Context context, Resources resources) {
        super(resources);
        this.a = new WeakReference(context);
    }

    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.a.get();
        if (!(drawable == null || context == null)) {
            l.a();
            l.a(context, i, drawable);
        }
        return drawable;
    }
}
