package repo;

import model.Order;
import model.Product;

import java.util.HashMap;
import java.util.Map;

public class OrderRepo {
    private Map<String, Order> orders = new HashMap<>();

    public OrderRepo() {
    }

    public void add(Order order){
        orders.put(order.getId(), order);
    }

    //    list()
    public Map<String, Order> list(){
        return orders;
    }

    //    get()
    public Order get(String id){
        return orders.get(id);
    }
}
