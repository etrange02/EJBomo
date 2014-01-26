package session;

import java.util.ArrayList;

import javax.ejb.Remote;

import entity.Contact;
import entity.ContactGroup;

@Remote
public interface IDAOContactRemote {

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

	public abstract Contact searchContact(int id);

}