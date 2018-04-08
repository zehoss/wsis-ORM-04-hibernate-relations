package pl.blackfernsoft.wsis.orm.hibernatejpa.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MOTOR")
public class Motorbike extends Vehicle {

    @Column(name = "ENGINE_SIZE_CM3")
    private Integer engineSize;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "vehicles")
    private List<Customer> customers = new ArrayList<>();

    public Integer getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(Integer engineSize) {
        this.engineSize = engineSize;
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                "engineSize=" + engineSize +
                "} " + super.toString();
    }
}
