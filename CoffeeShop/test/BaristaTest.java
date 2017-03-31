import org.junit.Before;
import org.junit.Test;
import java.util.PriorityQueue;
import java.util.Queue;

public class BaristaTest {
    Queue<Order> orderQueue =new PriorityQueue<>();
    Order order;
    @Before
    public void init() {
        order = new Order("Mocha","Sara","4a0d78d4-6ab1-4fae-9399-4c89ef25d901");
        orderQueue.add(order);
    }
    @Test
    public void testShouldPassWhenOrderInQueueisProcessed()
    {

    }
}
