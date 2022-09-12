package repo;

import model.Product;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {
    @Test
    void add_ShouldIncreaseLengthOfHashMap_ByOne() {
        // GIVEN
        ProductRepo productRepo = new ProductRepo();
        Product product1 = new Product("1", "iphone 14");
        productRepo.add(product1);
        int previousLength = productRepo.list().size();

        // WHEN
        Product productToAdd = new Product("2", "iphone 12");
        productRepo.add(productToAdd);
        int newLength = productRepo.list().size();

        // THEN
        assertEquals(previousLength+1, newLength);
    }


    @Test
    void list_ShouldReturn_AllProducts_ForTrue() {
        // GIVEN
        Product product1 = new Product("1", "iphone 14");
        Product product2 = new Product("2", "iphone 12");
        Product product3 = new Product("3", "iphone 11");

        ProductRepo productRepo = new ProductRepo();
        productRepo.add(product1);
        productRepo.add(product2);
        productRepo.add(product3);

        // WHEN
        Map<String, Product> actual = productRepo.list();

        // THEN
        String expected = "{1=Product{id='1', name='iphone 14'}, 2=Product{id='2', name='iphone 12'}, 3=Product{id='3', name='iphone 11'}}";
        assertEquals(expected, actual.toString());
    }
    @Test
    void list_ShouldReturn_AllProducts_ForFalse() {
        // GIVEN
        Product product1 = new Product("1", "iphone 14");
        Product product2 = new Product("2", "iphone 12");
        Product product3 = new Product("3", "iphone 11");

        ProductRepo productRepo = new ProductRepo();
        productRepo.add(product1);
        productRepo.add(product2);
        productRepo.add(product3);

        // WHEN
        Map<String, Product> actual = productRepo.list();

        // THEN
        String expected = "{1=Product{id='1', name='iphone 14'}, 2=Product{id='2', name='iphone 12'}, 3=Product{id='3', name='iphone 10'}}";
        assertFalse(expected.equals(actual.toString()));
    }

    @Test
    void get_ShouldReturn_ProductByGivenId_ForTure() {
        // GIVEN
        Product product1 = new Product("1", "iphone 14");
        Product product2 = new Product("2", "iphone 12");
        Product product3 = new Product("3", "iphone 11");

        ProductRepo productRepo = new ProductRepo();
        productRepo.add(product1);
        productRepo.add(product2);
        productRepo.add(product3);

        // WHEN
        Product actual = productRepo.get("1");

        // THEN
        String expected = "Product{id='1', name='iphone 14'}";
        assertEquals(expected, actual.toString());
    }
    @Test
    void get_ShouldReturn_ProductByGivenId_ForFalse() {
        // GIVEN
        Product product1 = new Product("1", "iphone 14");
        Product product2 = new Product("2", "iphone 12");
        Product product3 = new Product("3", "iphone 11");

        ProductRepo productRepo = new ProductRepo();
        productRepo.add(product1);
        productRepo.add(product2);
        productRepo.add(product3);

        // WHEN
        Product actual = productRepo.get("1");

        // THEN
        String expected = "Product{id='2', name='iphone 12'}";
        assertFalse(expected.equals(actual.toString()));
    }
}