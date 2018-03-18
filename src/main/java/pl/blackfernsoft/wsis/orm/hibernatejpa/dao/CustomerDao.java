package pl.blackfernsoft.wsis.orm.hibernatejpa.dao;

import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.Customer;
import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.CustomerPK;

import javax.persistence.EntityManager;

public class CustomerDao extends AbstractDao<Customer> {

    public CustomerDao(EntityManager entityManager) {
        super(entityManager, Customer.class);
    }

    public Customer findById(CustomerPK customerPK) {
        return em.find(entityClass, customerPK);
    }
}
