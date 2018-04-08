package pl.blackfernsoft.wsis.orm.hibernatejpa.entity;


import pl.blackfernsoft.wsis.orm.hibernatejpa.enums.Color;

import javax.persistence.*;
import java.util.Date;


//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "VEHICLE")
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    // other fields, getters and setters

    @Column(name = "PLATES_NUMBER")
    private String platesNumber;

    @Column(name = "FIRST_REGISTRATION")
    private Date firstRegistrationDate = new Date();

    @Enumerated(EnumType.STRING)
    private Color color;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatesNumber() {
        return platesNumber;
    }

    public void setPlatesNumber(String platesNumber) {
        this.platesNumber = platesNumber;
    }

    public Date getFirstRegistrationDate() {
        return firstRegistrationDate;
    }

    public void setFirstRegistrationDate(Date firstRegistrationDate) {
        this.firstRegistrationDate = firstRegistrationDate;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", platesNumber='" + platesNumber + '\'' +
                ", firstRegistrationDate=" + firstRegistrationDate +
                ", color=" + color +
                '}';
    }
}
