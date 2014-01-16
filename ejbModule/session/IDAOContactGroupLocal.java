package session;

import javax.ejb.Local;

import entity.ContactGroup;

@Local
public interface IDAOContactGroupLocal {
	public void createContactGroup(final ContactGroup contactGroup);
	public void updateContactGroup(final ContactGroup contactGroup);
	public ContactGroup searchContactGroup(final String criteria);
}
