package com.company.customerdataservice.controller;

import static org.junit.Assert.*;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest{
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    CustomerRepository customerRepo;
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldAddCustomer() throws Exception{
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

        Customer customer2 = new Customer();
        customer2.setFirstName("John B");
        customer2.setLastName("Routledge");
        customer2.setCompany("routledgeB@gmail.com");
        customer2.setPhone("123-456-7890");
        customer2.setCompany("Pogues");
        customer2.setAddress1("1234 Poguelandia dr");
        customer2.setAddress2("Apt 5210");
        customer2.setCity("North Carolina");
        customer2.setState("NC");
        customer2.setPostal("20947");
        customer2.setCountry("USA");
        doReturn(customer).when(customerRepo).save(customer2);
        String customerString = mapper.writeValueAsString(customer);
        mockMvc.perform(post("/customers")
                        .content(customerString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }


    @Test
    public void shouldUpdateCustomer() throws Exception{
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

        Customer customer2 = new Customer();
        customer2.setFirstName("John B");
        customer2.setLastName("Routledge");
        customer2.setCompany("routledgeB@gmail.com");
        customer2.setPhone("123-456-7890");
        customer2.setCompany("Pogues");
        customer2.setAddress1("1234 Poguelandia dr");
        customer2.setAddress2("Apt 5210");
        customer2.setCity("North Carolina");
        customer2.setState("NC");
        customer2.setPostal("20947");
        customer2.setCountry("USA");
        customer.setFirstName("Hello");
        customer2.setFirstName("Hello");
        doReturn(customer).when(customerRepo).save(customer2);
        String customerString = mapper.writeValueAsString(customer);
        mockMvc.perform((put("/customers"))
                        .content(customerString)
                        .contentType(MediaType.APPLICATION_JSON)).
                andDo(print())
                .andExpect(status().isNoContent());
    }


    @Test
    public void shouldGetCustomersByState() throws Exception{
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

        Customer customer2 = new Customer();
        customer2.setFirstName("John B");
        customer2.setLastName("Routledge");
        customer2.setCompany("routledgeB@gmail.com");
        customer2.setPhone("123-456-7890");
        customer2.setCompany("Pogues");
        customer2.setAddress1("1234 Poguelandia dr");
        customer2.setAddress2("Apt 5210");
        customer2.setCity("North Carolina");
        customer2.setState("NC");
        customer2.setPostal("20947");
        customer2.setCountry("USA");
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer2);
        doReturn(customerList).when(customerRepo).findByState(customer2.getState());

        mockMvc.perform(get("/customers/state/".concat(customer2.getAddress1())))
                .andDo(print())
                .andExpect(status().isOk());

    }
    @Test
    public void shouldDeleteCustomer() throws Exception{
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
        mockMvc.perform((delete("/customers/1")))
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldGetCustomerById() throws Exception{
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
        customer.setId(1);

        doReturn(Optional.of(customer)).when(customerRepo).findById(customer.getId());
        mockMvc.perform(get("/customers/".concat(String.valueOf(customer.getId()))))
                .andDo(print())
                .andExpect(status().isOk());


    }


}