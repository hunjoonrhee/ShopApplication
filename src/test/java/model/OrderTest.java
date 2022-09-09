package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    void getProduct_ShouldReturn_OrderedProduct_ForTure(){
        // GIVEN
        Product product1 = new Product("1", "iphone 14");
        Order order = new Order("1", product1);

        // WHEN
        Product actual = order.getProduct();

        // THEN
        String expectedToStringOfProduct = product1.toString();
        assertEquals(expectedToStringOfProduct, actual.toString());
    }

    @Test
    void getProduct_ShouldReturn_OrderedProduct_ForFalse(){
        // GIVEN
        Product product1 = new Product("1", "iphone 14");
        Order order = new Order("1", product1);

        // WHEN
        Product actual = order.getProduct();

        // THEN
        String expectedToStringOfProduct = "Product{" +
                "id='" + "2" + '\'' +
                ", name='" + "iphone 13" + '\'' +
                '}';
        assertFalse(expectedToStringOfProduct.equals(actual.toString()));
    }
}