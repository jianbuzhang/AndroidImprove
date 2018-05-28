package android.support.v4.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

final class t implements Parcelable {
    public static final Creator<t> CREATOR = new Creator<t>() {
        public t a(Parcel parcel) {
            return new t(parcel);
        }

        public t[] a(int i) {
            return new t[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }
    };
    final String a;
    final int b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final Bundle i;
    final boolean j;
    Bundle k;
    k l;

    public t(Parcel parcel) {
        boolean z = true;
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readInt() != 0;
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readInt() != 0;
        this.h = parcel.readInt() != 0;
        this.i = parcel.readBundle();
        if (parcel.readInt() == 0) {
            z = false;
        }
        this.j = z;
        this.k = parcel.readBundle();
    }

    public t(k kVar) {
        this.a = kVar.getClass().getName();
        this.b = kVar.g;
        this.c = kVar.o;
        this.d = kVar.x;
        this.e = kVar.y;
        this.f = kVar.z;
        this.g = kVar.C;
        this.h = kVar.B;
        this.i = kVar.i;
        this.j = kVar.A;
    }

    public k a(o oVar, k kVar, r rVar) {
        if (this.l == null) {
            Context g = oVar.g();
            if (this.i != null) {
                this.i.setClassLoader(g.getClassLoader());
            }
            this.l = k.a(g, this.a, this.i);
            if (this.k != null) {
                this.k.setClassLoader(g.getClassLoader());
                this.l.e = this.k;
            }
            this.l.a(this.b, kVar);
            this.l.o = this.c;
            this.l.q = true;
            this.l.x = this.d;
            this.l.y = this.e;
            this.l.z = this.f;
            this.l.C = this.g;
            this.l.B = this.h;
            this.l.A = this.j;
            this.l.s = oVar.d;
            if (q.a) {
                Log.v("FragmentManager", "Instantiated fragment " + this.l);
            }
        }
        this.l.v = rVar;
        return this.l;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeBundle(this.i);
        if (!this.j) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.k);
    }
}
