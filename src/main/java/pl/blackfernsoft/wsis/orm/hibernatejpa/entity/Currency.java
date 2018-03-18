package pl.blackfernsoft.wsis.orm.hibernatejpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CurrencyId.class)
public class Currency {

    @Id
    private String name;

    @Id
    private String country;

    private String symbol;

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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
