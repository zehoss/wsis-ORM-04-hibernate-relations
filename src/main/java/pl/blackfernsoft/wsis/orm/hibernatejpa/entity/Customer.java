package pl.blackfernsoft.wsis.orm.hibernatejpa.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq_gen")
    @SequenceGenerator(name = "customer_seq_gen", sequenceName = "CUSTOMER_SEQ", initialValue = 1000, allocationSize = 10)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT",
            unique = false,
            nullable = false,
            insertable = true,
            updatable = false
    )
    private Date creationDate = new Date();

    @Transient
    private BigDecimal currentDept;

    @Embedded
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public BigDecimal getCurrentDept() {
        return currentDept;
    }

    public void setCurrentDept(BigDecimal currentDept) {
        this.currentDept = currentDept;
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
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", creationDate=" + creationDate +
                ", currentDept=" + currentDept +
                ", address=" + address +
                '}';
    }
}
