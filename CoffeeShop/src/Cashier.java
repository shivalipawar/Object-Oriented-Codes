import java.util.*;

public class Cashier {
    Map<Double, String> menuCard;
    Order order;
    Queue<Order> orderQueue;
    Barista barista;
    Customer customer;

    public Cashier() {
        orderQueue =new PriorityQueue<>();
        barista=new Barista();
        menuCard = new HashMap<>();
        menuCard.put(30.0, "Cold Coffee");
        menuCard.put(45.0, "Mocha");
        menuCard.put(55.0, "Irish Coffee");
        menuCard.put(60.0, "Cad B");
    }

    public String takeOrder(Double cash, String customerName) {
        customer =new Customer();
        String tokenId = getTokenId();
        placeOrder(menuCard.get(cash), customerName, tokenId);
        return tokenId;
    }

    private String getTokenId() {
        String tokenNo = UUID.randomUUID().toString();
        return tokenNo;
    }

    private void placeOrder(String coffeeName, String nameOfCustomer, String tokenId) {
        order=new Order(coffeeName, nameOfCustomer, tokenId);
        orderQueue.add(order);
        customer.waitForCoffee(true);
        barista.ordersToProcess(orderQueue);
    }
}