/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.pointofsale.EJB;

import com.pos.pointofsale.details.TemporarDetails;
import com.pos.pointofsale.entity.Temporar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Asus
 */
@Stateless
public class TemporarBean {
  
    private static final Logger LOG = Logger.getLogger(TemporarBean.class.getName());

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    private EntityManager em;
    
    public void createTemporar(String name, String description, Double price, Integer quantity) {
        Temporar temporar = new Temporar();
        temporar.setName(name);
        temporar.setDescription(description);
        temporar.setPrice(price*quantity);
        temporar.setQuantity(quantity);
        
        em.persist(temporar);
    }
    
    public void updateTemporar(Integer id, String name, String description, Double price, Integer quantity) {
        LOG.info("updateTemporar");
        Temporar temporar = em.find(Temporar.class, id);
        temporar.setName(name);
        temporar.setDescription(description);
        temporar.setPrice(price);
        temporar.setQuantity(quantity);
        
    }
     public void updateTotal(Integer id,Integer quantity, Double price) {
        LOG.info("updateTotal");
        Temporar temporar = em.find(Temporar.class, id);
        temporar.setQuantity(quantity);
        temporar.setPrice(price);
        
    }
    
    public void deleteTemporarsByIds(Collection<Integer> ids) {
        LOG.info("deleteTemporarsByIds");
        for (Integer id : ids) {
            Temporar temporar = em.find(Temporar.class, id);
            em.remove(temporar);
        }
    }
    
    public List<TemporarDetails> getAllTemporars() {
        LOG.info("getAllTemporars");
        
        try {
            Query query = em.createQuery("SELECT t FROM Temporar t");
            List<Temporar> temporars = (List<Temporar>) query.getResultList();
            return copyTemporarsToDetails(temporars);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    private List<TemporarDetails> copyTemporarsToDetails(List<Temporar> temporars) {
        List<TemporarDetails> detailsList = new ArrayList<>();
        for (Temporar temporar : temporars) {
            TemporarDetails temporarDetails = new TemporarDetails(temporar.getId(),
                temporar.getName(),
                temporar.getDescription(),
                temporar.getPrice(),
                temporar.getQuantity());
            detailsList.add(temporarDetails);
        }
        return detailsList;
    }
    
    public TemporarDetails findById(Integer temporarId) {
        Temporar temporar = em.find(Temporar.class, temporarId);
        return new TemporarDetails(temporar.getId(),
                temporar.getName(),
                temporar.getDescription(),
                temporar.getPrice(),
                temporar.getQuantity()); }
    
    public Double getTotal() {
        Query query = em.createQuery("SELECT SUM(t.price) FROM Temporar t");
        Double total = (Double) query.getSingleResult();
        return total;
    }
    
    public void removeAll() {
        Query query = em.createQuery("DELETE FROM Temporar t");
        query.executeUpdate();
    }
    
    public TemporarDetails findByName(String productName) {
        
         LOG.info("getTempProdByName");
         try{
        Query query = em.createQuery("SELECT t FROM Temporar t WHERE t.name = :productName")
                .setParameter("productName", productName)
                .setMaxResults(1);
        Temporar temp = (Temporar) query.getSingleResult();
        return new TemporarDetails(temp.getId(), temp.getName(),temp.getDescription(),temp.getPrice(),temp.getQuantity());
         }catch(NoResultException ex)
         {
             return null;
         }
    }
    
//    public Boolean findByName(String temporarName) {
//        Query query = em.createQuery("SELECT t FROM Temporar t WHERE t.name = :temporarName")
//                .setParameter("temporarName", temporarName)
//                .setMaxResults(1);
//        Temporar temporar = (Temporar) query.getSingleResult();
//        if (temporar != null){
//            return true;
//        }
//        else 
//        {
//            return false;
//        }
//    }
    
//    public TemporarDetails findByName(String temporarName) {
//        try{
//        Query query = em.createQuery("SELECT t FROM Temporar t WHERE t.name = :temporarName")
//                .setParameter("temporarName", temporarName)
//                .setMaxResults(1);
//        Temporar temporar = (Temporar) query.getSingleResult();
//        return new TemporarDetails(temporar.getId(), temporar.getName(),temporar.getDescription(),temporar.getPrice(),temporar.getQuantity());
//        }
//        catch(NullPointerException e){
//            return null;
//        }
//        }
}
