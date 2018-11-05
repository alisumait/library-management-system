/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alisu
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    public Login main;
    @FXML
    public Stage window;
    @FXML
    private Button login;
    @FXML
    public TextField userid;
    @FXML
    public PasswordField passid;
    @FXML
    private Label isConnected;
    @FXML
    private ComboBox loginType;
    @FXML
    public Label welcomeM;
    
  
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
        
        loginType.getItems().addAll("Member","Librarian","Head");
       
    }    

   
    @FXML
    private void isTypa(ActionEvent event){
    
     String output = loginType.getSelectionModel().getSelectedItem().toString();
    switch (output) {
        case "Member":
            login.setOnAction(e -> {
         try {
             isLoginmem(event);
         } catch (IOException ex) {
             Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         }
     });
            break;
            
        case "Librarian":
            login.setOnAction(e -> {
         try {
             isLoginlib(event);
         } catch (IOException ex) {
             Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         }
     });
            break;
            
        case "Head":
            login.setOnAction(e -> {
         try {
             isLoginhead(event);
         } catch (IOException ex) {
             Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         }
     });
            break;
        default:
            break;
    }
    }
    
    

    

    @FXML
    public void isLoginmem(ActionEvent event) throws IOException {
      

             try{
                 try (Scanner inputStream = new Scanner(new FileInputStream("Members.txt"))) {
                     inputStream.useDelimiter(",");
                     
                     while(inputStream.hasNextLine()){
                         
                         String user = inputStream.next();
                         ArrayList<String> users = new ArrayList<>();
                         users.add(user);
                          
                         
                         String pass = inputStream.next();
                         ArrayList<String> upasses = new ArrayList<>();
                         upasses.add(pass);
                         
                         
                         String memail = inputStream.next();
                         ArrayList<String> memails = new ArrayList<>();
                         memails.add(memail);
                         
                         inputStream.nextLine();
                         
                        
                         
                         if(users.contains(userid.getText()) && upasses.contains(passid.getText())){
                         
                         PrintWriter pr = new PrintWriter("User.txt");
                         pr.println(userid.getText());
                         pr.println(passid.getText());
                         pr.println(memail);
                         pr.print("");
                         pr.close();
                         
                             Parent p1 = FXMLLoader.load(getClass().getResource("memberScene.fxml"));
                             Scene s2 = new Scene(p1);
                             Stage st1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                             st1.setScene(s2);
                             st1.show();
                             
                            
                         }
                         else
                             
                             isConnected.setText("Invalid Username or Password");
                         
                     }
                 
                 
                 }
            }
             
            catch (Exception e){
                    System.out.println(e.getMessage());
            }
       }
    
    @FXML
    public void isLoginlib(ActionEvent event) throws IOException{
      

             try{
                 try (Scanner inputStream = new Scanner(new FileInputStream("librarians.txt"))) {
                     inputStream.useDelimiter(",");
                     
                     while(inputStream.hasNextLine()){
                         
                         String user = inputStream.next();
                         ArrayList<String> libs = new ArrayList<>();
                         libs.add(user);
                         
                         
                         String pass = inputStream.next();
                         ArrayList<String> lpasses = new ArrayList<>();
                         lpasses.add(pass);
                         
                         
                         String lemail = inputStream.next();
                         ArrayList<String> lemails = new ArrayList<>();
                         lemails.add(lemail);
                         
                         inputStream.nextLine();
                         
                         if(libs.contains(userid.getText()) && lpasses.contains(passid.getText())){
                             
                             PrintWriter pr = new PrintWriter("User.txt");
                         pr.println(userid.getText());
                         pr.println(passid.getText());
                         pr.println(lemail);
                         pr.print("");
                         pr.close();
                         
                         
                         
                             Parent p5 = FXMLLoader.load(getClass().getResource("librarianScene.fxml"));
                             Scene s4 = new Scene(p5);
                             Stage st4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                             st4.setScene(s4);
                             st4.show();
                          
                             
                         }
                         else
                             
                             isConnected.setText("Invalid Username or Password");
                         
                     }
                     
                 }
            }
            catch (Exception e){
                    System.out.println(e.getMessage());
            }
            
       }
    @FXML
    public void isLoginhead(ActionEvent event) throws IOException{
      

             try{
                 try (Scanner inputStream = new Scanner(new FileInputStream("head.txt"))) {
                     inputStream.useDelimiter(",");
                     
                     while(inputStream.hasNextLine()){
                         
                         String user = inputStream.next();
                         ArrayList<String> head = new ArrayList<>();
                         head.add(user);
                         
                         
                         String pass = inputStream.next();
                         ArrayList<String> hpasses = new ArrayList<>();
                         hpasses.add(pass);
                         
                         
                         String hemail = inputStream.next();
                         ArrayList<String> hemails = new ArrayList<>();
                         hemails.add(hemail);
                         
                         inputStream.nextLine();
        
                         if(head.contains(userid.getText()) && hpasses.contains(passid.getText())){
                             
                         PrintWriter pr = new PrintWriter("User.txt");
                         pr.println(userid.getText());
                         pr.println(passid.getText());
                         pr.println(hemail);
                         pr.print("");
                         pr.close();
                         
                             Parent p5 = FXMLLoader.load(getClass().getResource("headScene.fxml"));
                             Scene s4 = new Scene(p5);
                             Stage st4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                             st4.setScene(s4);
                             st4.show();
                             
                             break;
                             
                         }
                         else
                             
                             isConnected.setText("Invalid Username or Password");
                         
                     }}
            }
            catch (Exception e){
                    System.out.println(e.getMessage());
            }
             
       }
    
    }

    
   

