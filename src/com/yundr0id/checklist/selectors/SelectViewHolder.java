package com.yundr0id.checklist.selectors;

import android.widget.CheckBox;
import android.widget.TextView;

public class SelectViewHolder {

	private CheckBox checkBox;
	private TextView textView;
	
	public SelectViewHolder() {
	
	}
	
	public SelectViewHolder(CheckBox checkBox, TextView textView){
		this.setCheckBox(checkBox);
		this.setTextView(textView);
	}

	public CheckBox getCheckBox() {
		return checkBox;
	}

	public void setCheckBox(CheckBox checkBox) {
		this.checkBox = checkBox;
	}

	public TextView getTextView() {
		return textView;
	}

	public void setTextView(TextView textView) {
		this.textView = textView;
	}
}
