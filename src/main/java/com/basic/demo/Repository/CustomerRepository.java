package com.basic.demo.Repository;

import com.basic.demo.Repository.PoJo.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Customer> findCustomerLimitedTo(int limit) {
        return entityManager.createQuery("SELECT * FROM customer",
                Customer.class).setMaxResults(limit).getResultList();
    }

}
