/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;

import java.util.Scanner;
import project.Admin;
import project.Supplier;
import project.Product;
import project.cashier;
import project.Order;
/**
 *
 * @author hp
 */
public class project {
    static Scanner input = new Scanner(System.in);

    static void customerMenu(){
        System.out.println("Customer functions:");
        System.out.println("1- View Cart");
        System.out.println("2- View History");
        System.out.println("3- Rate Order");
        int c=input.nextInt();
        if(c==1)
        {
            System.out.println("enter userId");
            int userId=input.nextInt();
            System.out.println("enter userName");
            String userName=input.next();
            customer cus=new customer(userId,userName,UserType.CUSTOMER);
            cus.ViewCart();
        }
        else if(c==2)
        {
           System.out.println("enter userId");
            int userId=input.nextInt();
            System.out.println("enter userName");
            String userName=input.next();
            customer cus=new customer(userId,userName,UserType.CUSTOMER);
            Order order=new Order();
            cus.viewOrderHistory(cus,order);
        }
        else if(c==3)
        {
            Order order=new Order(); 
            System.out.println("enter userId");
            int userId=input.nextInt();
            System.out.println("enter userName");
            String userName=input.next();
            System.out.println("enter user your rating for the order");
            int rate=input.nextInt();
            customer cus=new customer(userId,userName,UserType.CUSTOMER);
            cus.rateOrder(order,rate);
        }
                
    }
    
    static void cashierMenu(){
        cashier c = new cashier(2023, "Cashier", UserType.CASHIER);
        Order order=new Order(); 
        System.out.println("Cashier functions:");
        System.out.println("1- Create new cart");
        System.out.println("2- Add product to cart");
        System.out.println("3- Remove product from cart");
        System.out.println("4- View products in cart");
        System.out.println("5- Calculate total payment");
        System.out.println("6- Cancel cart");

        int A=input.nextInt();
        if(A==1)
        {
            c.createCart(order);
        }
        else if(A==2)
        {
            System.out.print("Enter name of product you want to add to cart: ");
            String productName=input.next();
            System.out.print("Enter code of product you want to add to cart: ");
            int productCode=input.nextInt();
            System.out.print("Enter size of product you want to add to cart: ");
            String productSize=input.next();
            System.out.print("Enter color of product you want to add to cart: ");
            String productColor=input.next();
            System.out.print("Enter type of product you want to add to cart: ");
            String productType=input.next();
            System.out.print("Enter quantity of product you want to add to cart: ");
            int productQuantity=input.nextInt();
            System.out.print("Enter price of product you want to add to cart: ");
            int productPrice=input.nextInt();
            System.out.print("Enter gender of product you want to add to cart: ");
            String productGender=input.next();
            
            Product product= new Product(productName, productSize, productColor, productType, productGender,null,productQuantity, productPrice, productCode);
            
            c.addProductToCart(product,order);

        }
        else if(A==3)
        {
            c.displayProductsInCart();
            System.out.print("Enter code of product you want to remove from cart: ");
            int productCode=input.nextInt();
            c.removeProductFromCart(productCode);

        }
        else if(A==4)
        {
             c.displayProductsInCart();
        }
        else if(A==5)
       {
             c.calculateTotalPayment(order);
       }
        else if(A==6)
       {
             c.cancelCart(order);
       }
    }
    
