package pl.blackfernsoft.wsis.orm.hibernatejpa;

public class HibernateJpaApplication {


    public static void main(String[] args) {

        try {

            // Run basic mapping examples
//            ExamplesBasicMapping.runMappingExamples();

            // Run inheritance examples
            ExamplesInheritance.runInheritanceExamples();

            // Run lazy loading examples
//            ExampleLazyLoading.runLazyLoadingExample();

//            ExampleCascade.runCascadeExample();

        } catch (Exception e) {
            // rollback db changes in case of any exception
            e.printStackTrace();
            HibernateUtil.getEntityManager().getTransaction().rollback();
        } finally {
            // Close db connection
            HibernateUtil.closeEntityManager();
        }
    }


}
