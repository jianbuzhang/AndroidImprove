package android.support.v4.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class s implements Parcelable {
    public static final Creator<s> CREATOR = new Creator<s>() {
        public s a(Parcel parcel) {
            return new s(parcel);
        }

        public s[] a(int i) {
            return new s[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }
    };
    t[] a;
    int[] b;
    g[] c;

    public s(Parcel parcel) {
        this.a = (t[]) parcel.createTypedArray(t.CREATOR);
        this.b = parcel.createIntArray();
        this.c = (g[]) parcel.createTypedArray(g.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.a, i);
        parcel.writeIntArray(this.b);
        parcel.writeTypedArray(this.c, i);
    }
}
