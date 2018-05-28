package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.c.a.b;
import android.util.AttributeSet;

public class av {
    private final Context a;
    private final TypedArray b;

    private av(Context context, TypedArray typedArray) {
        this.a = context;
        this.b = typedArray;
    }

    public static av a(Context context, int i, int[] iArr) {
        return new av(context, context.obtainStyledAttributes(i, iArr));
    }

    public static av a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new av(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static av a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new av(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public float a(int i, float f) {
        return this.b.getFloat(i, f);
    }

    public int a(int i, int i2) {
        return this.b.getInt(i, i2);
    }

    public Drawable a(int i) {
        if (this.b.hasValue(i)) {
            int resourceId = this.b.getResourceId(i, 0);
            if (resourceId != 0) {
                return b.b(this.a, resourceId);
            }
        }
        return this.b.getDrawable(i);
    }

    public void a() {
        this.b.recycle();
    }

    public boolean a(int i, boolean z) {
        return this.b.getBoolean(i, z);
    }

    public int b(int i, int i2) {
        return this.b.getColor(i, i2);
    }

    public Drawable b(int i) {
        if (this.b.hasValue(i)) {
            int resourceId = this.b.getResourceId(i, 0);
            if (resourceId != 0) {
                return l.a().a(this.a, resourceId, true);
            }
        }
        return null;
    }

    public int c(int i, int i2) {
        return this.b.getInteger(i, i2);
    }

    public CharSequence c(int i) {
        return this.b.getText(i);
    }

    public int d(int i, int i2) {
        return this.b.getDimensionPixelOffset(i, i2);
    }

    public String d(int i) {
        return this.b.getString(i);
    }

    public int e(int i, int i2) {
        return this.b.getDimensionPixelSize(i, i2);
    }

    public ColorStateList e(int i) {
        if (this.b.hasValue(i)) {
            int resourceId = this.b.getResourceId(i, 0);
            if (resourceId != 0) {
                ColorStateList a = b.a(this.a, resourceId);
                if (a != null) {
                    return a;
                }
            }
        }
        return this.b.getColorStateList(i);
    }

    public int f(int i, int i2) {
        return this.b.getLayoutDimension(i, i2);
    }

    public CharSequence[] f(int i) {
        return this.b.getTextArray(i);
    }

    public int g(int i, int i2) {
        return this.b.getResourceId(i, i2);
    }

    public boolean g(int i) {
        return this.b.hasValue(i);
    }
}
