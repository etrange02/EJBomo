package session;

import java.util.ArrayList;

import javax.ejb.Local;

import entity.Contact;
import entity.ContactGroup;
import entity.PhoneNumber;

@Local
public interface IDAOContactLocal {
	public void createContact(String firstname, String lastname, String email, String city, String country, String street, String zip, ArrayList<PhoneNumber> phoneList, ArrayList<ContactGroup> cgList);
	public void modifyContact(int id, String firstname, String lastname, String email);
	public void removeContact(int id);
	public Contact searchContact(String criteria);
}
