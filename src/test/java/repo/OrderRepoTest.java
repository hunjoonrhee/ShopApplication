package repo;

import model.Order;
import model.Product;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {

    @Test
    void add_ShouldIncreaseLengthOfHashMap_ByOne() {
        // GIVEN
        OrderRepo orderRepo = new OrderRepo();
        Product product = new Product("1", "iphone 14", 899.9);
        Order order1 = new Order("1", product);
        orderRepo.add(order1);
        int previousLength = orderRepo.list().size();

        // WHEN
        Product product2 = new Product("2", "iphone 12", 699.9);
        Order order2 = new Order("2", product2);
        orderRepo.add(order2);
        int newLength = orderRepo.list().size();

        // THEN
        assertEquals(previousLength+1, newLength);
    }

    @Test
    void list_ShouldReturn_AllProducts_ForTrue() {
        // GIVEN
        OrderRepo orderRepo = new OrderRepo();
        Product product = new Product("1", "iphone 14", 899.9);
        Order order1 = new Order("1", product);
        orderRepo.add(order1);

        // WHEN
        Map<String, Order> actual = orderRepo.list();

        // THEN
        String expected = "{1=Order{id='1', product=Product{id='1', name='iphone 14', price=899.9}}}";
        assertEquals(expected, actual.toString());
    }
    @Test
    void list_ShouldReturn_AllProducts_ForFalse() {
        // GIVEN
        OrderRepo orderRepo = new OrderRepo();
        Product product = new Product("1", "iphone 14", 899.9);
        Order order1 = new Order("1", product);
        orderRepo.add(order1);

        // WHEN
        Map<String, Order> actual = orderRepo.list();

        // THEN
        String expected = "{1=Order{id='1', product=Product{id='2', name='iphone 14'}}}";
        assertFalse(expected.equals(actual.toString()));
    }

    @Test
    void get_ShouldReturn_ProductByGivenId_ForTure() {
        // GIVEN
        OrderRepo orderRepo = new OrderRepo();
        Product product = new Product("1", "iphone 14", 899.9);
        Order order1 = new Order("1", product);
        orderRepo.add(order1);

        // WHEN
        Order actual = orderRepo.get(order1.getId());

        // THEN
        String expected = "Order{id='1', product=Product{id='1', name='iphone 14', price=899.9}}";
        assertEquals(expected, actual.toString());
    }
    @Test
    void get_ShouldReturn_ProductByGivenId_ForFalse() {
        // GIVEN
        OrderRepo orderRepo = new OrderRepo();
        Product product = new Product("1", "iphone 14", 899.9);
        Order order1 = new Order("1", product);
        orderRepo.add(order1);

        // WHEN
        Order actual = orderRepo.get(order1.getId());

        // THEN
        String expected = "Order{id='1', product=Product{id='2', name='iphone 14'}}";
        assertFalse(expected.equals(actual.toString()));
    }
}