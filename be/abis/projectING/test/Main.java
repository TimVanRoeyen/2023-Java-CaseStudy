package be.abis.projectING.test;

import be.abis.projectING.model.Order;
import be.abis.projectING.repository.CoursesRegistrationsRepository;
import be.abis.projectING.repository.OrderRepository;
import be.abis.projectING.repository.SandwichOrderRepository;
import be.abis.projectING.repository.SandwichTypeRepository;

import java.time.LocalDate;

// Main class to aggregate all repositories to run a 'happy flow' when possible
public class Main {
    public static void main(String[] args) {
        SandwichOrderRepository sandwichOrderRepository = new SandwichOrderRepository();
        Order order = sandwichOrderRepository.getCoursesRegistrationsRepository().getCourseById(1).getSessionRegistrationByDate(LocalDate.of(2023,10,1)).getOrder();
        // Print sandwich order as admin in pretty format:
        System.out.println(order.printSandwichOrderInPrettyFormat());

        // Print list of sandwich types, remove one type, then print list again
        System.out.println("Printing list of sandwich types");
        System.out.println(sandwichOrderRepository.getSandwichTypeRepository().getOverviewOfSandwichTypes());
        sandwichOrderRepository.getSandwichTypeRepository().removeSandwichTypeByName("ham");
        System.out.println("Printing list again after removing ham");
        System.out.println(sandwichOrderRepository.getSandwichTypeRepository().getOverviewOfSandwichTypes());
        sandwichOrderRepository.getSandwichTypeRepository().addSandwichTypeWithDescription("parmaham", "SPECIAAL", 6.6, "Gemaakt met echte ham");
        System.out.println("Printing list again after adding parmaham");
        System.out.println(sandwichOrderRepository.getSandwichTypeRepository().getOverviewOfSandwichTypes());
    }
}
