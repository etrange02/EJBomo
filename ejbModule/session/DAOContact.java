package session;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.*;

public class DAOContact {

	public void createContact(String firstname, String lastname, String email, String city, String country, String street, String zip, ArrayList<PhoneNumber> phoneList, ArrayList<ContactGroup> cgList) {
		Session session = null;
		Contact c = new Contact();
		c.setFirstname(firstname);
		c.setLastname(lastname);
		c.setEmail(email);

		Address a = new Address();
		a.setCity(city);
		a.setCountry(country);
		a.setStreet(street);
		a.setZip(zip);
		
		c.setAddress(a);
		
		c.setPhones(phoneList);
		for(PhoneNumber ph : phoneList){
			ph.setContact(c);
		}
		
		c.setBooks(cgList);
		
		try{
			session = null;// HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			System.out.println(session.save(a));
			for(PhoneNumber ph : phoneList){
				System.out.println(session.save(ph));
			}
			for(ContactGroup cg : cgList){
				System.out.println(session.save(cg));
			}
			System.out.println(session.save(c));
			tx.commit();
			session.close();
		} catch(Exception e){
			System.err.println("ERREUR DETECTE");
			System.out.println(e.getMessage());
		}
	}

	/*public void modifyContact(int id, String firstname, String lastname, String email) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Contact c = (Contact) session.load(Contact.class, id);
			System.out.println(c.getId());
			c.setFirstname(firstname);
			c.setLastname(lastname);
			c.setEmail(email);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public void removeContact(int id) {
		Session session = null;
		try {
			session = null; //HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Contact c = (Contact) session.load(Contact.class, id);
			System.out.println(c.getId());
			session.delete(c);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Contact searchContact(String criteria) {
		Session session = null;
		Contact contact = null;
		try {
			session = null; //HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			
			StringBuffer sb = new StringBuffer();
			sb.append("from Contact as c where c.id = ?");
			List<Contact> liste = session.createQuery(sb.toString()).setInteger(0, Integer.parseInt(criteria)).list();
			
			contact = (Contact) (liste.isEmpty() ? null : liste.get(0));
			
			if (contact != null)
				System.out.println(contact.getId());
			else
				System.out.println("Not Found");
			
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contact;
	}
}
