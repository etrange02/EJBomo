package session;

import java.util.ArrayList;

import javax.ejb.Local;

import entity.Contact;
import entity.ContactGroup;

@Local
public interface IDAOContactLocal {

	public abstract void createContact(Contact contact);

	public abstract void updateContact(Contact contact);

	public abstract void removeContact(int id);

	public abstract ArrayList<Contact> GetAllContacts();

	/// From type request
	/// Search with member name
	public abstract ArrayList<Contact> searchContactByName(String criteria);

	/// Criteria type
	/// Simple type
	public abstract ArrayList<Contact> searchContactByPhone(String phone);

	/// Example type request
	public abstract ArrayList<ContactGroup> searchGroupByName(String criteria);

	public abstract Contact searchContact(int id);

}