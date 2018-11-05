/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.util.ArrayList;

/**
 *
 * @author alisu
 */
public class Members {
    
    
     private String name;
    private String pass;
    private String email;
    
    
    public Members(){
    
        this.name = "";
        this.pass = "";
        this.email = "";
    }
    
    
     public Members(String name, String pass, String email){
        this.name = name;
        this.pass = pass;
        this.email = email;
     }
    

    Members(ArrayList<String> names, ArrayList<String> passes, ArrayList<String> emails) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
