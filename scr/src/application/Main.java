package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter ftm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter cliente data: ");

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Birth date (DD/MM/YYYY): ");
        String birthDate = sc.nextLine();
        LocalDate date = LocalDate.parse(birthDate, ftm);

        Client client = new Client(name, email, date);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine());

        LocalDateTime moment = LocalDateTime.now();

        Order order = new Order(moment, status);

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            System.out.println("Enter #" + (i + 1) + " item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String nameProd = sc.nextLine();

            System.out.print("Product price: ");
            Double priceProd = sc.nextDouble();

            System.out.print("Quantity: ");
            Integer quantityProd = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantityProd, priceProd);
            Product product = new Product(nameProd, priceProd);
            order.addItem(orderItem);
            orderItem.addProducts(product);
        }

        System.out.println("ORDER SUMMARY:");
        System.out.println("Order moment: " + order.getMoment());
        System.out.println("Order status: " + order.getStatus());
        System.out.println("Client: " + client.getName() + " (" + client.getBirthDate() + ")" + " - " + client.getEmail());

        System.out.println(order.toString());






        sc.close();

    }
}
