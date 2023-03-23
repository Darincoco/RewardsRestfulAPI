package com.example.rewardsrestfulapi.dao;

import com.example.rewardsrestfulapi.entity.CustomerInfoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    //define filed for entity manager
    private EntityManager entityManager;

    @Autowired
    public CustomerDAOImpl (EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    @Override
    public List<CustomerInfoEntity> findAll(){

        TypedQuery<CustomerInfoEntity> theQuery = entityManager.createQuery(
                "from CustomerInfoEntity", CustomerInfoEntity.class);

        List<CustomerInfoEntity> customerInfoEntities = theQuery.getResultList();

        return customerInfoEntities;
    }

    @Override
    public CustomerInfoEntity findByName(String name) {
        TypedQuery<CustomerInfoEntity> theQuery = entityManager.createQuery(
                "SELECT c from CustomerInfoEntity c WHERE c.name = :name", CustomerInfoEntity.class);
        theQuery.setParameter("name", name);
        return theQuery.getSingleResult();
    }

    @Override
    public CustomerInfoEntity saveCustomer(CustomerInfoEntity customerInfoEntity) {
        CustomerInfoEntity dbEmployee = entityManager.merge(customerInfoEntity);
        return dbEmployee;
    }

    @Override
    public void deleteCustomer(String name) {
        TypedQuery<CustomerInfoEntity> theQuery = entityManager.createQuery(
                "SELECT c from CustomerInfoEntity c WHERE c.name = :name", CustomerInfoEntity.class);
        theQuery.setParameter("name", name);
        CustomerInfoEntity customerInfoEntity = theQuery.getSingleResult();
        entityManager.remove(customerInfoEntity);
    }


}
