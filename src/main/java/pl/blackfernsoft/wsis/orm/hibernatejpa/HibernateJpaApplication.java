package pl.blackfernsoft.wsis.orm.hibernatejpa;

import pl.blackfernsoft.wsis.orm.hibernatejpa.dao.CarDao;
import pl.blackfernsoft.wsis.orm.hibernatejpa.dao.CustomerDao;
import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.Car;
import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.Customer;
import pl.blackfernsoft.wsis.orm.hibernatejpa.enums.CarType;
import pl.blackfernsoft.wsis.orm.hibernatejpa.enums.Color;

import javax.persistence.EntityManager;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HibernateJpaApplication {

    private static final EntityManager em = HibernateUtil.getEntityManager();
    private static final CarDao carDao = new CarDao(em);
    private static final CustomerDao customerDao = new CustomerDao(em);

    public static void main(String[] args) {

        try {

            // Create cars
            em.getTransaction().begin();
            carDao.save(createCar("Audi", Color.RED, CarType.AWD));
            carDao.save(createCar("Volvo", Color.SILVER, CarType.SEDAN));
            em.getTransaction().commit();
            printAllCars();


            // Create customers
            em.getTransaction().begin();
            customerDao.save(createCustomer("Stefan", "Kowalski"));
            customerDao.save(createCustomer("Adam", "Małysz"));
            em.getTransaction().commit();
            printAllCustomers();


        } finally {
            // Close db connection
            HibernateUtil.closeEntityManager();
        }
    }

    private static Customer createCustomer(String firstName, String lastName) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        return customer;
    }

    private static void printAllCustomers() {
        System.out.println("== PRINT ALL CUSTOMERS");
        List<Customer> customers = customerDao.findAll();
        for (Customer customerEntity : customers) {
            System.out.println(customerEntity);
        }
    }

    private static void printAllCars() {
        System.out.println("== PRINT ALL CARS");
        List<Car> cars = carDao.findAll();
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static Car createCar(String name, Color color, CarType type) {
        Car car1 = new Car();
        car1.setName(name);
        car1.setColor(color);
        car1.setCarType(type);
        return car1;
    }

    private static Date getAsDate(String dateString) {
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
