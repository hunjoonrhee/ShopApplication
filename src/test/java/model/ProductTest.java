package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test

    void getId_ShouldReturnId_IdOfProduct_ForTrue(){
        // GIVEN
        Product product1 = new Product("1", "iphone 14", 899.9);

        // WHEN
        String actual = product1.getId();

        // THEN
        assertEquals("1", actual);
    }
    @Test
    void getId_ShouldReturnId_IdOfProduct_ForFalse(){
        // GIVEN
        Product product1 = new Product("1", "iphone 14", 899.9);

        // WHEN
        String actual = product1.getId();

        // THEN
        assertFalse("2".equals(actual));
    }

    @Test

    void getName_ShouldReturnName_NameOfProduct_ForTrue(){
        // GIVEN
        Product product1 = new Product("1", "iphone 14", 899.9);

        // WHEN
        String actual = product1.getName();

        // THEN
        assertEquals("iphone 14", actual);
    }
    @Test
    void getName_ShouldReturnName_NameOfProduct_ForFalse(){
        // GIVEN
        Product product1 = new Product("1", "iphone 14", 899.9);

        // WHEN
        String actual = product1.getName();

        // THEN
        assertFalse("iphone 13".equals(actual));
    }


}