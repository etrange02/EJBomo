package session;

import java.util.ArrayList;

import javax.ejb.Stateless;

import entity.ContactGroup;

@Stateless(mappedName="DAOContactGroupBean")
public class DAOContactGroup implements IDAOContactGroupLocal{

	
	public void createContactGroup(final ContactGroup contactGroup) {
		
	}
	
	public void updateContactGroup(final ContactGroup contactGroup) {
		
	}
	
	public ContactGroup searchContactGroup(final String criteria) {
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
		return null;
	}
}
