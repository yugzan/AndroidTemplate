package org.iii.yugzan.template.viewload;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author yugzan
 * 
 */
public class CustomViewItem {
	private View view;
	private int itemId;
	private ImageView imageView;
	private TextView textView;
	private TextView textView2;

	public CustomViewItem(View _view, int _itemId) {
		view = _view;
		itemId = _itemId;
		bindViewResource();
	}

	private void bindViewResource() {
		imageView = (ImageView) view.findViewById(R.id.imageView1);
		textView = (TextView) view.findViewById(R.id.t1);
		textView2 = (TextView) view.findViewById(R.id.t2);
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}

	public TextView getTextView() {
		return textView;
	}

	public void setTextView(TextView textView) {
		this.textView = textView;
	}

	public TextView getTextView2() {
		return textView2;
	}

	public void setTextView2(TextView textView2) {
		this.textView2 = textView2;
	}

}