    static void adminMenu(){
        Admin admin = new Admin(0, "Admin", UserType.ADMIN);

        System.out.println("Admin functions:");
        System.out.println("1- Add User");
        System.out.println("2- Remove User");
        System.out.println("3- Edit User");
        System.out.println("4- Search user");
        System.out.println("5- view all users");
        System.out.println("");
        System.out.println("6- Add Product");
        System.out.println("7- Remove Product");
        System.out.println("8- Edit Product");    
        System.out.println("9- Search Product");
        System.out.println("10- view all Products");
        System.out.println("");
     /* System.out.println("15- View Product Reports");
        System.out.println("16- View User Reports");
        System.out.println("17- View Order Reports");
        System.out.println("18- View Order Detail");*/
        int B=input.nextInt();
        
        if(B==1){
            System.out.println("Enter the username of the user you want to add:");
            String username = input.next();
            System.out.println("Enter the id of the user you want to add ");
            int id = input.nextInt();
            System.out.println("choose the user type :");
            System.out.println(" 1 - Customer");
            System.out.println(" 2 - Cashier");
            B = input.nextInt();
            if(B == 1 ){
                User user = new User(id, username, UserType.CUSTOMER);
                admin.addUser(user);
            }else if(B == 2){
                User user = new User(id, username, UserType.CASHIER);
                admin.addUser(user);
            }else{
                System.out.println("Invalid option");
            }
        }
        else if(B==2){
            admin.displayUsers();
            System.out.println("choose the id of the user you want to remove :");
            int x = input.nextInt();
            admin.removeUser(x);
        }
        else if(B==3){
            admin.displayUsers();
            System.out.println("choose the id of the user you want to edite :");
            B = input.nextInt();
            System.out.println("Enter the new username :");
            String newUsername = input.next();
            admin.editUser(B ,newUsername);
        }
        else if(B==4){
            System.out.println("choose the id of the user you want to see :");
            B = input.nextInt();
            admin.searchUser(B);
        }
        else if(B==5){
            admin.displayUsers();
        }
        else if(B==6){
            System.out.println("Enter the name of the product you want to add:");
            String product_name = input.next();

            System.out.println("Enter the size of the product:");
            String product_size = input.next();

            System.out.println("Enter the color of the product:");
            String product_color = input.next();

            System.out.println("Enter the description of the product:");
            String product_description = input.next();

            System.out.println("Enter the gender for the product:");
            String product_gender = input.next();
            
            System.out.println("Enter the quantity for the product:");
            int product_quantity= input.nextInt();
            
            System.out.println("Enter the price for the product:");
            int product_price= input.nextInt();
            
            System.out.println("Enter the code for the product:");
            int product_code = input.nextInt();
            
            Product product= new Product(product_name, product_size, product_color, product_description, product_gender, null,product_quantity, product_price, product_code);
            
             admin.addProduct(product);
        }
        else if(B==7){
            admin.displayProducts();
            System.out.println("choose the code of the product you want to remove :");
            int x = input.nextInt();
            admin.removeProduct(x);
        }
        else if(B==8)
        {
          System.out.println("if you want to edit the product name, size, color, description,gender Enter 1");
          System.out.println("if you want to edit the product quantity, price,code Enter 2");
          int o=input.nextInt();
          if(o==1)
          {
            System.out.println("choose the id of the user you want to edit :");
            int code = input.nextInt();
            System.out.println("if you want to edit the product name enter 1, size 2, color 3, description 4 ,gender 5 and the value of the new string");
             int option = input.nextInt();
             String s=input.next();
             if(option==1)
             {
                 admin.editProductString(code,option,s);
             }
             else if(option==2)
             {
                  admin.editProductString(code,option,s);
             }
             else if(option==3)
             {
                 admin.editProductString(code,option,s); 
             }
             else if(option==4)
             {
                  admin.editProductString(code,option,s);
             }
             else if(option==5)
             {
                 admin.editProductString(code,option,s);
             }
           
          }
          else if(o==2)
          {
              System.out.println("choose the id of the user you want to edit :");
              int code = input.nextInt();
              System.out.println("if you want to edit the product quantity enter 1, price 2,code 3 and the new int value");
              int option=input.nextInt();
              int newint=input.nextInt();
              if(option==1)
             {
                 admin.editProductInt(code,option,newint);
             }
             else if(option==2)
             {
                 admin.editProductInt(code,option,newint);
             }
             else if(option==3)
             {
                 admin.editProductInt(code,option,newint); 
             }
              
          } 
     
        }
        else if(B==9)
        {
            System.out.println("choose the code of the product you want to see :");
            B = input.nextInt();
            admin.searchProduct(B);
        }
        else if(B==10)
        {
            admin.displayProducts();
        }
    }
    
    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("Select your role:");
                System.out.println("1- Enter as an Admin");
                System.out.println("2- Enter as a Cashier");
                System.out.println("3- Enter as a Customer");

                int x = input.nextInt();

                switch (x) {
                    case 1: 
                      adminMenu();
                        break;
                    case 2: 
                      cashierMenu();
                        break;
                    case 3: 
                      customerMenu();
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            } catch (Exception ex) {
                 System.out.println("Wrong input: " + ex);
                 input.nextLine();
            }
        }

    }
}
