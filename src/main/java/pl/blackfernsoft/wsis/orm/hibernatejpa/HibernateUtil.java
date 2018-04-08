package pl.blackfernsoft.wsis.orm.hibernatejpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    // Configuration from file resources/META-INF/persistence.xml
    private static EntityManagerFactory emf;

    private static EntityManager entityManager;

    private HibernateUtil() {
    }


    public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("persistenceUnit-h2");
        }
        if (entityManager == null) {
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }

    public static void closeEntityManager() {
        if (entityManager != null)
            entityManager.close();

        if (emf != null)
            emf.close();
    }

}
