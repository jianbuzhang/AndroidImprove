package android.support.v4.g;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;

class k {

    static class a implements Factory {
        final n a;

        a(n nVar) {
            this.a = nVar;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.a.a(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.a + "}";
        }
    }

    static n a(LayoutInflater layoutInflater) {
        Factory factory = layoutInflater.getFactory();
        return factory instanceof a ? ((a) factory).a : null;
    }

    static void a(LayoutInflater layoutInflater, n nVar) {
        layoutInflater.setFactory(nVar != null ? new a(nVar) : null);
    }
}
