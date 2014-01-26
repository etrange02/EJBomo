package session;

import java.util.ArrayList;
import java.util.Iterator;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import entity.Contact;
import entity.ContactGroup;

@Stateless(mappedName="DAOContactGroupBean")
public class DAOContactGroup implements IDAOContactGroupRemote, IDAOContactGroupLocal {

	@PersistenceContext
	EntityManager em;
	
	public void createContactGroup(final ContactGroup contactGroup) {
		em.persist(contactGroup);
	}
	
	public void updateContactGroup(final ContactGroup contactGroup) {
		em.merge(contactGroup);
	}
	
	public ContactGroup searchContactGroup(final String criteria) {
		try {
			ArrayList<ContactGroup> contactGroups = (ArrayList<ContactGroup>) em.createQuery("FROM ContactGroup as cg WHERE groupName = ?")
					.setParameter(1, criteria)
					.getResultList();
			if (contactGroups.isEmpty()) {
				return null;
			}
			ContactGroup contactGroup = contactGroups.get(0);
			Iterator<Contact> it = contactGroup.getContacts().iterator();
			while(it.hasNext()) {
				Contact c = it.next();
				if (c != null) {
					Iterator<ContactGroup> iter = c.getBooks().iterator();
					while (iter.hasNext())
						iter.next().getGroupId();
				}
			}			
			return contactGroup;
		} catch (NoResultException nre) {
			return null;
		}
	}
	
	public ContactGroup searchById(final int id)
	{
		return em.find(ContactGroup.class, id);
	}
}
