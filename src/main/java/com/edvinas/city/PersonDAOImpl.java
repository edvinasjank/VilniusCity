package com.edvinas.city;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edvinas.city.Person;
@Repository
public class PersonDAOImpl implements PersonDAO{
	
	@Autowired
    private SessionFactory sessionFactory;
	public List<Person> getAll(){
		Session session;
		try {
            session = this.sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
		List<Person> personsList = (List<Person>) session.createQuery("from PEOPLE").list();
        
		return personsList;
	}
	public List<Person> getPersonsInStreet(String street){
		Session session;
		Criteria cr;
		try {
            session = this.sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
		cr = session.createCriteria(Person.class);
		cr.add(Restrictions.ilike("street", street+'%'));
		List<Person> personsList = (List<Person>) cr.list();
        
		return personsList;
	}
	
	public Person getPerson(int id){
		Session session;
		try {
            session = this.sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
		Person person = (Person) session.get(Person.class, id);
		
		return person;
	}
	public void editPerson(int id) {
        Session session;
        try {
            session = this.sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Person person = session.load(Person.class, id);
        if (person != null) {
            Transaction tx = session.beginTransaction();
            session.update(person);
            tx.commit();
        }
    }
	
	public void deletePerson(int id) {
        Session session;
        try {
            session = this.sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Person person = session.load(Person.class, id);
        if (person != null) {
            Transaction tx = session.beginTransaction();
            session.delete(person);
            tx.commit();
        }
    }
	public void updatePerson(Person person) {
		Session session;
        try {
            session = this.sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Transaction tx = session.beginTransaction();
        session.update(person);
        tx.commit();
	}
	public void createPerson(Person person){
		Session session;
        try {
            session = this.sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Transaction tx = session.beginTransaction();
        session.save(person);
        tx.commit();
	}
}
