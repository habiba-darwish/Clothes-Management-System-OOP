package clothes.management.system;

import clothes.management.system.User;
import clothes.management.system.UserType;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author a
 */
public class Admin extends User {

    public Admin(int userId, String userName, UserType userType) {
        super(userId, userName, userType);
    }

    public void addUser(User user) {
        ArrayList<User> UserList = User.readUserFromFile();
        UserList.add(user);
        writeUserToFile(UserList);
        System.out.println("User added: " + user.getUserName());
    }

    public void removeUser(int id) {
        ArrayList<User> UserList = User.readUserFromFile();
        if (UserList == null || UserList.isEmpty()) {
            System.out.println("No users found");
        } else {
            boolean found = false;

            for (User u : UserList) {
                if (id == u.getUserId()) {
                    UserList.remove(u);
                    found = true;

                    System.out.println(u.getUserId() + "is removed successfully");
                    break;
                }
            }
            if (found) {
                writeUserToFile(UserList);
            } else {
                System.out.println("user not found");
            }
        }

    }

    public void editUser(int id, String newUsername) {
        boolean found = false;
        ArrayList<User> UserList = User.readUserFromFile();
        for (User u : UserList) {
            if (u.getUserId() == id) {
                u.setUserName(newUsername);
                found = true;
            }
        }
        if (found) {
            writeUserToFile(UserList);
            System.out.println("User with id :" + id + " edited successfully");
        } else {
            System.out.println("No user with id :" + id);
        }
    }

