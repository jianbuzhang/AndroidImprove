package android.support.v4.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;

abstract class i extends h {
    i() {
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a = a(view, str, context, attributeSet);
        return (a != null || VERSION.SDK_INT < 11) ? a : super.onCreateView(view, str, context, attributeSet);
    }
}
