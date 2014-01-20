package session;

import javax.ejb.Remote;

import entity.ContactGroup;

@Remote
public interface IDAOContactGroupLocal {
	public void createContactGroup(final ContactGroup contactGroup);
	public void updateContactGroup(final ContactGroup contactGroup);
	public ContactGroup searchContactGroup(final String criteria);
}
