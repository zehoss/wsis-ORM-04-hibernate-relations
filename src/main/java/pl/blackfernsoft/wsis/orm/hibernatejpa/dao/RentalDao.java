package pl.blackfernsoft.wsis.orm.hibernatejpa.dao;

import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.Rental;

import javax.persistence.EntityManager;

public class RentalDao extends AbstractDao<Rental> {

    public RentalDao(EntityManager em) {
        super(em, Rental.class);
    }

}
