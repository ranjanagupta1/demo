package com.basic.demo.DTO;

import lombok.Data;

@Data
public class Address {
    private String addressLine_1;
    private String addressLine_2;
    private String district;
    private String city;
    private String postalCode;
    private String contact;
    private String country;
}
