package session;

import java.util.ArrayList;

import javax.ejb.Stateless;

import entity.ContactGroup;

@Stateless(mappedName="DAOContactGroup")
public class DAOContactGroup implements IDAOContactGroupLocal{

	public ArrayList<ContactGroup> getGroups() {
		ArrayList<ContactGroup> cgList = new ArrayList<ContactGroup>();
		ContactGroup cg = new ContactGroup();
		cg.setGroupName("Bob");
		cgList.add(cg);
		return cgList;
	}

}
