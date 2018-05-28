package android.support.v4.g;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.e.d;
import android.support.v4.e.e;

public abstract class a implements Parcelable {
    public static final Creator<a> CREATOR = d.a(new e<a>() {
        public /* synthetic */ Object a(Parcel parcel, ClassLoader classLoader) {
            return b(parcel, classLoader);
        }

        public /* synthetic */ Object[] a(int i) {
            return b(i);
        }

        public a b(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return a.a;
            }
            throw new IllegalStateException("superState must be null");
        }

        public a[] b(int i) {
            return new a[i];
        }
    });
    public static final a a = new a() {
    };
    private final Parcelable b;

    private a() {
        this.b = null;
    }

    protected a(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        if (readParcelable == null) {
            readParcelable = a;
        }
        this.b = readParcelable;
    }

    protected a(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        if (parcelable == a) {
            parcelable = null;
        }
        this.b = parcelable;
    }

    public final Parcelable a() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.b, i);
    }
}
