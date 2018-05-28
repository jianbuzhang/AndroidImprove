package android.support.v4.d.a;

import android.support.v4.g.e;
import android.support.v4.g.q;
import android.view.MenuItem;
import android.view.View;

public interface b extends MenuItem {
    b a(e eVar);

    b a(q.e eVar);

    e a();

    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    boolean isActionViewExpanded();

    MenuItem setActionView(int i);

    MenuItem setActionView(View view);

    void setShowAsAction(int i);

    MenuItem setShowAsActionFlags(int i);
}
