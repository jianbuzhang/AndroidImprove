package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.g.ae;
import android.support.v7.b.a.j;
import android.util.AttributeSet;
import android.view.View;

class g {
    private final View a;
    private final l b;
    private int c = -1;
    private a d;
    private a e;
    private a f;

    private static class a extends at {
        public ColorStateList a;

        private a() {
        }

        void a() {
            super.a();
            this.a = null;
        }
    }

    g(View view) {
        this.a = view;
        this.b = l.a();
    }

    private boolean b(Drawable drawable) {
        if (this.f == null) {
            this.f = new a();
        }
        at atVar = this.f;
        atVar.a();
        ColorStateList m = ae.m(this.a);
        if (m != null) {
            atVar.e = true;
            atVar.b = m;
        }
        Mode n = ae.n(this.a);
        if (n != null) {
            atVar.d = true;
            atVar.c = n;
        }
        if (!atVar.e && !atVar.d) {
            return false;
        }
        l.a(drawable, atVar, this.a.getDrawableState());
        return true;
    }

    private boolean d() {
        if (this.e != null && this.e.e) {
            if (this.c >= 0) {
                ColorStateList a = this.b.a(this.a.getContext(), this.c, this.e.a);
                if (a != null) {
                    this.e.b = a;
                    return true;
                }
            }
            if (this.e.b != this.e.a) {
                this.e.b = this.e.a;
                return true;
            }
        }
        return false;
    }

    ColorStateList a() {
        return this.e != null ? this.e.b : null;
    }

    void a(int i) {
        this.c = i;
        b(this.b != null ? this.b.b(this.a.getContext(), i) : null);
        if (d()) {
            c();
        }
    }

    void a(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new a();
        }
        this.e.a = colorStateList;
        this.e.b = null;
        this.e.e = true;
        if (d()) {
            c();
        }
    }

    void a(Mode mode) {
        if (this.e == null) {
            this.e = new a();
        }
        this.e.c = mode;
        this.e.d = true;
        c();
    }

    void a(Drawable drawable) {
        this.c = -1;
        b(null);
        if (d()) {
            c();
        }
    }

    void a(AttributeSet attributeSet, int i) {
        av a = av.a(this.a.getContext(), attributeSet, j.ViewBackgroundHelper, i, 0);
        try {
            if (a.g(j.ViewBackgroundHelper_android_background)) {
                this.c = a.g(j.ViewBackgroundHelper_android_background, -1);
                ColorStateList b = this.b.b(this.a.getContext(), this.c);
                if (b != null) {
                    b(b);
                }
            }
            if (a.g(j.ViewBackgroundHelper_backgroundTint)) {
                ae.a(this.a, a.e(j.ViewBackgroundHelper_backgroundTint));
            }
            if (a.g(j.ViewBackgroundHelper_backgroundTintMode)) {
                ae.a(this.a, ad.a(a.a(j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            a.a();
        } catch (Throwable th) {
            a.a();
        }
    }

    Mode b() {
        return this.e != null ? this.e.c : null;
    }

    void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new a();
            }
            this.d.b = colorStateList;
            this.d.e = true;
        } else {
            this.d = null;
        }
        c();
    }

    void c() {
        Drawable background = this.a.getBackground();
        if (background == null) {
            return;
        }
        if (VERSION.SDK_INT != 21 || !b(background)) {
            if (this.e != null) {
                l.a(background, this.e, this.a.getDrawableState());
            } else if (this.d != null) {
                l.a(background, this.d, this.a.getDrawableState());
            }
        }
    }
}
