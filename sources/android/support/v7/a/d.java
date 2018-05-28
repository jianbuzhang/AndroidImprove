package android.support.v7.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.a.ad;
import android.support.v4.a.ad.a;
import android.support.v4.a.l;
import android.support.v4.a.y;
import android.support.v4.g.h;
import android.support.v7.view.b;
import android.support.v7.widget.ax;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class d extends l implements a, e {
    private f m;
    private int n = 0;
    private boolean o;
    private Resources p;

    public Intent a() {
        return y.a(this);
    }

    public b a(b.a aVar) {
        return null;
    }

    public void a(ad adVar) {
        adVar.a((Activity) this);
    }

    public void a(b bVar) {
    }

    public boolean a(Intent intent) {
        return y.a((Activity) this, intent);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        h().b(view, layoutParams);
    }

    public void b(Intent intent) {
        y.b((Activity) this, intent);
    }

    public void b(ad adVar) {
    }

    public void b(b bVar) {
    }

    public void c() {
        h().f();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (h.a(keyEvent) && keyEvent.getUnicodeChar(keyEvent.getMetaState() & -28673) == 60) {
            int action = keyEvent.getAction();
            if (action == 0) {
                a e = e();
                if (e != null && e.b() && e.g()) {
                    this.o = true;
                    return true;
                }
            } else if (action == 1 && this.o) {
                this.o = false;
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public a e() {
        return h().a();
    }

    public boolean f() {
        Intent a = a();
        if (a == null) {
            return false;
        }
        if (a(a)) {
            ad a2 = ad.a((Context) this);
            a(a2);
            b(a2);
            a2.a();
            try {
                android.support.v4.a.a.a(this);
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            b(a);
        }
        return true;
    }

    public View findViewById(int i) {
        return h().a(i);
    }

    @Deprecated
    public void g() {
    }

    public MenuInflater getMenuInflater() {
        return h().b();
    }

    public Resources getResources() {
        if (this.p == null && ax.a()) {
            this.p = new ax(this, super.getResources());
        }
        return this.p == null ? super.getResources() : this.p;
    }

    public f h() {
        if (this.m == null) {
            this.m = f.a((Activity) this, (e) this);
        }
        return this.m;
    }

    public void invalidateOptionsMenu() {
        h().f();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        h().a(configuration);
        if (this.p != null) {
            this.p.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    public void onContentChanged() {
        g();
    }

    protected void onCreate(Bundle bundle) {
        f h = h();
        h.h();
        h.a(bundle);
        if (h.i() && this.n != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.n, false);
            } else {
                setTheme(this.n);
            }
        }
        super.onCreate(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        h().g();
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        a e = e();
        return (menuItem.getItemId() != 16908332 || e == null || (e.a() & 4) == 0) ? false : f();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        h().b(bundle);
    }

    protected void onPostResume() {
        super.onPostResume();
        h().e();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        h().c(bundle);
    }

    protected void onStart() {
        super.onStart();
        h().c();
    }

    protected void onStop() {
        super.onStop();
        h().d();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        h().a(charSequence);
    }

    public void setContentView(int i) {
        h().b(i);
    }

    public void setContentView(View view) {
        h().a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        h().a(view, layoutParams);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.n = i;
    }
}
