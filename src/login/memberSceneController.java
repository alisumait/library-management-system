/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alisu
 */
public class memberSceneController implements Initializable {
    @FXML
    private Button backy;
    @FXML
    FXMLDocumentController g = new FXMLDocumentController();
    @FXML
    public ImageView image;
    @FXML
    public ComboBox cat;
    @FXML
    private Label pdate;
    @FXML
    private Label exdate;
    @FXML
    public Button search;
    @FXML
    public TextField puser;
    @FXML
    public TextField ppass;
    @FXML
    private TextField pemail;
    @FXML
    private Button update;
    @FXML
    private Label uplabel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
       
        try {
            puser.setText(User()[0]);
            ppass.setText(User()[1]);
            pemail.setText(User()[2]);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(memberSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
        // TODO
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
       

        search.setOnAction(e -> {
            try {
                searchMethod(event);
            } catch (IOException ex) {
                Logger.getLogger(memberSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
   
        backy.setOnAction(e -> {
            try {
                homy(event);
            } catch (IOException ex) {
                Logger.getLogger(memberSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        update.setOnAction(e -> {
            try {
                Updatep(event);
            } catch (IOException ex) {
                Logger.getLogger(memberSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    @FXML
    public void Updatep(ActionEvent event) throws IOException{

       String a = User()[0];
       String b = User()[1];
       String c = User()[2];
       String d = puser.getText();
       String e = ppass.getText();
       String f = pemail.getText();
       
       Path path = Paths.get("Members.txt");
Charset charset = StandardCharsets.UTF_8;

String content = new String(Files.readAllBytes(path), charset);
content = content.replaceAll(a+","+b+","+c+","+a, d+","+e+","+f+","+d);
Files.write(path, content.getBytes(charset));

uplabel.setText("Profile Updated Successfully!");
  
    }
    
    @FXML
    public void homy(ActionEvent event) throws IOException{
        
        Parent p2 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene shome = new Scene(p2);
        Stage st2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        st2.setScene(shome);
        st2.show();}
    
    @FXML
    public void searchMethod(ActionEvent event) throws IOException{
              
        

        Parent p3 = FXMLLoader.load(getClass().getResource("Search.fxml"));
        Scene f = new Scene(p3);
        Stage st3 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        st3.setScene(f);
        st3.show();
    }
    
        

    
}
