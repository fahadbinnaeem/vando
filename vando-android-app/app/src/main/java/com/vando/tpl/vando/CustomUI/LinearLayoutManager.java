package CustomUI;

import android.content.Context;

/**
 * Created by Aurang Zeb on 5/5/2016.
 */
public class LinearLayoutManager extends android.support.v7.widget.LinearLayoutManager {

    public LinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    @Override
    public boolean canScrollHorizontally() {
        return true;
    }

    @Override
    public boolean canScrollVertically() {
        return false;
    }
}
