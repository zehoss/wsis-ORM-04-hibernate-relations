package pl.blackfernsoft.wsis.orm.hibernatejpa.dao;

import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.Invoice;

import javax.persistence.EntityManager;

public class InvoiceDao extends AbstractDao<Invoice> {

    public InvoiceDao(EntityManager em) {
        super(em, Invoice.class);
    }

}
