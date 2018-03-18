package pl.blackfernsoft.wsis.orm.hibernatejpa.dao;

import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.TechnicalReview;

import javax.persistence.EntityManager;

public class TechnicalReviewDao extends AbstractDao<TechnicalReview> {

    public TechnicalReviewDao(EntityManager em) {
        super(em, TechnicalReview.class);
    }

}
