package pl.blackfernsoft.wsis.orm.hibernatejpa.entity;

import pl.blackfernsoft.wsis.orm.hibernatejpa.enums.CarType;

import javax.persistence.*;
import java.util.*;

@Entity
// Can't set @Table if inheritance strategy is SINGLE_TABLE
@NamedQueries({
        @NamedQuery(
                name = "Car.findIfExpiredReview",
                query = "from Vehicle c where c.firstRegistrationDate <= :firstRegistrationDate ")
})
public class Car extends Vehicle {

    private Integer numberOfSeats;

    @Enumerated(EnumType.ORDINAL)
    private CarType carType;

    @ElementCollection
    @CollectionTable(name = "RENTAL_ADDRESS", joinColumns = @JoinColumn(name = "CAR_ID"))
    private List<Address> rentalAddress = new ArrayList<Address>();

    @ElementCollection
    @CollectionTable(name = "RENTAL_DATES", joinColumns = @JoinColumn(name = "CAR_ID"))
    @Column(name = "RENTAL_DATES")
    private Collection<Date> rentalDates = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_ID")
    private Set<TechnicalReview> technicalReview = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "vehicles")
    private List<Customer> customers = new ArrayList<>();


    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public List<Address> getRentalAddress() {
        return rentalAddress;
    }

    public void setRentalAddress(List<Address> rentalAddress) {
        this.rentalAddress = rentalAddress;
    }

    public Collection<Date> getRentalDates() {
        return rentalDates;
    }

    public void setRentalDates(Collection<Date> rentalDates) {
        this.rentalDates = rentalDates;
    }

    public Set<TechnicalReview> getTechnicalReview() {
        return technicalReview;
    }

    public void setTechnicalReview(Set<TechnicalReview> technicalReview) {
        this.technicalReview = technicalReview;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfSeats=" + numberOfSeats +
                ", carType=" + carType +
                ", rentalAddress=" + rentalAddress +
                ", rentalDates=" + rentalDates +
                ", technicalReview=" + technicalReview +
                "} " + super.toString();
    }
}
