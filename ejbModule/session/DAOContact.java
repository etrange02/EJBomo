package session;

import java.util.ArrayList;
import java.util.Iterator;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Contact;
import entity.ContactGroup;
import entity.PhoneNumber;


@Stateless(mappedName="DAOContactBean")
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
	
	public ArrayList<Contact> GetAllContacts() {
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
		return new ArrayList<Contact>();
		/*return (ArrayList<Contact>) em.createQuery("from Contact as c where (from PhoneNumber as p where p.phoneNumber = ? ) in c.phones")
				.setParameter(1, phone)
				.getResultList();*/
//		return (ArrayList<Contact>) this.getHibernateTemplate().executeFind(new HibernateCallback<ArrayList<Contact>>() {
//			@Override
//			public ArrayList<Contact> doInHibernate(Session session) throws HibernateException, SQLException {
//				return (ArrayList<Contact>) session.createCriteria(Contact.class).createCriteria("phones")
//					.add(Restrictions.ilike("phoneNumber", phone))
//					.list();
//			}
//		});
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
}

