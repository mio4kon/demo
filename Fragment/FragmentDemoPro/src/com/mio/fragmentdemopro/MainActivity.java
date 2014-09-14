package com.mio.fragmentdemopro;


import com.mio.fragmentdemopro.FragmentOne.OneFragmentClickListener;
import com.mio.fragmentdemopro.FragmentTwo.TwoFragmentClickListener;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements OneFragmentClickListener {
	 private FragmentManager mFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 一开始MainActivity加载一个fragmentOne
         */
        FragmentOne fragmentOne = new FragmentOne();
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mTransaction = mFragmentManager.beginTransaction();
        mTransaction.add(R.id.content,fragmentOne , "fragmentOne");
        mTransaction.commit();
    }
    
    /**
     * 写在fragmentOne中的回调方法
     */
	@Override
	public void oneFragmentClick() {
		FragmentTwo fragmentTwo = new FragmentTwo();
		FragmentTransaction mTransaction = mFragmentManager.beginTransaction();
		mTransaction.replace(R.id.content, fragmentTwo, "fragmentTwo");
		mTransaction.addToBackStack(null);
		mTransaction.commit();
		//设置fragment2的按钮需要设置回调接口
		fragmentTwo.setTwoFragmentListener(new TwoFragmentClickListener() {
			
			@Override
			public void twoFragmentClick() {
				Toast.makeText(MainActivity.this, "搞定,这里写进入fragment3的逻辑即可", 0).show(); 					
			}
		});
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
