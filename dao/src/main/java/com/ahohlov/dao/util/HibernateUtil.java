package com.ahohlov.dao.util;

import com.ahohlov.config.ConfigurationManager;
import com.ahohlov.dao.model.Orders;
import com.ahohlov.dao.model.Profile;
import com.ahohlov.dao.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Created by admin on 9/3/18.
 */
public class HibernateUtil {
    private static final Logger logger = LogManager.getLogger(HibernateUtil.class);
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    private HibernateUtil(){
    }

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null) {
            try{
                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
                Map<String, String> settings = new HashMap<>();
                settings.put(Environment.DRIVER, ConfigurationManager.getInstance().getProperty(ConfigurationManager.DATABASE_DRIVER_NAME));
                settings.put(Environment.URL, ConfigurationManager.getInstance().getProperty(ConfigurationManager.DATABASE_URL));
                settings.put(Environment.USER, ConfigurationManager.getInstance().getProperty(ConfigurationManager.DATABASE_USERNAME));
                settings.put(Environment.PASS, ConfigurationManager.getInstance().getProperty(ConfigurationManager.DATABASE_PWD));
                settings.put(Environment.HBM2DDL_AUTO, ConfigurationManager.getInstance().getProperty(Environment.HBM2DDL_AUTO));
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, ConfigurationManager.getInstance().getProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS));

                registryBuilder.applySettings(settings);
                registry = registryBuilder.build();
                logger.info("Hibernate registry builder created.");

                MetadataSources sources = new MetadataSources(registry).
                        addAnnotatedClass(User.class).
                        addAnnotatedClass(Profile.class).
                        addAnnotatedClass(Orders.class);
                Metadata metadata = sources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
                logger.info("SessionFactory created.");
            }catch (Exception e){
                logger.error("SessionFactory creationfailed");
                logger.error(e.getMessage(),e);

                if(registry != null){
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }
}
