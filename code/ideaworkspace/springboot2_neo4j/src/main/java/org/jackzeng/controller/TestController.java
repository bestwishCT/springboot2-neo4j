package org.jackzeng.controller;

import com.google.common.collect.Lists;
import org.jackzeng.domain.node.Car;
import org.jackzeng.domain.node.Customer;
import org.jackzeng.domain.node.Phone;
import org.jackzeng.domain.node.User;
import org.jackzeng.domain.rel.Have;
import org.jackzeng.domain.rel.HaveDynamic;
import org.jackzeng.repository.HaveDynamicRepository;
import org.jackzeng.repository.HaveRepository;
import org.jackzeng.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class TestController {
    @Autowired
    private HaveDynamicRepository haveDynamicRepository;

    @Autowired
    private HaveRepository haveRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/create")
    public void dynamicTest() throws Exception {
        Customer customer = new Customer();
        customer.setName("John");
        Car car = new Car();
        car.setBrand("Benz");

        HaveDynamic<Customer, Car> haveDynamic = new HaveDynamic<>();
        haveDynamic.setCreateTime(LocalDateTime.now().toString());
        haveDynamic.setStartNode(customer);
        haveDynamic.setEndNode(car);

        haveDynamicRepository.save(haveDynamic);

    }

    @GetMapping("/create2")
    public void customerHaveCarTest() throws Exception {
        Customer customer = new Customer();
        customer.setName("Tom");
        Car car = new Car();
        car.setBrand("BMW");

        Have have = new Have();
        have.setCustomer(customer);
        have.setCar(car);
        have.setCreateTime(LocalDateTime.now().toString());

        haveRepository.save(have);

    }

    @GetMapping("/create3")
    public void userOwnPhoneTest() throws Exception {
        Phone phone = new Phone();
        phone.setPhoneNo("13800123456");

        User user = new User();
        user.setName("Jack");
        user.setPhones(Lists.newArrayList(phone));

        userRepository.save(user);

    }

}
