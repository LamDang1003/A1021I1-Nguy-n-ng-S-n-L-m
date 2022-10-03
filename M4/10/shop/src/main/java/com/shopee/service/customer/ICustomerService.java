package com.shopee.service.customer;

import com.shopee.model.Customer;
import com.shopee.model.Province;
import com.shopee.service.IGeneralService;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
