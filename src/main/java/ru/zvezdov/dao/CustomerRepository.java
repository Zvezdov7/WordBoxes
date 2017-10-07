package ru.zvezdov.dao;

import org.springframework.data.repository.CrudRepository;
import ru.zvezdov.model.Customer;

import java.util.List;

/**
 * @author Dmitry Zvezdov
 *         07.10.17.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
