package com.mvc.dao;

import com.mvc.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();
}
