package com.basic.demo.DTO;

import lombok.Data;

@Data
public class Cust {
    private int storeId;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private boolean isActive;

}
