package android.support.v4.e;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

class f<T> implements ClassLoaderCreator<T> {
    private final e<T> a;

    public f(e<T> eVar) {
        this.a = eVar;
    }

    public T createFromParcel(Parcel parcel) {
        return this.a.a(parcel, null);
    }

    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.a.a(parcel, classLoader);
    }

    public T[] newArray(int i) {
        return this.a.a(i);
    }
}
