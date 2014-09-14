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
import android.widget.Toast;

public class FragmentTwo extends Fragment implements OnClickListener {
	
	private TwoFragmentClickListener mTwoFragmentClickListener;
	/**
	 * 接口
	 * @author mio
	 *
	 */
	public interface TwoFragmentClickListener{
		void twoFragmentClick();
	}
	/**
	 * 设置这个接口
	 * @param twoFragmentClickListener
	 */
	public void setTwoFragmentListener(TwoFragmentClickListener twoFragmentClickListener){
		mTwoFragmentClickListener=twoFragmentClickListener;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_two, container, false);
		Button mButton = (Button) view.findViewById(R.id.bt);
		mButton.setOnClickListener(this);
		return view;
	}

	/**
	 * 只有设置了这个接口,才能保证不为null,也就才能调用方法
	 */
	@Override
	public void onClick(View v) {
		if(mTwoFragmentClickListener!=null){
			mTwoFragmentClickListener.twoFragmentClick();
		}
		Toast.makeText(getActivity(), "你没有设置回调接口哟", 0).show();
	}


}
