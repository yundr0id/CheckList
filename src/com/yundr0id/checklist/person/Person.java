package com.yundr0id.checklist.person;

public class Person {

	private String name;
	private String surname;
	
	private boolean checked = false;
	
	public Person(){
		
	}
	
	public Person(String name, String surname){
		this.name = name;
		this.surname = surname;
		
	}
	public Person(String name, String surname, boolean checked){
		this.setName(name);
		this.setSurname(surname);
		this.setChecked(checked);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getFullName(){
		return name + " " + surname;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	public void toggleChecked(){
		checked = !checked;
	}
}
