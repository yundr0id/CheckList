package com.yundr0id.checklist;

import java.util.ArrayList;

import com.yundr0id.checklist.person.Person;
import com.yundr0id.checklist.selectors.SelectArrayAdapter;
import com.yundr0id.checklist.selectors.SelectViewHolder;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView listView;
	private Person[] persons;
	private ArrayAdapter<Person> adapter;
	ArrayList<String> checked = new ArrayList<String>();
	
	private Button btnSave;
	
	CalendarView calendarView;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		listView = (ListView)findViewById(R.id.mainListView);
		
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Person p = adapter.getItem(position);
				p.toggleChecked();
				
				SelectViewHolder viewHolder = (SelectViewHolder) view.getTag();
				viewHolder.getCheckBox().setChecked(p.isChecked());
			}
		});
		
		listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				return false;
			}
		});
		
		persons = (Person[])getLastNonConfigurationInstance();
		
		ArrayList<Person> personsList = new ArrayList<Person>();
		
		personsList.add(new Person("Yunus", "BAYCAN"));
		personsList.add(new Person("Faruk", "ERO�LU"));
		personsList.add(new Person("H�seyin", "AYDIN"));
		personsList.add(new Person("�smail", "ARSLAN"));
		personsList.add(new Person("Kadir", "G�M��"));
		personsList.add(new Person("Niyazi", "�ZSOY"));
		personsList.add(new Person("Resul", "AKBABA"));
		personsList.add(new Person("Ra�it", "AYDIN"));
		personsList.add(new Person("Sinan", "YAZICI"));
		personsList.add(new Person("U�ur", "O�UZHAN"));
		personsList.add(new Person("Yusuf", "BA�KUTLU"));
		personsList.add(new Person("Zeki", "��FT��"));
		
		
		adapter = new SelectArrayAdapter(this, personsList);
		listView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public Object onRetainNonConfigurationInstance() {
		return persons;
	}

}
