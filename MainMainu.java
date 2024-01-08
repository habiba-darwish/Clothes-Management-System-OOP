/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clothes.management.system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.util.Date;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author a
 */
public class ClothesManagementSystem {
    
    static Scanner input = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    static void customerMenu() {
        System.out.println("Customer functions:");
        System.out.println("1- View Cart");
        System.out.println("2- View History");
        System.out.println("3- Rate Order");
        int c = input.nextInt();
        System.out.println("enter userId");
        int userId = input.nextInt();
        System.out.println("enter userName");
        
        String userName = input.next();
        Customer cus = new Customer(userId, userName, UserType.CUSTOMER);
        if (c == 1) {
            
            cus.productordered = cus.readHistoryfromfile();
            cus.ViewCart();
        } else if (c == 2) {
            System.out.println("enter userId");

            //Order order = new Order();
            //cus.viewOrderHistory(cus, order);
            cus.productordered = cus.readHistoryfromfile();
            cus.viewOrderHistory(cus);
        } else if (c == 3) {
            System.out.println("enter userId");
            
            cus.productordered = cus.readHistoryfromfile();
            cus.viewOrderHistory(cus);
            System.out.println("enter order id you want to rate");
            int order_id = input.nextInt();
            System.out.println("enter user your rating for the order");
            int rate = input.nextInt();
            cus.rateOrder(order_id, rate);
            // cus.writeHistorytofile(cus.productordered);

        }
        
    }//tested all

    static void cashierMenu() {

        Cashier c = new Cashier(2023, "Cashier", UserType.CASHIER);
        
        boolean x = true;
        while (x) {
            System.out.println("Cashier functions:");
            System.out.println("1- Place an order");
            System.out.println("2- Cancel an order");
            System.out.println("3- Return to main menu");
            
            int A = input.nextInt();
            switch (A) {
                case 1: // Sub menu for placing an order
                    // Initialize the order object before reading from file
                    System.out.println("enter customer userId that will place the order");
                    int userId = input.nextInt();
                    System.out.println("enter customer userName");
                    String userName = input.next();
                    
                    Customer customer = new Customer(userId, userName, UserType.CUSTOMER);
                    //customer.productordered = customer.readHistoryfromfile();
                    //still enhancing the generate order id function
                    System.out.println("enter order id");
                    int order_id = input.nextInt();
                    //Order order = new Order(order_id, customer);

                    Order order = new Order(order_id, customer);
                    // Read the order from file

                    boolean y = true;
                    while (y) {
                        System.out.println("Place an order functions:");
                        System.out.println("1- Create new cart");
                        System.out.println("2- Add product to cart");
                        System.out.println("3- Remove product from cart");
                        System.out.println("4- View products in cart");
                        System.out.println("5- Calculate total payment");
                        System.out.println("6- Place order");
                        System.out.println("7- Return to cashier menu");
                        
                        int B = input.nextInt();
                        if (B == 1) {
                            c.createCart(order);
                            //order.productCart = c.createCart();
                            
                        } else if (B == 2) {
                            Admin ad = new Admin(555, "Admin1", UserType.ADMIN);
                            ad.displayProducts();
                            System.out.print("Enter code of product you want to add to cart: ");
                            int productCode = input.nextInt();
                            System.out.print("Enter quantity of product you want to add to cart: ");
                            int productQuantity = input.nextInt();
                            
                            c.addProductToCart(productCode, order, productQuantity);
                        } else if (B == 3) {
                            c.displayProductsInCart(order);
                            System.out.print("Enter code of product you want to remove from cart: ");
                            int productCode = input.nextInt();
                            c.removeProductFromCart(productCode, order);
                            
                        } else if (B == 4) {
                            c.displayProductsInCart(order);
                        } else if (B == 5) {
                            c.calculateTotalPayment(order);
                        } else if (B == 6) {
                            //cashier must call this to save the order record
                            c.placeOrder(order, customer);
                            
                        } else if (B == 7) {
                            y = false;
                            break;
                        }
                    }
                    
                    break;
                case 2: // Sub menu for cancelling an order
                    boolean z = true;
                    while (z) {
                        System.out.println("Cancel an order functions:");
                        System.out.println("1- Enter the order id and customer info you want to cancel");
                        System.out.println("2- Return to cashier menu");
                        
                        int C = input.nextInt();
                        if (C == 1) {
                            System.out.println("enter customer userId that you will cancel the order for");
                            int user_Id = input.nextInt();
                            System.out.println("enter customer userName");
                            String user_Name = input.next();
                            
                            Customer customer_cancel = new Customer(user_Id, user_Name, UserType.CUSTOMER);
                            
                            System.out.print("Enter the order id you want to cancel: ");
                            int orderId = input.nextInt();
                            c.cancelCart(orderId, customer_cancel);
                            
                        } else if (C == 2) {
                            z = false;
                            break;
                        }
                    }
                    break;
                case 3:
                    x = false;
                    break;
            }
        }
        
    }

