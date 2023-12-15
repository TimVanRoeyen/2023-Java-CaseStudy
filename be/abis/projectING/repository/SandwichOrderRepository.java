package be.abis.projectING.repository;

import be.abis.projectING.model.*;

import java.time.LocalDate;
import java.util.List;

public class SandwichOrderRepository {
    private final CoursesRegistrationsRepository coursesRegistrationsRepository = new CoursesRegistrationsRepository();
    private final SandwichTypeRepository sandwichTypeRepository = new SandwichTypeRepository();
    private final PersonRepository personRepository = new PersonRepository();

    public SandwichOrderRepository(){
        SessionRegistration registrationToManage = coursesRegistrationsRepository.getCourseById(1).getSessionRegistrations().get(0);
        // TODO: Error handling
        registrationToManage.addSandwichToOrder(new SandwichOrder(sandwichTypeRepository.getSandwichTypeByName("ham"),false, BreadType.WHITE, (Participant)personRepository.getPersonList().get(0)));
        registrationToManage.addSandwichToOrder(new SandwichOrder(sandwichTypeRepository.getSandwichTypeByName("zalm"), true, BreadType.GRAY, (Participant)personRepository.getPersonList().get(1)));
    }

    public List<SandwichOrder> getSandwichOrdersForSessionRegistration(int courseId, LocalDate courseDate){
        return coursesRegistrationsRepository.getCourseById(courseId).getSessionRegistrationByDate(courseDate).getOrder().getAllSandwichOrdersForOrder();
    }

    public CoursesRegistrationsRepository getCoursesRegistrationsRepository() {
        return coursesRegistrationsRepository;
    }

    public SandwichTypeRepository getSandwichTypeRepository() {
        return sandwichTypeRepository;
    }
}
