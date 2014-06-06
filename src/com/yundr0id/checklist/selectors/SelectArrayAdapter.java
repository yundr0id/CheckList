package com.yundr0id.checklist.selectors;

import java.util.List;

import com.yundr0id.checklist.R;
import com.yundr0id.checklist.person.Person;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class SelectArrayAdapter extends ArrayAdapter<Person>{

	private LayoutInflater inflater;
	
	public SelectArrayAdapter(Context context, List<Person> persons) {
		super(context, R.layout.simplerow, R.id.rowTextView, persons);
		
		inflater = LayoutInflater.from(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Person p = (Person) this.getItem(position);
		
		CheckBox checkBox;
		TextView textView;
		
		if(convertView == null){
			convertView = inflater.inflate(R.layout.simplerow, null);
			
			textView = (TextView)convertView.findViewById(R.id.rowTextView);
			checkBox = (CheckBox)convertView.findViewById(R.id.CheckBox01);
			
			convertView.setTag(new SelectViewHolder(checkBox, textView));
			
			checkBox.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					CheckBox cb = (CheckBox) v;
					Person p = (Person) cb.getTag();
					p.setChecked(cb.isChecked());
				}
			});
		} else{
			SelectViewHolder viewHolder = (SelectViewHolder)convertView.getTag();
			checkBox = viewHolder.getCheckBox();
			textView = viewHolder.getTextView();
		}
		
		checkBox.setTag(p);
		checkBox.setChecked(p.isChecked());
		textView.setText(p.getFullName());
		
		return convertView;
				
	}
	
	

}
