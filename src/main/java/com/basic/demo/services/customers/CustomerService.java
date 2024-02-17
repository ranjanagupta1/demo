package com.basic.demo.services.customers;

import com.basic.demo.DTO.Address;
import com.basic.demo.DTO.Cust;
import com.basic.demo.Repository.CustomerRepo;
import com.basic.demo.Repository.CustomerRepository;
import com.basic.demo.Repository.PoJo.Customer;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Cust findById(Integer id) {
        return getCustomer(customerRepo.findById(id));
    }

    private Cust getCustomer(Optional<com.basic.demo.Repository.PoJo.Customer> byId) {
        if (byId.isEmpty())
            return null;

        com.basic.demo.Repository.PoJo.Customer customer = byId.get();
        Cust cust = new Cust();

        cust.setStoreId(customer.getStore_id());
        cust.setFirstName(customer.getFirst_name());
        cust.setLastName(customer.getLast_name());
        cust.setEmail(customer.getEmail());
        cust.setActive(customer.is_active());
        Address address = new Address();
        address.setAddressLine_1(customer.getAddress().getAddress_line_1());
        address.setAddressLine_2(customer.getAddress().getAddress_line_2());
        address.setCity(customer.getAddress().getCity().getCity());
        address.setContact(customer.getAddress().getPhone());
        address.setDistrict(customer.getAddress().getDistrict());
        address.setPostalCode(customer.getAddress().getPostal_code());
        address.setCountry(customer.getAddress().getCity().getCountry().getCountry());
        cust.setAddress(address);

        return cust;
    }

    public List<Cust> listCustomers() {
        return customerRepo.findAll().stream().map(x -> getCustomer(Optional.ofNullable(x))).collect(Collectors.toList());
    }

    public List<Cust> listCustomers(int limit) {
        return customerRepository.findCustomerLimitedTo(limit).stream().map(x -> getCustomer(Optional.ofNullable(x))).collect(Collectors.toList());
    }
}
