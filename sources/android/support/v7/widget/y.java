package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.b.a.j;
import android.support.v7.e.a;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

class y {
    final TextView a;
    private at b;
    private at c;
    private at d;
    private at e;

    y(TextView textView) {
        this.a = textView;
    }

    protected static at a(Context context, l lVar, int i) {
        ColorStateList b = lVar.b(context, i);
        if (b == null) {
            return null;
        }
        at atVar = new at();
        atVar.e = true;
        atVar.b = b;
        return atVar;
    }

    static y a(TextView textView) {
        return VERSION.SDK_INT >= 17 ? new z(textView) : new y(textView);
    }

    void a() {
        if (this.b != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
    }

    void a(Context context, int i) {
        av a = av.a(context, i, j.TextAppearance);
        if (a.g(j.TextAppearance_textAllCaps)) {
            a(a.a(j.TextAppearance_textAllCaps, false));
        }
        if (VERSION.SDK_INT < 23 && a.g(j.TextAppearance_android_textColor)) {
            ColorStateList e = a.e(j.TextAppearance_android_textColor);
            if (e != null) {
                this.a.setTextColor(e);
            }
        }
        a.a();
    }

    final void a(Drawable drawable, at atVar) {
        if (drawable != null && atVar != null) {
            l.a(drawable, atVar, this.a.getDrawableState());
        }
    }

    void a(AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2;
        Context context = this.a.getContext();
        l a = l.a();
        av a2 = av.a(context, attributeSet, j.AppCompatTextHelper, i, 0);
        int g = a2.g(j.AppCompatTextHelper_android_textAppearance, -1);
        if (a2.g(j.AppCompatTextHelper_android_drawableLeft)) {
            this.b = a(context, a, a2.g(j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a2.g(j.AppCompatTextHelper_android_drawableTop)) {
            this.c = a(context, a, a2.g(j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a2.g(j.AppCompatTextHelper_android_drawableRight)) {
            this.d = a(context, a, a2.g(j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a2.g(j.AppCompatTextHelper_android_drawableBottom)) {
            this.e = a(context, a, a2.g(j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        a2.a();
        boolean z3 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        ColorStateList colorStateList = null;
        if (g != -1) {
            av a3 = av.a(context, g, j.TextAppearance);
            if (z3 || !a3.g(j.TextAppearance_textAllCaps)) {
                z = false;
                z2 = false;
            } else {
                z2 = a3.a(j.TextAppearance_textAllCaps, false);
                z = true;
            }
            if (VERSION.SDK_INT < 23 && a3.g(j.TextAppearance_android_textColor)) {
                colorStateList = a3.e(j.TextAppearance_android_textColor);
            }
            a3.a();
        } else {
            z = false;
            z2 = false;
        }
        av a4 = av.a(context, attributeSet, j.TextAppearance, i, 0);
        if (!z3 && a4.g(j.TextAppearance_textAllCaps)) {
            z2 = a4.a(j.TextAppearance_textAllCaps, false);
            z = true;
        }
        if (VERSION.SDK_INT < 23 && a4.g(j.TextAppearance_android_textColor)) {
            colorStateList = a4.e(j.TextAppearance_android_textColor);
        }
        a4.a();
        if (colorStateList != null) {
            this.a.setTextColor(colorStateList);
        }
        if (!z3 && r0) {
            a(z2);
        }
    }

    void a(boolean z) {
        this.a.setTransformationMethod(z ? new a(this.a.getContext()) : null);
    }
}
