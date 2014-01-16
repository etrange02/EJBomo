package session;

import java.util.ArrayList;

import javax.ejb.Local;

import entity.ContactGroup;

@Local
public interface IDAOContactGroupLocal {
	public ArrayList<ContactGroup> getGroups();
}
