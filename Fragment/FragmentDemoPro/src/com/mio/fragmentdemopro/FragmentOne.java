package com.mio.fragmentdemopro;

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
	
	/**
	 * 暴漏按钮作用的接口,复用性高,耦合性低
	 * @author mio
	 *
	 */
	public interface OneFragmentClickListener{
		void oneFragmentClick();
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
	 ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_one,container,false);
		Button mButton = (Button) view.findViewById(R.id.bt);
		mButton.setOnClickListener(this);
		return view;
	}

	/**
	 * 只要是实现了此接口的,点击事件会自动调用oneFragmentClick方法.
	 */
	@Override
	public void onClick(View v) {

		if(getActivity() instanceof OneFragmentClickListener){
			((OneFragmentClickListener) getActivity()).oneFragmentClick();
		}
	}




}
