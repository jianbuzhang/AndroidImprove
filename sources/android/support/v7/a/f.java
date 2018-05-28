package android.support.v7.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.e.c;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public abstract class f {
    private static int a = -1;
    private static boolean b = false;

    f() {
    }

    public static f a(Activity activity, e eVar) {
        return a(activity, activity.getWindow(), eVar);
    }

    public static f a(Dialog dialog, e eVar) {
        return a(dialog.getContext(), dialog.getWindow(), eVar);
    }

    private static f a(Context context, Window window, e eVar) {
        int i = VERSION.SDK_INT;
        return c.a() ? new h(context, window, eVar) : i >= 23 ? new k(context, window, eVar) : i >= 14 ? new j(context, window, eVar) : i >= 11 ? new i(context, window, eVar) : new l(context, window, eVar);
    }

    public static int j() {
        return a;
    }

    public static boolean k() {
        return b;
    }

    public abstract a a();

    public abstract View a(int i);

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public abstract void a(View view);

    public abstract void a(View view, LayoutParams layoutParams);

    public abstract void a(CharSequence charSequence);

    public abstract MenuInflater b();

    public abstract void b(int i);

    public abstract void b(Bundle bundle);

    public abstract void b(View view, LayoutParams layoutParams);

    public abstract void c();

    public abstract void c(Bundle bundle);

    public abstract boolean c(int i);

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract boolean i();
}
