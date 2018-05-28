package android.support.v4.g.a;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class e {
    private static final a a;
    private final Object b;

    interface a {
        Object a(e eVar);
    }

    static class d implements a {
        d() {
        }

        public Object a(e eVar) {
            return null;
        }
    }

    private static class b extends d {
        private b() {
        }

        public Object a(final e eVar) {
            return f.a(new a(this) {
                final /* synthetic */ b b;

                public Object a(int i) {
                    b a = eVar.a(i);
                    return a == null ? null : a.a();
                }

                public List<Object> a(String str, int i) {
                    List a = eVar.a(str, i);
                    if (a == null) {
                        return null;
                    }
                    List<Object> arrayList = new ArrayList();
                    int size = a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(((b) a.get(i2)).a());
                    }
                    return arrayList;
                }

                public boolean a(int i, int i2, Bundle bundle) {
                    return eVar.a(i, i2, bundle);
                }
            });
        }
    }

    private static class c extends d {
        private c() {
        }

        public Object a(final e eVar) {
            return g.a(new a(this) {
                final /* synthetic */ c b;

                public Object a(int i) {
                    b a = eVar.a(i);
                    return a == null ? null : a.a();
                }

                public List<Object> a(String str, int i) {
                    List a = eVar.a(str, i);
                    if (a == null) {
                        return null;
                    }
                    List<Object> arrayList = new ArrayList();
                    int size = a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(((b) a.get(i2)).a());
                    }
                    return arrayList;
                }

                public boolean a(int i, int i2, Bundle bundle) {
                    return eVar.a(i, i2, bundle);
                }

                public Object b(int i) {
                    b b = eVar.b(i);
                    return b == null ? null : b.a();
                }
            });
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            a = new c();
        } else if (VERSION.SDK_INT >= 16) {
            a = new b();
        } else {
            a = new d();
        }
    }

    public e() {
        this.b = a.a(this);
    }

    public e(Object obj) {
        this.b = obj;
    }

    public b a(int i) {
        return null;
    }

    public Object a() {
        return this.b;
    }

    public List<b> a(String str, int i) {
        return null;
    }

    public boolean a(int i, int i2, Bundle bundle) {
        return false;
    }

    public b b(int i) {
        return null;
    }
}
