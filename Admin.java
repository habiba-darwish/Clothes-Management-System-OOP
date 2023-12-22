
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
    
    
    public void removeUser(int id ){
        boolean found = false;
        ArrayList<User> UserList = User.readUserFromFile() ; 
        for(User u : UserList){
            if(u.getUserId()== id){
                UserList.remove(u);
                found = true;
            }
        }
        if(found){
            writeUserToFile(UserList);
            System.out.println("User with id :" + id + " removed successfully");
        }
        else 
            System.out.println("No user with id :" + id);
    }
    
}
