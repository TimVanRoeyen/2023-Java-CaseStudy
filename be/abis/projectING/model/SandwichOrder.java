package be.abis.projectING.model;

public class SandwichOrder {
    private int id;
    private String remark;
    private BreadType breadType;
    private boolean vegetables;
    private SandwichType sandwichType;
    private Participant p;

    public SandwichOrder(SandwichType sandwichType, boolean vegetables, BreadType breadType, String remark) {
        this.sandwichType = sandwichType;
        this.vegetables = vegetables;
        this.breadType = breadType;
        this.remark = remark;
    }
    public SandwichOrder(SandwichType sandwichType, boolean vegetables, BreadType breadType) {
        this(sandwichType, vegetables, breadType, "No remarks");
    }

    public double calculatePrice(){
        if(vegetables) return (sandwichType.getPrice() +1); else return sandwichType.getPrice();
    }
}
