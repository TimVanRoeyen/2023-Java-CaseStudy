package be.abis.projectING.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private int id;
    private SessionRegistration sessionRegistration;
    private List<SandwichOrder> sandwichOrderList;

    public Order(SessionRegistration sessionRegistration){
        this.sessionRegistration = sessionRegistration;
        sandwichOrderList = new ArrayList<>();
    }

    public void addSandwichOrderToOrder(SandwichOrder sandwichOrder){
        this.sandwichOrderList.add(sandwichOrder);
    }

    public double calculateOrderPrice() {
        return sandwichOrderList.stream()
                .mapToDouble(SandwichOrder::calculatePrice)
                .sum();
    }

    public List<SandwichOrder> getAllSandwichOrdersForOrder() {
        return sandwichOrderList;
    }
}
