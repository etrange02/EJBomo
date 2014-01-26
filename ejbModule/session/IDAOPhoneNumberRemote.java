package session;

import javax.ejb.Remote;

import entity.PhoneNumber;

@Remote
public interface IDAOPhoneNumberRemote {
	public void create(final PhoneNumber phoneNumber);
	public void update(final PhoneNumber phoneNumber);
	public void remove(final PhoneNumber phoneNumber);
	public PhoneNumber searchByName(final String criteria);
	public PhoneNumber searchById(final int id);
}
