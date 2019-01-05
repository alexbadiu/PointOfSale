/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.pointofsale.EJB;


import com.pos.pointofsale.details.UserDetails;
import com.pos.pointofsale.entity.User;
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
public class UserBean {

    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    private EntityManager em;
    
    public void createUser(String username, String email, String passwordSha256, String position) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordSha256);
        user.setPosition(position);
        
        em.persist(user);
    }
    
    public void updateUser(Integer id, String username, String passwordSha256, String email, String position) {
        LOG.info("updateCar");
        User user = em.find(User.class, id);
        user.setUsername(username);
        user.setPassword(passwordSha256);
        user.setEmail(email);
        user.setPosition(position);
    }
    
    public void deleteUsersByIds(Collection<Integer> ids) {
        LOG.info("deleteCarsByIds");
        for (Integer id : ids) {
            User user = em.find(User.class, id);
            em.remove(user);
        }
    }
    
    public List<UserDetails> getAllUsers() {
        LOG.info("getAllUsers");
        
        try {
            Query query = em.createQuery("SELECT u FROM User u");
            List<User> users = (List<User>) query.getResultList();
            return copyUsersToDetails(users);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    private List<UserDetails> copyUsersToDetails(List<User> users) {
        List<UserDetails> detailsList = new ArrayList<>();
        for (User user : users) {
            UserDetails userDetails = new UserDetails(user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPosition());
            detailsList.add(userDetails);
        }
        return detailsList;
    }
    
    public UserDetails findById(Integer userId) {
        User user = em.find(User.class, userId);
        return new UserDetails(user.getId(), user.getUsername(), user.getEmail(), user.getPosition());
    }
}
