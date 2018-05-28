package android.support.v4.g;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.g.a.e;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class b {
    private static final b b;
    private static final Object c = b.a();
    final Object a = b.a(this);

    interface b {
        e a(Object obj, View view);

        Object a();

        Object a(b bVar);

        void a(Object obj, View view, int i);

        void a(Object obj, View view, android.support.v4.g.a.b bVar);

        boolean a(Object obj, View view, int i, Bundle bundle);

        boolean a(Object obj, View view, AccessibilityEvent accessibilityEvent);

        boolean a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void b(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void c(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void d(Object obj, View view, AccessibilityEvent accessibilityEvent);
    }

    static class d implements b {
        d() {
        }

        public e a(Object obj, View view) {
            return null;
        }

        public Object a() {
            return null;
        }

        public Object a(b bVar) {
            return null;
        }

        public void a(Object obj, View view, int i) {
        }

        public void a(Object obj, View view, android.support.v4.g.a.b bVar) {
        }

        public boolean a(Object obj, View view, int i, Bundle bundle) {
            return false;
        }

        public boolean a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return false;
        }

        public boolean a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return true;
        }

        public void b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public void c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public void d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }
    }

    static class a extends d {
        a() {
        }

        public Object a() {
            return c.a();
        }

        public Object a(final b bVar) {
            return c.a(new android.support.v4.g.c.a(this) {
                final /* synthetic */ a b;

                public void a(View view, int i) {
                    bVar.a(view, i);
                }

                public void a(View view, Object obj) {
                    bVar.a(view, new android.support.v4.g.a.b(obj));
                }

                public boolean a(View view, AccessibilityEvent accessibilityEvent) {
                    return bVar.b(view, accessibilityEvent);
                }

                public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return bVar.a(viewGroup, view, accessibilityEvent);
                }

                public void b(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.d(view, accessibilityEvent);
                }

                public void c(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.c(view, accessibilityEvent);
                }

                public void d(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.a(view, accessibilityEvent);
                }
            });
        }

        public void a(Object obj, View view, int i) {
            c.a(obj, view, i);
        }

        public void a(Object obj, View view, android.support.v4.g.a.b bVar) {
            c.a(obj, view, bVar.a());
        }

        public boolean a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return c.a(obj, view, accessibilityEvent);
        }

        public boolean a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return c.a(obj, viewGroup, view, accessibilityEvent);
        }

        public void b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            c.b(obj, view, accessibilityEvent);
        }

        public void c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            c.c(obj, view, accessibilityEvent);
        }

        public void d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            c.d(obj, view, accessibilityEvent);
        }
    }

    static class c extends a {
        c() {
        }

        public e a(Object obj, View view) {
            Object a = d.a(obj, view);
            return a != null ? new e(a) : null;
        }

        public Object a(final b bVar) {
            return d.a(new android.support.v4.g.d.a(this) {
                final /* synthetic */ c b;

                public Object a(View view) {
                    e a = bVar.a(view);
                    return a != null ? a.a() : null;
                }

                public void a(View view, int i) {
                    bVar.a(view, i);
                }

                public void a(View view, Object obj) {
                    bVar.a(view, new android.support.v4.g.a.b(obj));
                }

                public boolean a(View view, int i, Bundle bundle) {
                    return bVar.a(view, i, bundle);
                }

                public boolean a(View view, AccessibilityEvent accessibilityEvent) {
                    return bVar.b(view, accessibilityEvent);
                }

                public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return bVar.a(viewGroup, view, accessibilityEvent);
                }

                public void b(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.d(view, accessibilityEvent);
                }

                public void c(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.c(view, accessibilityEvent);
                }

                public void d(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.a(view, accessibilityEvent);
                }
            });
        }

        public boolean a(Object obj, View view, int i, Bundle bundle) {
            return d.a(obj, view, i, bundle);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            b = new c();
        } else if (VERSION.SDK_INT >= 14) {
            b = new a();
        } else {
            b = new d();
        }
    }

    public e a(View view) {
        return b.a(c, view);
    }

    Object a() {
        return this.a;
    }

    public void a(View view, int i) {
        b.a(c, view, i);
    }

    public void a(View view, android.support.v4.g.a.b bVar) {
        b.a(c, view, bVar);
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        b.d(c, view, accessibilityEvent);
    }

    public boolean a(View view, int i, Bundle bundle) {
        return b.a(c, view, i, bundle);
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return b.a(c, viewGroup, view, accessibilityEvent);
    }

    public boolean b(View view, AccessibilityEvent accessibilityEvent) {
        return b.a(c, view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        b.c(c, view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        b.b(c, view, accessibilityEvent);
    }
}
