package pl.blackfernsoft.wsis.orm.hibernatejpa.dao;

import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.Motorbike;

import javax.persistence.EntityManager;

public class MotorbikeDao extends AbstractDao<Motorbike> {

    public MotorbikeDao(EntityManager em) {
        super(em, Motorbike.class);
    }
}
