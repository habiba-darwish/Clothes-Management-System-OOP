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
public class Cashier extends User {
//    Order order=order.productsordered;
//    ArrayLi
    public Cashier(int userId, String userName, UserType userType)
    {
        super(userId, userName, userType);
    }
    
    public int getCashierId() 
    {
        return userId;
    }
    
    public void setCashierId(int cashierId) 
    {
        this.userId = cashierId;
    }
    
    public String getCashierName() 
    {
        return userName;
    }
    
    public void setCashierName(String cashierName) 
    {
        this.userName = cashierName;
    }
   
    public void createCart(Order order) {
//        Order newOrder = new Order ()
        ArrayList<Product> ProductCart = order.productCart ; 
        System.out.println("Cart created successfully");
    }

    public void addProductToCart(Product product,Order order) {
       // ArrayList<Product> ProductCart = order.productCart ; 
        order.productCart.add(product);
        //order.productsordered.add(product); 
        Order.writeProductCarttofile(order.productCart);
        System.out.println("Product added to cart: " + product.getName());
    }
    
    public void displayProductsInCart() {
        ArrayList<Product> ProductCart = Order.readProductCartfromfile();         
        if (ProductCart.isEmpty()) {
            System.out.println("No Product available.");
        }else{
            for (Product p : ProductCart) {
                System.out.println(p);
            }
        }
    }
    
    public void AddOrderToCustomer(Customer c,Order o){
        
       
    }

     public void removeProductFromCart(int code) {
        ArrayList<Product> ProductCart = Order.readProductCartfromfile();
        if(ProductCart == null||ProductCart.isEmpty()){
            System.out.println("No products found");
        }else{
            boolean found = false;

            for (Product p : ProductCart) {
                if(p.getCode()== code){
                    ProductCart.remove(p);
                    found = true;
                    System.out.println("Product with code :" + code + " removed successfully");
                    break;
                }
            }
            if(found)
                Order.writeProductCarttofile(ProductCart);
            else
                System.out.println("Product no found");
        }
    } 
     
    public double calculateTotalPayment(Order order) {
        double totalPayment = 0.0;
        ArrayList<Product> ProductCart = Order.readProductCartfromfile();
        for (Product product : ProductCart) {
            for(int i=0;i<product.getQuantity();i++)
            {
            totalPayment += product.getPrice();
            }
        }
        System.out.println("Total payment: " + totalPayment);
        return totalPayment;
    }
     
    public void cancelCart(Order order) {
        ArrayList<Product> ProductCart = Order.readProductCartfromfile();
        ProductCart.clear();
        Order.writeProductCarttofile(ProductCart);
        System.out.println("cart cancelled  ");
    }

}
    
    

