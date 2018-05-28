package android.support.v7.a;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.g.ae;
import android.support.v7.b.a.j;
import android.support.v7.view.menu.h;
import android.support.v7.widget.ac;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window.Callback;
import java.util.ArrayList;

class o extends a {
    private ac a;
    private Callback b;
    private boolean c;
    private boolean d;
    private ArrayList<android.support.v7.a.a.b> e;
    private final Runnable f;

    /* renamed from: android.support.v7.a.o$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ o a;

        public void run() {
            this.a.i();
        }
    }

    private final class a implements android.support.v7.view.menu.o.a {
        final /* synthetic */ o a;
        private boolean b;

        private a(o oVar) {
            this.a = oVar;
        }

        public void a(h hVar, boolean z) {
            if (!this.b) {
                this.b = true;
                this.a.a.n();
                if (this.a.b != null) {
                    this.a.b.onPanelClosed(j.AppCompatTheme_ratingBarStyle, hVar);
                }
                this.b = false;
            }
        }

        public boolean a(h hVar) {
            if (this.a.b == null) {
                return false;
            }
            this.a.b.onMenuOpened(j.AppCompatTheme_ratingBarStyle, hVar);
            return true;
        }
    }

    private final class b implements android.support.v7.view.menu.h.a {
        final /* synthetic */ o a;

        private b(o oVar) {
            this.a = oVar;
        }

        public void a(h hVar) {
            if (this.a.b == null) {
                return;
            }
            if (this.a.a.i()) {
                this.a.b.onPanelClosed(j.AppCompatTheme_ratingBarStyle, hVar);
            } else if (this.a.b.onPreparePanel(0, null, hVar)) {
                this.a.b.onMenuOpened(j.AppCompatTheme_ratingBarStyle, hVar);
            }
        }

        public boolean a(h hVar, MenuItem menuItem) {
            return false;
        }
    }

    private Menu j() {
        if (!this.c) {
            this.a.a(new a(), new b());
            this.c = true;
        }
        return this.a.r();
    }

    public int a() {
        return this.a.o();
    }

    public void a(float f) {
        ae.c(this.a.a(), f);
    }

    public void a(Configuration configuration) {
        super.a(configuration);
    }

    public void a(CharSequence charSequence) {
        this.a.a(charSequence);
    }

    public void a(boolean z) {
    }

    public boolean a(int i, KeyEvent keyEvent) {
        Menu j = j();
        if (j != null) {
            j.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            j.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    public boolean b() {
        return this.a.q() == 0;
    }

    public Context c() {
        return this.a.b();
    }

    public void c(boolean z) {
    }

    public void d(boolean z) {
    }

    public void e(boolean z) {
        if (z != this.d) {
            this.d = z;
            int size = this.e.size();
            for (int i = 0; i < size; i++) {
                ((android.support.v7.a.a.b) this.e.get(i)).a(z);
            }
        }
    }

    public boolean e() {
        this.a.a().removeCallbacks(this.f);
        ae.a(this.a.a(), this.f);
        return true;
    }

    public boolean f() {
        if (!this.a.c()) {
            return false;
        }
        this.a.d();
        return true;
    }

    public boolean g() {
        ViewGroup a = this.a.a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    void h() {
        this.a.a().removeCallbacks(this.f);
    }

    void i() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0030 in list [B:12:0x002d]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = r5.j();
        r2 = r1 instanceof android.support.v7.view.menu.h;
        if (r2 == 0) goto L_0x0031;
    L_0x0009:
        r0 = r1;
        r0 = (android.support.v7.view.menu.h) r0;
        r2 = r0;
    L_0x000d:
        if (r2 == 0) goto L_0x0012;
    L_0x000f:
        r2.g();
    L_0x0012:
        r1.clear();	 Catch:{ all -> 0x0033 }
        r0 = r5.b;	 Catch:{ all -> 0x0033 }
        r3 = 0;	 Catch:{ all -> 0x0033 }
        r0 = r0.onCreatePanelMenu(r3, r1);	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0028;	 Catch:{ all -> 0x0033 }
    L_0x001e:
        r0 = r5.b;	 Catch:{ all -> 0x0033 }
        r3 = 0;	 Catch:{ all -> 0x0033 }
        r4 = 0;	 Catch:{ all -> 0x0033 }
        r0 = r0.onPreparePanel(r3, r4, r1);	 Catch:{ all -> 0x0033 }
        if (r0 != 0) goto L_0x002b;	 Catch:{ all -> 0x0033 }
    L_0x0028:
        r1.clear();	 Catch:{ all -> 0x0033 }
    L_0x002b:
        if (r2 == 0) goto L_0x0030;
    L_0x002d:
        r2.h();
    L_0x0030:
        return;
    L_0x0031:
        r2 = r0;
        goto L_0x000d;
    L_0x0033:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0039;
    L_0x0036:
        r2.h();
    L_0x0039:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.a.o.i():void");
    }
}
