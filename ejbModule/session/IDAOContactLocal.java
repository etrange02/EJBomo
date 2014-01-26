package session;

import java.util.ArrayList;

import javax.ejb.Local;

import entity.Contact;

@Local
public interface IDAOContactLocal {

	public abstract void createContact(Contact contact);

	public abstract void updateContact(Contact contact);

	public abstract void removeContact(int id);

	public abstract ArrayList<Contact> getAllContacts();

	/// From type request
	/// Search with member name
	public abstract ArrayList<Contact> searchContactByName(String criteria);

	/// Criteria type
	/// Simple type
	public abstract ArrayList<Contact> searchContactByPhone(String phone);

	public abstract Contact searchContact(int id);
}
