package com.mio.dialogdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {
	LStyleDialog mMaterialDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();

	}

	public void show(View view) {
		mMaterialDialog = new LStyleDialog(this);
		mMaterialDialog.setTitle("MaterialDialog").setMessage("dewufuierghuirehuieuheiwhfuiewhuihwdqoiiodwhjioi").setPositiveButton("OK", new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mMaterialDialog.dismiss();
				Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_LONG)
						.show();
			}
		}).setNegativeButton("CANCEL", new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mMaterialDialog.dismiss();
				Toast.makeText(MainActivity.this, "Cancle", Toast.LENGTH_LONG)
						.show();
			}
		}).show();
		//mMaterialDialog.setBackgroundResource(R.drawable.background);
	}

	private void init() {

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