    public void searchUser(int id) {
        boolean found = false;
        ArrayList<User> UserList = User.readUserFromFile();
        for (User u : UserList) {
            if (u.getUserId() == id) {
                System.out.println(u);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No user with id :" + id);
        }
    }

    public void displayUsers() {
        ArrayList<User> UserList = User.readUserFromFile();

        if (UserList.isEmpty()) {
            System.out.println("No Users available.");
        } else {
            for (User user : UserList) {
                System.out.println("User ID: " + user.getUserId() + ", Name: " + user.getUserName());
            }
        }
    }

    public void addProduct(Product product) {
        ArrayList<Product> ProductList = Product.readproductfromfile();
        ProductList.add(product);
        Product.writeproducttofile(ProductList);
        System.out.println("Product added: " + product.getName());
    }

    public void displayProducts() {
        ArrayList<Product> ProductList = Product.readproductfromfile();

        if (ProductList.isEmpty()) {
            System.out.println("No Product available.");
        } else {
            for (Product p : ProductList) {
                System.out.println(p);
            }
        }
    }

    public void removeProduct(int code) {

        ArrayList<Product> ProductList = Product.readproductfromfile();
        if (ProductList == null || ProductList.isEmpty()) {
            System.out.println("No products found");
        } else {
            boolean found = false;

            for (Product p : ProductList) {
                if (p.getCode() == code) {
                    ProductList.remove(p);
                    found = true;
                    System.out.println("Product with code :" + code + " removed successfully");
                    break;
                }
            }
            if (found) {
                Product.writeproducttofile(ProductList);
            } else {
                System.out.println("Product not found");
            }
        }
    }

    public void editProductString(int code, int option, String newstring) {

        if (option == 1) {
            boolean found = false;
            ArrayList<Product> ProductList = Product.readproductfromfile();
            for (Product p : ProductList) {
                if (p.getCode() == code) {
                    p.setName(newstring);
                    found = true;
                }
            }
            if (found) {
                Product.writeproducttofile(ProductList);
                System.out.println("Product with code :" + code + " edited successfully");
            } else {
                System.out.println("No Product with code :" + code);
            }
        } else if (option == 2) {
            boolean found = false;
            ArrayList<Product> ProductList = Product.readproductfromfile();
            for (Product p : ProductList) {
                if (p.getCode() == code) {
                    p.setSize(newstring);
                    found = true;
                }
            }
            if (found) {
                Product.writeproducttofile(ProductList);
                System.out.println("Product with code :" + code + "edited successfully");
            } else {
                System.out.println("No Product with code :" + code);
            }

        } else if (option == 3) {
            boolean found = false;
            ArrayList<Product> ProductList = Product.readproductfromfile();
            for (Product p : ProductList) {
                if (p.getCode() == code) {
                    p.setColor(newstring);
                    found = true;
                }
            }
            if (found) {
                Product.writeproducttofile(ProductList);
                System.out.println("Product with code :" + code + "edited successfully");
            } else {
                System.out.println("No Product with code :" + code);
            }
        } else if (option == 4) {
            boolean found = false;
            ArrayList<Product> ProductList = Product.readproductfromfile();
            for (Product p : ProductList) {
                if (p.getCode() == code) {
                    p.setDescription(newstring);
                    found = true;
                }
            }
            if (found) {
                Product.writeproducttofile(ProductList);
                System.out.println("Product with code :" + code + "edited successfully");
            } else {
                System.out.println("No Product with code :" + code);
            }
        } else if (option == 5) {
            boolean found = false;
            ArrayList<Product> ProductList = Product.readproductfromfile();
            for (Product p : ProductList) {
                if (p.getCode() == code) {
                    p.setGender(newstring);
                    found = true;
                }
            }
            if (found) {
                Product.writeproducttofile(ProductList);
                System.out.println("Product with code :" + code + "edited successfully");
            } else {
                System.out.println("No Product with code :" + code);
            }
        }
    }

    public void editProductInt(int code, int option, int newint) {
        if (option == 1) {
            boolean found = false;
            ArrayList<Product> ProductList = Product.readproductfromfile();
            for (Product p : ProductList) {
                if (p.getCode() == code) {
                    p.setQuantity(newint);
                    found = true;
                }
            }
            if (found) {
                Product.writeproducttofile(ProductList);
                System.out.println("Product with code :" + code + " edited successfully");
            } else {
                System.out.println("No Product with code :" + code);
            }
        } else if (option == 2) {
            boolean found = false;
            ArrayList<Product> ProductList = Product.readproductfromfile();
            for (Product p : ProductList) {
                if (p.getCode() == code) {
                    p.setPrice(newint);
                    found = true;
                }
            }
            if (found) {
                Product.writeproducttofile(ProductList);
                System.out.println("Product with code :" + code + "edited successfully");
            } else {
                System.out.println("No Product with code :" + code);
            }

        } else if (option == 3) {
            boolean found = false;
            ArrayList<Product> ProductList = Product.readproductfromfile();
            for (Product p : ProductList) {
                if (p.getCode() == code) {
                    p.setCode(newint);
                    found = true;
                }
            }
            if (found) {
                Product.writeproducttofile(ProductList);
                System.out.println("Product with code :" + code + "edited successfully");
            } else {
                System.out.println("No Product with code :" + code);
            }
        }
    }

    public void searchProduct(int code) {
        boolean found = false;
        ArrayList<Product> ProductList = Product.readproductfromfile();

        for (Product p : ProductList) {
            if (p.getCode() == code) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No Product with code :" + code);
        }
    }
    public void ViewOrders(){
    Cashier c = new Cashier(123, "Cashier1", UserType.CASHIER);
     Order.orders=Order.readProductCartfromfile();
        for(Order o:Order.orders){
        c.displayProductsInCart(o);
        }
    }

    /*          
    void viewProductReports(Date startDate, Date endDate,Product product) 
    {       
    }
    void viewUserReports(Date startDate, Date endDate, User user,Product product, Supplier supplier, customer c,cashier ca) 
    {       
    }
    void viewOrderReports(Date startDate, Date endDate,Order order) 
    {
    }
    void viewOrderDetails(Order order) 
    {
        System.out.println("Order ID: " + order.getOrderId() + ", Total Amount: " + order.getTotalAmount());        
    }
     */
}
