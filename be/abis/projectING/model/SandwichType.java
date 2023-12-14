package be.abis.projectING.model;

public class SandwichType {
    private String name;
    private ToppingType toppingType;
    private double price;
    private String description;

    // 2 constructors: 1 with description, 1 without. Description is only used for Special and Veggie
    public SandwichType(String name, String toppingType, double price){
        this.name = name;
        try {
            this.toppingType = ToppingType.valueOf(toppingType.toUpperCase());
        } catch (IllegalArgumentException e){
            System.out.println("Topping type not recognized: " + toppingType);
        }
        this.price = price;
    }
    public SandwichType(String name, String toppingType, double price, String description){
        this(name, toppingType, price);
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ToppingType getToppingType() {
        return toppingType;
    }

    public void setToppingType(ToppingType toppingType) {
        this.toppingType = toppingType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
