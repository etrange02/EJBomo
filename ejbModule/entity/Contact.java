package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;
	private String firstname;
	private String lastname;
	private String email;
	private Integer id;
	@Version
	private int version;
	private List<ContactGroup> books;
	private List<PhoneNumber> phones;
	private Address address;

	public Contact(){
		this.firstname="";
		this.lastname="";
		this.email="";
		this.id=-1;
		this.address = null;
		this.books = new ArrayList<ContactGroup>();
		this.phones = new ArrayList<PhoneNumber>();
	}

	@ManyToMany(cascade={CascadeType.MERGE})
	public List<ContactGroup> getBooks() {
		return books;
	}

	public void setBooks(List<ContactGroup> books) {
		this.books = books;
	}
	
	@OneToMany(mappedBy="contact", cascade={CascadeType.MERGE})
	public List<PhoneNumber> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneNumber> phones) {
		this.phones = phones;
	}

	@ManyToOne(cascade={CascadeType.MERGE})
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
