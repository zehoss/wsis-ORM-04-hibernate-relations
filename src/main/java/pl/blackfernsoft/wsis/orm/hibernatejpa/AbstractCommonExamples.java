package pl.blackfernsoft.wsis.orm.hibernatejpa;

import pl.blackfernsoft.wsis.orm.hibernatejpa.dao.*;
import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.*;
import pl.blackfernsoft.wsis.orm.hibernatejpa.enums.CarType;
import pl.blackfernsoft.wsis.orm.hibernatejpa.enums.Color;

import javax.persistence.EntityManager;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public abstract class AbstractCommonExamples {

    protected static final EntityManager em = HibernateUtil.getEntityManager();

    protected static final CarDao carDao = new CarDao(em);
    protected static final CurrencyDao currencyDao = new CurrencyDao(em);
    protected static final CustomerDao customerDao = new CustomerDao(em);
    protected static final RentalDao rentalDao = new RentalDao(em);
    protected static final InvoiceDao invoiceDao = new InvoiceDao(em);
    protected static final MotorbikeDao motorbikeDao = new MotorbikeDao(em);
    protected static TechnicalReviewDao technicalReviewDao = new TechnicalReviewDao(em);

    protected static TechnicalReview createTechnicalReview(Car car, TechnicalReviewResultEnum result, Date date, Date next) {
        TechnicalReview technicalReview = new TechnicalReview();
        technicalReview.setDate(date);
        technicalReview.setNextReview(next);
        technicalReview.setResult(result);
        technicalReview.setCar(car);
        return technicalReview;
    }

    protected static Customer createCustomer(String firstName, String lastName, String pesel) {
        Customer customer = new Customer();

        return customer;
    }

    protected static void printAll(Class clazz) {
        System.out.println("== PRINT ALL " + clazz.getSimpleName());
        List<Object> resuls = em.createQuery("from " + clazz.getName()).getResultList();
        for (Object entity : resuls) {
            System.out.println(entity);
        }
    }

    protected static Motorbike createMotorbike(String name, int engineSize, String platesNumber) {
        Motorbike motorbike = new Motorbike();
        motorbike.setName(name);
        motorbike.setEngineSize(engineSize);
        motorbike.setColor(Color.BLACK);
        motorbike.setPlatesNumber(platesNumber);
        return motorbike;
    }

    protected static Car createCar(String name, Color color, CarType type, String platesNumber) {
        Car car = new Car();
        car.setName(name);
        car.setColor(color);
        car.setCarType(type);
        car.setPlatesNumber(platesNumber);
        return car;
    }

    protected static Date getAsDate(String dateString) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = df.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
