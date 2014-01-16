package session;

import java.util.ArrayList;

import entity.ContactGroup;

public class DAOContactGroup {

	public ArrayList<ContactGroup> getGroups() {
		ArrayList<ContactGroup> cgList = new ArrayList<ContactGroup>();
		ContactGroup cg = new ContactGroup();
		cg.setGroupName("Bob");
		cgList.add(cg);
		return cgList;
	}

}
