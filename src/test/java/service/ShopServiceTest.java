package service;

import model.Order;
import model.Product;
import org.junit.jupiter.api.Test;
import repo.OrderRepo;
import repo.ProductRepo;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {
    @Test
    void getProduct_ShouldReturn_ProductOfGivenId_ForTrue(){
        //GIVEN
        Product product1 = new Product("1", "iphone 14", 899.9);
        ProductRepo productRepo = new ProductRepo();
//        productRepo.add(product1);


        ShopService shopService = new ShopService(productRepo);
        shopService.addProduct(product1);

        // WHEN
        Product actual = shopService.getProduct(product1.getId());

       // THEN
        Product expectedProduct = productRepo.get(product1.getId());

//        assertTrue(expectedProduct.equals(actual));
        //Using AssertJ
        assertThat(expectedProduct).isEqualTo(actual);
    }

    @Test
    void getProduct_ShouldReturn_ProductOfGivenId_ForFalse(){
        //GIVEN
        Product product1 = new Product("1", "iphone 14", 899.9);
        Product product2 = new Product("2", "iphone 13", 799.9);
        ProductRepo productRepo = new ProductRepo();
        productRepo.add(product1);
        productRepo.add(product2);


        ShopService shopService = new ShopService(productRepo);
        shopService.addProduct(product1);

        // WHEN
        Product actual = shopService.getProduct(product1.getId());

        // THEN
        Product expectedProduct = productRepo.get(product2.getId());

        assertFalse(expectedProduct.equals(actual));
    }

    @Test
    void addOrder_ShouldThrowException_WhenAWrongProductOrdered(){
        //GIVEN
        Product product1 = new Product("1", "iphone 14", 899.9);
        Product product2 = new Product("2", "iphone 13", 799.9);
        ProductRepo productRepo = new ProductRepo();
        productRepo.add(product1);

        ShopService shopService = new ShopService(productRepo);
        //WHEN
        try{
            Order order2 = new Order("2", product2);
            shopService.addOrder(order2);
            fail();
            //THEN
        }catch(IllegalArgumentException e){}

    }

    @Test
    void addOrder_ShouldContain_AddedOrder(){
        //GIVEN
        Product product1 = new Product("1", "iphone 14", 899.9);
        Product product2 = new Product("2", "iphone 13", 799.9);
        ProductRepo productRepo = new ProductRepo();

        ShopService shopService = new ShopService(productRepo);
        shopService.addProduct(product1);
        shopService.addProduct(product2);

        //WHEN
        Order order2 = new Order("2", product2);
        shopService.addOrder(order2);

        //THEN
        assertThat(shopService.listOrders())
                .isNotEmpty().containsKey(order2.getId())
                .doesNotContainKey("1");



    }

}