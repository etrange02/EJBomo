package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class PhoneNumber implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String phoneKind;
	private String phoneNumber;
	@Version
	private int version;
	private Contact contact;
	

	public PhoneNumber() {
	}
	
	@ManyToOne
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPhoneKind() {
		return phoneKind;
	}
	
	public void setPhoneKind(String phoneKind) {
		this.phoneKind = phoneKind;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
