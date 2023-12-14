package be.abis.projectING.repository;

import be.abis.projectING.model.*;

import java.time.LocalDate;
import java.util.List;

public class SandwichOrderRepository {
    private final CoursesRegistrationsRepository coursesRegistrationsRepository = new CoursesRegistrationsRepository();
    private final SandwichTypeRepository sandwichTypeRepository = new SandwichTypeRepository();

    public SandwichOrderRepository(){
        SessionRegistration registrationToManage = coursesRegistrationsRepository.getCourseById(1).getSessionRegistrations().get(0);
        registrationToManage.addSandwichToOrder(new SandwichOrder(sandwichTypeRepository.getSandwichTypeByName("ham"),false, BreadType.WHITE));
        registrationToManage.addSandwichToOrder(new SandwichOrder(sandwichTypeRepository.getSandwichTypeByName("zalm"), true, BreadType.GRAY));
    }

    public List<SandwichOrder> getSandwichOrdersForSessionRegistration(int courseId, LocalDate courseDate){
        return coursesRegistrationsRepository.getCourseById(courseId).getSessionRegistrationByDate(courseDate).getOrder().getAllSandwichOrdersForOrder();
    }

}
