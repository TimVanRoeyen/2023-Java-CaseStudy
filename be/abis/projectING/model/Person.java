package be.abis.projectING.model;
import java.util.*;

public abstract class Person {
    private String name;

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
