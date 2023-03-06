package com.company.customerdataservice.repository;

import static org.junit.Assert.*;
import com.company.customerdataservice.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepo;
    @Before
    public void setUp() throws Exception {
        customerRepo.deleteAll();
    }

    @Test
    public void addCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("John B");
        customer.setLastName("Routledge");
        customer.setCompany("routledgeB@gmail.com");
        customer.setPhone("123-456-7890");
        customer.setCompany("Pogues");
        customer.setAddress1("1234 Poguelandia dr");
        customer.setAddress2("Apt 5210");
        customer.setCity("North Carolina");
        customer.setState("NC");
        customer.setPostal("20947");
        customer.setCountry("USA");

        customer = customerRepo.save(customer);

        Optional<Customer> customer1 = customerRepo.findById(customer.getId());
        assertEquals(customer1.get(), customer);
    }

    @Test
    public void getAllCustomers() {
        Customer customer = new Customer();
        customer.setFirstName("John B");
        customer.setLastName("Routledge");
        customer.setCompany("routledgeB@gmail.com");
        customer.setPhone("123-456-7890");
        customer.setCompany("Pogues");
        customer.setAddress1("1234 Poguelandia dr");
        customer.setAddress2("Apt 5210");
        customer.setCity("North Carolina");
        customer.setState("NC");
        customer.setPostal("20947");
        customer.setCountry("USA");
        customerRepo.save(customer);

        Customer customer2 = new Customer();
        customer2.setFirstName("Sarah");
        customer2.setLastName("Cameron");
        customer2.setCompany("scameron@gmail.com");
        customer2.setPhone("098-765-4321");
        customer2.setCompany("Hybrid");
        customer2.setAddress1("3213 Highway st");
        customer2.setAddress2("Apt 2093");
        customer2.setCity("North Carolina");
        customer2.setState("NC");
        customer2.setPostal("20947");
        customer2.setCountry("USA");
        customerRepo.save(customer);
        customerRepo.save(customer2);

        List<Customer> customerList = customerRepo.findAll();
        assertEquals(2, customerList.size());
    }

    @Test
    public void updateCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("John B");
        customer.setLastName("Routledge");
        customer.setCompany("routledgeB@gmail.com");
        customer.setPhone("123-456-7890");
        customer.setCompany("Pogues");
        customer.setAddress1("1234 Poguelandia dr");
        customer.setAddress2("Apt 5210");
        customer.setCity("North Carolina");
        customer.setState("NC");
        customer.setPostal("20947");
        customer.setCountry("USA");
        customerRepo.save(customer);

        customer.setFirstName("UPDATED");
        customerRepo.save(customer);

        Optional<Customer> customer1 = customerRepo.findById(customer.getId());
        assertEquals(customer1.get(), customer);
    }

    @Test
    public void deleteCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("John B");
        customer.setLastName("Routledge");
        customer.setCompany("routledgeB@gmail.com");
        customer.setPhone("123-456-7890");
        customer.setCompany("Pogues");
        customer.setAddress1("1234 Poguelandia dr");
        customer.setAddress2("Apt 5210");
        customer.setCity("North Carolina");
        customer.setState("NC");
        customer.setPostal("20947");
        customer.setCountry("USA");
        customerRepo.save(customer);

        customerRepo.deleteById(customer.getId());

        Optional<Customer> customer1 = customerRepo.findById(customer.getId());
        assertFalse(customer1.isPresent());
    }
}