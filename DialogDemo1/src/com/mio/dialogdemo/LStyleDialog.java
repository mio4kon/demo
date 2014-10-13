package com.mio.dialogdemo;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LStyleDialog {

	private Context mContext;
	private LStyleDialog.Builder mBuilder;
	private boolean mHasShow = false;
	private AlertDialog mAlertDialog;
	private int mTitleResId;
	private CharSequence mTitle;
	private int mMessageResId;
	private CharSequence mMessage;
	private Button mPositiveButton;
	private LinearLayout.LayoutParams mLayoutParams;
	private Button mNegativeButton;
	private Drawable mBackgroundDrawable;
	private int mBackgroundResId;

	public LStyleDialog(Context context) {
		this.mContext = context;
	}

	/** 显示dialog */
	public void show() {
		if (mHasShow == false)
			mBuilder = new Builder();
		else
			mAlertDialog.show();
		mHasShow = true;
	}

	public void dismiss() {
		mAlertDialog.dismiss();
	}

	private int dip2px(float dpValue) {
		final float scale = mContext.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	public LStyleDialog setTitle(int resId) {
		mTitleResId = resId;
		if (mBuilder != null)
			mBuilder.setTitle(resId);
		return this;
	}

	public LStyleDialog setTitle(CharSequence title) {
		mTitle = title;
		if (mBuilder != null) {
			mBuilder.setTitle(title);
		}
		return this;
	}

	public LStyleDialog setMessage(int resId) {
		mMessageResId = resId;
		if (mBuilder != null)
			mBuilder.setMessage(resId);
		return this;
	}

	public LStyleDialog setMessage(CharSequence message) {
		mMessage = message;
		if (mBuilder != null)
			mBuilder.setMessage(message);
		return this;
	}

	public LStyleDialog setBackground(Drawable drawable) {
		mBackgroundDrawable = drawable;
		if (mBuilder != null) {
			mBuilder.setBackground(mBackgroundDrawable);
		}
		return this;
	}

	public LStyleDialog setBackgroundResource(int resId) {
		mBackgroundResId = resId;
		if (mBuilder != null) {
			mBuilder.setBackgroundResource(mBackgroundResId);
		}
		return this;
	}

	public LStyleDialog setPositiveButton(String text,
			final View.OnClickListener listener) {
		mPositiveButton = new Button(mContext);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		mPositiveButton.setLayoutParams(params);
		mPositiveButton.setBackgroundResource(R.drawable.material_card_nos);
		mPositiveButton.setTextColor(Color.argb(255, 35, 159, 242));
		mPositiveButton.setText(text);
		mPositiveButton.setGravity(Gravity.CENTER);
		mPositiveButton.setTextSize(14);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(dip2px(2), 0, dip2px(16), dip2px(12));
		mPositiveButton.setLayoutParams(layoutParams);
		mPositiveButton.setOnClickListener(listener);
		return this;
	}

	/**
	 * set negative button
	 * 
	 * @param text
	 *            the name of button
	 * @param listener
	 */
	public LStyleDialog setNegativeButton(String text,
			final View.OnClickListener listener) {
		mNegativeButton = new Button(mContext);
		mLayoutParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		mNegativeButton.setLayoutParams(mLayoutParams);
		mNegativeButton.setBackgroundResource(R.drawable.material_card_nos);
		mNegativeButton.setText(text);
		mNegativeButton.setTextColor(Color.argb(222, 0, 0, 0));
		mNegativeButton.setTextSize(14);
		mNegativeButton.setGravity(Gravity.CENTER);
		mNegativeButton.setOnClickListener(listener);
		return this;
	}

	private class Builder {
		private TextView mTitleView;
		private TextView mMessageView;
		private Window mAlertDialogWindow;
		private LinearLayout mButtonLayout;

		private Builder() {
			mAlertDialog = new AlertDialog.Builder(mContext).create();
			mAlertDialog.show();
			mAlertDialogWindow = mAlertDialog.getWindow();
			mAlertDialogWindow.setContentView(R.layout.layout_materialdialog); // 设置dialog布局
			mTitleView = (TextView) mAlertDialogWindow.findViewById(R.id.title); // 标题
			mMessageView = (TextView) mAlertDialogWindow
					.findViewById(R.id.message);// 内容
			mButtonLayout = (LinearLayout) mAlertDialogWindow
					.findViewById(R.id.buttonLayout);

			if (mTitleResId != 0) {
				setTitle(mTitleResId);
			}
			if (mTitle != null) {
				setTitle(mTitle);
			}
			if (mMessageResId != 0) {
				setMessage(mMessageResId);
			}
			if (mMessage != null) {
				setMessage(mMessage);
			}
			if (mPositiveButton != null) {
				mButtonLayout.addView(mPositiveButton);
			}
			if (mLayoutParams != null && mNegativeButton != null) {
				if (mButtonLayout.getChildCount() > 0) {
					mLayoutParams.setMargins(dip2px(12), 0, 0, dip2px(12));
					mNegativeButton.setLayoutParams(mLayoutParams);
					mButtonLayout.addView(mNegativeButton, 1);
				} else {
					mNegativeButton.setLayoutParams(mLayoutParams);
					mButtonLayout.addView(mNegativeButton);
				}
			}
			if (mBackgroundResId != 0) {
				LinearLayout linearLayout = (LinearLayout) mAlertDialogWindow
						.findViewById(R.id.material_background);
				linearLayout.setBackgroundResource(mBackgroundResId);
			}
			if (mBackgroundDrawable != null) {
				LinearLayout linearLayout = (LinearLayout) mAlertDialogWindow
						.findViewById(R.id.material_background);
				linearLayout.setBackground(mBackgroundDrawable);
			}

		}

		public void setTitle(int resId) {
			mTitleView.setText(resId);
		}

		public void setTitle(CharSequence title) {
			mTitleView.setText(title);
		}

		public void setMessage(int resId) {
			mMessageView.setText(resId);
		}

		public void setMessage(CharSequence message) {
			mMessageView.setText(message);
		}

		public void setBackground(Drawable drawable) {
			LinearLayout linearLayout = (LinearLayout) mAlertDialogWindow
					.findViewById(R.id.material_background);
			linearLayout.setBackground(drawable);
		}

		public void setBackgroundResource(int resId) {
			LinearLayout linearLayout = (LinearLayout) mAlertDialogWindow
					.findViewById(R.id.material_background);
			linearLayout.setBackgroundResource(resId);
		}
	}
}
