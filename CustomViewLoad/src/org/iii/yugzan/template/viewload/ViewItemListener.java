package org.iii.yugzan.template.viewload;

import android.view.View;

/**
 * @author yugzan
 * 
 * @param <V>
 */
public interface ViewItemListener<V extends View> {
	void onViewItemClickListener(V v, int itemId);
}
