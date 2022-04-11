package ru.mkskom.ashikhmin.spring_jpa.repo;

import org.springframework.data.repository.CrudRepository;
import ru.mkskom.ashikhmin.spring_jpa.entities.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);
}
