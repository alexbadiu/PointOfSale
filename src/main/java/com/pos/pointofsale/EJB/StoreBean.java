/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.pointofsale.EJB;

import com.pos.pointofsale.details.StoreDetails;
import com.pos.pointofsale.entity.Store;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alex
 */
@Stateless
public class StoreBean {

    private static final Logger LOG = Logger.getLogger(StoreBean.class.getName());

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    private EntityManager em;
    
    public List<StoreDetails> getAllStores() {
        LOG.info("getAllStores");
        
        try {
            Query query = em.createQuery("SELECT s FROM Store s");
            List<Store> stores = (List<Store>) query.getResultList();
            return copyStoresToDetails(stores);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    private List<StoreDetails> copyStoresToDetails(List<Store> stores) {
        List<StoreDetails> detailsList = new ArrayList<>();
        for (Store store : stores) {
            StoreDetails storeDetails = new StoreDetails(store.getId(),
                store.getName(),
                store.getAddress());
            detailsList.add(storeDetails);
        }
        return detailsList;
    }
    
    public StoreDetails findById(Integer storeId) {
        Store store = em.find(Store.class, storeId);
        return new StoreDetails(store.getId(), store.getName(), store.getAddress());
    }
    
    public void createStore(String name, String address) {
        Store store = new Store();
        store.setName(name);
        store.setAddress(address);
        
        em.persist(store);
    }
    
    public void updateStore(Integer id, String name, String address) {
        LOG.info("updateStore");
        Store store = em.find(Store.class, id);
        store.setName(name);
        store.setAddress(address);
    }
    
    public void deleteStoresByIds(Collection<Integer> ids) {
        LOG.info("deleteStoresByIds");
        for (Integer id : ids) {
            Store store = em.find(Store.class, id);
            em.remove(store);
        }
    }
}
