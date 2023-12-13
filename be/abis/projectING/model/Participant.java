package be.abis.projectING.model;

public class Participant extends Person{
    public Participant(String name){
        super(name);
    }
    public void orderSandwich(SessionRegistration s, SandwichOrder o, boolean vegetables, String remark, SandwichType sandwichType, BreadType breadType){
        SandwichOrder so = new SandwichOrder();
        s.addSandwichToOrder(o);
    }
}
