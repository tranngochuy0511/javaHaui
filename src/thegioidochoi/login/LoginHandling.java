/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thegioidochoi.login;

import ConnectionClass.Account;
import ConnectionClass.ConnectionClass;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author msinp
 */
public class LoginHandling {
    private static ArrayList<Account> accounts = new ArrayList();
    /* Loading the data from database*/   
   public static boolean load()
   {
       if (!accounts.isEmpty())
            return false;
        
        ResultSet resultSet = ConnectionClass.selectQuery("SELECT * FROM account;");
        
        if(resultSet == null)
            return false;
        
         try{
            while(resultSet.next()){
          accounts.add(new Account(resultSet.getObject(1).toString(),resultSet.getObject(2).toString()));
            }
            System.out.println("loaded with size of " + accounts.size());
        }catch(SQLException e){
        }
       return true;
   }
   public static boolean access(String username,String password){
       load();
       for (int i = 0; i < accounts.size(); i++) {
           //Account account=new Account(username, password);
            if(accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password)){
                return true;
            }
           
       }
       return false;
   }
}
