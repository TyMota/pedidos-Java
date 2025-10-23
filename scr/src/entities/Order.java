package entities;

import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDateTime moment;
    private OrderStatus status;
    private List<OrderItem> item = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

    public Order(){}

    public Order(LocalDateTime moment, OrderStatus status){
        this.moment = moment;
        this.status = status;
    }

    public void setMoment(LocalDateTime moment){
        this.moment = moment;
    }
    public void setStatus(OrderStatus status){
        this.status = status;
    }
    public String getMoment(){
        DateTimeFormatter ftm1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return moment.format(ftm1);
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
