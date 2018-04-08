package pl.blackfernsoft.wsis.orm.hibernatejpa;

import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.*;
import pl.blackfernsoft.wsis.orm.hibernatejpa.enums.CarType;
import pl.blackfernsoft.wsis.orm.hibernatejpa.enums.Color;

import java.util.Date;
import java.util.Iterator;

public class ExampleCascade extends AbstractCommonExamples {

    public static void runCascadeExample() {

        // Car -> Technical Review

        em.getTransaction().begin();
        Car audi = createCar("Audi", Color.RED, CarType.AWD, "DW-45753");
        audi.getTechnicalReview().add(createTechnicalReview(audi, TechnicalReviewResultEnum.PASSED, getAsDate("18-01-2016"), getAsDate("18-01-2017")));
        audi.getTechnicalReview().add(createTechnicalReview(audi, TechnicalReviewResultEnum.FAILED, getAsDate("18-01-2017"), null));
        audi.getTechnicalReview().add(createTechnicalReview(audi, TechnicalReviewResultEnum.PASSED, getAsDate("19-01-2017"), getAsDate("19-01-2018")));

        carDao.save(audi);
        em.getTransaction().commit();


        printAll(Car.class);
        printAll(TechnicalReview.class);

        em.getTransaction().begin();
        // After removing reference to TechnicalReview, a referenced row will be removed from DB
        Iterator<TechnicalReview> it = audi.getTechnicalReview().iterator();
        it.next();
        it.remove();
        carDao.save(audi);
        em.getTransaction().commit();

        printAll(Car.class);
        printAll(TechnicalReview.class);

        // Clear persistence context to prevent Hibernate to re-save removed entity from the context.
        em.clear();
        em.getTransaction().begin();
        technicalReviewDao.delete(technicalReviewDao.findById(2L));
        em.getTransaction().commit();

        printAll(Car.class);
        printAll(TechnicalReview.class);


//        em.getTransaction().begin();
//        System.out.println("Removing CAR enity");
//        // By removing Car entity we remove all child technical review entities
//        carDao.delete(audi);
//        em.getTransaction().commit();

//        printAll(Car.class);
//        printAll(TechnicalReview.class);

    }

    private static Rental createRental(Invoice invoice) {
        Rental rental = new Rental();
        rental.setDateFrom(new Date());
        // add reference from source (rental) to target (invoice)
        rental.setInvoice(invoice);
        return rental;
    }

    private static Invoice createInvoice() {
        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber("F-VAT-01/2018");
        invoice.setDate(new Date());
        return invoice;
    }
}
