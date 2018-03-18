package pl.blackfernsoft.wsis.orm.hibernatejpa.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CustomerPK implements Serializable {


    private String firstName;
    private String lastName;
    private String PESEL;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    @Override
    public String toString() {
        return "CustomerPK{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", PESEL='" + PESEL + '\'' +
                '}';
    }
}
