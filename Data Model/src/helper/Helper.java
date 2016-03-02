package helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by ghalib on 3/2/2016.
 */
public class Helper {
    public static SessionFactory sessionFactory = null;

    public static void init(){
        if (sessionFactory == null)
            createSessionFactory();
    }

    private static void createSessionFactory(){
        Configuration configuration = new Configuration().configure();
        ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = serviceRegistryBuilder.buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
}
