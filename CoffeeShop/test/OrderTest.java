import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

public class OrderTest {
    Order order;
    @Before
    public void init(){
        order= new Order("Mocha","Sara", "4a0d78d4-6ab1-4fae-9399-4c89ef25d901");
    }
    @Test
    public void orderShouldAcceptValidValuesToConstructor()
    {
        Assert.assertEquals("Mocha",order.coffeeName);
        Assert.assertEquals("Sara",order.nameOfCustomer);
        Assert.assertEquals("4a0d78d4-6ab1-4fae-9399-4c89ef25d901",order.tokenId);
    }

    @Test
    public void orderShouldFailForInvalidValuesToConstructor()
    {
        Assert.assertNotEquals("Cappuchino",order.coffeeName);
        Assert.assertNotEquals("Jennifer",order.nameOfCustomer);
        Assert.assertNotEquals("Random value",order.tokenId);
    }
}
