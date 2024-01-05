/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author a
 */
package clothes.management.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ListIterator;

public class Cashier extends User {
//    Order order=order.productsordered;
//    ArrayLi

    public Cashier(int userId, String userName, UserType userType) {
        super(userId, userName, userType);
    }

    public int getCashierId() {
        return userId;
    }

    public void setCashierId(int cashierId) {
        this.userId = cashierId;
    }

    public String getCashierName() {
        return userName;
    }

    public void setCashierName(String cashierName) {
        this.userName = cashierName;
    }

    public HashMap<Integer, Integer> createCart() {
        HashMap<Integer, Integer> productCart = new HashMap<>();
        return productCart;
    }//tested

    public void createCart(Order order) {
        HashMap<Integer, Integer> productCart = order.productCart;
        System.out.println("Cart created successfully");
    }

    public void addProductToCart(int productid, Order order, int quantity) {
        boolean found = false;
       
        ArrayList<Product> productList = Product.readproductfromfile();
     
        for (Product product : productList) {
          
            if (product.getCode() == productid && product.getQuantity() > quantity) {
                order.productCart.put(product.getCode(), quantity);
                System.out.println("Product added to cart: " + product.getName());
                product.setQuantity(product.getQuantity() - quantity);
                product.setQuantitySold(product.getQuantitySold() + quantity);
                Product.writeproducttofile(productList);
                found=true;
                break;
            }
        }
        if(!found){
        System.out.println("no product found with this code or no quantity available ");
        }
    }//tested

    //Admin and customer have access to view product in cart
    public void displayProductsInCart(Order order) {
        if (order.productCart == null || order.productCart.isEmpty()) {
            System.out.println("No products found in the cart");
            System.out.println("---------------------------------------------------------------------------------");
            return;
        }
        ArrayList<Product> productList = Product.readproductfromfile();
        System.out.println("order ID " + order.getOrderId());
        System.out.println("Date " + order.getOrderDate());
        //System.out.println("Order Rating " + order.getRating());
        System.out.println("Items ");
        for (Map.Entry<Integer, Integer> entry : order.productCart.entrySet()) {
            //product code
            int key = entry.getKey();
            //quantity
            int value = entry.getValue();
            for (Product product : productList) {
                if (product.getCode() == key) {
                    System.out.println(product.getName() + " Price : " + product.getPrice() + " quantity : " + value);

                }

            }

        }
        System.out.println("Total payment: " + order.getTotalAmount());
        System.out.println("---------------------------------------------------------------------------------");

    }//tested

    public void AddOrderToCustomer(Customer c, Order o) {
        c.productordered.add(o);
        c.writeHistorytofile(c.productordered);

    }//tested

//parameter product code and an object from the the order
    public void removeProductFromCart(int code, Order order) {
        if (order.productCart == null || order.productCart.isEmpty()) {
            System.out.println("No products found");
        } else {
            boolean found = false;

            for (Map.Entry<Integer, Integer> entry : order.productCart.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                if (key == code) {
                    order.productCart.remove(key, value);

                    found = true;
                    break;
                }

            }

            if (found) {

                System.out.println("Product with code :" + code + " removed successfully");
                calculateTotalPayment(order);

            } else {
                System.out.println("Product no found");
            }

        }

    }

    public double calculateTotalPayment(Order order) {
        double totalPayment = 0.0;
        ArrayList<Product> productList = Product.readproductfromfile();
        for (Map.Entry<Integer, Integer> entry : order.productCart.entrySet()) {
            //product code
            int key = entry.getKey();
            //quantity
            int value = entry.getValue();
            for (Product product : productList) {
                if (product.getCode() == key) {
                    totalPayment += product.getPrice() * value;

                }

            }

        }
        order.setTotalAmount(totalPayment);
        //System.out.println("Total payment: " + totalPayment);
        return totalPayment;
    }//tested

    public void cancelCart(int id) {

        ListIterator<Order> iterator = Order.orders.listIterator();

        // Use the iterator to iterate over the list
        while (iterator.hasNext()) {
            // Get the next order
            Order o = iterator.next();

            // Check if the order id matches the given id
            if (o.getOrderId() == id) {
                // Remove the order from the list using the iterator
                o.productCart.clear();
                iterator.remove();
                // Remove the order from the customer's product ordered list
                
                o.getC().productordered.remove(o);
                Order.writeordertofile(Order.orders);
                o.getC().writeHistorytofile(o.getC().productordered);
            }
        }
        System.out.println("cart cancelled");

    }

}
