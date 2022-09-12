import model.Order;
import model.Product;
import repo.OrderRepo;
import repo.ProductRepo;
import service.ShopService;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // main menu
        mainmenu();

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> validInputs = new ArrayList<>();
        validInputs.add("1");
        validInputs.add("2");
        String input = scanner.nextLine();
        if(!validInputs.contains(input)){
            System.out.println("invalid input!");
        } else{
            switch(input){
                case "1":
                    ProductRepo productRepo = new ProductRepo();
                    ShopService shopService = new ShopService(productRepo);
                    String answer= null;
                    if(shopService.listProducts().isEmpty()){

                        do{
                            System.out.println("Enter a product Id:");
                            String id = scanner.next();
                            System.out.println("Enter a product name:");
                            String name = scanner.next();
                            shopService.addProduct(new Product(id, name));
                            System.out.println("Would you add one more product? y/n");
                            answer= scanner.next();
                        }while(answer.equals("y"));

                    }
                    do{
                        System.out.println("give an order number:");
                        String orderId = scanner.next();
                        System.out.println("Available products are " + shopService.listProducts());
                        System.out.println("select a product id to order:");
                        String productId = scanner.next();
                        try{
                            Product selectedProduct = shopService.getProduct(productId);
                            shopService.addOrder(new Order(orderId, selectedProduct));
                            System.out.println("Orderd product: " + shopService.getOrder(orderId));
                            System.out.println("All ordered products: " + shopService.listOrders());
                        }catch(IllegalArgumentException ex){
                            System.out.println("invalid product id!");
                            break;
                        }
                        System.out.println("Would you order one more product? y/n");
                        answer= scanner.next();
                    }while(answer.equals("y"));
                    mainmenu();
                    input = scanner.next();
                    break;
                case "2":
                    System.out.println("Exit the program");
                    scanner.close();
                    break;
            }
        }
    }

    public static void mainmenu(){
        System.out.println("Main Menu");
        System.out.println("----------------------------------------------");
        System.out.println("1. See all available products and make an order");
        System.out.println("2. Exit");
        System.out.println("----------------------------------------------");
        System.out.println("Please select a number for the menu option");
    }
}
