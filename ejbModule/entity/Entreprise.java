package entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Entreprise extends Contact {
	private static final long serialVersionUID = 1L;
	private int numSiret;

	public int getNumSiret() {
		return numSiret;
	}

	public void setNumSiret(int numSiret) {
		this.numSiret = numSiret;
	}
}
