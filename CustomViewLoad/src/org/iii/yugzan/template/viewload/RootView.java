package org.iii.yugzan.template.viewload;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * @author yugzan
 * 
 */
public class RootView extends LinearLayout {
	private Context context;
	private LayoutInflater rootLayout;
	private ViewItemListener<View> onClickCallBack;

	public RootView(Context _context) {
		super(_context);
		context = _context;
		LinearLayout.LayoutParams l = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		this.setLayoutParams(l);
		this.setOrientation(LinearLayout.VERTICAL);
		rootLayout = LayoutInflater.from(_context);
		for (int i = 0; i < 3; i++) {
			this.addView(addMyItem(i));
		}

	}

	private View addMyItem(final int id) {
		CustomViewItem viewitem = new CustomViewItem(rootLayout.inflate(
				R.layout.item, null), id);
		viewitem.getImageView().setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				onClickCallBack.onViewItemClickListener(v, id);
			}
		});
		return viewitem.getView();
	}

	public void setOnClickViewItem(ViewItemListener<View> onClickCallBack) {
		this.onClickCallBack = onClickCallBack;
	}

}
