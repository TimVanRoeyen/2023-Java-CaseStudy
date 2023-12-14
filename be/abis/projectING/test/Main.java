package be.abis.projectING.test;

import be.abis.projectING.repository.CoursesRegistrationsRepository;
import be.abis.projectING.repository.SandwichOrderRepository;
import be.abis.projectING.repository.SandwichTypeRepository;

// Main class to aggregate all repositories to run a 'happy flow' when possible
public class Main {
    public static void main(String[] args) {
        SandwichOrderRepository sandwichOrderRepository = new SandwichOrderRepository();
    }
}
