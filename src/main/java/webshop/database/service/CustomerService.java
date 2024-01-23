package webshop.database.service;

import webshop.database.service.dto.CustomerDto;
import webshop.database.exception.NoCustomerFoundException;

public interface CustomerService {

  CustomerDto save(CustomerDto customerDto);
  CustomerDto findCustomer(long id) throws NoCustomerFoundException;
  CustomerDto findCustomerByName(String name);

}
