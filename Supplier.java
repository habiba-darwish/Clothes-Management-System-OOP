/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author a
 */
package clothes.management.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Supplier implements Serializable  {

    private int max_orders, max_revenue, no_orders;
    static ArrayList<Supplier> SupplierList = new ArrayList<>();
    ArrayList<Order> SupplierOrderList = new ArrayList<>();

    // private String supplierID;
    private String supplierName;
    private String supplierAddress;
    private String supplierPhoneNumber;
    private String supplierEmail;
    private int SupplierID;

    public void setSupplierID(int SupplierID) {
        this.SupplierID = SupplierID;
    }

    public int getSupplierID() {
        return SupplierID;
    }

    public Supplier(int max_orders, int max_revenue, String supplierID, String supplierName, String supplierAddress, String supplierPhoneNumber, String supplierEmail, String Name, String size, String color, String description, int quantity, int price, int code) {
        this.max_orders = max_orders;
        this.max_revenue = max_revenue;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierPhoneNumber = supplierPhoneNumber;
        this.supplierEmail = supplierEmail;
    }

    public Supplier() {
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierPhoneNumber() {
        return supplierPhoneNumber;
    }

    public void setSupplierPhoneNumber(String supplierPhoneNumber) {
        this.supplierPhoneNumber = supplierPhoneNumber;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public void viewSupplierproducts(Supplier supplier) {
        ArrayList<Product> productList = Product.readproductfromfile();
        for (Product product : productList) {
            if (supplier.SupplierID == product.getSupplierID()) {
                System.out.println("Product name:" + product.getName());
                System.out.println("Product code" + product.getCode());
                System.out.println("Product color" + product.getColor());
                System.out.println("Product description" + product.getDescription());
                System.out.println("Product size" + product.getSize());
                System.out.println("Product gender" + product.getGender());
                System.out.println("Product price" + product.getPrice());
                System.out.println("Product quantity" + product.getQuantity());
            }
        }
    }

    public int getMaxOrders(LocalDate startDate, LocalDate endDate) {
        ArrayList<Supplier> SupplierList = Supplier.readsupplierfromfile();
        int maxOrders = 0;
        for (Supplier supplier : SupplierList) {
            int orders = 0;   
            for (Order order : supplier.SupplierOrderList) {

                if (order.getOrderDate().compareTo(startDate) >= 0 && order.getOrderDate().compareTo(endDate) <= 0) {

                    orders = supplier.get_noOforders(supplier);
                }
            }
            if (orders > maxOrders) {
                maxOrders = orders;
            }
        }
        return maxOrders;
    }

    public double getMaxRevenue(Date startDate, Date endDate) {
        ArrayList<Integer> ProductQuantity = new ArrayList<>();
        double maxRevenue = 0;
        for (Supplier supplier : SupplierList) {
            double revenue = 0;
            for (Order order : supplier.SupplierOrderList) {
//                for(Product product:order.productCart){
//                int index =order.productCart.indexOf(product);
//                
//                if (product.getS() == supplier && order.getOrderDate().compareTo(startDate) >= 0 && order.getOrderDate().compareTo(endDate) <= 0) { //&& product.getOrderDate().compareTo(startDate) >= 0 && product.getOrderDate().compareTo(endDate) <= 0) {
//                    revenue += ProductQuantity.get(index) * product.getPrice();
//                }
////                 if (product.getSupplierID() == (supplier.getSupplierID()) && order.getOrderDate().compareTo(startDate) >= 0 && order.getOrderDate().compareTo(endDate) <= 0) { //&& product.getOrderDate().compareTo(startDate) >= 0 && product.getOrderDate().compareTo(endDate) <= 0) {
////                    revenue += ProductQuantity.get(index) * product.getPrice();
////                }
//                }
            }
            if (revenue > maxRevenue) {
                maxRevenue = revenue;
            }
        }
        // }
        return maxRevenue;
    }

    public int get_noOforders(Supplier supplier) {

        return SupplierOrderList.size();
    }

    public void writesuppliertofile(ArrayList<Supplier> supplierList) {
        try {
            FileOutputStream o = new FileOutputStream("supplier.dat");
            ObjectOutputStream out = new ObjectOutputStream(o);
            for (Supplier supplier : supplierList) {
                out.writeObject(supplier);
            }
            out.close();
            o.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static ArrayList readsupplierfromfile() {
        ArrayList<Supplier> supplierList = new ArrayList<>();

        try {
            FileInputStream i = new FileInputStream("supplier.dat");
            ObjectInputStream in = new ObjectInputStream(i);
            for (Supplier supplier : supplierList) {
                supplier = (Supplier) in.readObject();
                supplierList.add(supplier);
            }

            in.close();
            i.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        return supplierList;
    }
}
