/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.pointofsale.EJB;

import com.pos.pointofsale.details.ProductSpecificationDetails;
import com.pos.pointofsale.entity.Product;
import com.pos.pointofsale.entity.ProductSpecification;
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
 * @author Alex
 */
@Stateless
public class ProductSpecificationBean {

    private static final Logger LOG = Logger.getLogger(ProductSpecificationBean.class.getName());

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    private EntityManager em;
    
    public void createProductSpecification(String description, Double price, Integer unitOnStock, Integer productId, String barcode) {
        ProductSpecification productSpecification = new ProductSpecification();
        productSpecification.setDescription(description);
        productSpecification.setPrice(price);
        productSpecification.setUnitOnStock(unitOnStock);
        
        Product product = em.find(Product.class, productId);
        product.setProductSpecification(productSpecification);
        productSpecification.setProduct(product);
        
        productSpecification.setBarcode(barcode);
        
        em.persist(productSpecification);
    }
    
    public void updateProductSpecification(Integer id, String description, Double price, Integer unitOnStock, Integer productId, String barcode) {
        LOG.info("updateProductSpecification");
        ProductSpecification productSpecification = em.find(ProductSpecification.class, id);
        productSpecification.setDescription(description);
        productSpecification.setPrice(price);
        productSpecification.setUnitOnStock(unitOnStock);
        
        Product product = em.find(Product.class, productId);
        product.setProductSpecification(productSpecification);
        productSpecification.setProduct(product);
        
        productSpecification.setBarcode(barcode);
    }
    
    public ProductSpecificationDetails findByName(String productName) {
        Query query = em.createQuery("SELECT ps FROM ProductSpecification ps WHERE ps.product = (SELECT p FROM Product p WHERE p.prodName = :productName)")
                .setParameter("productName", productName)
                .setMaxResults(1);
        ProductSpecification productSpecification = (ProductSpecification) query.getSingleResult();
        return new ProductSpecificationDetails(
                productSpecification.getId(),
                productSpecification.getDescription(),
                productSpecification.getPrice(),
                productSpecification.getUnitOnStock(),
                productSpecification.getProduct().getProdName(),
                productSpecification.getProduct().getId(),
                productSpecification.getBarcode());
    }
    
    public void deleteProductSpecificationsByIds(Collection<Integer> ids) {
        LOG.info("deleteProductSpecificationsByIds");
        for (Integer id : ids) {
            ProductSpecification productSpecification = em.find(ProductSpecification.class, id);
            em.remove(productSpecification);
        }
    }
    
    public List<ProductSpecificationDetails> getAllProductSpecifications() {
        LOG.info("getAllProductSpecifications");
        
        try {
            Query query = em.createQuery("SELECT ps FROM ProductSpecification ps");
            List<ProductSpecification> productSpecifications = (List<ProductSpecification>) query.getResultList();
            return copyProductSpecificationsToDetails(productSpecifications);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    private List<ProductSpecificationDetails> copyProductSpecificationsToDetails(List<ProductSpecification> productSpecifications) {
        List<ProductSpecificationDetails> detailsList = new ArrayList<>();
        for (ProductSpecification productSpecification : productSpecifications) {
            ProductSpecificationDetails productSpecificationDetails = new ProductSpecificationDetails(productSpecification.getId(),
                productSpecification.getDescription(),
                productSpecification.getPrice(),
                productSpecification.getUnitOnStock(),
                productSpecification.getProduct().getProdName(),
                productSpecification.getProduct().getId(),
                productSpecification.getBarcode());
            detailsList.add(productSpecificationDetails);
        }
        return detailsList;
    }
    
    public ProductSpecificationDetails findById(Integer productSpecificationId) {
        ProductSpecification productSpecification = em.find(ProductSpecification.class, productSpecificationId);
        return new ProductSpecificationDetails(productSpecification.getId(),
                productSpecification.getDescription(),
                productSpecification.getPrice(),
                productSpecification.getUnitOnStock(),
                productSpecification.getProduct().getProdName(),
                productSpecification.getProduct().getId(),
                productSpecification.getBarcode());
    }
    
    
    public ProductSpecificationDetails findByBarcode(String barcode) {
        try{
        Query query = em.createQuery("SELECT ps FROM ProductSpecification ps WHERE ps.barcode = :barcode")
                .setParameter("barcode", barcode)
                .setMaxResults(1);
        ProductSpecification productSpecification = (ProductSpecification) query.getSingleResult();
        return new ProductSpecificationDetails(productSpecification.getId(),
                productSpecification.getDescription(),
                productSpecification.getPrice(),
                productSpecification.getUnitOnStock(),
                productSpecification.getProduct().getProdName(),
                productSpecification.getProduct().getId(),
                productSpecification.getBarcode());
        }catch(NoResultException e){
            return null;
        }
    }
}
