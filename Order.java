


package clothes.management.system;
import clothes.management.system.Product;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
//import java.util.LocalDateTime;
import java.util.HashMap;
import java.time.LocalDateTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a
 */

public class Order{
   private int orderId;
     private double totalAmount;
     public int rating; 
     private Date OrderDate;
   private Customer c;
   
   ArrayList<Product> productCart = new ArrayList<>();
   ArrayList<Order> orders = new ArrayList<>();
     //ArrayList<ArrayList<Product>>ProductCart= new ArrayList<ArrayList<Order>>();
    
    public Order() {
        
    }
    public Order(int orderId, double totalAmount, int rating, String customerName) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.rating = rating;
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

    public void setOrderDate(Date OrderDate) {
        this.OrderDate = OrderDate;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    
    public LocalDateTime date(){
    LocalDateTime date = LocalDateTime.now();
    return date;
    }
      
    void displayOrderDetails(Order order){
    System.out.println("Order date: " + date());
    System.out.println("Order Id" + orderId);
    System.out.println("Total Amount" + totalAmount);

}
    
    public static void writeProductCarttofile(ArrayList<Product> ProductCart) {
        try {
            FileOutputStream outt = new FileOutputStream("ProductCart.dat");
            ObjectOutputStream out = new ObjectOutputStream(outt);
            out.writeObject(ProductCart);
            out.close();
            outt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ArrayList<Product> readProductCartfromfile() {
        ArrayList<Product> ProductCart = new ArrayList<>();

        try {
            FileInputStream inn = new FileInputStream("ProductCart.dat");
            ObjectInputStream in = new ObjectInputStream(inn);
            ProductCart = (ArrayList<Product>) in.readObject();
            in.close();
            inn.close();
        } catch (Exception e) {
            System.out.println(e);
            return ProductCart;
        } 
        return ProductCart;
}
    
    public static void displayProductsordered(){
        ArrayList<Product> productsordered=Order.readProductCartfromfile();
          for (Product product : productsordered) {
               System.out.println( product.getName());
               
            }
    } 
}
