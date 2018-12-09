package CustomUI;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * Created by Ameer Hamza on 4/25/2016.
 */
public class CustomLinearLayoutManager extends LinearLayoutManager {

    public CustomLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    @Override
    public boolean canScrollHorizontally() {
        return false;
    }

    @Override
    public boolean canScrollVertically() {
        return true;
    }
}