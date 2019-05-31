package com.jboxers.datastructure.persistenceFascade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {

    private static EntityManagerProducer instance;

    private EntityManagerFactory emf;


    private EntityManagerProducer() {
        emf = Persistence.createEntityManagerFactory("ivanDB");
    }

    private synchronized static EntityManagerProducer getInstance() {
        if (instance == null) {
            instance = new EntityManagerProducer();
        }

        return instance;
    }

    public static EntityManager getEntityManager() {
        return getInstance().emf.createEntityManager();
    }
}
