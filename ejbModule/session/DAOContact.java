package session;

import java.util.ArrayList;
import java.util.Iterator;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import entity.Contact;
import entity.ContactGroup;
import entity.PhoneNumber;


@Stateless(mappedName="DAOContactBean")
@WebService(endpointInterface="session.IDAOContactRemote")
public class DAOContact implements IDAOContactRemote, IDAOContactLocal {

	@PersistenceContext
	EntityManager em;
	
	public void createContact(final Contact contact) {
		em.persist(contact.getAddress());
		Iterator<ContactGroup> iter = contact.getBooks().iterator();
		while (iter.hasNext())
			em.persist(iter.next());
		Iterator<PhoneNumber> iter2 = contact.getPhones().iterator();
		while (iter2.hasNext())
			em.persist(iter2.next());
		em.persist(contact);
	}

	public void updateContact(final Contact contact) {
		em.merge(contact);
	}

	public void removeContact(final int id) {
		em.remove(em.find(Contact.class, id));
	}
	
	public ArrayList<Contact> getAllContacts() {
		return (ArrayList<Contact>) em.createQuery("select object(c) from Contact as c").getResultList();
	}

	/// From type request
	/// Search with member name
	public ArrayList<Contact> searchContactByName(final String criteria) {
		return (ArrayList<Contact>) em.createQuery("from Contact as c where c.firstname = ? or c.lastname = ?")
				.setParameter(1, criteria)
				.setParameter(2, criteria)
				.getResultList();
	}
	
	/// Criteria type
	/// Simple type
	public ArrayList<Contact> searchContactByPhone(final String phone) {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		try {
			ArrayList<PhoneNumber> list = (ArrayList<PhoneNumber>) em.createQuery("from PhoneNumber as pn where pn.phoneNumber = ?")
				.setParameter(1, phone)
				.getResultList();
			
			Iterator<PhoneNumber> iter = list.iterator();
			while (iter.hasNext()) {
				PhoneNumber pn = iter.next();
				contacts.add(pn.getContact());
			}
		} catch (NoResultException nre) {
			return new ArrayList<Contact>();
		}
		
		return contacts;
	}

	public Contact searchContact(final int id) {
		Contact c = em.find(Contact.class, id);
		if (c == null)
			return null;
		c.getAddress().getStreet();
		for (ContactGroup cg: c.getBooks())
			cg.getGroupName();
		for (PhoneNumber pn: c.getPhones())
			pn.getPhoneKind();
		
		return c;
	}


	public String getFriendName(final int id) {
		try {
			return em.find(Contact.class, id).getFirstname();
		} catch (NoResultException nre) {
			return "";
		}
	}
}

