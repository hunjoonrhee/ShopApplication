import model.Order;
import model.Product;
import repo.OrderRepo;
import repo.ProductRepo;
import service.ShopService;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product("1", "iphone 14");
        ProductRepo productRepo = new ProductRepo();
        productRepo.add(product1);

        Product product2 = new Product("2", "iphone 13");
        Order order2 = new Order(product2.getId(), product2);

        ShopService shopService = new ShopService(productRepo);
        shopService.addOrder(order2);


    }
}
