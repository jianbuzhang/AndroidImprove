package android.support.v4.g;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import java.lang.reflect.Field;

class l {
    private static Field a;
    private static boolean b;

    static class a extends a implements Factory2 {
        a(n nVar) {
            super(nVar);
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.a.a(view, str, context, attributeSet);
        }
    }

    static void a(LayoutInflater layoutInflater, n nVar) {
        Factory2 aVar = nVar != null ? new a(nVar) : null;
        layoutInflater.setFactory2(aVar);
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2) {
            a(layoutInflater, (Factory2) factory);
        } else {
            a(layoutInflater, aVar);
        }
    }

    static void a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!b) {
            try {
                a = LayoutInflater.class.getDeclaredField("mFactory2");
                a.setAccessible(true);
            } catch (Throwable e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            b = true;
        }
        if (a != null) {
            try {
                a.set(layoutInflater, factory2);
            } catch (Throwable e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
