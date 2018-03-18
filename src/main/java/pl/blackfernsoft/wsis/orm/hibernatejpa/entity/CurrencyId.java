package pl.blackfernsoft.wsis.orm.hibernatejpa.entity;

import java.io.Serializable;

public class CurrencyId implements Serializable {

    private String name;
    private String country;

    public CurrencyId() {
    }

    public CurrencyId(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
