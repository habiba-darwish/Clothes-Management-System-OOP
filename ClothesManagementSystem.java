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

/**
 *
 * @author a
 */
public class ClothesManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {    // create supplier instatnce that supply these products
         Supplier s=new Supplier();
        //create product object
        Product p = new Product("TSHIRT", "Xl", "White", "cotton", "MALE",123,s,100,250,789,0);
        Product p2 = new Product("TSHIRT", "Xl", "White", "cotton", "MALE",123,s,100,250,789,0);
      //declare arrayList of products
        ArrayList<Product> productList = new ArrayList<>(); 
        //add products to arraylist
        productList.add(p);
        productList.add(p2);
        //write ArrayList to file
        Product.writeproducttofile(productList);
//      --------------------------------------------------------------------------
        //create new ArrayList           
        ArrayList<Product> producttry = new ArrayList<>();
        // read files to arrayList
        producttry=Product.readproductfromfile();
        //print ArrayList
        for (Product p3 : producttry) {
            System.out.println("Product name:" + " " + p3.getName());
            System.out.println("Product code" + " " + p3.getCode());
            System.out.println("Product color" + " " + p3.getColor());
            System.out.println("Product description" + " " + p3.getDescription());
            System.out.println("Product size" + " " + p3.getSize());
            System.out.println("Product gender" + " " + p3.getGender());
            System.out.println("Product price" + " " + p3.getPrice());
            System.out.println("Product quantity" + " " + p3.getQuantity());
        }
        
        
        
    }
}
