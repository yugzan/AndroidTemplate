package org.iii.yugzan.template.viewload;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity implements ViewItemListener<View> {
	private RootView rootView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		rootView = new RootView(this);
		setContentView(rootView);

		rootView.setOnClickViewItem(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onViewItemClickListener(View v, int itemId) {

		log(itemId);

		switch (itemId) {
		case 0:
			break; // do some thing
		case 1:
			break;
		case 2:
			break;
		}
	}

	private void log(String value) {
		Log.e("MainActivity", value);
	}

	private void log(Integer value) {
		Log.e("MainActivity", String.valueOf(value));
	}
}
