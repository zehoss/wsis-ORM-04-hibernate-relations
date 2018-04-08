package pl.blackfernsoft.wsis.orm.hibernatejpa.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Customer {

//    @EmbeddedId
//    private CustomerPK primaryKey;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private Date creationDate = new Date();

    @Embedded
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CUSTOMER_CAR",
            joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
            inverseJoinColumns = @JoinColumn(name = "CAR_ID"))
    private List<Car> cars = new ArrayList<>();

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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", address=" + address +
                ", cars=" + (cars != null ? cars.size() : "null") +
                '}';
    }
}
