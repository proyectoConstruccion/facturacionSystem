/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import com.modelo.entidades.Persona;
import javax.persistence.EntityManager;
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
        EntityManager em = Persistence.createEntityManagerFactory("Facturacion").createEntityManager();

        Persona persona = new Persona();

        persona.setNombre("Juan");
        
        em.getTransaction().begin();
        try {
            em.persist(persona);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(">>>> ERROR:JPAGenericDAO:create " + e);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

}
