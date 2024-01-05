package clothes.management.system;

import clothes.management.system.Product;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
//import java.util.LocalDateTime;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author a
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 4352509969366909146L;
    private static int currentOrderId = 0;
    private int orderId;
    private double totalAmount;
    public int rating;
    private LocalDate OrderDate;
    private Customer c;

    static ArrayList<Order> orders = Order.readProductCartfromfile();
    HashMap<Integer, Integer> productCart = new HashMap<>();

    public Order() {

    }

    public Order(int orderId, Customer customerName) {
        this.orderId = orderId;
        this.totalAmount = 0;
        this.rating = 0;
        this.c = customerName;
       

    }

    
    // A method to generate a new order id
   
    public Customer getC() {
        return c;
    }

    public void setC(Customer c) {
        this.c = c;
    }
    

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDate getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(LocalDate OrderDate) {
        this.OrderDate = OrderDate;
    }

    public LocalDateTime date() {
        LocalDateTime date = LocalDateTime.now();
        return date;
    }

    public LocalDate getDate() {
        // Get the current date from the system clock
        LocalDate date = LocalDate.now();
        // Return the date
        return date;
    }

    public String getDateAndTime() {
        // Get the current date and time from the system clock
        LocalDateTime date = LocalDateTime.now();
        // Get the date part as a LocalDate object
        LocalDate datePart = date.toLocalDate();
        // Get the time part as a LocalTime object
        LocalTime timePart = date.toLocalTime();
        // Truncate the time to minutes
        timePart = timePart.truncatedTo(ChronoUnit.MINUTES);
        // Return a String that concatenates the date and the time with a separator
        return datePart + " " + timePart;
    }

    public static void writeordertofile(ArrayList<Order> ProductCart) {
        try {
            FileOutputStream outt = new FileOutputStream("Order.dat");
            ObjectOutputStream out = new ObjectOutputStream(outt);
            out.writeObject(ProductCart);
            out.close();
            outt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ArrayList<Order> readProductCartfromfile() {
        ArrayList<Order> ProductCart = new ArrayList<>();

        try {
            FileInputStream inn = new FileInputStream("Order.dat");
            ObjectInputStream in = new ObjectInputStream(inn);
            ProductCart = (ArrayList<Order>) in.readObject();
            in.close();
            inn.close();
        } catch (Exception e) {
            System.out.println(e);
            return ProductCart;
        }
        return ProductCart;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", totalAmount=" + totalAmount + ", rating=" + rating + ", OrderDate=" + OrderDate  + ", productCart=" + productCart + '}';
    }

}
