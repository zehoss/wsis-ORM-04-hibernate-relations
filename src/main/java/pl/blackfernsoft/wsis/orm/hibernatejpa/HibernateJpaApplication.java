package pl.blackfernsoft.wsis.orm.hibernatejpa;

import pl.blackfernsoft.wsis.orm.hibernatejpa.dao.CarDao;
import pl.blackfernsoft.wsis.orm.hibernatejpa.dao.CustomerDao;
import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.Car;
import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.Customer;
import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.CustomerPK;
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
            customerDao.save(createCustomer("Stefan", "Kowalski", "85199535949"));
            customerDao.save(createCustomer("Adam", "Małysz", "95063435949"));
            em.getTransaction().commit();
            printAllCustomers();

            // Find customer using composite key
            CustomerPK customerPK = new CustomerPK();
            customerPK.setFirstName("Adam");
            customerPK.setLastName("Małysz");
            customerPK.setPESEL("95063435949");

            Customer customer = customerDao.findById(customerPK);
            System.out.println(customer);


        } finally {
            // Close db connection
            HibernateUtil.closeEntityManager();
        }
    }

    private static Customer createCustomer(String firstName, String lastName, String pesel) {
        CustomerPK customerPK = new CustomerPK();
        customerPK.setFirstName(firstName);
        customerPK.setLastName(lastName);
        customerPK.setPESEL(pesel);

        Customer customer = new Customer();
        customer.setPrimaryKey(customerPK);

        customerDao.save(customer);

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
