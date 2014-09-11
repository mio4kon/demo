package com.mio.tabviewpage;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar.TabListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;

/**
 * 需要实现两个监听
 * TabListener:				tab改变--->Viewpage改变
 * OnPageChangeListener:	ViewPage改变--->tab改变
 * @author mio
 *
 */
public class MainActivity extends SherlockFragmentActivity implements
		ActionBar.TabListener,OnPageChangeListener {

	private String[] mTabTitles = { "首页", "新闻", "关注", "声音" };
	private ViewPager mViewPager;
	/**
	 * 装载Fragment的容器，我们的每一个界面都是一个Fragment
	 */
	private List<Fragment> mFragmentList;
	private ActionBar mActionBar;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		mViewPager = (ViewPager) findViewById(R.id.vp);
		mFragmentList =  new ArrayList<Fragment>(); 
		mViewPager.setAdapter(new TabPagerAdapter(getSupportFragmentManager(),
				mFragmentList));

		// 获取ActionBar实例我们使用getSupportActionBar()方法
		mActionBar = getSupportActionBar();
		// 隐藏Title
		mActionBar.setDisplayShowTitleEnabled(false);
		// 隐藏Home logo
		mActionBar.setDisplayShowHomeEnabled(false);
		// 设置ActionBar的导航模式为Tab
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		// 设置监听
		mViewPager.setOnPageChangeListener(this);

		// 为ActionBar添加Tab并设置TabListener
		// 为ActionBar添加Tab并设置TabListener
		for (int i = 0; i < mTabTitles.length; i++) {
			ActionBar.Tab tab = mActionBar.newTab();
			tab.setText(mTabTitles[i]);
			tab.setTabListener(this);
			mActionBar.addTab(tab, i);
		}

		// 将Fragment加入到List中，并将Tab的title传递给Fragment
		for (int i = 0; i < mTabTitles.length; i++) {
			Fragment fragment = new ItemFragment();
			// 将tab的名称传递给Fragment
			Bundle args = new Bundle();
			args.putString("arg", mTabTitles[i]);
			fragment.setArguments(args);

			mFragmentList.add(fragment);
		}

	}

	/**
	 * 点击ActionBar Tab的时候切换不同的Fragment界面
	 */
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int arg0) {
		// 滑动ViewPager的时候设置相对应的ActionBar Tab被选中
		mActionBar.setSelectedNavigationItem(arg0);

	}
}
