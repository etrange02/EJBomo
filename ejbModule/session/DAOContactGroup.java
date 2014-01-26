package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

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
			return (ContactGroup) em.createQuery("FROM ContactGroup as cg WHERE groupName = ?")
					.setParameter(1, criteria)
					.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
//		return (ContactGroup) this.getHibernateTemplate().execute(new HibernateCallback<ContactGroup>() {
//			@Override
//			public ContactGroup doInHibernate(Session session) throws HibernateException, SQLException {
//				ArrayList<ContactGroup> contactGroups =
//						(ArrayList<ContactGroup>) session.createCriteria(ContactGroup.class)
//						.add(Restrictions.ilike("groupName", criteria)).list();
//				
//				if (contactGroups.isEmpty()) {
//					return null;
//				}
//					
//				ContactGroup contactGroup = contactGroups.get(0);
//				Iterator<Contact> it = contactGroup.getContacts().iterator();
//				while(it.hasNext()) {
//					Contact c = it.next();
//					if (c != null) {
//						Iterator<ContactGroup> iter = c.getBooks().iterator();
//						while (iter.hasNext())
//							iter.next().getGroupId();
//					}
//				}			
//				return contactGroup;
//			}
//		});
	}
	
	public ContactGroup searchById(final int id)
	{
		return em.find(ContactGroup.class, id);
	}
}
