/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author a
 */
package clothes.management.system;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Customer extends User {

    ArrayList<Order>productordered;
    
    public Customer(int userId, String userName, UserType userType) {
        super(userId, userName, userType);
        this.productordered = new ArrayList<>();
    }
    public int getCustomerId() {
        return userId;
    }

    public void setCustomerId(int customerId) {
        this.userId = customerId;
    }

    public String getCustomerName() {
        return userName;
    }

    public void setCustomerName(String customerName) {
        this.userName = customerName;
    }


//    public void AddOrder(Order order) {
//        productordered.add(order);
//    }

    public void rateOrder(Order order, int rating) {
        // Check if the rating  between 1 and 5
        if (rating >= 1 && rating <= 5) {
            order.setRating(rating);
            System.out.println("Order rated successfully");
        } else {
            System.out.println("Invalid rating. Please provide a rating between 1 and 5");

        }
    }

    public void viewOrderHistory(Customer customer) {
//        ArrayList orders=Order.readOrdersfromfile();
//        for(order Order : orders){
//        
//        }
        


//        if (productordered.isEmpty()) {
//            System.out.println("No order history available ");

//        } else {
            System.out.println("Order History:");
            for (Order order : productordered) {
                System.out.println("order ID" + order.getOrderId());
                //System.out.println("Date" + Order.getOrderDate());
                System.out.println("Items");
                ArrayList<Product> productsinorder = order.readProductCartfromfile() ;
                for (Product Product : productsinorder) {
                    System.out.println("-" + Product.getName());
                }
                System.out.println();

            }
        }

    }
    

//    public static void CustomerOrders(Customer customer) {
//        
//
////        customer.productordered
////        for (Order order:Order.)
////        
////    }
//
//}

