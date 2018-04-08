package pl.blackfernsoft.wsis.orm.hibernatejpa;

import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.Car;
import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.TechnicalReview;
import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.TechnicalReviewResultEnum;
import pl.blackfernsoft.wsis.orm.hibernatejpa.enums.CarType;
import pl.blackfernsoft.wsis.orm.hibernatejpa.enums.Color;

public class ExampleLazyLoading extends AbstractCommonExamples {

    public static void runLazyLoadingExample() {


        em.getTransaction().begin();

        Car audi = createCar("Audi", Color.RED, CarType.AWD, "DW-12242");
        audi.getTechnicalReview().add(createTechnicalReview(audi, TechnicalReviewResultEnum.PASSED, getAsDate("18-01-2016"), getAsDate("18-01-2017")));
        audi.getTechnicalReview().add(createTechnicalReview(audi, TechnicalReviewResultEnum.FAILED, getAsDate("18-01-2017"), null));
        audi.getTechnicalReview().add(createTechnicalReview(audi, TechnicalReviewResultEnum.PASSED, getAsDate("19-01-2017"), getAsDate("19-01-2018")));

        carDao.save(audi);
        em.getTransaction().commit();

        // clear pesistence context
        em.clear();

        // If lazy loading is set then retrieves only Car entity (without technical reviews)
        Car dbCar = carDao.findById(2L);
        System.out.println(dbCar.getName());

        // Here technical reviews are loaded "lazyly" from db
        for (TechnicalReview tr : dbCar.getTechnicalReview()) {
            System.out.println(tr);
        }


    }

}
