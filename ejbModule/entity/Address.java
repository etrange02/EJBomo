package entity;

public class Address {
	
	private int id;
	private String street;
	private String city;
	private String zip;
	private String country;
	private int version;
	
	public Address() {
		this("", "", "", "");
	}
	
	public Address(String street, String city, String zip, String country) {
		this.id = -1;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}