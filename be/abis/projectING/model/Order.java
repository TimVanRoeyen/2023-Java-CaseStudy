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

    public String printSandwichOrderInPrettyFormat(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%10s%-30s%10s\n", " ", "Sandwiches for course " + sessionRegistration.getCourse().getName() + " on date " + sessionRegistration.getSessionRegistrationDate().toString(), " "));
        for(int i = 0; i < 50; i++){
            sb.append("-");
        }
        sb.append("\n");
        for(SandwichOrder so:sandwichOrderList){
            sb.append(String.format("Order for %s: %s, %s vegetables, %s bread. Price is %.2f.%n", so.getP().getName(), so.getSandwichType().getName(), so.vegetables() ? "with":"without", so.getBreadType().name().toLowerCase(), so.calculatePrice()));
        }
        sb.append(String.format("Total price of order: %.2f", (Double) sandwichOrderList.stream().mapToDouble(SandwichOrder::calculatePrice).sum()));
        return sb.toString();
    }
}
