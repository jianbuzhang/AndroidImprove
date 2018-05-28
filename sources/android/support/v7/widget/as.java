package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.v7.a.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class as extends ContextWrapper {
    private static final ArrayList<WeakReference<as>> a = new ArrayList();
    private final Resources b;
    private final Theme c;

    private as(Context context) {
        super(context);
        if (ax.a()) {
            this.b = new ax(this, context.getResources());
            this.c = this.b.newTheme();
            this.c.setTo(context.getTheme());
            return;
        }
        this.b = new au(this, context.getResources());
        this.c = null;
    }

    public static Context a(Context context) {
        if (!b(context)) {
            return context;
        }
        Context context2;
        int size = a.size();
        for (int i = 0; i < size; i++) {
            WeakReference weakReference = (WeakReference) a.get(i);
            context2 = weakReference != null ? (as) weakReference.get() : null;
            if (context2 != null && context2.getBaseContext() == context) {
                return context2;
            }
        }
        context2 = new as(context);
        a.add(new WeakReference(context2));
        return context2;
    }

    private static boolean b(Context context) {
        return ((context instanceof as) || (context.getResources() instanceof au) || (context.getResources() instanceof ax)) ? false : !f.k() || VERSION.SDK_INT <= 20;
    }

    public Resources getResources() {
        return this.b;
    }

    public Theme getTheme() {
        return this.c == null ? super.getTheme() : this.c;
    }

    public void setTheme(int i) {
        if (this.c == null) {
            super.setTheme(i);
        } else {
            this.c.applyStyle(i, true);
        }
    }
}