    static void adminMenu() {
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
        System.out.println("11- view all orders");
        
        System.out.println("");
        System.out.println("15- View Product Reports");
        System.out.println("16- View User Reports");
        System.out.println("17- View Order Reports");
        System.out.println("18- View Order Detail");
        int B = input.nextInt();
        
        if (B == 1) {
            System.out.println("Enter the username of the user you want to add:");
            String username = input.next();
            System.out.println("Enter the id of the user you want to add ");
            int id = input.nextInt();
            System.out.println("choose the user type :");
            System.out.println(" 1 - Customer");
            System.out.println(" 2 - Cashier");
            B = input.nextInt();
            if (B == 1) {
                User user = new User(id, username, UserType.CUSTOMER);
                admin.addUser(user);
            } else if (B == 2) {
                User user = new User(id, username, UserType.CASHIER);
                admin.addUser(user);
            } else {
                System.out.println("Invalid option");
            }
        } else if (B == 2) {
            admin.displayUsers();
            System.out.println("choose the id of the user you want to remove :");
            int x = input.nextInt();
            admin.removeUser(x);
        } else if (B == 3) {
            admin.displayUsers();
            System.out.println("choose the id of the user you want to edite :");
            B = input.nextInt();
            System.out.println("Enter the new username :");
            String newUsername = input.next();
            admin.editUser(B, newUsername);
        } else if (B == 4) {
            System.out.println("choose the id of the user you want to see :");
            B = input.nextInt();
            admin.searchUser(B);
        } else if (B == 5) {
            admin.displayUsers();
        } else if (B == 6) {
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
            int product_quantity = input.nextInt();
            
            System.out.println("Enter the price for the product:");
            int product_price = input.nextInt();
            
            System.out.println("Enter the code for the product:");
            int product_code = input.nextInt();

            //Product product= new Product(product_name, product_size, product_color, product_description, product_gender, null,product_quantity, product_price, product_code);
            //admin.addProduct(product);
        } else if (B == 7) {
            admin.displayProducts();
            System.out.println("choose the code of the product you want to remove :");
            int x = input.nextInt();
            admin.removeProduct(x);
        } else if (B == 8) {
            System.out.println("if you want to edit the product name, size, color, description,gender Enter 1");
            System.out.println("if you want to edit the product quantity, price,code Enter 2");
            int o = input.nextInt();
            if (o == 1) {
                System.out.println("choose the id of the user you want to edit :");
                int code = input.nextInt();
                System.out.println("if you want to edit the product name enter 1, size 2, color 3, description 4 ,gender 5 and the value of the new string");
                int option = input.nextInt();
                String s = input.next();
                if (option == 1) {
                    admin.editProductString(code, option, s);
                } else if (option == 2) {
                    admin.editProductString(code, option, s);
                } else if (option == 3) {
                    admin.editProductString(code, option, s);
                } else if (option == 4) {
                    admin.editProductString(code, option, s);
                } else if (option == 5) {
                    admin.editProductString(code, option, s);
                }
                
            } else if (o == 2) {
                System.out.println("choose the id of the user you want to edit :");
                int code = input.nextInt();
                System.out.println("if you want to edit the product quantity enter 1, price 2,code 3 and the new int value");
                int option = input.nextInt();
                int newint = input.nextInt();
                if (option == 1) {
                    admin.editProductInt(code, option, newint);
                } else if (option == 2) {
                    admin.editProductInt(code, option, newint);
                } else if (option == 3) {
                    admin.editProductInt(code, option, newint);
                }
                
            }
            
        } else if (B == 9) {
            System.out.println("choose the code of the product you want to see :");
            B = input.nextInt();
            admin.searchProduct(B);
        } else if (B == 10) {
            admin.displayProducts();
        } else if (B == 11) {
            admin.ViewOrders();
            
        } else if (B == 12) {
            System.out.println("Enter a start date in the format yyyy-MM-dd:");
            String startdate = input.nextLine();
//            System.out.println("Enter a end date in the format yyyy-MM-dd:");
//            String enddate = input.nextLine();
// Parse the input String to a LocalDate object
//format 2024-01-05
            LocalDate date1 = LocalDate.parse(startdate);
            //LocalDate date2 = LocalDate.parse(enddate);
// Print the date
            //System.out.println("The date you entered is: " + startdate);
            // int max = admin.no_of_pieces_sold(LocalDate.MAX, LocalDate.MAX);
            //System.out.println("no of pieces =  " + max);
            System.out.println("The date you entered is: " + date1);
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
