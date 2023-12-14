package be.abis.projectING.repository;

import be.abis.projectING.model.Participant;
import be.abis.projectING.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    private List<Person> personList;

    public PersonRepository(){
        personList = new ArrayList<>();
        Person p1 = new Participant("Tim");
        Person p2 = new Participant("Patrick");
        Person p3 = new Participant("Annick");
        Person p4 = new Participant("Sandy");
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
