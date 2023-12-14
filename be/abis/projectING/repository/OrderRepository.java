package be.abis.projectING.repository;

import be.abis.projectING.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private List<Order> orderList;
    private final CoursesRegistrationsRepository coursesRegistrationsRepository = new CoursesRegistrationsRepository();

    public OrderRepository(){
        this.orderList = new ArrayList<>();
        Order o1 = new Order(coursesRegistrationsRepository.getSessionRegistrationsForCourse(1).get(0));
        orderList.add(o1);
        Order o2 = new Order(coursesRegistrationsRepository.getSessionRegistrationsForCourse(2).get(0));
        orderList.add(o2);
        Order o3 = new Order(coursesRegistrationsRepository.getSessionRegistrationsForCourse(2).get(1));
        orderList.add(o3);
    }
}
