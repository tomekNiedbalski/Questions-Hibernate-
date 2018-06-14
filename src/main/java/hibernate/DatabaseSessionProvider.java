package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DatabaseSessionProvider {

    private static DatabaseSessionProvider databaseSessionProvider = new DatabaseSessionProvider();

    private DatabaseSessionProvider() { }

    public static DatabaseSessionProvider getInstance(){
        return databaseSessionProvider;
    }

    private StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure("hibernate.config.xml")
            .build();

    private Metadata metadata = new MetadataSources(registry)
            .getMetadataBuilder()
            .build();

    private SessionFactory sessionFactory = metadata
            .getSessionFactoryBuilder()
            .build();

    public Session openSession(){
        return sessionFactory.openSession();
    }

    public void closeSessionFactory(){
        sessionFactory.close();
    }


}
