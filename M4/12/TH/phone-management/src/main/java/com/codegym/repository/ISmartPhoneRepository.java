package com.codegym.repository;

import com.codegym.model.SmartPhone;
import org.springframework.data.repository.CrudRepository;

public interface ISmartPhoneRepository extends CrudRepository<SmartPhone, Long> {

}
