package pl.blackfernsoft.wsis.orm.hibernatejpa;

import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.Car;

import javax.persistence.TypedQuery;

public class ExamplesJpql extends AbstractCommonExamples {


    public static void runInheritanceExamples() {

        TypedQuery<Car> typedQuery = em.createQuery("from CAR c where c.carType LIKE :carType order by c.name", Car.class);
        typedQuery.getResultList();

    }

}
