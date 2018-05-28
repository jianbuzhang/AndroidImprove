package android.support.v4.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class g implements Parcelable {
    public static final Creator<g> CREATOR = new Creator<g>() {
        public g a(Parcel parcel) {
            return new g(parcel);
        }

        public g[] a(int i) {
            return new g[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }
    };
    final int[] a;
    final int b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;
    final ArrayList<String> j;
    final ArrayList<String> k;

    public g(Parcel parcel) {
        this.a = parcel.createIntArray();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = parcel.readInt();
        this.i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.createStringArrayList();
        this.k = parcel.createStringArrayList();
    }

    public g(f fVar) {
        int i = 0;
        for (a aVar = fVar.c; aVar != null; aVar = aVar.a) {
            if (aVar.i != null) {
                i += aVar.i.size();
            }
        }
        this.a = new int[(i + (fVar.e * 7))];
        if (fVar.l) {
            i = 0;
            for (a aVar2 = fVar.c; aVar2 != null; aVar2 = aVar2.a) {
                int i2 = i + 1;
                this.a[i] = aVar2.c;
                int i3 = i2 + 1;
                this.a[i2] = aVar2.d != null ? aVar2.d.g : -1;
                int i4 = i3 + 1;
                this.a[i3] = aVar2.e;
                i2 = i4 + 1;
                this.a[i4] = aVar2.f;
                i4 = i2 + 1;
                this.a[i2] = aVar2.g;
                i2 = i4 + 1;
                this.a[i4] = aVar2.h;
                if (aVar2.i != null) {
                    int size = aVar2.i.size();
                    i4 = i2 + 1;
                    this.a[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.a[i4] = ((k) aVar2.i.get(i2)).g;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.a[i2] = 0;
                }
            }
            this.b = fVar.j;
            this.c = fVar.k;
            this.d = fVar.n;
            this.e = fVar.p;
            this.f = fVar.q;
            this.g = fVar.r;
            this.h = fVar.s;
            this.i = fVar.t;
            this.j = fVar.u;
            this.k = fVar.v;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public f a(q qVar) {
        f fVar = new f(qVar);
        int i = 0;
        int i2 = 0;
        while (i2 < this.a.length) {
            a aVar = new a();
            int i3 = i2 + 1;
            aVar.c = this.a[i2];
            if (q.a) {
                Log.v("FragmentManager", "Instantiate " + fVar + " op #" + i + " base fragment #" + this.a[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.a[i3];
            if (i2 >= 0) {
                aVar.d = (k) qVar.f.get(i2);
            } else {
                aVar.d = null;
            }
            i3 = i4 + 1;
            aVar.e = this.a[i4];
            i4 = i3 + 1;
            aVar.f = this.a[i3];
            i3 = i4 + 1;
            aVar.g = this.a[i4];
            int i5 = i3 + 1;
            aVar.h = this.a[i3];
            i4 = i5 + 1;
            int i6 = this.a[i5];
            if (i6 > 0) {
                aVar.i = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (q.a) {
                        Log.v("FragmentManager", "Instantiate " + fVar + " set remove fragment #" + this.a[i4]);
                    }
                    i5 = i4 + 1;
                    aVar.i.add((k) qVar.f.get(this.a[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            fVar.f = aVar.e;
            fVar.g = aVar.f;
            fVar.h = aVar.g;
            fVar.i = aVar.h;
            fVar.a(aVar);
            i++;
            i2 = i4;
        }
        fVar.j = this.b;
        fVar.k = this.c;
        fVar.n = this.d;
        fVar.p = this.e;
        fVar.l = true;
        fVar.q = this.f;
        fVar.r = this.g;
        fVar.s = this.h;
        fVar.t = this.i;
        fVar.u = this.j;
        fVar.v = this.k;
        fVar.a(1);
        return fVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        TextUtils.writeToParcel(this.g, parcel, 0);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel, 0);
        parcel.writeStringList(this.j);
        parcel.writeStringList(this.k);
    }
}
