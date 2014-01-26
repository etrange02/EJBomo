package session;

import java.util.ArrayList;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import entity.Contact;

@Remote
@WebService(targetNamespace="http://session/Contact", name="Contact")
public interface IDAOContactRemote {

	public abstract void createContact(Contact contact);

	public abstract void updateContact(Contact contact);

	public abstract void removeContact(int id);

	@WebMethod(action="urn:getAllContacts", operationName="getAll")
	public abstract @WebResult(name="Resultat")
		ArrayList<Contact> getAllContacts();

	/// From type request
	/// Search with member name
	public abstract ArrayList<Contact> searchContactByName(String criteria);

	/// Criteria type
	/// Simple type
	public abstract ArrayList<Contact> searchContactByPhone(String phone);

	@WebMethod(action="urn:searchContact", operationName="searchContact")
	public abstract @WebResult(name="Resultat")
	Contact searchContact(@WebParam(name="id") int id);

	@WebMethod(action="urn:getFriendname", operationName="getFriendName")
	public @WebResult(name="HisName")
	String getFriendName(@WebParam(name="id") int id);
}