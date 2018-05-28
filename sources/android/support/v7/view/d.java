package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.support.v7.b.a.i;
import android.view.LayoutInflater;

public class d extends ContextWrapper {
    private int a;
    private Theme b;
    private LayoutInflater c;

    public d(Context context, int i) {
        super(context);
        this.a = i;
    }

    public d(Context context, Theme theme) {
        super(context);
        this.b = theme;
    }

    private void b() {
        boolean z = this.b == null;
        if (z) {
            this.b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.b.setTo(theme);
            }
        }
        a(this.b, this.a, z);
    }

    public int a() {
        return this.a;
    }

    protected void a(Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.c == null) {
            this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.c;
    }

    public Theme getTheme() {
        if (this.b != null) {
            return this.b;
        }
        if (this.a == 0) {
            this.a = i.Theme_AppCompat_Light;
        }
        b();
        return this.b;
    }

    public void setTheme(int i) {
        if (this.a != i) {
            this.a = i;
            b();
        }
    }
}
