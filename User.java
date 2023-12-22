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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author hp
 */


public class User implements Serializable{
    int userId;
    String userName;
    UserType userType;
    public User(int userId, String userName, UserType userType) {
        this.userId = userId;
        this.userName = userName;
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
    
    public static void writeUserToFile(ArrayList<User> usersList) {
        try{
            FileOutputStream o = new FileOutputStream("users.dat");
            ObjectOutputStream out = new ObjectOutputStream(o);
            out.writeObject(usersList);
            out.close();
            o.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static ArrayList<User> readUserFromFile() {
        ArrayList<User> usersList = new ArrayList<>();

        try {
            FileInputStream i = new FileInputStream("users.dat");
            ObjectInputStream in = new ObjectInputStream(i);
            usersList = (ArrayList<User>) in.readObject();
            in.close();
            i.close();
        } catch (Exception e) {
            System.out.println(e);
            return usersList; 
        } 
        return usersList;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userName=" + userName + ", userType=" + userType + '}';
    }
}