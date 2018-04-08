package pl.blackfernsoft.wsis.orm.hibernatejpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Motorbike extends Vehicle {

    @Column(name = "ENGINE_SIZE_CM3")
    private Integer engineSize;

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
