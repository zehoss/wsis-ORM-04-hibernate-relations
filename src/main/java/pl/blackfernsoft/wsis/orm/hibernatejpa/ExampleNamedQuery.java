package pl.blackfernsoft.wsis.orm.hibernatejpa;

import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.Customer;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;

public class ExampleNamedQuery extends AbstractCommonExamples {

    public static void runNamedQueryExample() {

        int numberOfCars = 1;
        Query namedQuery = em.createNamedQuery("Customer.findCustomersWithXCars")
                .setParameter("numberOfCars", numberOfCars);
        List<Customer> customers = namedQuery.getResultList();

        System.out.println("Customers with at least " + numberOfCars + " cars");
        System.out.println(customers);


        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> customer = criteriaQuery.from(Customer.class);
        criteriaQuery.where(
                criteriaBuilder.greaterThanOrEqualTo(
                        criteriaBuilder.size(customer.<Collection>get("vehicles")),
                        criteriaBuilder.parameter(Integer.class, "numberOfCars"))
        );

        Query query = em.createQuery(criteriaQuery)
                .setParameter("numberOfCars", numberOfCars);

        List<Customer> customerList = query.getResultList();

        System.out.println("Results from criteria builder");
        System.out.println(customerList);


    }
}
