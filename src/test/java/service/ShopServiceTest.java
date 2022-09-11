package service;

import model.Order;
import model.Product;
import org.junit.jupiter.api.Test;
import repo.OrderRepo;
import repo.ProductRepo;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {
    @Test
    void getProduct_ShouldReturn_ProductOfGivenId_ForTrue(){
        //GIVEN
        Product product1 = new Product("1", "iphone 14");
        ProductRepo productRepo = new ProductRepo();
//        productRepo.add(product1);


        ShopService shopService = new ShopService(productRepo);
        shopService.addProduct(product1);

        // WHEN
        Product actual = shopService.getProduct(product1.getId());

       // THEN
        Product expectedProduct = productRepo.get(product1.getId());

        assertTrue(expectedProduct.equals(actual));
    }

    @Test
    void getProduct_ShouldReturn_ProductOfGivenId_ForFalse(){
        //GIVEN
        Product product1 = new Product("1", "iphone 14");
        Product product2 = new Product("2", "iphone 13");
        ProductRepo productRepo = new ProductRepo();

        ShopService shopService = new ShopService(productRepo);
        shopService.addProduct(product1);

        // WHEN
        Product actual = shopService.getProduct(product1.getId());

        // THEN
        Product expectedProduct = product2;

        assertFalse(expectedProduct.equals(actual));
    }

    @Test
    void addOrder_ShouldThrowException_WhenAWrongProductOrdered(){
        //GIVEN
        Product product1 = new Product("1", "iphone 14");
        Product product2 = new Product("2", "iphone 13");
        ProductRepo productRepo = new ProductRepo();

        ShopService shopService = new ShopService(productRepo);
        shopService.addProduct(product1);
        //WHEN
        try{
            Order order2 = new Order(product2.getId(), product2);
            shopService.addOrder(order2);
            fail();
            //THEN
        }catch(IllegalArgumentException e){}

    }

}