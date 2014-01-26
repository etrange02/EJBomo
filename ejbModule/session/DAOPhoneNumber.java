package session;

import javax.ejb.Stateless;

@Stateless(mappedName="DAOPhoneNumberBean")
public class DAOPhoneNumber implements IDAOPhoneNumberRemote, IDAOPhoneNumberLocal {

}
