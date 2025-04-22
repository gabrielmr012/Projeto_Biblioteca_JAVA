package com.biblioteca.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory managerf = Persistence.createEntityManagerFactory("biblioteca_Pu");

    public static EntityManager getEntityManager() {
        return managerf.createEntityManager();
    }

    public static void closeEntityManager() {
        if (managerf != null) {
            managerf.close();
        }
    }

}
