package service;

import model.Order;
import model.Product;
import repo.OrderRepo;
import repo.ProductRepo;

import java.util.Map;

public class ShopService {
    private ProductRepo productRepo;
    private OrderRepo orderRepo = new OrderRepo();


    public ShopService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public void addProduct(Product product){
        productRepo.add(product);
    }

    public Product getProduct(String id){
        if(!productRepo.list().containsKey(id)){
            throw new IllegalArgumentException("Ungültige ID. Es gibt kein Produkt mit der ID " + id);
        }
        return productRepo.get(id);
    }

    public Map<String, Product> listProducts(){
        return productRepo.list();
    }

    public void addOrder(Order order){
        if(!productRepo.list().containsKey(order.getProduct().getId())){
            throw new IllegalArgumentException("Das Produkt: " + order.getProduct() + " gibt es nicht in der Produktliste.");
        }
        orderRepo.add(order);
    }

    public Order getOrder(String id){
        if(!orderRepo.list().containsKey(id)){
            throw new IllegalArgumentException("Ungültige ID. Es gibt kein Produkt mit der ID " + id);
        }
        return orderRepo.get(id);
    }

    public Map<String, Order> listOrders(){
        return orderRepo.list();
    }

}
