package com.mio.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentTwo extends Fragment implements OnClickListener {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_two, container, false);
		Button mButton = (Button) view.findViewById(R.id.bt);
		mButton.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
		FragmentThree fragmentThree = new FragmentThree();
		FragmentTransaction mTransaction = mFragmentManager.beginTransaction();
		mTransaction.hide(this);
		/**
		 * add与replace的区别:
		 * 如果切换到fragment3,那么replace会调用onDestoryView的方法
		 */
		//mTransaction.add(R.id.content, fragmentThree,"three");
		mTransaction.replace(R.id.content, fragmentThree, "three");
		mTransaction.addToBackStack(null);
		mTransaction.commit();
	}

	@Override
	public void onDestroyView() {
		System.out.println("onDestroyView");
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		System.out.println("onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		System.out.println("onDetach");
		super.onDetach();
	}
}
