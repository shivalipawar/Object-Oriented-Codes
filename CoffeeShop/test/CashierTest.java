import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CashierTest {

    Cashier cashier;
    Customer customer;
    Map<Double,String> menuCard;
    @Before
    public void init(){
        cashier =new Cashier();
        customer=new Customer();
        menuCard=new HashMap<>();
        menuCard.put(30.0,"Cold Coffee");
        menuCard.put(45.0,"Mocha");
        menuCard.put(55.0,"Irish Coffee");
        menuCard.put(60.0,"Cad B");
    }

    @Test
    public void testShouldReturnAppropriateNameOfCoffeeWhenMoneyPassed(){
        Assert.assertEquals("Cold Coffee",cashier.menuCard.get(30.0));
        Assert.assertEquals("Mocha",cashier.menuCard.get(45.0));
    }

    @Test
    public void testShouldReturnAppropriateOrderIdForGivenOrder(){
        Assert.assertEquals(UUID.randomUUID().toString(),cashier.takeOrder(30.0,"Sara"));
    }

    @Test
    public void waitForCoffeeShouldPassIfReturnedTrue(){
        Assert.assertEquals(true,customer.waitForCoffee(true));
    }
    @Test
    public void collectForCoffeeShouldPassIfReturnedTrue(){
        Assert.assertEquals(true,customer.canCollectCoffee(true));
    }
}
