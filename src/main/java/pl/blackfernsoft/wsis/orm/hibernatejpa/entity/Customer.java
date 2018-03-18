package pl.blackfernsoft.wsis.orm.hibernatejpa.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Customer {

    @EmbeddedId
    private CustomerPK primaryKey;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private Date creationDate = new Date();

    @Embedded
    private Address address;

    public CustomerPK getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(CustomerPK primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "primaryKey=" + primaryKey +
                ", creationDate=" + creationDate +
                ", address=" + address +
                '}';
    }
}
