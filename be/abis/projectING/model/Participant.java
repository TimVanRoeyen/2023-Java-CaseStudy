package be.abis.projectING.model;

public class Participant extends Person{
    public Participant(String name){
        super(name);
    }
    public void orderSandwich(SessionRegistration s, boolean vegetables, String remark, SandwichType sandwichType, BreadType breadType){
        SandwichOrder so = new SandwichOrder(sandwichType, vegetables, breadType, remark);
        s.addSandwichToOrder(so);
    }
}
