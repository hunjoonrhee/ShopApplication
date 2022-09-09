package service;

import model.Order;
import model.Product;
import repo.OrderRepo;
import repo.ProductRepo;

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
        return productRepo.get(id);
    }

    public void listProducts(){
        productRepo.list();
    }

    public void addOrder(Order order){
        if(!productRepo.list().containsKey(order.getProduct().getId())){
            throw new IllegalArgumentException("Das Produkt: " + order.getProduct() + " gibt es nicht in der Produktliste.");
        }
        orderRepo.add(order);
    }

    public void getOrder(String id){
        orderRepo.get(id);
    }

    public void listOrder(){
        orderRepo.list();
    }

}
