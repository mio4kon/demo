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

public class FragmentOne extends Fragment implements OnClickListener {


	@Override
	public View onCreateView(LayoutInflater inflater,
	 ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_one,container,false);
		Button mButton = (Button) view.findViewById(R.id.bt);
		mButton.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		FragmentTwo fragmentTwo = new FragmentTwo();
		FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
		FragmentTransaction mTransaction = mFragmentManager.beginTransaction();
		mTransaction.replace(R.id.content, fragmentTwo, "fragmentTwo");
		mTransaction.addToBackStack(null);
		mTransaction.commit();
	}

}
