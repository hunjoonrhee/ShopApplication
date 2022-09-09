package repo;

import model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepo {
    private Map<String, Product> products = new HashMap<>();

    public ProductRepo() {
    }

    public void add(Product product){
        products.put(product.getId(), product);
    }

//    list()
    public Map<String, Product> list(){
        return products;
    }

//    get()
    public Product get(String id){
        return products.get(id);
    }



}
