/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import com.modelo.entidades.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Fernando Sangopanta
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     // crear la entidad persona en la base de datos
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Facturacion");
        EntityManager em = emf.createEntityManager();

        Persona persona = new Persona();
        persona.setNombre("Fernando");
        
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
        em.close();

    }
    
}
