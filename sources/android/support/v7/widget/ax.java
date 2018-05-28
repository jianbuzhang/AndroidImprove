package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.f;
import java.lang.ref.WeakReference;

public class ax extends Resources {
    private final WeakReference<Context> a;

    public ax(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.a = new WeakReference(context);
    }

    public static boolean a() {
        return f.k() && VERSION.SDK_INT <= 20;
    }

    final Drawable a(int i) {
        return super.getDrawable(i);
    }

    public Drawable getDrawable(int i) {
        Context context = (Context) this.a.get();
        return context != null ? l.a().a(context, this, i) : super.getDrawable(i);
    }
}
