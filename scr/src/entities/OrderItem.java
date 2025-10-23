package entities;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {
    private Integer quantity;
    private Double price;
    private List<Product> products = new ArrayList<>();

    public OrderItem(){}

    public OrderItem(Integer quantity, Double price){
        this.quantity = quantity;
        this.price = price;
    }

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }
    public void setPrice(Double price){
        this.price = price;
    }
    public Integer getQuantity(){
        return quantity;
    }
    public Double getPrice(){
        return price;
    }
    public Double subTotal(){
        return quantity * price;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProducts(Product product){
        this.products.add(product);
    }

    public String toProd(){
        String names = "";
        Double prices = 0.0;
        for (Product i : products){
          names += i.getName();
          prices += getPrice();
        }
        return names + ", $" + prices + ", Quatity: " + quantity + ", Subtotal: $" + subTotal() + "\n";
    }

}
