public class Customer {
    Cashier cashier;

    public Customer() {
        cashier = new Cashier();
    }

    public void giveOrderToCashier(Double priceOfCoffee,String name){
        cashier.takeOrder(priceOfCoffee,name);
    }

    public boolean waitForCoffee(boolean shouldWait) {
        return shouldWait;
    }

    public boolean canCollectCoffee(boolean canCollect) {
        return canCollect;
    }

}
