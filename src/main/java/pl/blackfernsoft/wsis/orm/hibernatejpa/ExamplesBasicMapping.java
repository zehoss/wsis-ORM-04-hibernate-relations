package pl.blackfernsoft.wsis.orm.hibernatejpa;

import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.*;
import pl.blackfernsoft.wsis.orm.hibernatejpa.enums.CarType;
import pl.blackfernsoft.wsis.orm.hibernatejpa.enums.Color;

import java.util.Date;

public class ExamplesBasicMapping extends AbstractCommonExamples {


    public static void runMappingExamples() {

        // Create cars

        Car audi = createCar("Audi", Color.RED, CarType.AWD, "DW-45753");
        audi.getTechnicalReview().add(createTechnicalReview(audi, TechnicalReviewResultEnum.PASSED, getAsDate("18-01-2016"), getAsDate("18-01-2017")));
        audi.getTechnicalReview().add(createTechnicalReview(audi, TechnicalReviewResultEnum.FAILED, getAsDate("18-01-2017"), null));
        audi.getTechnicalReview().add(createTechnicalReview(audi, TechnicalReviewResultEnum.PASSED, getAsDate("19-01-2017"), getAsDate("19-01-2018")));

        em.getTransaction().begin();
        carDao.save(audi);
        em.getTransaction().commit();

        printAll(Car.class);
        printAll(TechnicalReview.class);

        // Create customers
        Car volvo = createCar("Volvo", Color.BLUE, CarType.AWD, "DW-48752");

        Customer customer = createCustomer("Stefan", "Kowalski", "85199535949");
        customer.getVehicles().add(volvo);
        volvo.getCustomers().add(customer);

        em.getTransaction().begin();
        customerDao.save(customer);
        em.getTransaction().commit();

        printAll(Customer.class);
        printAll(Car.class);

        // Find customer using composite key
//            CustomerPK customerPK = new CustomerPK();
//            customerPK.setFirstName("Adam");
//            customerPK.setLastName("Małysz");
//            customerPK.setPESEL("95063435949");
//
//            Customer customerDb = customerDao.findById(customerPK);
//            System.out.println(customerDb);

        // Create currencies

        Currency euroDE = new Currency();
        euroDE.setCountry("Germany");
        euroDE.setName("Euro");
        euroDE.setSymbol("€");

        Currency dollarAu = new Currency();
        dollarAu.setCountry("Australia");
        dollarAu.setName("Dollar");
        dollarAu.setSymbol("$");

        Currency dollarUSA = new Currency();
        dollarUSA.setCountry("USA");
        dollarUSA.setName("Dollar");
        dollarUSA.setSymbol("$");

        em.getTransaction().begin();
        currencyDao.save(euroDE);
        currencyDao.save(dollarAu);
        currencyDao.save(dollarUSA);
        em.getTransaction().commit();

        printAll(Currency.class);

        // Find currency by composite key
        Currency retrievedCurrency = currencyDao.findById(new CurrencyId("Dollar", "Australia"));
        System.out.println(retrievedCurrency);


        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber("F-VAT-01/2018");
        invoice.setDate(new Date());

        Rental rental = new Rental();
        rental.setDateFrom(new Date());
        // add reference from source (rental) to target (invoice)
        rental.setInvoice(invoice);

        // add reversed reference from target to source
        invoice.setRental(rental);

        em.getTransaction().begin();
        rentalDao.save(rental);
        em.getTransaction().commit();

        printAll(Rental.class);
        printAll(Invoice.class);


    }

}
