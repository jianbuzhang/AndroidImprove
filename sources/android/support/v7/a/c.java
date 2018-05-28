package android.support.v7.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;

public class c extends m implements DialogInterface {
    private final b a = new b(getContext(), this, getWindow());

    public static class a {
        private final android.support.v7.a.b.a a;
        private final int b;

        public a(Context context) {
            this(context, c.b(context, 0));
        }

        public a(Context context, int i) {
            this.a = new android.support.v7.a.b.a(new ContextThemeWrapper(context, c.b(context, i)));
            this.b = i;
        }

        public Context a() {
            return this.a.a;
        }

        public a a(OnKeyListener onKeyListener) {
            this.a.r = onKeyListener;
            return this;
        }

        public a a(Drawable drawable) {
            this.a.d = drawable;
            return this;
        }

        public a a(View view) {
            this.a.g = view;
            return this;
        }

        public a a(ListAdapter listAdapter, OnClickListener onClickListener) {
            this.a.t = listAdapter;
            this.a.u = onClickListener;
            return this;
        }

        public a a(CharSequence charSequence) {
            this.a.f = charSequence;
            return this;
        }

        public c b() {
            c cVar = new c(this.a.a, this.b);
            this.a.a(cVar.a);
            cVar.setCancelable(this.a.o);
            if (this.a.o) {
                cVar.setCanceledOnTouchOutside(true);
            }
            cVar.setOnCancelListener(this.a.p);
            cVar.setOnDismissListener(this.a.q);
            if (this.a.r != null) {
                cVar.setOnKeyListener(this.a.r);
            }
            return cVar;
        }
    }

    protected c(Context context, int i) {
        super(context, b(context, i));
    }

    private static int b(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.support.v7.b.a.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a.a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.a.a(i, keyEvent) ? true : super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.a.b(i, keyEvent) ? true : super.onKeyUp(i, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.a.a(charSequence);
    }
}
