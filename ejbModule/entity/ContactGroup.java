package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

@Entity
public class ContactGroup implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer groupId;
	private String groupName;
	@Version
	private int version;
	private List<Contact> contacts;

	public ContactGroup(){
		this.contacts = new ArrayList<Contact>();
	}
	
	@ManyToMany(mappedBy="books")
	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
}
