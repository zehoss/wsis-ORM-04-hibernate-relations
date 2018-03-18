package pl.blackfernsoft.wsis.orm.hibernatejpa.dao;

import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.Currency;
import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.CurrencyId;

import javax.persistence.EntityManager;

public class CurrencyDao extends AbstractDao<Currency> {

    public CurrencyDao(EntityManager em) {
        super(em, Currency.class);
    }

    public Currency findById(CurrencyId currencyId) {
        return em.find(entityClass, currencyId);
    }
}
