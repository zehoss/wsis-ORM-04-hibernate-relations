package pl.blackfernsoft.wsis.orm.hibernatejpa;

import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.Car;
import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.Customer;
import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.Motorbike;
import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.Vehicle;
import pl.blackfernsoft.wsis.orm.hibernatejpa.enums.CarType;
import pl.blackfernsoft.wsis.orm.hibernatejpa.enums.Color;

public class ExamplesInheritance extends AbstractCommonExamples {


    public static void runInheritanceExamples() {

        // Vehicle is @MappedSuperclass

//        em.getTransaction().begin();
//
//        Car car = createCar("Volvo", Color.BLACK, CarType.AWD, "DW-4747");
//        carDao.save(car);
//
//        Motorbike motorbike = createMotorbike("Suzuki", 650, "DW-23463");
//        motorbikeDao.save(motorbike);
//
//        printAll(Car.class);
//        printAll(Motorbike.class);
//        printAll(Vehicle.class);
//
//        em.getTransaction().commit();


        // Vehicle is @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
        em.getTransaction().begin();


        Car audi = createCar("Audi", Color.RED, CarType.SEDAN, "DW-87347");
        Car volvo = createCar("Volvo", Color.BLACK, CarType.AWD, "DW-4747");

        carDao.save(audi);
        carDao.save(volvo);

        Motorbike motorbike = createMotorbike("Suzuki", 650, "DW-23463");
        motorbikeDao.save(motorbike);

        printAll((Vehicle.class));

        Customer customer = createCustomer("Jan", "Kowalski", "7629472832");
        customer.getVehicles().add(audi);
        customer.getVehicles().add(volvo);
        customer.getVehicles().add(motorbike);

        customerDao.save(customer);

        em.getTransaction().commit();

        printAll(Vehicle.class);
        printAll(Customer.class);
    }

}
