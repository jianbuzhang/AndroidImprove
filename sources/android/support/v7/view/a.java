package android.support.v7.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.g.ao;
import android.support.v7.b.a.b;
import android.support.v7.b.a.d;
import android.support.v7.b.a.j;
import android.view.ViewConfiguration;

public class a {
    private Context a;

    private a(Context context) {
        this.a = context;
    }

    public static a a(Context context) {
        return new a(context);
    }

    public int a() {
        Resources resources = this.a.getResources();
        int b = android.support.v4.b.a.a.b(resources);
        int a = android.support.v4.b.a.a.a(resources);
        return (android.support.v4.b.a.a.c(resources) > 600 || b > 600 || ((b > 960 && a > 720) || (b > 720 && a > 960))) ? 5 : (b >= 500 || ((b > 640 && a > 480) || (b > 480 && a > 640))) ? 4 : b >= 360 ? 3 : 2;
    }

    public boolean b() {
        return VERSION.SDK_INT >= 19 || !ao.a(ViewConfiguration.get(this.a));
    }

    public int c() {
        return this.a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean d() {
        return this.a.getResources().getBoolean(b.abc_action_bar_embed_tabs);
    }

    public int e() {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(null, j.ActionBar, android.support.v7.b.a.a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(j.ActionBar_height, 0);
        Resources resources = this.a.getResources();
        if (!d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(d.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean f() {
        return this.a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int g() {
        return this.a.getResources().getDimensionPixelSize(d.abc_action_bar_stacked_tab_max_width);
    }
}
