/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.pointofsale.EJB;

import com.pos.pointofsale.details.ProductDetails;
import com.pos.pointofsale.entity.Product;
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
public class ProductBean {

    private static final Logger LOG = Logger.getLogger(ProductBean.class.getName());

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    private EntityManager em;
    
    public List<ProductDetails> getAllProducts() {
        LOG.info("getAllProducts");
        
        try {
            Query query = em.createQuery("SELECT p FROM Product p");
            List<Product> products = (List<Product>) query.getResultList();
            return copyProductsToDetails(products);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    private List<ProductDetails> copyProductsToDetails(List<Product> products) {
        List<ProductDetails> detailsList = new ArrayList<>();
        for (Product product : products) {
            ProductDetails productDetails = new ProductDetails(product.getId(),
                product.getProdName());
            detailsList.add(productDetails);
        }
        return detailsList;
    }
    
    public ProductDetails findById(Integer productId) {
        Product product = em.find(Product.class, productId);
        return new ProductDetails(product.getId(), product.getProdName());
    }
    
    public ProductDetails findByName(String productName) {
        Query query = em.createQuery("SELECT p FROM Product p WHERE p.prodName = :prodName")
                .setParameter("prodName", productName)
                .setMaxResults(1);
        Product product = (Product) query.getSingleResult();
        return new ProductDetails(product.getId(), product.getProdName());
    }
    
    public ProductDetails findMaxId() {
        Query query = em.createQuery("SELECT p FROM Product p WHERE p.id = (SELECT MAX(p.id) FROM Product p)");
        Product product = (Product) query.getSingleResult();
        return new ProductDetails(product.getId(), product.getProdName());
    }
    
    public void createProduct(String prodName) {
        Product product = new Product();
        product.setProdName(prodName);
        
        em.persist(product);
    }
    
    public void updateProduct(Integer id, String prodName) {
        LOG.info("updateProduct");
        Product product = em.find(Product.class, id);
        product.setProdName(prodName);
    }
    
    public void deleteProductsByIds(Collection<Integer> ids) {
        LOG.info("deleteProductsByIds");
        for (Integer id : ids) {
            Product product = em.find(Product.class, id);
            em.remove(product);
        }
    }
}
