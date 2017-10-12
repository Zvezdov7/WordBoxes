package ru.zvezdov.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.zvezdov.dao.CustomerRepository;
import ru.zvezdov.model.Customer;

/**
 * @author Dmitry Zvezdov
 *         06.10.17.
 */
@Controller
public class MainController {
    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    private CustomerRepository repository;

    @RequestMapping("/hello")
    public String hello() {
        log.info("Method /hello");
        return "welcome";
    }

    @GetMapping("/customers")
    public ModelAndView getCustomers(ModelAndView modelAndView) {
        Iterable<Customer> all = repository.findAll();
        modelAndView.addObject("customers", all);
        modelAndView.setViewName("welcome");
        return modelAndView;

    }

    @ResponseBody
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable("id") Long id) {
        return repository.findOne(id);
    }

    @ResponseBody
    @PostMapping("/customers/")
    public Long createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = repository.save(customer);
        return createdCustomer.getId();
    }

    @ResponseBody
    @PutMapping("/customers/")
    public Customer setCustomer(@RequestBody Customer customer) {
        Customer previousCustomer = repository.findOne(customer.getId());
        repository.save(customer);
        return previousCustomer;
    }

    @ResponseBody
    @DeleteMapping("/customer/{id}")
    public Customer deleteCustomer(@PathVariable("id") Long id) {
        Customer customer = repository.findOne(id);
        repository.delete(id);
        return customer;
    }

    @Autowired
    public void setRepository(CustomerRepository repository) {
        this.repository = repository;
    }

}
