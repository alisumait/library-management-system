/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alisu
 */
public class LibrarianSceneController implements Initializable {
    @FXML
    private Button lbacky;
    @FXML
    private Label clockinlabel;
    @FXML
    private Label clockoutlabel;
    @FXML
    private Button searchm;
    @FXML
    public TextField luser;
    @FXML
    public TextField lpass;
    @FXML
    private TextField lemail;
    @FXML
    public TextField mname;
    @FXML
    public TextField mpass;
    @FXML
    public TextField memail;
    @FXML
    private Button clockin;
    @FXML
    private Button clockout;
    @FXML
    private Button addmem;
    @FXML
    private Button managemem;
    @FXML
    private Button updatelib;
    @FXML
    private ComboBox category;
    @FXML
    private Label addlabel;
    @FXML
    private Label uplabel;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
       
        try {
            luser.setText(User()[0]);
            lpass.setText(User()[1]);
            lemail.setText(User()[2]);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LibrarianSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
        category.getItems().addAll("Sci-Fi","Business","Novels");
        
    }
    
    @FXML
    public void Updatep(ActionEvent event) throws IOException{

       String a = User()[0];
       String b = User()[1];
       String c = User()[2];
       String d = luser.getText();
       String e = lpass.getText();
       String f = lemail.getText();
       
       Path path = Paths.get("librarians.txt");
Charset charset = StandardCharsets.UTF_8;

String content = new String(Files.readAllBytes(path), charset);
content = content.replaceAll(a+","+b+","+c+","+a, d+","+e+","+f+","+d);
Files.write(path, content.getBytes(charset));

uplabel.setText("Profile Updated Successfully!");
  
    }
    
    @FXML
    public void clockin(ActionEvent event) throws IOException{
            
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        clockinlabel.setText("Clocked-In Successfully.");
        try(
                FileWriter fw = new FileWriter(luser.getText()+"Clock.txt", true);
                
        BufferedWriter bw = new BufferedWriter(fw);
                
                PrintWriter out = new PrintWriter(bw)){
            
                    

        out.println(luser.getText()+" Clocked-In at "+dateFormat.format(cal.getTime()));
        out.close();
        }
        catch (IOException e) {
    //exception handling left as an exercise for the reader

                
        PrintWriter pr = new PrintWriter(new FileOutputStream(luser.getText()+"Clock.txt"));
                         pr.close();
                           clockin(event);
        }
        }
  
    
    
    @FXML
    public void clockout(ActionEvent event) throws IOException{
    
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        clockoutlabel.setText("Clocked-Out Successfully.");
        
       try(
                FileWriter fw = new FileWriter(luser.getText()+"Clock.txt", true);
                
        BufferedWriter bw = new BufferedWriter(fw);
                
                PrintWriter out = new PrintWriter(bw)){
            
                      

        out.println(luser.getText()+" Clocked-Out at "+dateFormat.format(cal.getTime()));
        out.println("---------------------------------------------------------------------");
        out.close();
        }
       catch (IOException e) {
    //exception handling left as an exercise for the reader

                
        PrintWriter pr = new PrintWriter(new FileOutputStream(luser.getText()+"Clock.txt"));
                         pr.close();
                           clockout(event);
        }
        }

    
    
     @FXML
    public void addMember(ActionEvent event) throws FileNotFoundException{


        PrintWriter adder = new PrintWriter(new FileOutputStream("Members.txt", true));
        adder.print(mname.getText());
        adder.print(",");
        adder.print(mpass.getText());
        adder.print(",");
        adder.print(memail.getText());
        adder.print(",");
        adder.println(mname.getText());
        adder.close();
        
        addlabel.setText("Member Added Successfully.");
        
        
        mname.clear();
        mpass.clear();
        memail.clear();

                }
    
    @FXML
    public String[] User() throws FileNotFoundException{
    String[] arr = new String[3];
    int y =0;
        try{Scanner sc = new Scanner (new FileInputStream("User.txt"));
            while (sc.hasNextLine()) {
                arr[y]=sc.nextLine();
                y++;
            }
            sc.close();
    }catch(Exception e){}
    
    return arr;
    }
    
    @FXML
    public void showMemberScene(ActionEvent event) throws IOException{

        updatelib.setOnAction(e -> {
            try {
                Updatep(event);
            } catch (IOException ex) {
                Logger.getLogger(LibrarianSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        clockin.setOnAction(e -> {
            try {
                clockin(event);
            } catch (IOException ex) {
                Logger.getLogger(LibrarianSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        clockout.setOnAction(e -> {
            try {
                clockout(event);
            } catch (IOException ex) {
                Logger.getLogger(LibrarianSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        searchm.setOnAction(e -> {
            try {
                searchmMethod(event);
            } catch (IOException ex) {
                Logger.getLogger(LibrarianSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
   
        lbacky.setOnAction(e -> {
            try {
                lhomy(event);
            } catch (IOException ex) {
                Logger.getLogger(LibrarianSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        managemem.setOnAction(e -> {
            try {
                manageMembers(event);
            } catch (IOException ex) {
                Logger.getLogger(LibrarianSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        addmem.setOnAction(e -> {
            try {
                addMember(event);
            } catch (IOException ex) {
                Logger.getLogger(LibrarianSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
    }
    
   
     @FXML
    public void manageMembers(ActionEvent event) throws IOException{
        
        Parent p2 = FXMLLoader.load(getClass().getResource("manageMembers.fxml"));
        Scene shome = new Scene(p2);
        Stage st2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        st2.setScene(shome);
        st2.show();}
    
    @FXML
    public void lhomy(ActionEvent event) throws IOException{
        
        Parent p2 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene shome = new Scene(p2);
        Stage st2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        st2.setScene(shome);
        st2.show();}
    
    @FXML
    public void searchmMethod(ActionEvent event) throws IOException{
        Parent p3 = FXMLLoader.load(getClass().getResource("Searchm.fxml"));
        Scene f = new Scene(p3);
        Stage st3 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        st3.setScene(f);
        st3.show();
        SearchController fs = new SearchController();
        fs.getBookstables();
    }
        
}