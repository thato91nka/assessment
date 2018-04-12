package solution5;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Controller {

  private Double amountReceived;
  private String productID;
  private Product product;
  private ArrayList<Product> products;
  private double change;
  private NumberFormat formatter = NumberFormat.getCurrencyInstance();

  public Controller() {
    product = new Product();
    products=product.getProducts();
  }

  public void acceptOrder(String productID){
    this.productID=productID;
  }


  public void dispenseProduct() {
    int i = products.indexOf(product);
    Product product = products.get(i);
    int quantity =product.getQuantity();
    if(quantity>0){
      System.out.println("Please take your order");
      quantity=quantity-1;
      product.setQuantity(quantity);
    }
    else{
      System.out.println("Product selected is unavailable.");
      System.exit(0);
    }
  }


  public void checkValidityProduct() {
    Stream stream = products.stream();
    Predicate<Product> predicate = p -> productID.equals(p.getId());
    if (stream.anyMatch(predicate)) {
      product = (Product) products.stream().filter(predicate).findFirst().get();
    } else {
      System.out.println("You have entered an invalid option");
      System.exit(0);

    }
  }

  public void comparePrice(Double amount) {
    if (amount < product.getPrice()) {
      System.out.println("There is not enough money provided for the purchase, please try again.");
      System.exit(0);
    }
    change = amount - product.getPrice();
  }

  public void getChange() {
    System.out.println("Your change is :" +formatter.format(change));
  }

  public void displayProducts(){
    for(Product product:products){
      System.out.println(product.toString());
    }
  }
}
