package android.support.v7.a;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;

class j extends i {
    private int r = -100;
    private boolean s;
    private boolean t = true;
    private b u;

    class a extends a {
        final /* synthetic */ j c;

        a(j jVar, Callback callback) {
            this.c = jVar;
            super(jVar, callback);
        }

        final ActionMode a(ActionMode.Callback callback) {
            Object aVar = new android.support.v7.view.f.a(this.c.a, callback);
            android.support.v7.view.b b = this.c.b((android.support.v7.view.b.a) aVar);
            return b != null ? aVar.b(b) : null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return this.c.o() ? a(callback) : super.onWindowStartingActionMode(callback);
        }
    }

    final class b {
        final /* synthetic */ j a;
        private q b;
        private boolean c;
        private BroadcastReceiver d;
        private IntentFilter e;

        b(j jVar, q qVar) {
            this.a = jVar;
            this.b = qVar;
            this.c = qVar.a();
        }

        final int a() {
            return this.c ? 2 : 1;
        }

        final void b() {
            boolean a = this.b.a();
            if (a != this.c) {
                this.c = a;
                this.a.i();
            }
        }

        final void c() {
            d();
            if (this.d == null) {
                this.d = new BroadcastReceiver(this) {
                    final /* synthetic */ b a;

                    {
                        this.a = r1;
                    }

                    public void onReceive(Context context, Intent intent) {
                        this.a.b();
                    }
                };
            }
            if (this.e == null) {
                this.e = new IntentFilter();
                this.e.addAction("android.intent.action.TIME_SET");
                this.e.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.e.addAction("android.intent.action.TIME_TICK");
            }
            this.a.a.registerReceiver(this.d, this.e);
        }

        final void d() {
            if (this.d != null) {
                this.a.a.unregisterReceiver(this.d);
                this.d = null;
            }
        }
    }

    j(Context context, Window window, e eVar) {
        super(context, window, eVar);
    }

    private boolean e(int i) {
        Resources resources = this.a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 == i3) {
            return false;
        }
        if (w()) {
            ((Activity) this.a).recreate();
        } else {
            Configuration configuration2 = new Configuration(configuration);
            configuration2.uiMode = i3 | (configuration2.uiMode & -49);
            resources.updateConfiguration(configuration2, null);
        }
        return true;
    }

    private int u() {
        return this.r != -100 ? this.r : f.j();
    }

    private void v() {
        if (this.u == null) {
            this.u = new b(this, q.a(this.a));
        }
    }

    private boolean w() {
        if (!this.s || !(this.a instanceof Activity)) {
            return false;
        }
        try {
            return (this.a.getPackageManager().getActivityInfo(new ComponentName(this.a, this.a.getClass()), 0).configChanges & 512) == 0;
        } catch (Throwable e) {
            Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
            return true;
        }
    }

    Callback a(Callback callback) {
        return new a(this, callback);
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle != null && this.r == -100) {
            this.r = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    public void c() {
        super.c();
        i();
    }

    public void c(Bundle bundle) {
        super.c(bundle);
        if (this.r != -100) {
            bundle.putInt("appcompat:local_night_mode", this.r);
        }
    }

    int d(int i) {
        switch (i) {
            case -100:
                return -1;
            case 0:
                v();
                return this.u.a();
            default:
                return i;
        }
    }

    public void d() {
        super.d();
        if (this.u != null) {
            this.u.d();
        }
    }

    public void g() {
        super.g();
        if (this.u != null) {
            this.u.d();
        }
    }

    public boolean i() {
        boolean z = false;
        int u = u();
        int d = d(u);
        if (d != -1) {
            z = e(d);
        }
        if (u == 0) {
            v();
            this.u.c();
        }
        this.s = true;
        return z;
    }

    public boolean o() {
        return this.t;
    }
}
