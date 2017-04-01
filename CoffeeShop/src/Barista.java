import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Barista {
    Queue<Order> completedOrders = new PriorityQueue<>();
    Customer customer ;

    public void ordersToProcess(Queue<Order> orderQueue) {
        Iterator iterator=orderQueue.iterator();
        boolean isCoffeePrepared=false;
        while (iterator.hasNext()) {
            Order currentOrder =orderQueue.poll();
            try {
                 isCoffeePrepared=prepareCoffee(currentOrder);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (isCoffeePrepared){
                completedOrders.add(currentOrder);
                notifyCustomer(currentOrder);
            }
        }
    }

    private void notifyCustomer(Order currentOrder) {
        customer=new Customer();
        System.out.println(currentOrder.nameOfCustomer+" can collect his coffee.");
        if (currentOrder==completedOrders.poll()) {
            customer.canCollectCoffee(true);
        }
        else {
            customer.canCollectCoffee(false);
        }
    }

    private boolean prepareCoffee(Order currentOrder) throws InterruptedException {
        System.out.println(currentOrder.nameOfCustomer+" has asked for "+currentOrder.coffeeName+". So Please wait for 10 minutes ");   //I can add threading here.
        Thread.sleep(2000);
        System.out.println("Coffee Prepared!!! Ready To Serve");
        return true;
    }
}
