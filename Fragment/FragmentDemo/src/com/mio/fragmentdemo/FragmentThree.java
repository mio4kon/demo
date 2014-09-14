package com.mio.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentThree extends Fragment implements OnClickListener {


	@Override
	public View onCreateView(LayoutInflater inflater,
	 ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_three,container,false);
		Button mButton = (Button) view.findViewById(R.id.bt);
		mButton.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
	}


}
