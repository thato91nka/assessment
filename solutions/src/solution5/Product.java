package solution5;

import java.util.ArrayList;

/**
 * Created by A222186 on 2018/04/10.
 */
public class Product {

  private double price;
  private int quantity;
  private String id;
  private ArrayList<Product> products = new ArrayList<>();
  private String name;


  public Product(double price, String id, int quantity,String name) {
    this.price = price;
    this.id = id;
    this.quantity = quantity;
    this.name = name;
  }


  public Product() {
    products.add(new Product(10.00, "A1", 10,"Jelly Tots"));
    products.add(new Product(12.00, "B2", 10,"BBQ Chips"));
    products.add(new Product(9.50, "C3", 10,"Chutney Chips"));
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ArrayList<Product> getProducts() {
    return products;
  }

  @Override
  public String toString() {
    return "Product{" +
        "price=" + price +
        ", quantity=" + quantity +
        ", id='" + id + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
