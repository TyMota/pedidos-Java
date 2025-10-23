package entities;

import entities.enums.OrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;
    private List<OrderItem> item = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

    public Order(){}

    public Order(Date moment, OrderStatus status){
        this.moment = moment;
        this.status = status;
    }

    public void setMoment(Date moment){
        this.moment = moment;
    }
    public void setStatus(OrderStatus status){
        this.status = status;
    }
    public Date getMoment(){
        return moment;
    }
    public OrderStatus getStatus(){
        return status;
    }
    public List<OrderItem> getItem() {
        return item;
    }
    public void setItem(List<OrderItem> item) {
        this.item = item;
    }

    public void addItem(OrderItem item){
        this.item.add(item);
    }
    public void removeItem(OrderItem item) {
        this.item.remove(item);
    }
    public Double total(){
        double sum = 0;
        for (OrderItem i: item){
            sum += i.subTotal();
        }
        return sum;
    }
}
