package be.abis.projectING.model;

public class SandwichOrder {
    private int id;
    private String remark;
    private BreadType breadType;
    private boolean vegetables;
    private SandwichType sandwichType;
    private Participant participant;

    public SandwichOrder(SandwichType sandwichType, boolean vegetables, BreadType breadType, String remark, Participant p) {
        this.sandwichType = sandwichType;
        this.vegetables = vegetables;
        this.breadType = breadType;
        this.remark = remark;
        this.participant = p;
    }
    public SandwichOrder(SandwichType sandwichType, boolean vegetables, BreadType breadType, Participant p) {
        this(sandwichType, vegetables, breadType, "No remarks", p);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public boolean vegetables() {
        return vegetables;
    }

    public void setVegetables(boolean vegetables) {
        this.vegetables = vegetables;
    }

    public SandwichType getSandwichType() {
        return sandwichType;
    }

    public void setSandwichType(SandwichType sandwichType) {
        this.sandwichType = sandwichType;
    }

    public Participant getP() {
        return participant;
    }

    public void setP(Participant p) {
        this.participant = p;
    }

    public double calculatePrice(){
        if(vegetables) return (sandwichType.getPrice() +1); else return sandwichType.getPrice();
    }
}
