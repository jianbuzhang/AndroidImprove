package android.support.v4.a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.v4.b.f;
import android.util.Log;

public final class y {
    private static final a a;

    interface a {
        Intent a(Activity activity);

        String a(Context context, ActivityInfo activityInfo);

        boolean a(Activity activity, Intent intent);

        void b(Activity activity, Intent intent);
    }

    static class b implements a {
        b() {
        }

        public Intent a(Activity activity) {
            String b = y.b(activity);
            if (b == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, b);
            try {
                return y.b((Context) activity, componentName) == null ? f.a(componentName) : new Intent().setComponent(componentName);
            } catch (NameNotFoundException e) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + b + "' in manifest");
                return null;
            }
        }

        public String a(Context context, ActivityInfo activityInfo) {
            if (activityInfo.metaData == null) {
                return null;
            }
            String string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
            return string == null ? null : string.charAt(0) == '.' ? context.getPackageName() + string : string;
        }

        public boolean a(Activity activity, Intent intent) {
            String action = activity.getIntent().getAction();
            return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
        }

        public void b(Activity activity, Intent intent) {
            intent.addFlags(67108864);
            activity.startActivity(intent);
            activity.finish();
        }
    }

    static class c extends b {
        c() {
        }

        public Intent a(Activity activity) {
            Intent a = z.a(activity);
            return a == null ? b(activity) : a;
        }

        public String a(Context context, ActivityInfo activityInfo) {
            String a = z.a(activityInfo);
            return a == null ? super.a(context, activityInfo) : a;
        }

        public boolean a(Activity activity, Intent intent) {
            return z.a(activity, intent);
        }

        Intent b(Activity activity) {
            return super.a(activity);
        }

        public void b(Activity activity, Intent intent) {
            z.b(activity, intent);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            a = new c();
        } else {
            a = new b();
        }
    }

    public static Intent a(Activity activity) {
        return a.a(activity);
    }

    public static Intent a(Context context, ComponentName componentName) {
        String b = b(context, componentName);
        if (b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b);
        return b(context, componentName2) == null ? f.a(componentName2) : new Intent().setComponent(componentName2);
    }

    public static boolean a(Activity activity, Intent intent) {
        return a.a(activity, intent);
    }

    public static String b(Activity activity) {
        try {
            return b((Context) activity, activity.getComponentName());
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String b(Context context, ComponentName componentName) {
        return a.a(context, context.getPackageManager().getActivityInfo(componentName, 128));
    }

    public static void b(Activity activity, Intent intent) {
        a.b(activity, intent);
    }
}
