package com.example.apac3;

import org.hibernate.Session;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try ( // get a Session and start a transaction
                Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession()) {
            laSesion.getTransaction().begin();
            
            Biblioteca b = new Biblioteca("", "", 0, 0);

            // Create new object
            Libro p = new Libro(0, "Como matar a un ruiseñor", "No lo se", b);
            System.out.println("Unsaved: " + p);
            
            // save in the database
            int idNueva = (int) laSesion.save(p);
            
            // Get the saved object (with another varaible)
            Libro q = laSesion.get(Libro.class, idNueva);
            
            System.out.println("Saved: " + q);
            
            // close all
            laSesion.getTransaction().commit();
        }

    }
}
