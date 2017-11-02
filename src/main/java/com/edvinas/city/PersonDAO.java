package com.edvinas.city;

import java.util.List;


public interface PersonDAO {
	public List<Person> getAll();
	public void editPerson(int id);
    public void deletePerson(int id);

	public Person getPerson(int id);

	public void updatePerson(Person person);

	public void createPerson(Person person);
	public List<Person> getPersonsInStreet(String street);
	
}
