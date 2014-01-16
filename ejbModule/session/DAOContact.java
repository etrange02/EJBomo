package session;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Contact;
import entity.ContactGroup;


@Stateless(mappedName="DAOContactBean")
public class DAOContact implements IDAOContactLocal {

	@PersistenceContext
	EntityManager em;
	

	/* (non-Javadoc)
	 * @see session.IDAOContactLocal_#createContact(entity.Contact)
	 */
	public void createContact(final Contact contact) {

	}
	
	/* (non-Javadoc)
	 * @see session.IDAOContactLocal_#updateContact(entity.Contact)
	 */
	public void updateContact(final Contact contact) {

	}

	/* (non-Javadoc)
	 * @see session.IDAOContactLocal_#removeContact(int)
	 */
	public void removeContact(final int id) {
		

	}
	
	/* (non-Javadoc)
	 * @see session.IDAOContactLocal_#GetAllContacts()
	 */
	public ArrayList<Contact> GetAllContacts() {
		return null;
	}

	/// From type request
	/// Search with member name
	/* (non-Javadoc)
	 * @see session.IDAOContactLocal_#searchContactByName(java.lang.String)
	 */
	public ArrayList<Contact> searchContactByName(final String criteria) {
//		return (ArrayList<Contact>) getHibernateTemplate().executeFind(new HibernateCallback<ArrayList<Contact>>() {
//			@Override
//			public ArrayList<Contact> doInHibernate(Session session) throws HibernateException, SQLException {
//				Query query = session.createQuery("from Contact as c where c.firstname = ? or c.lastname = ?");
//				query.setString(0, criteria);
//				query.setString(1, criteria);
//				return (ArrayList<Contact>) query.list();
//			}
//		});
		return null;
	}
	
	/// Criteria type
	/// Simple type
	/* (non-Javadoc)
	 * @see session.IDAOContactLocal_#searchContactByPhone(java.lang.String)
	 */
	public ArrayList<Contact> searchContactByPhone(final String phone) {
//		return (ArrayList<Contact>) this.getHibernateTemplate().executeFind(new HibernateCallback<ArrayList<Contact>>() {
//			@Override
//			public ArrayList<Contact> doInHibernate(Session session) throws HibernateException, SQLException {
//				return (ArrayList<Contact>) session.createCriteria(Contact.class).createCriteria("phones")
//					.add(Restrictions.ilike("phoneNumber", phone))
//					.list();
//			}
//		});
		return null;
	}
	
	/// Example type request
	/* (non-Javadoc)
	 * @see session.IDAOContactLocal_#searchGroupByName(java.lang.String)
	 */
	public ArrayList<ContactGroup> searchGroupByName(final String criteria) {
//		return (ArrayList<ContactGroup>) this.getHibernateTemplate().executeFind(new HibernateCallback<ArrayList<ContactGroup>>() {
//			@Override
//			public ArrayList<ContactGroup> doInHibernate(Session session) throws HibernateException, SQLException {				
//				ContactGroup contactGroup = new ContactGroup();
//				contactGroup.setGroupName(criteria);
//				ArrayList<ContactGroup> groups = 
//						(ArrayList<ContactGroup>) session.createCriteria(ContactGroup.class)
//						.add(Example.create(contactGroup).excludeProperty("groupId").excludeProperty("contacts").excludeProperty("version").ignoreCase().enableLike())
//						.list();
//				if (groups != null) {
//					Iterator<ContactGroup> iter = groups.iterator();
//					while (iter.hasNext()) {
//						Iterator<Contact> it = iter.next().getContacts().iterator();
//						while (it.hasNext())
//							it.next().getFirstname();
//					}
//				}
//				return groups;
//			}
//		});
		return null;
	}
	
	/* (non-Javadoc)
	 * @see session.IDAOContactLocal_#searchContact(int)
	 */
	public Contact searchContact(final int id) {
//		return (Contact) this.getHibernateTemplate().execute(new HibernateCallback<Contact>() {
//			@Override
//			public Contact doInHibernate(Session session) throws HibernateException, SQLException {
//				ArrayList<Contact> contacts = (ArrayList<Contact>) session.createCriteria(Contact.class)
//						.add(Restrictions.eq("id", id)).list();
//				Contact contact = (Contact) (contacts.isEmpty() ? null : contacts.get(0));
//				
//				if (contact != null) {
//					contact.getAddress().getStreet();
//					for (ContactGroup cg: contact.getBooks())
//						cg.getGroupName();
//					for (PhoneNumber pn: contact.getPhones())
//						pn.getPhoneKind();
//					return contact;
//				}
//				return null;
//			}
//		});
		return null;
	}
}

