package com.basic.demo.Repository;

import com.basic.demo.Repository.PoJo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends CrudRepository<Customer,Integer>, JpaRepository<Customer,Integer> {



}
