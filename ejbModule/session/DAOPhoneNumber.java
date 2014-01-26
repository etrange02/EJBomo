package session;

import java.util.ArrayList;

import javassist.NotFoundException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import entity.Contact;
import entity.PhoneNumber;

@Stateless(mappedName="DAOPhoneNumberBean")
public class DAOPhoneNumber implements IDAOPhoneNumberRemote, IDAOPhoneNumberLocal {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void create(PhoneNumber phoneNumber) {
		em.persist(phoneNumber);
	}

	@Override
	public void update(PhoneNumber phoneNumber) {
		em.merge(phoneNumber);
	}

	@Override
	public void remove(PhoneNumber phoneNumber) {
		em.remove(em.find(PhoneNumber.class, phoneNumber.getId()));
	}

	@Override
	public PhoneNumber searchById(int id) {
		return em.find(PhoneNumber.class, id);
	}

	@Override
	public PhoneNumber searchByName(String criteria) {
		try {
			return  (PhoneNumber) em.createQuery("FROM PhoneNumber as pn where pn.kind = ?")
				.setParameter(1, criteria)
				.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

}
